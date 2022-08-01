package player

import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.InsertOneResult
import com.mongodb.client.result.UpdateResult
import database.Database
import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Message
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import rpg.RPGState
import world.Place
import world.PlaceManager

object PlayerService {

    private val collection
        get() = Database.database.getCollection<Player>()

    fun register(player: Player): InsertOneResult = collection.insertOne(player)

    fun update(player: Player): UpdateResult = collection.replaceOne(Player::discordId eq player.discordId, player)

    fun find(discordID: Snowflake): Player? = collection.findOne(Player::discordId eq discordID)

    fun delete(discordID: Snowflake): DeleteResult = collection.deleteOne(Player::discordId eq discordID)

    fun exists(discordID: Snowflake): Boolean = find(discordID) != null

}

class Player(
    val discordId: Snowflake,
    private var state: RPGState?,
    val location: Place,
    val renderTo: Message?
) {


    suspend fun user() = Bot.kord().getUser(discordId)!!

    suspend fun state(newState: RPGState) {
        this.state?.stop()
        this.state = newState
        this.state?.render(user(), renderTo!!)
    }

}

open class PlayerBuilder {

    open var discordID: Snowflake = Snowflake.max

    fun build(): Player {
        return Player(
            discordId = discordID,
            state = null,
            location = PlaceManager.places[PlaceManager.defaultPlace]!!,
            renderTo = null
        )
    }

}

fun buildPlayer(block: PlayerBuilder.() -> Unit): Player {
    val builder = PlayerBuilder()
    block(builder)
    return builder.build()
}