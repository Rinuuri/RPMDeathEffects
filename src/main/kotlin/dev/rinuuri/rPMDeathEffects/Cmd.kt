package dev.rinuuri.rPMDeathEffects

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType

class Cmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty() || sender !is Player) return true

        val effect = RPMDeathEffects.instance.config.getConfigurationSection(args[0])

        if (args[0] != "null" && (effect == null || !sender.hasPermission(effect.getString("permission","*")!!))) return true
        sender.persistentDataContainer.set(RPMDeathEffects.key, PersistentDataType.STRING, args[0])
        return true
    }
}