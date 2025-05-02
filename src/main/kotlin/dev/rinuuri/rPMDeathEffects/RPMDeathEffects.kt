package dev.rinuuri.rPMDeathEffects

import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin

class RPMDeathEffects : JavaPlugin() {

    companion object {
        lateinit var instance: RPMDeathEffects private set
        lateinit var key: NamespacedKey private set
    }

    override fun onEnable() {
        instance = this
        key = NamespacedKey(instance, "death-effect")
        getCommand("setkillef")!!.setExecutor(Cmd())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
