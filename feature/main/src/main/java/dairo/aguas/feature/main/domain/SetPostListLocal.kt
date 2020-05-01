package dairo.aguas.feature.main.domain

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class SetPostListLocal(private val postRepository: PostRepository) {

    suspend fun execute(postList: List<Post>) {
        if (postRepository.getTotalPosts() == 0)
            postRepository.setPostListLocal(postList)
        else {
            postList.forEach { post ->
                postRepository.getPostById(post.id)?.let {
                    postRepository.updatePost(post)
                } ?: run {
                    postRepository.setPostLocal(post)
                }
            }
        }
    }
}