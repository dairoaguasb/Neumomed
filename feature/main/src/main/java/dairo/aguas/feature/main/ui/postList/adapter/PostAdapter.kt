package dairo.aguas.feature.main.ui.postList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dairo.aguas.data.model.post.Post
import dairo.aguas.feature.main.databinding.CardPostBinding

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
class PostAdapter(private val onListenerPost: OnListenerPost) :
    ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PostViewHolder.from(parent)

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position), onListenerPost)
    }

    class PostViewHolder private constructor(private val binding: CardPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Post, onListenerPost: OnListenerPost) {
            binding.post = item
            binding.clickListener = onListenerPost
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PostViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardPostBinding.inflate(layoutInflater, parent, false)
                return PostViewHolder(binding)
            }
        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Post, newItem: Post) =
        oldItem == newItem
}