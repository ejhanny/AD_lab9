package edu.mines.csci448.examples.samodelkin.presentation.navigation.specs

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import edu.mines.csci448.examples.samodelkin.R
import edu.mines.csci448.examples.samodelkin.presentation.newcharacter.NewCharacterScreen
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.ISamodelkinViewModel
import edu.mines.csci448.examples.samodelkin.util.CharacterGenerator
import edu.mines.csci448.examples.samodelkin.util.NetworkConnectionUtil
import edu.mines.csci448.examples.samodelkin.util.api.SamodelkinFetchr
import kotlinx.coroutines.CoroutineScope

object NewCharacterScreenSpec : IScreenSpec {
    private const val LOG_TAG = "448.NewCharacterScreenSpec"

    override val route = "newCharacter"
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun buildRoute(vararg args: String?): String = route

    override val title = R.string.app_name

    @Composable
    override fun TopAppBarActions(
        samodelkinViewModel: ISamodelkinViewModel,
        navHostController: NavHostController,
        navBackStackEntry: NavBackStackEntry?,
        context: Context
    ) {}

    @Composable
    override fun Content(
        samodelkinViewModel: ISamodelkinViewModel,
        navController: NavHostController,
        navBackStackEntry: NavBackStackEntry,
        context: Context,
        coroutineScope: CoroutineScope) {

        val characterState = remember {
            mutableStateOf( CharacterGenerator.generateRandomCharacter(context) )
        }

        val samodelkinFetchr = remember { SamodelkinFetchr() }
        val apiCharacterState = samodelkinFetchr
            .characterState
            .collectAsStateWithLifecycle(context = coroutineScope.coroutineContext)

        LaunchedEffect(key1 = apiCharacterState.value) {
            // transfer updated state here
            val apiCharacter = apiCharacterState.value
            Log.d(LOG_TAG, "apiCharacter created")

            if(apiCharacter != null) {
                Log.d(LOG_TAG, "we have a valid character")
                characterState.value = apiCharacter
            } else {
                Log.d(LOG_TAG, "we have an invalid character")
                characterState.value = CharacterGenerator.generateRandomCharacter(context)
            }
        }

        NewCharacterScreen(
            character = characterState.value,
            onGenerateRandomCharacter = {
                characterState.value = CharacterGenerator.generateRandomCharacter(context)
            },
            onSaveCharacter = { currentCharacter ->
                samodelkinViewModel.addCharacter(currentCharacter)
                navController
                    .popBackStack(route = ListScreenSpec.buildRoute(), inclusive = false)
            },
            apiButtonIsEnabled = NetworkConnectionUtil.isNetworkAvailableAndConnected(context),
            onRequestApiCharacter = { samodelkinFetchr.getCharacter() }
        )
    }
}