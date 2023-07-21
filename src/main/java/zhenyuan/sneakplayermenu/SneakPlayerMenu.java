package zhenyuan.sneakplayermenu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import zhenyuan.sneakplayermenu.Listener.SneakPlayerListener;

public final class SneakPlayerMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new SneakPlayerListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
