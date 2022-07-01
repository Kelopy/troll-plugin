package me.kelopy.trollol.commands;

import me.kelopy.trollol.commands.subcommands.explode;
import me.kelopy.trollol.commands.subcommands.freeze;
import me.kelopy.trollol.commands.subcommands.unfreeze;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager(){
        subCommands.add(new explode());
        subCommands.add(new freeze());
        subCommands.add(new unfreeze());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(args.length > 0){
                for(int i = 0; i < getSubCommands().size(); i++){
                    if(args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(p, args);
                    }
                }
            }else if(args.length == 0){
                p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------------------");
                for (int i = 0; i < getSubCommands().size(); i++){
                    p.sendMessage(ChatColor.RED + getSubCommands().get(i).getSyntax() + ChatColor.AQUA + " - " + ChatColor.GRAY + getSubCommands().get(i).getDescription());
                }
                p.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------------------");
            }
    }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

    public ArrayList<SubCommand> getSubCommands(){
        return subCommands;
    }

}
