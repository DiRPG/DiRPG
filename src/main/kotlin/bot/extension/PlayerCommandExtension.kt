package bot.extension

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import player.PlayerService
import player.buildPlayer

class PlayerCommandExtension: Extension() {

    override val name = "playerCommands"

    override suspend fun setup() {

        publicSlashCommand {
            name = "register"
            description = "Register to DiRPG"

            action {

                PlayerService.register(buildPlayer {
                    discordID = user.id
                })

                respond {
                    embed {
                        title = "Registration"
                        description = "Successfully registered to DiRPG!"
                        color = Color(0, 255, 0)
                    }
                }
            }
        }

    }

}