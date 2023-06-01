package com.example.lab03_jetpackroom.navigationHost

sealed class Destination (val route: String){
    object Home : Destination("home")
    object ViewList : Destination ("list")

    fun routeWithArgs (vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}