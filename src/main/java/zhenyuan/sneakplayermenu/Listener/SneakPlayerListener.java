package zhenyuan.sneakplayermenu.Listener;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import zhenyuan.sneakplayermenu.Message.SneakPlayerMessage;

public class SneakPlayerListener implements Listener {
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        // 檢查玩家是否在潛行狀態
        if (player.isSneaking()) {
            Player clickPlayer = (Player) event.getRightClicked();
            SneakPlayerMessage.sendSneakPlayerMessage(player, clickPlayer);

            // 將訊息發送到控制台
            Bukkit.getConsoleSender().sendMessage(Component.text("玩家 " + player.getName() + " 正在與玩家 " + clickPlayer.getName() + " 進行潛行互動。"));
        }
    }
}
