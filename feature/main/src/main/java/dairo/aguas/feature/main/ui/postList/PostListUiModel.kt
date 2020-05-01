package dairo.aguas.feature.main.ui.postList

import android.view.View

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
data class PostListUiModel(
    val showMessageAlert: String,
    val showProgress: Boolean
) {
    fun toggleVisibility(showProgress: Boolean) =
        when (showProgress) {
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }
}