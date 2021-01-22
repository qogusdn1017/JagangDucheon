package com.baehyeonwoo.jagangducheon

import org.bukkit.Bukkit
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.entity.Trident
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin


class Main : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    fun onJagangDucheon(e: EntityDamageByEntityEvent) {

        val dmgr = e.damager
        val d = e.finalDamage

        if (dmgr is Player) {
            dmgr.damage(d)
        }

        if (dmgr is Arrow) {
            val arrowsrc = dmgr.shooter as? Player ?: return
            arrowsrc.damage(d)
        }

        if (dmgr is Trident) {
            val tridentsrc = dmgr.shooter as? Player ?: return
            tridentsrc.damage(d)
        }
    }
}