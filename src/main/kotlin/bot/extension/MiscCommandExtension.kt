package bot.extension

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed

class MiscCommandExtension: Extension() {

    override val name = "miscCommands"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ping"
            description = "Check the ping."

            action {
                respond {
                    embed {
                        title = "Ping!"
                        description = "${this@publicSlashCommand.kord.gateway.averagePing}"
                    }
                }
            }
        }
    }

}