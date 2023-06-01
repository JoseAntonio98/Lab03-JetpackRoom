package com.example.lab03_jetpackroom.navigationHost

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab03_jetpackroom.ViewModel.MainViewModel
import com.example.lab03_jetpackroom.views.Home
import com.example.lab03_jetpackroom.views.ViewList

@Composable
fun NavigationHostApp (
    viewModel: MainViewModel,
    navController : NavHostController
) {
    NavHost(navController = navController, startDestination = Destination.Home.route){
        composable(route = Destination.Home.route) {
            Home(viewModel = viewModel, navController = navController)
        }

        composable(route = Destination.ViewList.route) {
            ViewList(viewModel = viewModel)
        }
    }
}