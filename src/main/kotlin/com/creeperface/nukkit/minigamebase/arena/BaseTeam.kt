package com.creeperface.nukkit.minigamebase.arena

import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData
import com.creeperface.nukkit.minigamebase.data.BasePlayerData
import java.util.*

open class BaseTeam<
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>,
        A : BaseArena<A, D, DA>
        >(
    val id: Int
) {

    val players = mutableMapOf<UUID, DA>()
}