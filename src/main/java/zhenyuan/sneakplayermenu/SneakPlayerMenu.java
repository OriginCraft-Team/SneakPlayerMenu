package zhenyuan.sneakplayermenu;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import zhenyuan.sneakplayermenu.Listener.OnPlayerLeft;
import zhenyuan.sneakplayermenu.Listener.SneakPlayerListener;
import zhenyuan.sneakplayermenu.Listener.SneakSwapHandItemsListener;

@SuppressWarnings("unused")
public final class SneakPlayerMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new SneakPlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerLeft(), this);
        Bukkit.getPluginManager().registerEvents(new SneakSwapHandItemsListener(), this);
        Bukkit.getConsoleSender().sendMessage(
                Component.text("This plugin is made by Zhenyuan, please do not steal it.")
                        .color(NamedTextColor.GREEN)
        );
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(
                Component.text("Thank you for using this plugin! made by Zhenyuan")
                        .color(NamedTextColor.GREEN)
        );
    }
}
