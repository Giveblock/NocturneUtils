package me.giveblock.nocturneUtils.api.helpers;

import me.giveblock.nocturneUtils.NocturneUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class DatapackHelper {

    private static final Plugin pl = NocturneUtils.getPlugin(NocturneUtils.class);

    public static void DatapackHelper() {}

    public static void checkPacks() {
        List<World> worlds = Bukkit.getWorlds();
        Iterator var1 = worlds.iterator();

        while(var1.hasNext()) {
            World world = (World)var1.next();
            String name = world.getName();
            if (!name.endsWith("DIM-1") && !name.endsWith("DIM1")) {
                checkWorldPacks(name);
            }
        }

    }

    public static void checkWorldPacks(String world) {
        File[] packs = (new File(pl.getDataFolder(), "datapacks")).listFiles();

        assert packs != null;

        File[] var2 = packs;
        int var3 = packs.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            File pack = var2[var4];
            File worldPack = new File(world + "/datapacks/" + pack.getName());
            if (!worldPack.exists()) {
                copyPack(pack.getName(), world);
            }
        }

    }

    private static void copyPack(String name, String world) {
        File pFolder = new File(pl.getDataFolder(), "datapacks/" + name);
        File wFolder = new File(world + "/datapacks/" + name);
        if (!wFolder.exists()) {
            wFolder.mkdirs();
        }

        try {
            FileUtils.copyDirectory(pFolder, wFolder);
            Bukkit.getLogger().info(name + " copied to world: " + world);
        } catch (IOException var5) {
            IOException e = var5;
            throw new RuntimeException(e);
        }
    }


}
