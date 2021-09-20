package br.com.mvclopes.mygists.database

import androidx.room.TypeConverter
import br.com.mvclopes.mygists.model.File
import br.com.mvclopes.mygists.model.Files
import br.com.mvclopes.mygists.model.Owner

abstract class Converters {

    /**Exemplo de conversor de tipos pro ROOM
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
     */
    @TypeConverter
    fun fromOwner(owner: Owner): List<String>{
        return listOf(owner.avatar_url, owner.login)
    }

    @TypeConverter
    fun toOwner(list: List<String>): Owner{
        return Owner(
            list[0],
            list[1]
        )
    }
}