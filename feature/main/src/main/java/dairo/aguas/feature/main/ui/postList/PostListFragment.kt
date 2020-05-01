package dairo.aguas.feature.main.ui.postList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dairo.aguas.data.model.post.Post
import dairo.aguas.feature.main.databinding.PostListFragmentBinding
import dairo.aguas.feature.main.ui.postList.adapter.OnListenerPost
import dairo.aguas.feature.main.ui.postList.adapter.PostAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class PostListFragment : Fragment(), OnListenerPost {

    private val viewModel: PostListViewModel by viewModel()
    private lateinit var binding: PostListFragmentBinding
    private lateinit var postAdapter: PostAdapter
    private val postListObserver = Observer<List<Post>> { handlePostList(it) }
    private val uiModel = Observer<PostListUiModel> { handleUI(it) }

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

    private fun handleUI(uiModel: PostListUiModel) {
        uiModel.apply {
            binding.pbLoading.visibility = uiModel.toggleVisibility(showProgress)

            if (showMessageAlert.isNotEmpty())
                Toast.makeText(context, showMessageAlert, Toast.LENGTH_LONG).show()
        }
    }
}
