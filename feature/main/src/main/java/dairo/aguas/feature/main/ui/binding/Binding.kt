package dairo.aguas.feature.main.ui.binding

import android.graphics.Color
import android.view.View
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