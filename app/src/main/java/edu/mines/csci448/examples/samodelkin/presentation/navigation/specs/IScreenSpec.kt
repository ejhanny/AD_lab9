package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.ISamodelkinViewModel
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel
import kotlinx.coroutines.CoroutineScope

sealed interface IScreenSpec {
    companion object {
        private const val LOG_TAG = "448.IScreenSpec"

        val allScreens = IScreenSpec::class.sealedSubclasses.associate {
            Log.d(LOG_TAG, "allScreens: mapping route \"${it.objectInstance?.route ?: ""}\" to object \"${it.objectInstance}\"")
            it.objectInstance?.route to it.objectInstance
        }
        const val root = "samodelkin"
        val startDestination = ListScreenSpec.route

        @Composable
        fun TopBar(samodelkinViewModel: ISamodelkinViewModel,
                   navController: NavHostController,
                   navBackStackEntry: NavBackStackEntry,
                   context: Context,
                  ) {
            val route = navBackStackEntry?.destination?.route ?: ""
            allScreens[route]?.TopAppBarContent(samodelkinViewModel,
                                                navController,
                                                navBackStackEntry,
                                                context)
        } // end of TopBar
    } // end of companion object

    val route: String
    val arguments: List<NamedNavArgument>
    val title: Int

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun TopAppBarContent(samodelkinViewModel: ISamodelkinViewModel,
                                 navHostController: NavHostController,
                                 navBackStackEntry: NavBackStackEntry?,
                                 context: Context) {
        TopAppBar(
            navigationIcon = if (navHostController.previousBackStackEntry != null) {
                {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.menu_back_desc)
                        )
                    }
                }
            } else {
                { }
            },
            title = {
                Text(text = stringResource(id = title))
            },
            actions = {
                TopAppBarActions(samodelkinViewModel, navHostController, navBackStackEntry, context)
            }
        ) // end of TopAppBar
    } // end of TopAppBarContent

    @Composable
    fun TopAppBarActions(samodelkinViewModel: ISamodelkinViewModel,
                         navHostController: NavHostController,
                         navBackStackEntry: NavBackStackEntry?,
                         context: Context)

    fun buildRoute(vararg args: String?): String

    @Composable
    fun Content(
        samodelkinViewModel: ISamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context,
        coroutineScope: CoroutineScope
    )

}