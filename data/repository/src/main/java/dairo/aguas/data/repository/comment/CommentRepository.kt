package dairo.aguas.data.repository.comment

import dairo.aguas.data.model.comment.Comment
import dairo.aguas.data.model.vo.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
interface CommentRepository {

    suspend fun getCommentList(idPost: Int): Result<List<Comment>>

    fun getCommentListFlow(idPost: Int): Flow<List<Comment>>

    suspend fun setCommentListLocal(commentList: List<Comment>)
}