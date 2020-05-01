package dairo.aguas.feature.main.ui.postList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.vo.Result
import dairo.aguas.feature.main.domain.GetPostListAPI
import dairo.aguas.feature.main.domain.SetPostListLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostListViewModel(
    private val getPostListAPI: GetPostListAPI,
    private val setPostListLocal: SetPostListLocal
) : ViewModel() {

    private val _uiModel = MutableLiveData<PostListUiModel>()
    val uiModel: LiveData<PostListUiModel>
        get() = _uiModel

    init {
        getPostListAPI()
    }

    private fun getPostListAPI() {
        emitUiState(showProgress = true)
        viewModelScope.launch(Dispatchers.IO) {
            getPostListAPI.execute().also {
                validatePostListResult(it)
            }
        }
    }

    private fun validatePostListResult(postListResult: Result<List<Post>>) {
        when (postListResult) {
            is Result.Failure -> {
                emitUiState(showMessageAlert = postListResult.exception.message!!)
            }
            is Result.Success -> {
                validatePostListData(postListResult.data)
            }
        }
    }

    private fun validatePostListData(postList: List<Post>) {
        viewModelScope.launch(Dispatchers.IO) {
            setPostListLocal.execute(postList).also {
                emitUiState(showProgress = false)
            }
        }
    }


    private fun emitUiState(showProgress: Boolean = false, showMessageAlert: String = "") {
        viewModelScope.launch(Dispatchers.Main) {
            val uiModel = PostListUiModel(showMessageAlert, showProgress)
            _uiModel.value = uiModel
        }
    }
}
