package ece5xx.joint.project.app_Nick_A_Phil_N

// Simulating a pseudo database using an in-memory map
object PseudoDatabase { //objects have singleton initialization (on instance of object throughout lifetime of the app) Defaults to empty so no issues
    // A map to store user data where the key is the username and the value is a pair of password and PIN
    private val users = mutableMapOf<String, Pair<String, String>>() // <Username, Pair<Password, PIN>>

    // Function to check if the username exists in the "database"
    fun isUsernameTaken(username: String): Boolean {
        if (username.lowercase() == "null"){ //null check. If the username is null the line return user?.first == password will be true when we want it to be false)
            return true //Don't add a username of null in the database
        }
        return users.containsKey(username)
    }

    // Function to add a new user without error checking
    fun addUser(username: String, password: String, pin: String) {
        // Add user to the database (username as key, password and PIN as value)
        users[username] = Pair(password, pin)
    }

    // Function to check if the provided username and password match an existing user
    fun isUserValid(username: String, password: String): Boolean {
        //Handle if the user decided their password should be null (cheeky)
        if (password.lowercase() == "null") //null check. If the password is null the line return user?.first == password will be true when we want it to be false
        {
            return false
        }
        val user = users[username] //gets the password and pin for the associated username. Pair held in user val. If not found, user is null
        return user?.first == password // Check if the password matches.. If user is null (username not in the map) user?.first is null so null == password is checked.
    }                                   //only problem is if the user enters "null" as their password.
}

//Note: Kotlin is null safe so while checking for "null" isn't necessary it is still good practice
