package com.florianwalther.incentivetimer.core.ui.screenspecs

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink

sealed interface ScreenSpec {

    companion object {
        val allScreens = listOf<ScreenSpec>(
            TimerScreenSpec,
            RewardListScreenSpec,
            AddEditRewardScreenSpec,
        ).associateBy { it.navHostRoute }
    }

    val navHostRoute: String

    val arguments: List<NamedNavArgument> get() = emptyList()

    val deepLinks: List<NavDeepLink> get() = emptyList()

    @Composable
    fun TopBar(navController: NavController, navBackStackEntry: NavBackStackEntry)

    @Composable
    fun Content(
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
    )
}