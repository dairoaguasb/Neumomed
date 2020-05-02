package dairo.aguas.feature.main.domain

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 1/05/2020.
 */
class UpdatePostFavoriteLocal(private val postRepository: PostRepository) {

    suspend fun execute(isFavorite: Boolean, idPost: Int) {
        postRepository.addPostFavorite(isFavorite, idPost)
    }
}