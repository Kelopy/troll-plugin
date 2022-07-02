package me.kelopy.trollol.commands.subcommands;

import me.kelopy.trollol.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class unfreeze extends SubCommand {

    @Override
    public String getName() {
        return "unfreeze";
    }

    @Override
    public String getDescription() {
        return "unfreeze a player";
    }

    @Override
    public String getSyntax() {
        return "/troll unfreeze <player>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            Player target = Bukkit.getPlayerExact(args[1]);

            if(target != null){
                target.setWalkSpeed((float) 0.2);

                player.sendMessage(ChatColor.GRAY + "You unfroze " + ChatColor.AQUA + target.getDisplayName() + ChatColor.GRAY + "!");
                player.sendMessage(ChatColor.GRAY + "You were unfrozen by " + ChatColor.AQUA + player.getDisplayName() + ChatColor.GRAY + "!");
            }else{
                player.sendMessage(ChatColor.RED + "Player not found.");
            }

        }else if(args.length == 1){
            player.sendMessage(ChatColor.RED + "Usage: /troll unfreeze <player>");
        }

    }

}
