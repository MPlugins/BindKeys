package net.mplugins.bindkeys.keybindings;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FKeybinding implements Keybinding
{
    private static final String NAME = "f";
    private static final String PATH = "keybindings." + NAME;
    private static final Set<UUID> cooldowns = new HashSet<>();

    private final boolean enabled;
    private final boolean cancelEvent;
    private final String permission;
    private final int cooldown;
    private final List<String> commands;

    public FKeybinding()
    {
        this.enabled = config.getBoolean(PATH + ".enabled");
        this.cancelEvent = config.getBoolean(PATH + ".cancel-event");
        this.permission = config.isSet(PATH + ".permission") ? config.getString(PATH + ".permission") : "";
        this.cooldown = config.getInt(PATH + ".cooldown");
        this.commands = config.getStringList(PATH + ".commands");
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    @Override
    public boolean hasCooldown(UUID uuid)
    {
        return cooldowns.contains(uuid);
    }

    @Override
    public boolean isEventCanceled()
    {
        return cancelEvent;
    }

    @Override
    public String getPermission()
    {
        return permission;
    }

    @Override
    public int getCooldown()
    {
        return cooldown;
    }

    @Override
    public List<String> getCommands()
    {
        return commands;
    }

    @EventHandler
    public void onSwitchHand(PlayerSwapHandItemsEvent event)
    {
        Player player = event.getPlayer();

        if (!this.isEnabled() || !player.hasPermission(this.getPermission()) || hasCooldown(player.getUniqueId()))
            return;

        event.setCancelled(this.isEventCanceled());

        for (String command : this.getCommands())
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceFirst("/", ""));

        cooldowns.add(player.getUniqueId());

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                cooldowns.remove(player.getUniqueId());
            }
        }.runTaskLaterAsynchronously(plugin, 20L * this.getCooldown());
    }
}
