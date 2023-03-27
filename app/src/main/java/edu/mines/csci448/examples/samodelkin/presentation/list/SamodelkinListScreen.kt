package edu.mines.csci448.examples.samodelkin.presentation.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter
import edu.mines.csci448.examples.samodelkin.data.SamodelkinRepo
import edu.mines.csci448.examples.samodelkin.presentation.viewmodel.PreviewSamodelkinViewModel

@Composable
fun SamodelkinListScreen(characterList: List<SamodelkinCharacter>,
                         onSelectCharacter: (SamodelkinCharacter) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(characterList) { character ->
            SamodelkinCharacterListItem(character = character, onSelectCharacter = onSelectCharacter)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSamodelkinListScreen() {
    // get a reference to the current local context
    val context = LocalContext.current

    // create an instance of PreviewSamodelkinViewModel
    val currentPSVM = PreviewSamodelkinViewModel(context)

    // collect the characterListState flow as a state
    val charactListState =
        currentPSVM.characterListState.collectAsState()

    SamodelkinListScreen(characterList = charactListState.value) {}
}