package ece5xx.joint.project.app_Nick_A_Phil_N

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// 1. Define User Entity
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String,
    val pin: String
)

// 2. Create the DAO (Data Access Object)
@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password LIMIT 1")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?
}

// 3. Create the Room Database class
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// 4. Create a ViewModel to interact with the Database
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    // Insert user into the database
    fun insertUser(user: User) {
        viewModelScope.launch {
            try {
                userDao.insertUser(user)
            } catch (e: Exception) {
                // Handle error (e.g., log the error)
            }
        }
    }

    // Get user by username (Wrap in a coroutine)
    suspend fun getUserByUsername(username: String): User? {
        return withContext(Dispatchers.IO) {
            try {
                userDao.getUserByUsername(username)
            } catch (e: Exception) {
                // Handle error (e.g., log the error)
                null
            }
        }
    }

    // Check if a user with the given username and password exists
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            try {
                userDao.getUserByUsernameAndPassword(username, password)
            } catch (e: Exception) {
                // Handle error (e.g., log the error)
                null
            }
        }
    }
}

