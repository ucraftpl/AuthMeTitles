package pl.ucraft.authmetitles;

import fr.xephi.authme.api.v3.AuthMeApi;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuthMeTitlesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        AuthMeApi authMeApi = AuthMeApi.getInstance();
        saveDefaultConfig();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new TitleTask(this, authMeApi), 10L, 10L);
    }

    @Override
    public void onDisable() {

    }
}
