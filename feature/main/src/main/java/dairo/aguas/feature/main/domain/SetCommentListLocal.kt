package dairo.aguas.feature.main.domain

import dairo.aguas.data.model.comment.Comment
import dairo.aguas.data.repository.comment.CommentRepository

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class SetCommentListLocal(private val commentRepository: CommentRepository) {

    suspend fun execute(commentList: List<Comment>) {
        commentRepository.setCommentListLocal(commentList)
    }
}