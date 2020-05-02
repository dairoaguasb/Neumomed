package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class UpdatePostReadLocal(private val postRepository: PostRepository) {

    suspend fun execute(idPost: Int) {
        postRepository.updatePostRead(idPost)
    }
}