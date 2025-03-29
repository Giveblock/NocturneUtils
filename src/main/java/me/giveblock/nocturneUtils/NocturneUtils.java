package me.giveblock.nocturneUtils;

import me.giveblock.nocturneUtils.api.listeners.ServerLoad;
import me.giveblock.nocturneUtils.commands.NocturneUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class NocturneUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.setupFiles();
        this.getCommand("nocturneutil").setExecutor(new NocturneUtil(this));
        this.getServer().getPluginManager().registerEvents(new ServerLoad(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setupFiles() {
        this.saveDefaultConfig();
        File datapacks = new File(this.getDataFolder(), "datapacks");
        if (!datapacks.exists()) {
            datapacks.mkdirs();
        }

    }

}
