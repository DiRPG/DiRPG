package bot.extension

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import player.PlayerService

class RpgCommandExtension: Extension() {

    override val name = "rpgCommands"

    override suspend fun setup() {
        publicSlashCommand {
            name = "rpg"
            description = "Start DiRPG game"

            action {
                respond {
                    content = "Starting DiRPG"

                }
            }
        }
    }

}