package zhenyuan.sneakplayermenu.Message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class SneakPlayerMessage {
    public static void sendSneakPlayerMessage(Player player, Player target) {
        Component Message = Component.text().build();
        //裝飾用
        Message = Message.append(
                Component.text("--------------------------------")
                        .append(Component.newline())
        );
        //標題
        Message = Message.append(
                Component.text("玩家交互系統")
                        .color(NamedTextColor.AQUA)
                        .append(Component.newline())
        );
        //顯示目標玩家
        Message = Message.append(
                Component.text("目標玩家: ")
                        .color(NamedTextColor.AQUA)
                        .append(Component.text(target.getName()))
                        .color(NamedTextColor.YELLOW)
                        .append(Component.newline())
                        .append(Component.newline())
        );
        //操作面板
        Message = Message.append(
                Component.text("[私訊]")
                        .color(NamedTextColor.GREEN)
                        .clickEvent(ClickEvent.suggestCommand("/m " + target.getName() + " "))
                        .append(Component.newline())
        );
        //裝飾用
        Message = Message.append(Component.text("--------------------------------"));

        player.sendMessage(Message);

    }
}
