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
        // 檢查玩家是否在潛行狀態
        if (player.isSneaking()) {
            //確認對象是否玩家
            if (!(event.getRightClicked() instanceof Player clickPlayer)) return;
            //現在時間放入變數
            long currTime = System.currentTimeMillis();

            //如果沒有玩家資料就放置資料
            if (!clickPlayers.containsKey(player)) {
                clickPlayers.put(player, currTime);

            }

            if ((currTime - clickPlayers.get(player)) > 1000) {
                clickPlayers.remove(player);
                SneakPlayerMessage.sendSneakPlayerMessage(player, clickPlayer);
            }

            // 將訊息發送到控制台
            Bukkit.getConsoleSender().sendMessage(Component.text("玩家 " + player.getName() + " 正在與玩家 " + clickPlayer.getName() + " 進行潛行互動。"));
        }





    }
}
