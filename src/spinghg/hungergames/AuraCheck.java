/*
 * Copyright (C) 2014 Maciej Mionskowski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package spinghg.hungergames;

import com.comphenix.packetwrapper.WrapperPlayServerEntityDestroy;
import com.comphenix.packetwrapper.WrapperPlayServerNamedEntitySpawn;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class AuraCheck {
    private final libsHg plugin;
    private HashMap<Integer, Boolean> entitiesSpawned = new HashMap<>();
    private CommandSender invoker;
    private Player checked;
    private static Vector[] vectors = {new Vector(0, 0, 1.5), new Vector(-1.5, 0, 0), new Vector(1.5, 0, 0), new Vector(0, 0, -1.5), new Vector(1.5, 0, 1.5), new Vector(-1.5, 0, -1.5),};
    private long started;
    private long finished = 9223372036854775807L;


    public AuraCheck(libsHg plugin, Player checked) {
        this.plugin = plugin;
        this.checked = checked;
    }

    public void invoke(CommandSender player) {
        this.invoker = player;
        this.started = System.currentTimeMillis();
        for (int i = 0; i < Math.min(vectors.length, plugin.getConfig().getInt("amountOfFakePlayers", 6)); i++) {
            WrapperPlayServerNamedEntitySpawn wrapper = getWrapper(this.checked.getLocation().add(vectors[i]).toVector(),plugin);
            entitiesSpawned.put(wrapper.getEntityID(), false);
            wrapper.sendPacket(this.checked);
        }

        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
            @Override
            public void run() {
                AbstractMap.SimpleEntry<Integer, Integer> result = end();
                plugin.remove(checked.getUniqueId());
                if (invoker instanceof Player && !((Player) invoker).isOnline()) {
                    return;
                }
                invoker.sendMessage("§6§oResultado do teste: mortos " + result.getKey() + "/" + result.getValue());
                double timeTaken = finished != Long.MAX_VALUE ? (int) ((finished - started) / 1000) : ((double)plugin.getConfig().getInt("ticksToKill",10)/20);
                invoker.sendMessage("§6§oclicks: " + timeTaken + " segundos.");
            }
        }, plugin.getConfig().getInt("ticksToKill",20));
    }

    public void markAsKilled(Integer val) {
        if (entitiesSpawned.containsKey(val)) {
            entitiesSpawned.put(val, true);
            kill(val).sendPacket(checked);
        }
        if (!entitiesSpawned.containsValue(false)) {
            this.finished = System.currentTimeMillis();
        }

    }

    public AbstractMap.SimpleEntry<Integer, Integer> end() {
        int killed = 0;
        for (Map.Entry<Integer, Boolean> entry : entitiesSpawned.entrySet()) {
            if (entry.getValue()) {
                killed++;
            } else if (checked.isOnline()) {
                kill(entry.getKey()).sendPacket(checked);
            }

        }
        int amount = entitiesSpawned.size();
        entitiesSpawned.clear();
        return new AbstractMap.SimpleEntry<>(killed, amount);
        

    }

    public static WrapperPlayServerNamedEntitySpawn getWrapper(Vector loc, libsHg plugin) {
        WrapperPlayServerNamedEntitySpawn wrapper = new WrapperPlayServerNamedEntitySpawn();
        wrapper.setEntityID(libsHg.RANDOM.nextInt(20000));
        wrapper.setPosition(loc);
        wrapper.setPlayerUUID(UUID.randomUUID().toString());
        wrapper.setPlayerName("§cBudokkan");
        wrapper.setYaw(0);
        wrapper.setPitch(-45);
        WrappedDataWatcher watcher = new WrappedDataWatcher();
        watcher.setObject(0, Byte.valueOf(plugin.getConfig().getBoolean("invisibility", false) ? Byte.valueOf((byte) 32).byteValue() : 0));
        watcher.setObject(6, Float.valueOf(0.5F));
        watcher.setObject(11, Byte.valueOf((byte) 1));
        wrapper.setMetadata(watcher);
        return wrapper;
    }

    public static WrapperPlayServerEntityDestroy kill(int entity) {
        WrapperPlayServerEntityDestroy wrapper = new WrapperPlayServerEntityDestroy();
        wrapper.setEntities(new int[]{entity});
        return wrapper;
    }
}
