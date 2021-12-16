package me.jm.afkmanager.eventHandlers;

import me.jm.afkmanager.helpers.AfkSetter;
import me.jm.afkmanager.helpers.dataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if (dataManager.afkingPlayers.contains(player)) {
            AfkSetter.setPlayerAfk(player);
            return;
        }
        dataManager.notMovingPlayers.remove(player);
    }
}
