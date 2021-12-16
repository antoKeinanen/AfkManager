package me.jm.afkmanager.helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AfkSetter {

    public static void setPlayerAfk(Player player) {
        if (!dataManager.afkingPlayers.contains(player)) {
            dataManager.afkingPlayers.add(player);
            player.setCollidable(false);

            player.setPlayerListName(ChatColor.GRAY + player.getName());
            player.sendMessage("You are now afk!");

            Bukkit.getLogger().info(player.getName() + " is now afk");

        } else {
            dataManager.afkingPlayers.remove(player);
            player.setCollidable(true);

            player.setPlayerListName(ChatColor.WHITE + player.getName());
            player.sendMessage("You are no longer afk!");

            Bukkit.getLogger().info(player.getName() + " is no longer afk");
        }
    }
}
