package br.com.mvclopes.mygists.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mvclopes.mygists.model.Gist

@Database(entities = [Gist::class], version = 1, exportSchema = false)
abstract class GistDatabase: RoomDatabase() {
    abstract val gistDao: DatabaseDao
}

private lateinit var INSTANCE: GistDatabase

fun getDataBase(context: Context): GistDatabase{
    synchronized(GistDatabase::class.java){
        if (!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                GistDatabase::class.java,
                "gists_db"
            ).build()
        }
    }
    return INSTANCE
}
