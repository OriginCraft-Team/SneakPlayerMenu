package zhenyuan.sneakplayermenu.Message;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;

public class SneakPlayerMessage {
    public static void sendSneakPlayerMessage(Player player, Player target) {
        TextComponent message = Component.text()
                .append(Component.text("--------------------------------"))
                .append(Component.newline())
                .append(Component.text("玩家交互系統", NamedTextColor.AQUA, TextDecoration.BOLD))
                .append(Component.newline())
                .append(Component.text("目標玩家: ")
                        .append(Component.text(target.getName()))
                        .color(NamedTextColor.YELLOW)
                        .append(Component.newline())
                        .append(Component.newline()))
                .append(Component.text("[私訊] ")
                        .color(NamedTextColor.GREEN)
                        .clickEvent(ClickEvent.suggestCommand("/m " + target.getName() + " ")))
                .append(Component.text("[轉帳]")
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .clickEvent(ClickEvent.suggestCommand("/pay " + target.getName() + " "))
                        .append(Component.newline()))
                .append(Component.text("--------------------------------"))
                .build();

        player.sendMessage(message);

    }
}
