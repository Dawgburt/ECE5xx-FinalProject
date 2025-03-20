package ece5xx.joint.project.app_Nick_A_Phil_N

sealed class Screen(val route: String) {
    object LoginScreen : Screen(route = "login_screen")
    object AddUserScreen : Screen(route = "add_user_screen")
    object LoginCheckDBSplashScreen : Screen(route = "login_check_db_splash_screen/{username}/{password}")
    object AddUserCheckDBSplashScreen : Screen(route = "add_user_check_db_splash_screen/{username}/{password}/{PIN}")
    object SendPINandLockStatusScreen : Screen(route = "send_pin_and_lock_status_screen/{username}/{password}")
}