package com.creeperface.nukkit.minigamebase.data

import cn.nukkit.Player
import com.creeperface.nukkit.minigamebase.arena.BaseArena
import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData

interface PlayerData<
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>,
        A : BaseArena<A, D, DA>
        > {

    val player: Player

    var arenaData: DA?

    fun close() {

    }
}