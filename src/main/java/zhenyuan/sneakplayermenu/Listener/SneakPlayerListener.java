package zhenyuan.sneakplayermenu.Listener;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import zhenyuan.sneakplayermenu.Message.SneakPlayerMessage;

import java.util.HashMap;

public class SneakPlayerListener implements Listener {
    public static HashMap<Player, Long> clickPlayers = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        // 玩家如果沒有在潛行狀態就不執行以下代碼
        if (!player.isSneaking() || !(event.getRightClicked() instanceof Player clickPlayer)) {
            return;
        }

        //目前系統時間放入變數
        long currTime = System.currentTimeMillis();
        // 檢測是否有時間間隔,沒有則放置,有則判斷是否超過時間
        if (!clickPlayers.containsKey(player) || (currTime - clickPlayers.getOrDefault(player, 0L)) > 1000) {
            clickPlayers.put(player, currTime);
            SneakPlayerMessage.sendSneakPlayerMessage(player, clickPlayer);
            // 將訊息發送到控制台
            Bukkit.getConsoleSender().sendMessage(Component.text("玩家 " + player.getName() + " 正在與玩家 " + clickPlayer.getName() + " 進行潛行互動。"));
        }
    }
}
