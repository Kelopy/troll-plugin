package me.kelopy.trollol;

import me.kelopy.trollol.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trollol extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Trolling people...");

        getCommand("troll").setExecutor(new CommandManager());
    }

}
