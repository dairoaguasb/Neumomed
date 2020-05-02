package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.comment.CommentRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class GetCommentListLocalFlow(private val commentRepository: CommentRepository) {

    fun execute(idPost: Int) =
        commentRepository.getCommentListFlow(idPost)
}