package com.creeperface.nukkit.minigamebase

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.player.PlayerQuitEvent
import com.creeperface.nukkit.minigamebase.arena.BaseArena
import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData
import com.creeperface.nukkit.minigamebase.data.BasePlayerData

class BaseEventHandler<
        A : BaseArena<A, D, DA>,
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>
        >(

    private val plugin: MinigameBase<A, D, DA>

) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        plugin.players[e.player.uniqueId] = plugin.playerDataFactory(e.player)
    }

    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        plugin.players.remove(e.player.uniqueId)?.close()
    }
}