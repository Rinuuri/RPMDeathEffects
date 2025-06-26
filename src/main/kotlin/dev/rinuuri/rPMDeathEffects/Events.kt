package dev.rinuuri.rPMDeathEffects

import io.lumine.mythic.api.mobs.MythicMob
import io.lumine.mythic.bukkit.BukkitAdapter
import io.lumine.mythic.bukkit.MythicBukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.persistence.PersistentDataType

class Events : Listener {
    @EventHandler
    fun onDeath(event: PlayerDeathEvent){
        val e = event.entity.killer ?: return
        val name = e.persistentDataContainer
            .get(RPMDeathEffects.key, PersistentDataType.STRING) ?: return
        val effect = RPMDeathEffects.instance.config.getConfigurationSection(name) ?: return
        val mob: MythicMob = MythicBukkit.inst().mobManager.getMythicMob(
            effect.getString("mm-id") ?: return
        ).orElse(null) ?: return
        mob.spawn(BukkitAdapter.adapt(event.player.location), 1.0)
    }
}