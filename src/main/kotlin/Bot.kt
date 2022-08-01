

import bot.extension.MiscCommandExtension
import bot.extension.PlayerCommandExtension
import bot.extension.RpgCommandExtension
import bot.extension.TestCommandExtension
import com.kotlindiscord.kord.extensions.ExtensibleBot
import dev.kord.core.Kord


object Bot {

    lateinit var extensibleBot: ExtensibleBot

    suspend fun start(config: Config) {
        extensibleBot = ExtensibleBot(config.token) {
            extensions {
                add(::MiscCommandExtension)
                add(::RpgCommandExtension)
                add(::TestCommandExtension)
                add(::PlayerCommandExtension)
            }
        }

        extensibleBot.start()
    }

    fun kord() = extensibleBot.getKoin().get<Kord>()

}