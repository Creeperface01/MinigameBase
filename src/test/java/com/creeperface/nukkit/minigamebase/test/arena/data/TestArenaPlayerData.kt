package com.creeperface.nukkit.minigamebase.test.arena.data

import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData
import com.creeperface.nukkit.minigamebase.test.arena.TestArena
import com.creeperface.nukkit.minigamebase.test.data.TestPlayerData

class TestArenaPlayerData(data: TestPlayerData, arena: TestArena) :
    BaseArenaPlayerData<TestPlayerData, TestArenaPlayerData, TestArena>(data, arena) {
}