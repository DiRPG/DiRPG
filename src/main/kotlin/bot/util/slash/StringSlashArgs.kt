package bot.util.slash

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string

class StringSlashArgs: Arguments() {

    val string by string {
        name = "input_string"
        description = "Input string"
    }

}