package dairo.aguas.data.repository.comment

import dairo.aguas.data.local.dao.CommentDao
import dairo.aguas.data.model.comment.Comment
import dairo.aguas.data.remote.comment.CommentDatasource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class CommentRepositoryImpl(
    private val commentDatasource: CommentDatasource,
    private val commentDao: CommentDao
) : CommentRepository {

    override suspend fun getCommentList(idPost: Int) =
        commentDatasource.getCommentListByIdPost(idPost)

    override fun getCommentListFlow(idPost: Int) =
        commentDao.getCommentListFlow(idPost)

    override suspend fun setCommentListLocal(commentList: List<Comment>) {
        commentDao.insertAll(commentList)
    }
}