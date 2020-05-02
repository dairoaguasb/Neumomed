package dairo.aguas.feature.main.ui.postDetail

import android.view.View

/**
 * Created by Dairo Aguas B on 02/05/2020.
 */
data class PostDetailUiModel(
    val showMessageAlert: String,
    val showProgress: Boolean
) {
    fun toggleVisibility(showProgress: Boolean) =
        when (showProgress) {
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }
}