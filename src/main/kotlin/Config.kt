import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import java.io.File

val jsonBuilder = Json {
    prettyPrint = true
    encodeDefaults = true
}

@Serializable
data class Config(
    val token: String = "TOKEN",
    val databaseConfig: DatabaseConfig = DatabaseConfig()
) {
    companion object {
        fun loadFromFile(file: File): Config {
            if(!file.exists()) createDefaultConfig(file)
            val text = file.readText()
            return jsonBuilder.decodeFromString(text)
        }

        fun createDefaultConfig(file: File) {
            val text = jsonBuilder.encodeToString(Config())
            file.writeText(text)
        }
    }
}

@Serializable
data class DatabaseConfig(
    val url: String = "MongoDB URL",
    val name: String = "MongoDB Database Name"
)