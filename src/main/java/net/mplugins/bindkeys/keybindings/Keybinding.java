package net.mplugins.bindkeys.keybindings;

import net.mplugins.bindkeys.BindKeys;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.UUID;

public interface Keybinding extends Listener
{
    BindKeys plugin = BindKeys.getInstance();
    FileConfiguration config = plugin.getConfig();

    /**
     * Check if this keybinding is enabled.
     *
     * @return true if enabled, false otherwise
     */
    boolean isEnabled();

    /**
     * Checks if uuid is still on cooldown.
     *
     * @param uuid uuid of the player to check
     * @return true, if cooldown is still active, false otherwise.
     */
    boolean hasCooldown(UUID uuid);

    /**
     * Checks if the event should be canceled.
     *
     * @return true, if event should be canceled, false otherwise.
     */
    boolean isEventCanceled();

    /**
     * Get the permission needed to use this keybinding.
     *
     * @return the permission
     */
    String getPermission();

    /**
     * Get the cooldown for this keybinding in seconds.
     *
     * @return cooldown in seconds
     */
    int getCooldown();

    /**
     * Get commands that are executed when key is pressed.
     *
     * @return the commands
     */
    List<String> getCommands();
}
