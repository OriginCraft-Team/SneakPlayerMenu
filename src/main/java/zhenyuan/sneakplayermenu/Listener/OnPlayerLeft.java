package zhenyuan.sneakplayermenu.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeft implements Listener {
    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent player) {
        SneakPlayerListener.clickPlayers.remove(player.getPlayer());
    }
}
