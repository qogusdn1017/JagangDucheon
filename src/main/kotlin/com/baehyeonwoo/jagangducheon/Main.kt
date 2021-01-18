package com.baehyeonwoo.jagangducheon

import org.bukkit.Bukkit
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
        val d = e.damager

        if (d is Player) {
            d.damage(e.finalDamage)
        }
    }
}