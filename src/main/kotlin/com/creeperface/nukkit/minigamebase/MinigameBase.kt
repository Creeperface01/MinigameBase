package com.creeperface.nukkit.minigamebase

import cn.nukkit.Player
import cn.nukkit.plugin.PluginBase
import com.creeperface.nukkit.minigamebase.arena.BaseArena
import com.creeperface.nukkit.minigamebase.arena.data.BaseArenaPlayerData
import com.creeperface.nukkit.minigamebase.data.BasePlayerData
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.full.createType

@Suppress("UNCHECKED_CAST")
abstract class MinigameBase<
        A : BaseArena<A, D, DA>,
        D : BasePlayerData<D, DA, A>,
        DA : BaseArenaPlayerData<D, DA, A>
        >(
    arena: KClass<A>,
    playerData: KClass<D>,
    arenaPlayerData: KClass<DA>
) : PluginBase() {

    private val arenas = Int2ObjectOpenHashMap<A>()

    internal val players = mutableMapOf<UUID, D>()

    internal var playerDataFactory: (Player) -> D //TODO: add more arguments?
        private set

    internal var playerArenaDataFactory: (Player, BaseArena<A, D, DA>) -> DA //TODO: add more arguments?
        private set

    internal var arenaFactory: () -> BaseArena<A, D, DA> //TODO: add more arguments
        private set

    init {
        fun <T : Any> KClass<T>.findConstructor(vararg args: KType): KFunction<T> {
            return this.constructors.first {
                val arguments = args.toMutableList()

                it.parameters.forEach { param ->
                    val iterator = arguments.iterator()

                    var match = false
                    while (iterator.hasNext()) {
                        val arg = iterator.next()

                        if (param.type == arg) {
                            iterator.remove()
                            match = true
                        }
                    }

                    if (!param.isOptional && !match) {
                        return@first false
                    }
                }

                return@first arguments.isEmpty()
            }
        }

        val dataConstructor = playerData.findConstructor(Player::class.createType())

        playerDataFactory = { p ->
            dataConstructor.call(p)
        }

        println(0)
        val arenaDataConstructor = arenaPlayerData.findConstructor(
            Player::class.createType(),
            arena.createType()
        )

        println(1)
        playerArenaDataFactory = { p, a ->
            arenaDataConstructor.call(p, a)
        }

        val arenaConstructor = arena.findConstructor()

        arenaFactory = {
            arenaConstructor.call()
        }

        println(2)
    }

    fun setPlayerDataFactory(factory: (Player) -> D) {
        playerDataFactory = factory
    }

    fun getArena(id: Int): A? = arenas[id]
}