package rpg.state

import dev.kord.core.behavior.edit
import dev.kord.core.entity.Message
import dev.kord.core.entity.User
import dev.kord.rest.builder.message.modify.embed
import rpg.RPGState

class RPGIdleState: RPGState {

    private var running = true

    override suspend fun render(user: User, message: Message) {
        message.edit {
            embed {
                title = "DiRPG - ${user.username} - Idling"

            }
        }
    }

    override fun stop() {
        running = false
    }

}