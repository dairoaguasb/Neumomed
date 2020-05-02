package dairo.aguas.data.repository.comment

import dairo.aguas.data.remote.comment.CommentDatasource

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
class CommentRepositoryImpl(
    private val commentDatasource: CommentDatasource
) : CommentRepository {

    override suspend fun getCommentList(idPost: Int) =
        commentDatasource.getCommentListByIdPost(idPost)
}