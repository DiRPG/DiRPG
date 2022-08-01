package database

import DatabaseConfig
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import io.ktor.util.*
import org.bson.Document
import org.litote.kmongo.KMongo
import org.slf4j.LoggerFactory

object Database {

    val logger = LoggerFactory.getLogger(javaClass)

    lateinit var client: MongoClient
    lateinit var database: MongoDatabase

    fun connect(config: DatabaseConfig): Boolean {
        logger.info("Connecting database...")
        try {
            client = KMongo.createClient(config.url)
            database = client.getDatabase(config.name)
            logger.info("Connected to database successfully!")
        } catch (e: Exception) {
            logger.error("Couldn't initialize database! Check below for detailed message")
            logger.error(e)
            return false
        }
        return true
    }
}