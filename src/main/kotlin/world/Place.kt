package world

import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.io.File

object PlaceManager {

    private const val placesFilePath = "/places.json"

    var defaultPlace = "kinci"
    var places = mutableMapOf<String, Place>()

    fun loadPlaces() {
        val text = javaClass.getResource(placesFilePath)!!.readText()
        val json = Json.parseToJsonElement(text).jsonObject
        this.defaultPlace = json["defaultPlace"]!!.jsonPrimitive.content
        this.places = json["places"]!!.jsonObject.mapValues { e -> Json.decodeFromJsonElement<Place>(e.value) }.toMutableMap()
    }

}

@Serializable
data class Place(
    val name: String,
    val links: Array<String>,
    val type: PlaceType
)

enum class PlaceType {
    big_city,
    village,
    resource,
    waypoint
}