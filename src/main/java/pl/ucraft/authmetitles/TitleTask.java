package pl.ucraft.authmetitles;

import fr.xephi.authme.api.v3.AuthMeApi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TitleTask implements Runnable {

    private final AuthMeApi authMeApi;
    private final String titleHeader;
    private final String subtitleUnregistered;
    private final String subtitleUnauthenticated;

    TitleTask(AuthMeTitlesPlugin plugin, AuthMeApi authMeApi){
        this.authMeApi = authMeApi;
        this.titleHeader = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("header", "KiwiMc.pl"));
        this.subtitleUnregistered = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("unregistered", "Register with /register <pass> <pass>"));
        this.subtitleUnauthenticated = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("unauthenticated", "Log in with /login <password>"));
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(!authMeApi.isRegistered(player.getName())){
                player.sendTitle(titleHeader, subtitleUnregistered, 0, 15, 5);
                return;
            }

            if(!authMeApi.isAuthenticated(player)){
                player.sendTitle(titleHeader, subtitleUnauthenticated, 0, 15, 5);
                return;
            }
        }
    }
}
