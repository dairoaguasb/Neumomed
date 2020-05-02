package dairo.aguas.feature.main.domain

import dairo.aguas.data.repository.comment.CommentRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class GetCommentListAPI(private val commentRepository: CommentRepository) {

    suspend fun execute(idPost: Int) =
        commentRepository.getCommentList(idPost)
}