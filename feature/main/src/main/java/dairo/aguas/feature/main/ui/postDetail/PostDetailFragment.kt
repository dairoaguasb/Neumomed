package dairo.aguas.feature.main.ui.postDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import dairo.aguas.common.utils.Constants
import dairo.aguas.data.model.post.Post
import dairo.aguas.feature.main.R
import dairo.aguas.feature.main.databinding.PostDetailFragmentBinding
import dairo.aguas.feature.main.ui.comment.CommentFragment
import dairo.aguas.feature.main.ui.user.UserFragment
import org.koin.android.viewmodel.ext.android.viewModel

class PostDetailFragment : Fragment() {

    private val viewModel: PostDetailViewModel by viewModel()
    private lateinit var binding: PostDetailFragmentBinding
    private val uiModel = Observer<PostDetailUiModel> { handleUI(it) }
    private lateinit var post: Post

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        configureDataBinding(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title = getString(R.string.title_post_detail)
        getArgsBundle()
        getInfoViewModel()
        startObserver()
        configureNavigationItem()
        navigateToUser()
    }

    private fun configureDataBinding(inflater: LayoutInflater) {
        binding = PostDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun getArgsBundle() {
        val arguments = PostDetailFragmentArgs.fromBundle(arguments!!)
        post = arguments.post
    }

    private fun getInfoViewModel() {
        viewModel.updatePostRead(post.id)
        viewModel.getUserById(post.userId)
        viewModel.getCommentList(post.id)
    }

    private fun startObserver() {
        viewModel.uiModel.observe(viewLifecycleOwner, uiModel)
    }

    private fun configureNavigationItem() {
        binding.navViewOrder.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itUser -> navigateToUser()
                R.id.itComment -> navigateToComment()
            }
            true
        }
    }

    private fun navigateToUser() {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = UserFragment()
        val args = Bundle()
        args.putInt(Constants.ID_USER, post.userId)
        fragment.arguments = args
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun navigateToComment() {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = CommentFragment()
        val args = Bundle()
        args.putInt(Constants.ID_POST, post.id)
        fragment.arguments = args
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun handleUI(uiModel: PostDetailUiModel) {
        uiModel.apply {
            binding.pbLoading.visibility = uiModel.toggleVisibility(showProgress)

            if (showMessageAlert.isNotEmpty())
                Toast.makeText(context, showMessageAlert, Toast.LENGTH_LONG).show()
        }
    }

}
