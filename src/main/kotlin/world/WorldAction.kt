package world

import player.Player

interface WorldAction<T: WorldObject> {
    fun run(obj: T, player: Player)
}