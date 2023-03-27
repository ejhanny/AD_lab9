package edu.mines.csci448.examples.samodelkin.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.mines.csci448.examples.samodelkin.data.SamodelkinCharacter

@Database(entities = [SamodelkinCharacter::class], version = 1)
@TypeConverters(SamodelkinTypeConverters::class)
abstract class SamodelkinDatabase : RoomDatabase() {

    // Follow singleton pattern by utilizing companion object
    companion object {
        @Volatile private var INSTANCE: SamodelkinDatabase? = null
        fun getInstance(context: Context): SamodelkinDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                                    SamodelkinDatabase::class.java,
                                    "samodelkin-database").build()
                    INSTANCE = instance
                } // end of if

                return instance

            } // end of synchronized
        } // end of getInstance

    } // end companion object

    // DAO
    abstract val samodelkinDao: SamodelkinDao
}