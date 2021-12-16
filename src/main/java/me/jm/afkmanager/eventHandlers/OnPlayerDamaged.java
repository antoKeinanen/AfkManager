package me.jm.afkmanager.eventHandlers;

import me.jm.afkmanager.helpers.dataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnPlayerDamaged implements Listener {

    @EventHandler
    public void onPlayerDamaged(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();
        if (!dataManager.afkingPlayers.contains(player)) return;

        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDamagedByEntity(EntityDamageByEntityEvent e){
        if (!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();
        if (!dataManager.afkingPlayers.contains(player)) return;

        if(e.getDamager() instanceof Player) return;

        e.getDamager().remove();

        e.setCancelled(true);
    }
}
