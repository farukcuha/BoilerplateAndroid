package com.farukcuha.library.util

import kotlinx.coroutines.flow.MutableStateFlow

abstract class NavigationManager {

    var commands = MutableStateFlow<NavigationCommand?>(null)

    fun navigate(directions: NavigationCommand) { commands.value = directions }

    fun reset() { commands.value = null }
}