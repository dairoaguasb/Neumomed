package dairo.aguas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dairo.aguas.data.local.dao.PostDao
import dairo.aguas.data.model.post.Post

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Database(
    entities = [Post::class],
    version = 2,
    exportSchema = false
)
abstract class NeumomedDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NeumomedDatabase::class.java,
                "Neumomed.db"
            )
                .fallbackToDestructiveMigration()
                .setJournalMode(JournalMode.TRUNCATE)
                .build()
    }

}