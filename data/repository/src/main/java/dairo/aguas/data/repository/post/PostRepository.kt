package dairo.aguas.data.repository.post

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.vo.Result

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
interface PostRepository {

    suspend fun getPostList() : Result<List<Post>>

    suspend fun setPostListLocal(postList: List<Post>)
}