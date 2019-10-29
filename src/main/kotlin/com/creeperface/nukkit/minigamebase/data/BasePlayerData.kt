package com.creeperface.nukkit.minigamebase.data

import cn.nukkit.Player
import com.creeperface.nukkit.minigamebase.arena.BaseArena
import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData

open class BasePlayerData<
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>,
        A : BaseArena<A, D, DA>
        >(

    override val player: Player

) : PlayerData<D, DA, A> {

    override var arenaData: DA? = null

}