package dairo.aguas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dairo.aguas.data.local.dao.CommentDao
import dairo.aguas.data.local.dao.PostDao
import dairo.aguas.data.local.dao.UserDao
import dairo.aguas.data.model.comment.Comment
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.user.User

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@Database(
    entities = [Post::class, User::class, Comment::class],
    version = 5,
    exportSchema = false
)
abstract class NeumomedDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
    abstract fun commentDao(): CommentDao

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