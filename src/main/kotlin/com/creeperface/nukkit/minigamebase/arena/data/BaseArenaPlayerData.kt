package com.creeperface.nukkit.minigamebase.arena.data

import com.creeperface.nukkit.minigamebase.arena.BaseArena
import com.creeperface.nukkit.minigamebase.data.BasePlayerData
import com.creeperface.nukkit.minigamebase.data.PlayerData

open class BaseArenaPlayerData<
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>,
        A : BaseArena<A, D, DA>
        >(
    data: D,
    val arena: A
) : PlayerData<D, DA, A> by data