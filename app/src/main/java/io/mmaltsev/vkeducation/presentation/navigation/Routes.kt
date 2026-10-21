package io.mmaltsev.vkeducation.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object AppListRoute

@Serializable
data class AppDetailsRoute(val id: String)
