package com.creeperface.nukkit.minigamebase.test.data

import cn.nukkit.Player
import com.creeperface.nukkit.minigamebase.data.BasePlayerData
import com.creeperface.nukkit.minigamebase.test.arena.TestArena
import com.creeperface.nukkit.minigamebase.test.arena.data.TestArenaPlayerData

class TestPlayerData(player: Player) : BasePlayerData<TestPlayerData, TestArenaPlayerData, TestArena>(player) {
}