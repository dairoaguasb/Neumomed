package dairo.aguas.data.repository.post

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.vo.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
interface PostRepository {

    suspend fun getPostList() : Result<List<Post>>

    suspend fun setPostListLocal(postList: List<Post>)

    fun getPostListLocalFlow() : Flow<List<Post>>
}