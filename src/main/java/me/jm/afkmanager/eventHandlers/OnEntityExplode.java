package me.jm.afkmanager.eventHandlers;

import me.jm.afkmanager.helpers.dataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class OnEntityExplode implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(e.getLocation().distance(p.getLocation())>=5 && dataManager.afkingPlayers.contains(p)){
                e.setCancelled(true);
                break;
            }
        }
    }
}
