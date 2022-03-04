package net.mplugins.bindkeys;

import net.mplugins.bindkeys.keybindings.FKeybinding;
import net.mplugins.bindkeys.keybindings.QKeybinding;
import net.mplugins.bindkeys.keybindings.ShiftFKeybinding;
import net.mplugins.bindkeys.keybindings.ShiftQKeybinding;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class BindKeys extends JavaPlugin
{
    private static BindKeys instance;

    @Override
    public void onEnable()
    {
        instance = this;
        this.setUpConfigurationFile();
        this.registerKeybindings();
    }

    private void registerKeybindings()
    {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new FKeybinding(), this);
        pluginManager.registerEvents(new ShiftFKeybinding(), this);
        pluginManager.registerEvents(new QKeybinding(), this);
        pluginManager.registerEvents(new ShiftQKeybinding(), this);
    }

    private void setUpConfigurationFile()
    {
        saveDefaultConfig();
        getConfig().options().setHeader(getHeaderComments());
        saveConfig();
    }

    private List<String> getHeaderComments()
    {
        String version = getDescription().getVersion();
        List<String> header = new ArrayList<>();

        header.add("## ====================== ##");
        header.add("## Plugin by MPlugins.net ##");
        header.add("## ====================== ##");
        header.add(null);
        header.add("GitHub: https://github.com/MPlugins/BindKeys");
        header.add(null);
        header.add("Discord: https://discord.gg/DgHD48E75s");
        header.add(null);
        header.add("Version: " + version);
        header.add(null);
        header.add(null);
        header.add(null);
        header.add("Note that any keybinding involving Q only works if the player holds an item in their hand. There");
        header.add("unfortunately is no way around this!");

        return header;
    }

    public static BindKeys getInstance()
    {
        return instance;
    }
}
