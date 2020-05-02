package dairo.aguas.feature.main.ui.comment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dairo.aguas.common.utils.Constants
import dairo.aguas.feature.main.databinding.CommentFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class CommentFragment : Fragment() {

    private val viewModel: CommentViewModel by viewModel()
    private lateinit var binding: CommentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        configureDataBinding(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getArgumentsBundle()
    }

    private fun configureDataBinding(inflater: LayoutInflater) {
        binding = CommentFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun getArgumentsBundle() {
        val idPost = arguments!!.getInt(Constants.ID_POST)
    }

}
