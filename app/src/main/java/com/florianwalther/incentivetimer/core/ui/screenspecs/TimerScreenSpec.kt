package com.florianwalther.incentivetimer.core.ui.screenspecs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import com.florianwalther.incentivetimer.features.timer.TimerScreenContent
import com.florianwalther.incentivetimer.features.timer.TimerScreenAppBar
import com.florianwalther.incentivetimer.features.timer.TimerViewModel

object TimerScreenSpec : ScreenSpec {
    override val navHostRoute: String = "timer"

    override val deepLinks: List<NavDeepLink> = listOf(
        navDeepLink {
            uriPattern = "https://www.incentivetimer.com/timer"
        }
    )

    @Composable
    override fun TopBar(navController: NavController, navBackStackEntry: NavBackStackEntry) {
        val viewModel: TimerViewModel = hiltViewModel(navBackStackEntry)
        TimerScreenAppBar(actions = viewModel)
    }

    @Composable
    override fun Content(navController: NavController, navBackStackEntry: NavBackStackEntry) {
        val viewModel: TimerViewModel = hiltViewModel(navBackStackEntry)
        val pomodoroTimerState by viewModel.pomodoroTimerState.observeAsState()
        val showResetTimerConfirmationDialog
        by viewModel.showResetTimerConfirmationDialog.observeAsState(false)
        val showResetPomodoroSetConfirmationDialog
        by viewModel.showResetPomodoroSetConfirmationDialog.observeAsState(false)
        val showResetPomodoroCountConfirmationDialog
        by viewModel.showResetPomodoroCountConfirmationDialog.observeAsState(false )

        TimerScreenContent(
            pomodoroTimerState = pomodoroTimerState,
            actions = viewModel,
            showResetTimerConfirmationDialog = showResetTimerConfirmationDialog,
            showResetPomodoroSetConfirmationDialog = showResetPomodoroSetConfirmationDialog,
            showResetPomodoroCountConfirmationDialog = showResetPomodoroCountConfirmationDialog,
        )
    }
}