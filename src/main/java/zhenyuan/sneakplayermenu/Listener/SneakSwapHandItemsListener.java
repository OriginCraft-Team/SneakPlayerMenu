package zhenyuan.sneakplayermenu.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class SneakSwapHandItemsListener implements Listener {
    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void onHand(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (!player.isSneaking()) {
            return;
        }
        // 取消將物品放置到副手的事件
        event.setCancelled(true);
        // 執行指令
        player.performCommand("cp Main");
    }
}
