package com.baehyeonwoo.jagangducheon

import org.bukkit.Bukkit
import org.bukkit.entity.Arrow
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin


class Main  : JavaPlugin(), Listener {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    fun onJagangDucheon(e: EntityDamageByEntityEvent) {
        val dmgr = e.damager
        val d = e.finalDamage

        if (e.entity !is Player) return
        if (e.damager !is Arrow)
            return
        val src = (e.damager as Arrow).shooter as? Player ?: return
        src.damage(d)
        if (dmgr is Player) {
            dmgr.damage(d)
        }
    }
}