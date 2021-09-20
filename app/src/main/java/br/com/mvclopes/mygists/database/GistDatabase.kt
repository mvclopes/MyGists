package br.com.mvclopes.mygists.database

import android.content.Context
import androidx.room.*
import br.com.mvclopes.mygists.model.GistItem

@Database(entities = [GistItem::class], version = 1, exportSchema = false)
abstract class GistDatabase: RoomDatabase() {
    abstract fun gistDao(): DatabaseDao
}

private lateinit var INSTANCE: GistDatabase

fun getDataBase(context: Context): GistDatabase{
    synchronized(GistDatabase::class.java){
        if (!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                GistDatabase::class.java,
                "gists_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}

