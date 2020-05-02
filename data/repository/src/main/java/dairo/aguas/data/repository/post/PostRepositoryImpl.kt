package dairo.aguas.data.repository.post

import dairo.aguas.data.local.dao.PostDao
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.remote.post.PostDatasource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class PostRepositoryImpl(
    private val postDatasource: PostDatasource,
    private val postDao: PostDao
) : PostRepository {

    override suspend fun getPostList() =
        postDatasource.getPostList()

    override suspend fun getTotalPosts() =
        postDao.getTotalPosts()

    override suspend fun getPostById(idPost: Int) =
        postDao.getPostById(idPost)

    override suspend fun setPostListLocal(postList: List<Post>) {
        postDao.insertAll(postList)
    }

    override suspend fun setPostLocal(post: Post) {
        postDao.insert(post)
    }

    override fun getPostListLocalFlow() =
        postDao.getPostList()

    override fun getPostFavoriteListLocalFlow() =
        postDao.getPostFavoriteList()

    override suspend fun updatePost(post: Post) {
        post.apply {
            postDao.updatePost(title, body, id)
        }
    }

    override suspend fun deletePost(idPost: Int) {
        postDao.deletePost(idPost)
    }

    override suspend fun deleteAll() {
        postDao.deleteAll()
    }

    override suspend fun addPostFavorite(isFavorite: Boolean, idPost: Int) {
        postDao.addPostFavorite(isFavorite, idPost)
    }

}