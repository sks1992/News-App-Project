package sk.sksv.newsmvvmapp.db

import androidx.room.TypeConverters
import sk.sksv.newsmvvmapp.model.Source

class Converters {
    @TypeConverters
    fun fromSource(source: Source): String {
        return source.name
    }

    fun toSource(name: String): Source {
        return Source(name, name)
    }
}