package dairo.aguas.data.remote

import dairo.aguas.data.model.post.Post
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Dairo Aguas B on 2020-04-30.
 */
interface ApiServices {

    @GET("posts")
    suspend fun getPostList(): Response<List<Post>>

}