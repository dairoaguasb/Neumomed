package dairo.aguas.feature.main.ui.postList.adapter

import dairo.aguas.data.model.post.Post

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
interface OnListenerPost {

    fun onClickListener(post: Post)

    fun onClickAddFavorite(post: Post)

    fun removeItem(post: Post)
}