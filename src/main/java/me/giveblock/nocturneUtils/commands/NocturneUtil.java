package me.giveblock.nocturneUtils.commands;

import me.giveblock.nocturneUtils.NocturneUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class NocturneUtil implements CommandExecutor {

    private Plugin pl = NocturneUtils.getPlugin(NocturneUtils.class);

    public NocturneUtil(NocturneUtils plugin) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0 && !(sender instanceof Player) && args[0].equalsIgnoreCase("broadcastrestart")) {
            if (args[2].equalsIgnoreCase("m")) {
                Bukkit.getServer().broadcastMessage("§7[§8§lNocturne§7] §cDaily Restart In §4" + args[1] + " minutes");
            }

            if (args[2].equalsIgnoreCase("s")) {
                Bukkit.getServer().broadcastMessage("§7[§8§lNocturne§7] §cDaily Restart In §4" + args[1] + " seconds");
            }

            if (args[1].equalsIgnoreCase("restart")) {
                Bukkit.getServer().broadcastMessage("§7[§8§lNocturne§7] §4Restarting...");
            }
        }


        return false;
    }


}
