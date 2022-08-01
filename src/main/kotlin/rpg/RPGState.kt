package rpg

import dev.kord.core.entity.Message
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.EmbedBuilder

interface RPGState {

    suspend fun render(user: User, message: Message)

    fun stop()

}