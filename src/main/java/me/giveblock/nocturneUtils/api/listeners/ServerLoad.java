package me.giveblock.nocturneUtils.api.listeners;

import me.giveblock.nocturneUtils.api.helpers.DatapackHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

public class ServerLoad implements Listener {

    public ServerLoad() {
    }

    @EventHandler
    public void onServerLoad(ServerLoadEvent e) {
        if (e.getType().equals(ServerLoadEvent.LoadType.STARTUP)) {
            DatapackHelper.checkPacks();
        }

    }


}
