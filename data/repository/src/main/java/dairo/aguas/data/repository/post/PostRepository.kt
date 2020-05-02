package dairo.aguas.data.repository.post

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.vo.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
interface PostRepository {

    suspend fun getPostList(): Result<List<Post>>

    suspend fun getTotalPosts(): Int

    suspend fun getPostById(idPost: Int): Post?

    suspend fun setPostListLocal(postList: List<Post>)

    suspend fun setPostLocal(post: Post)

    fun getPostListLocalFlow(): Flow<List<Post>>

    fun getPostFavoriteListLocalFlow(): Flow<List<Post>>

    suspend fun updatePost(post: Post)

    suspend fun deletePost(idPost: Int)

    suspend fun deleteAll()

    suspend fun addPostFavorite(isFavorite: Boolean, idPost: Int)

    suspend fun updatePostRead(idPost: Int)
}