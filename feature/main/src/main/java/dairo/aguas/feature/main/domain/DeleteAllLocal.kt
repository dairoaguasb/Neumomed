package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 1/05/2020.
 */
class DeleteAllLocal(private val postRepository: PostRepository) {

    suspend fun execute() {
        postRepository.deleteAll()
    }
}