package com.farukcuha.library.util

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>

    val destination: String
}

/*
With params:
object DashboardNavigation {
  private val KEY_USER_ID = "userId"
  val route = "dashboard/{$KEY_USER_ID}"

  val arguments = listOf(navArgument(KEY_USER_ID) { type = NavType.StringType })

  fun dashboard(userId: String? = null) = object : NavigationCommand {
    override val arguments = arguments

    override val destination = "dashboard/$userId"
  }
}
*/