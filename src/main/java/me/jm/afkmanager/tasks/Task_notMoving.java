package me.jm.afkmanager.tasks;

import me.jm.afkmanager.helpers.AfkSetter;
import me.jm.afkmanager.helpers.dataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Task_notMoving extends BukkitRunnable {
    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!dataManager.afkingPlayers.contains(p) && p.getVelocity().length() == 0) {
                if (dataManager.notMovingPlayers.contains(p)) {
                    dataManager.notMovingPlayers.remove(p);
                    AfkSetter.setPlayerAfk(p);
                } else {
                    dataManager.notMovingPlayers.add(p);
                }
            }
        }
    }
}

