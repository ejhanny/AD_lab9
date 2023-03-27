package edu.mines.csci448.examples.samodelkin.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter
import kotlinx.coroutines.flow.Flow
import java.util.UUID

// DAO: Data Access Object
@Dao
interface SamodelkinDao {

    // Create
    @Insert
    suspend fun addCharacter(samodelkinCharacter: SamodelkinCharacter)

    // Read
    /*
        QUESTION: Did I use the right library for Flow?
     */
    @Query("SELECT * FROM character")
    fun getCharacters(): Flow<List<SamodelkinCharacter>>
    @Query("SELECT * FROM character WHERE id=(:uuid)")
    suspend fun getCharacterById(uuid: UUID) : SamodelkinCharacter?

    // Delete
    @Delete
    suspend fun deleteCharacter(samodelkinCharacter: SamodelkinCharacter)

}