package ece5xx.joint.project.app_Nick_A_Phil_N

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import io.realm.kotlin.types.RealmUUID
import android.app.Application
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import androidx.lifecycle.ViewModel
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class User : RealmObject {
    @PrimaryKey
    var id: String = RealmUUID.random().toString()
    var username: String = ""
    var password: String = ""
    var pin: String = ""
}

// Singleton Realm instance to prevent multiple connections
object RealmDatabase {
    private val config = RealmConfiguration.Builder(schema = setOf(User::class)).build()
    val realm: Realm = Realm.open(config)
}

// Initialize Realm in Application class
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        RealmDatabase.realm // Ensures Realm is initialized
    }
}

// ViewModel using coroutine-friendly Realm operations
class UserViewModel : ViewModel() {
    private val realm = RealmDatabase.realm

    // Insert a new user into the database
    suspend fun addUser(username: String, password: String, pin: String): Boolean {
        return withContext(Dispatchers.IO) {
            // Check if the username already exists to avoid duplicates
            val existingUser = realm.query<User>("username == $0", username).first().find()
            if (existingUser == null) {
                realm.write {
                    copyToRealm(User().apply {
                        this.username = username
                        this.password = password
                        this.pin = pin
                    })
                }
                return@withContext true // User added successfully
            } else {
                return@withContext false // Username already exists
            }
        }
    }

    // Check if a given username exists in the database
    suspend fun checkUsernameExists(username: String): Boolean {
        return withContext(Dispatchers.IO) {
            val existingUser = realm.query<User>("username == $0", username).first().find()
            return@withContext existingUser != null
        }
    }

    // Check if a given username and password pair is in the database for login
    suspend fun checkLoginCredentials(username: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val user = realm.query<User>("username == $0 AND password == $1", username, password).first().find()
            return@withContext user != null
        }
    }

}


/*
PSEUDO DB WORK (DO NOT DELETE, NECESSARY BACKUP IF ALL ELSE FAILS)

data class User(
    val id: Int,
    val username: String,
    val password: String,
    val PIN: String
)

class PseudoDatabase {
    // This is your in-memory database (list of users)
    private val userList = mutableListOf<User>()

    // Insert a user into the pseudo-database
    fun insertUser(user: User): Boolean {
        if (userList.any { it.username == user.username }) {
            // If the username already exists, return false
            return false
        }
        userList.add(user)
        return true
    }

    // Get a user by username
    fun getUserByUsername(username: String): User? {
        return userList.find { it.username == username }
    }

    // Get a user by username and password for login check
    fun getUserByUsernameAndPassword(username: String, password: String): User? {
        return userList.find { it.username == username && it.password == password }
    }
}

class UserViewModel : ViewModel() {
    private val pseudoDatabase = PseudoDatabase()

    // Insert user into the pseudo-database
    fun insertUser(user: User): Boolean {
        return pseudoDatabase.insertUser(user)
    }

    // Get user by username
    fun getUserByUsername(username: String): User? {
        return pseudoDatabase.getUserByUsername(username)
    }

    // Check if a user with the given username and password exists
    fun getUserByUsernameAndPassword(username: String, password: String): User? {
        return pseudoDatabase.getUserByUsernameAndPassword(username, password)
    }
}


//Pseudo DB Example Usage

fun main() {
    val userViewModel = UserViewModel()

    // Create a new user
    val user1 = User(id = 1, username = "test1", password = "password123", pin = "1234")

    // Insert user into the "database"
    if (userViewModel.insertUser(user1)) {
        println("User inserted successfully!")
    } else {
        println("User already exists!")
    }

    // Try to get the user by username
    val retrievedUser = userViewModel.getUserByUsername("test1")
    if (retrievedUser != null) {
        println("User found: $retrievedUser")
    } else {
        println("User not found!")
    }

    // Try to login with username and password
    val loggedInUser = userViewModel.getUserByUsernameAndPassword("test1", "password123")
    if (loggedInUser != null) {
        println("Login successful: $loggedInUser")
    } else {
        println("Login failed!")
    }
}


* */

