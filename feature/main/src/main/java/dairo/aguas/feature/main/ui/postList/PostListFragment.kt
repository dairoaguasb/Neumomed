package dairo.aguas.feature.main.ui.postList

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dairo.aguas.data.model.post.Post
import dairo.aguas.feature.main.R
import dairo.aguas.feature.main.databinding.PostListFragmentBinding
import dairo.aguas.feature.main.ui.postList.adapter.OnListenerPost
import dairo.aguas.feature.main.ui.postList.adapter.PostAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class PostListFragment : Fragment(), OnListenerPost {

    private val viewModel: PostListViewModel by viewModel()
    private lateinit var binding: PostListFragmentBinding
    private lateinit var postAdapter: PostAdapter
    private lateinit var deleteIcon: Drawable
    private val postListObserver = Observer<List<Post>> { handlePostList(it) }
    private val uiModel = Observer<PostListUiModel> { handleUI(it) }
    private val swipeBackground: ColorDrawable = ColorDrawable(Color.parseColor("#C53C58"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        configureDataBinding(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureAdapter()
        configureItemTouch()
        startObserver()
    }

    private fun configureDataBinding(inflater: LayoutInflater) {
        binding = PostListFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun configureAdapter() {
        postAdapter = PostAdapter(this)
        binding.rvPosts.layoutManager = LinearLayoutManager(context)
        binding.rvPosts.adapter = postAdapter

    }

    private fun configureItemTouch() {
        deleteIcon = ContextCompat.getDrawable(context!!, R.drawable.ic_delete)!!
        val itemTouchHelperCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                postAdapter.removeItem(viewHolder.adapterPosition)
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemView = viewHolder.itemView
                val iconMargin = (itemView.height - deleteIcon.intrinsicHeight) / 2
                if (dX > 0) {
                    swipeBackground.setBounds(
                        itemView.left, itemView.top, dX.toInt(), itemView.bottom
                    )
                    deleteIcon.setBounds(
                        itemView.left + iconMargin,
                        itemView.top + iconMargin,
                        itemView.left + iconMargin + deleteIcon.intrinsicWidth,
                        itemView.bottom - iconMargin
                    )
                } else {
                    swipeBackground.setBounds(
                        itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom
                    )
                    deleteIcon.setBounds(
                        itemView.right - iconMargin - deleteIcon.intrinsicWidth,
                        itemView.top + iconMargin,
                        itemView.right - iconMargin,
                        itemView.bottom - iconMargin
                    )
                }

                swipeBackground.draw(c)
                deleteIcon.draw(c)
                super.onChildDraw(
                    c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive
                )
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.rvPosts)
    }

    private fun startObserver() {
        viewModel.uiModel.observe(viewLifecycleOwner, uiModel)
        viewModel.postList.observe(viewLifecycleOwner, postListObserver)
    }

    private fun handlePostList(it: List<Post>) {
        postAdapter.submitList(it)
    }

    override fun onClickListener(post: Post) {

    }

    override fun onClickAddFavorite(post: Post) {
        viewModel.addPostFavorite(post)
    }

    override fun removeItem(post: Post) {
        Log.d("item", post.id.toString())
    }

    private fun handleUI(uiModel: PostListUiModel) {
        uiModel.apply {
            binding.pbLoading.visibility = uiModel.toggleVisibility(showProgress)

            if (showMessageAlert.isNotEmpty())
                Toast.makeText(context, showMessageAlert, Toast.LENGTH_LONG).show()
        }
    }
}
