package com.creeperface.nukkit.minigamebase.test

import com.creeperface.nukkit.minigamebase.test.arena.TestArena
import com.creeperface.nukkit.minigamebase.test.arena.data.TestArenaPlayerData
import com.creeperface.nukkit.minigamebase.test.data.TestPlayerData
import com.creeperface.nukkit.minigamebase.test.util.TestMinigameBase

class TestPlugin : TestMinigameBase(
    TestArena::class,
    TestPlayerData::class,
    TestArenaPlayerData::class
) {

    override fun onLoad() {

    }

    override fun onEnable() {

    }
}