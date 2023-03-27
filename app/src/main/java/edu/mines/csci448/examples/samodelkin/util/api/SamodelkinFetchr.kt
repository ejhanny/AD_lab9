package edu.mines.csci448.examples.samodelkin.util.api

import android.util.Log
import androidx.compose.runtime.State
import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SamodelkinFetchr() {
    // LOG_TAG
    companion object {
        private const val LOG_TAG = "448.api.SamodelkinFetchr"
    }

    private val samodelkinApiService: SamodelkinApiService

    private val mCharacterState = MutableStateFlow<SamodelkinCharacter?>( null )
    val characterState: StateFlow<SamodelkinCharacter?>
        get() = mCharacterState.asStateFlow()


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SamodelkinApiService.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        samodelkinApiService = retrofit.create(SamodelkinApiService::class.java)
    }

    fun getCharacter() {
        val samodelkinRequest = samodelkinApiService.getCharacter()

        samodelkinRequest.enqueue(object : Callback<SamodelkinCharacter> {
                override fun onFailure(call: Call<SamodelkinCharacter>, t: Throwable) {
                    Log.e(LOG_TAG, "onFailure() called $t")
                    mCharacterState.update { null }
                }
                override fun onResponse(call: Call<SamodelkinCharacter>,
                                        response: Response<SamodelkinCharacter>
                ) {
                    Log.d(LOG_TAG, "onResponse() called")
                    val responseCharacter = response.body()

                    if (responseCharacter == null) {
                        Log.d(LOG_TAG, "responseCharacter is null")
                        mCharacterState.update { null }
                    } else {
                        val newCharacter = responseCharacter.copy(
                            avatarAssetPath = "file:///android_asset/characters/${responseCharacter.avatarAssetPath}",
                            id = UUID.randomUUID()
                        )

                        Log.d(LOG_TAG, "newCharacter created")
                        mCharacterState.update { newCharacter }

                    } // end of inner else
                } // end of onResponse
            }
        ) // end of enqueue
    } // end of getCharacter()

}