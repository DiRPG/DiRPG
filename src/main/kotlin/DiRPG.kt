import database.Database
import world.PlaceManager

object DiRPG {

    lateinit var config: Config
    suspend fun start(config: Config) {
        this.config = config

        PlaceManager.loadPlaces()
        Database.connect(config.databaseConfig)
        Bot.start(config)
    }

}