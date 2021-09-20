package br.com.mvclopes.mygists.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.mvclopes.mygists.model.GistItem
@Dao
interface DatabaseDao {

    @Insert(onConflict = REPLACE)
    fun insertAll(gists: List<GistItem>)

    @Query("SELECT * FROM tb_public_gists")
    fun getAllGists() : LiveData<List<GistItem>>

}
