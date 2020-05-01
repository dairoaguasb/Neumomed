package dairo.aguas.feature.main.domain

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class SetPostListLocal(private val postRepository: PostRepository) {

    suspend fun execute(postList: List<Post>) {
        postRepository.setPostListLocal(postList)
    }
}