package dairo.aguas.data.model.vo

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure<out T>(val exception: Exception) : Result<T>()
}