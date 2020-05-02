package dairo.aguas.feature.main.ui.comment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dairo.aguas.common.utils.Constants
import dairo.aguas.data.model.comment.Comment
import dairo.aguas.feature.main.databinding.CommentFragmentBinding
import dairo.aguas.feature.main.ui.comment.adapter.CommentAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class CommentFragment : Fragment() {

    private val viewModel: CommentViewModel by viewModel()
    private lateinit var binding: CommentFragmentBinding
    private lateinit var commentAdapter: CommentAdapter
    private val commentListObserver = Observer<List<Comment>> { handleCommentList(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        configureDataBinding(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureAdapter()
        getArgumentsBundle()
        startObserver()
    }

    private fun configureDataBinding(inflater: LayoutInflater) {
        binding = CommentFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun configureAdapter() {
        commentAdapter = CommentAdapter()
        binding.rvComment.layoutManager = LinearLayoutManager(context)
        binding.rvComment.adapter = commentAdapter
    }

    private fun getArgumentsBundle() {
        val idPost = arguments!!.getInt(Constants.ID_POST)
        viewModel.getCommentListLocal(idPost)
    }

    private fun startObserver() {
        viewModel.commentList.observe(viewLifecycleOwner, commentListObserver)
    }

    private fun handleCommentList(it: List<Comment>) {
        commentAdapter.submitList(it)
    }
}
