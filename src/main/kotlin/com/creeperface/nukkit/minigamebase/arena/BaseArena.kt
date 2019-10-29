package com.creeperface.nukkit.minigamebase.arena

import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData
import com.creeperface.nukkit.minigamebase.data.BasePlayerData
import java.util.*

abstract class BaseArena<
        A : BaseArena<A, D, DA>,
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>
        >(

    val id: Int

) {

    private val players = mutableMapOf<UUID, D>()

    fun onPlayerJoin() {

    }

    fun onPlayerLeave() {

    }

    fun startGame() {

    }

    fun endGame() {

    }

    fun stopGame() {

    }
}