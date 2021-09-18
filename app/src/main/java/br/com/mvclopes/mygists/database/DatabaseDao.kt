package br.com.mvclopes.mygists.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.mvclopes.mygists.model.Gist

@Dao
interface DatabaseDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(gist: Gist)

    @Query("SELECT * FROM tb_public_gists WHERE id = :key")
    suspend fun get(key: Long) : Gist?

    @Query("DELETE FROM tb_public_gists")
    suspend fun clear()

    @Query("SELECT * FROM tb_public_gists")
    fun getAllGists() : LiveData<List<Gist>>

}