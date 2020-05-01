package dairo.aguas.data.repository.post

import dairo.aguas.data.remote.post.PostDatasource

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class PostRepositoryImpl(private val postDatasource: PostDatasource) : PostRepository {

    override suspend fun getPostList() =
        postDatasource.getPostList()

}