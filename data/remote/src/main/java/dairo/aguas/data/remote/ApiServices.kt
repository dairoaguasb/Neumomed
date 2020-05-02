package dairo.aguas.data.remote

import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.user.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dairo Aguas B on 2020-04-30.
 */
interface ApiServices {

    @GET("posts")
    suspend fun getPostList(): Response<List<Post>>

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") idUser: Int): Response<UserResponse>
}