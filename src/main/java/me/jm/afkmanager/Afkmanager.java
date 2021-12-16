package me.jm.afkmanager;

import me.jm.afkmanager.commands.Cmd_afk;
import me.jm.afkmanager.eventHandlers.OnPlayerDamaged;
import me.jm.afkmanager.eventHandlers.OnPlayerMove;
import me.jm.afkmanager.tasks.Task_notMoving;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Afkmanager extends JavaPlugin {

    public long timeInSeconds = 30;
    public long timeInTicks = timeInSeconds * 20;

    @Override
    public void onEnable() {
        Cmd_afk cmd_afk = new Cmd_afk();

        getCommand("afk").setExecutor(cmd_afk);

        OnPlayerMove onPlayerMove = new OnPlayerMove();
        OnPlayerDamaged onPlayerDamaged = new OnPlayerDamaged();

        Bukkit.getPluginManager().registerEvents(onPlayerMove, this);
        Bukkit.getPluginManager().registerEvents(onPlayerDamaged, this);

        BukkitTask taskNotMoving = new Task_notMoving().runTaskTimer(this, timeInTicks, timeInTicks);

    }
}
