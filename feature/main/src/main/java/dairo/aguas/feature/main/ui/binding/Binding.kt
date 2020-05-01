package dairo.aguas.feature.main.ui.binding

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import dairo.aguas.feature.main.R

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
@BindingAdapter("bindVisible")
fun View.bindVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("isFavorite")
fun ImageView.isFavorite(isFavorite: Boolean) {
    if (isFavorite) this.setBackgroundResource(R.drawable.ic_favorite)
    else this.setBackgroundResource(R.drawable.ic_favorite_border)
}