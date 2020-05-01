package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.post.PostRepository

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class GetPostListLocalFlow(private val postRepository: PostRepository) {

    fun execute() =
        postRepository.getPostListLocalFlow()
}