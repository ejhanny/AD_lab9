package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.*
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.detail.SamodelkinDetailScreen
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.ISamodelkinViewModel
import kotlinx.coroutines.CoroutineScope
import java.util.*

object DetailScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.DetailScreenSpec"

    private const val ROUTE_BASE = "detail"
    private const val ARG_UUID_NAME = "uuid"

    private fun buildFullRoute(argVal: String): String {
        var fullRoute = ROUTE_BASE
        if(argVal == ARG_UUID_NAME) {
            fullRoute += "/{$argVal}"
            Log.d(LOG_TAG, "Built base route $fullRoute")
        } else {
            fullRoute += "/$argVal"
            Log.d(LOG_TAG, "Built specific route $fullRoute")
        }
        return fullRoute
    }

    override val route = buildFullRoute(ARG_UUID_NAME)

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(ARG_UUID_NAME) {
            type = NavType.StringType
        }
    )

    override fun buildRoute(vararg args: String?): String = buildFullRoute(args[0] ?: "0")

    override val title = R.string.app_name

    /*
        QUESTION: it doesn't let me leave it as an empty body
     */
    @Composable
    override fun TopAppBarActions(
        samodelkinViewModel: ISamodelkinViewModel,
        navHostController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ) {
        // observe character state
        val tempCharacter = samodelkinViewModel.currentCharacterState.collectAsState()

        // IconButton stuff
        // share button
        IconButton(onClick = {

            val tempCharacter2 = tempCharacter.value
            if (tempCharacter2 != null) {
                val i = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, context.resources.getString(R.string.Extra_subject_str))
                        putExtra(Intent.EXTRA_TEXT, context.resources.getString(R.string.send_character_msg_formatter,
                                tempCharacter2.name, tempCharacter2.race, tempCharacter2.profession))
                }

                val i_title = context.resources.getString(R.string.Intent_chooser_title)
                val i_chooser = Intent.createChooser(i, i_title)

                context.startActivity(i_chooser)
            }

        }) {
            Icon(imageVector = Icons.Filled.Share, 
                 contentDescription = stringResource(id = R.string.menu_share_character_desc)
            )
        }
        
        // delete button
        IconButton(onClick = {
            tempCharacter.value?.let { samodelkinViewModel.deleteCharacter(it) }
            navHostController
                .popBackStack(route = ListScreenSpec.buildRoute(), inclusive = false)
        }) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = stringResource(id = R.string.menu_delete_character_desc)
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

        /*
            Question: how do I actually get the character? Seems to be null issues
         */

        // call loadCharacterByUUID to set currentCharacter, save to tempCharacter
        val tempCharacter = samodelkinViewModel.currentCharacterState.collectAsState()
        val tempBack = navBackStackEntry.arguments?.getString(ARG_UUID_NAME)?.let { UUID.fromString( it ) }

        if (tempBack != null) {
            samodelkinViewModel.loadCharacterByUUID( tempBack )
        }

        // call SamodelkinDetailScreen, but allow for nullability
        tempCharacter.value?.let { SamodelkinDetailScreen(character = it) }
    }

}