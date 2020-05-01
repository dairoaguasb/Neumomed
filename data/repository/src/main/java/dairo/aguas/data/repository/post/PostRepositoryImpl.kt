package dairo.aguas.data.repository.post

import dairo.aguas.data.local.dao.PostDao
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.remote.post.PostDatasource

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class PostRepositoryImpl(
    private val postDatasource: PostDatasource,
    private val postDao: PostDao
) : PostRepository {

    override suspend fun getPostList() =
        postDatasource.getPostList()

    override suspend fun setPostListLocal(postList: List<Post>) {
        postDao.insertAll(postList)
    }

}