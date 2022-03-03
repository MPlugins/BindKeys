package net.mplugins.bindkeys;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class BindKeys extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        this.setUpConfigurationFile();
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

        return header;
    }
}
