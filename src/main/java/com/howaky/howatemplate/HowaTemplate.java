package com.howaky.howatemplate;

import com.github.howard12721.howalib.HowaLib;
import com.howaky.howatemplate.config.Settings;
import lombok.Getter;
import net.william278.annotaml.Annotaml;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public final class HowaTemplate extends JavaPlugin {

    @Getter
    private static HowaTemplate plugin;

    @Getter
    private Settings settings;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();
        loadConfig();

        HowaLib.initialize(this);
    }

    @Override
    public void onDisable() {
        HowaLib.dispose();
    }

    private void loadConfig() throws RuntimeException {
        try {
            this.settings = Annotaml.create(new File(getDataFolder(), "config.yml"), Settings.class).get();
        } catch (IOException | InvocationTargetException | InstantiationException |
                IllegalAccessException e) {
            getLogger().log(Level.SEVERE, "コンフィグの読み込みに失敗しました", e);
            throw new RuntimeException(e);
        }
    }
}
