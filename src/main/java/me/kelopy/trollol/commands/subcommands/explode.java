package me.kelopy.trollol.commands.subcommands;

import me.kelopy.trollol.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class explode extends SubCommand {

    @Override
    public String getName() {
        return "explode";
    }

    @Override
    public String getDescription() {
        return "explode a player into smithereens";
    }

    @Override
    public String getSyntax() {
        return "/troll explode <player>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if(args.length > 1){
            Player target = Bukkit.getPlayerExact(args[1]);

            if(target != null){
                Location location = target.getLocation();

                target.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
                target.setHealth(0.0);

                player.sendMessage(ChatColor.GRAY + "You successfully bombed " + ChatColor.AQUA + target.getDisplayName() + ChatColor.GRAY + "!");
                player.sendMessage(ChatColor.GRAY + "You were bombed by " + ChatColor.AQUA + player.getDisplayName() + ChatColor.GRAY + "!");
            }else{
                player.sendMessage(ChatColor.RED + "Player not found.");
            }

        }else if(args.length == 1){
            player.sendMessage(ChatColor.RED + "Usage: /troll explode <player>");
        }

    }

}
