package me.kelopy.trollol.commands.subcommands;

import me.kelopy.trollol.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class freeze extends SubCommand {

    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public String getDescription() {
        return "freeze a player";
    }

    @Override
    public String getSyntax() {
        return "/troll freeze <player>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            Player target = Bukkit.getPlayerExact(args[1]);

            target.setWalkSpeed(0);

            player.sendMessage(ChatColor.GRAY + "You froze " + ChatColor.AQUA + target.getDisplayName() + ChatColor.GRAY + "!");
            player.sendMessage(ChatColor.GRAY + "You were frozen by " + ChatColor.AQUA + player.getDisplayName() + ChatColor.GRAY + "!");

        }else if(args.length == 1){
            player.sendMessage(ChatColor.RED + "Usage: /troll freeze <player>");
        }

    }

}
