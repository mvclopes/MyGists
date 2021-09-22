package br.com.mvclopes.mygists.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import br.com.mvclopes.mygists.model.GistItem
@Dao
interface DatabaseDao {

    @Insert(onConflict = REPLACE)
    fun insertAll(gists: List<GistItem>)

    @Update(onConflict = REPLACE)
    fun update(gistItem: GistItem)

    @Query("SELECT * FROM tb_public_gists")
    fun getAllGists() : LiveData<List<GistItem>>

    @Query("SELECT * FROM tb_public_gists WHERE isStarred = 1")
    fun getStarredGists() : MutableList<GistItem>
}
