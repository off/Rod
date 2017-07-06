package com.glenjendary.rod;

import com.glenjendary.rod.commands.Rod;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/* Rod Created by Glenjendary on 6/07/2017. */

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        registerCommands();

        logger.info(pdfFile.getName() + " has been enabled with version "
                + pdfFile.getVersion());

    }

    public void registerCommands() {

        getCommand("rod").setExecutor(new Rod(this));

    }

    public void onDisable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled with version "
                + pdfFile.getVersion());
    }
}
