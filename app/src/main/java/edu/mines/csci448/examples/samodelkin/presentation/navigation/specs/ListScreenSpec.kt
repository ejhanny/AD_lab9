package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.list.SamodelkinListScreen
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.ISamodelkinViewModel
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.SamodelkinViewModel
import kotlinx.coroutines.CoroutineScope
import java.util.*

object ListScreenSpec : IScreenSpec {

    override val route = "list"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?) = route

    override val title = R.string.app_name
    
    @Composable
    override fun TopAppBarActions(
        samodelkinViewModel: ISamodelkinViewModel,
        navHostController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ) {
        IconButton(onClick = {
            navHostController.navigate(route = NewCharacterScreenSpec.route)
        }) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = stringResource(id = R.string.menu_add_character_desc)
            )
        }
    }

    @Composable
    override fun Content(
        samodelkinViewModel: ISamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context,
        coroutineScope: CoroutineScope
    ) {
        // call the SamodelkinListScreen compasable with ViewModel's character list
        // and pass in the "onClicked" lambda
        val charactListState =
            samodelkinViewModel.characterListState.collectAsState()
        SamodelkinListScreen(
            characterList = charactListState.value,
            onSelectCharacter = { currCharacter ->
                navController.navigate(route = DetailScreenSpec.buildRoute(currCharacter.id.toString()))
            }
        )
    }

}