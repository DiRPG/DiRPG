import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import java.io.File

const val defaultConfigPath = "./config.json"

suspend fun main(args: Array<String>) {
    val parser = ArgParser("DiRPG")
    val configPath by parser.option(ArgType.String, description = "The path of the config file")

    parser.parse(args)

    val configFile = File(configPath ?: defaultConfigPath)
    val config = Config.loadFromFile(configFile)

    DiRPG.start(config)
}