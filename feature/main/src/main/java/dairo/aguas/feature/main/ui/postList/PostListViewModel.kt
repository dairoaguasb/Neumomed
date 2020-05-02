package dairo.aguas.feature.main.ui.postList

import androidx.lifecycle.*
import dairo.aguas.data.model.post.Post
import dairo.aguas.data.model.vo.Result
import dairo.aguas.feature.main.domain.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostListViewModel(
    private val getPostListAPI: GetPostListAPI,
    private val setPostListLocal: SetPostListLocal,
    private val addPostFavoriteLocal: AddPostFavoriteLocal,
    private val deletePostLocal: DeletePostLocal,
    private val deleteAllLocal: DeleteAllLocal,
    private val getPostListLocalFlow: GetPostListLocalFlow,
    private val getPostFavoriteListLocalFlow: GetPostFavoriteListLocalFlow
) : ViewModel() {

    private val _uiModel = MutableLiveData<PostListUiModel>()
    val uiModel: LiveData<PostListUiModel>
        get() = _uiModel

    fun getPostListAPI() {
        emitUiState(showProgress = true)
        viewModelScope.launch(Dispatchers.IO) {
            getPostListAPI.execute().also {
                validatePostListResult(it)
            }
        }
    }

    fun getPostList() =
        getPostListLocalFlow.execute().asLiveData()

    fun getPostFavoriteList() =
        getPostFavoriteListLocalFlow.execute().asLiveData()

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
            setPostListLocal.execute(modifyProductList(postList)).also {
                emitUiState(showProgress = false)
            }
        }
    }

    private fun modifyProductList(postList: List<Post>): MutableList<Post> {
        val subList = postList.subList(20, postList.size)
        val modifyList = postList.take(20).toMutableList()
        modifyList.forEach { it.isRead = false }
        modifyList.addAll(subList)
        return modifyList
    }

    fun addPostFavorite(post: Post) {
        val isFavorite = post.isFavorite.not()
        viewModelScope.launch(Dispatchers.IO) {
            addPostFavoriteLocal.execute(isFavorite, post.id)
        }
    }

    fun deletePost(post: Post) {
        viewModelScope.launch(Dispatchers.IO) {
            viewModelScope.launch(Dispatchers.IO) {
                deletePostLocal.execute(post.id)
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllLocal.execute()
        }
    }

    private fun emitUiState(showProgress: Boolean = false, showMessageAlert: String = "") {
        viewModelScope.launch(Dispatchers.Main) {
            val uiModel = PostListUiModel(showMessageAlert, showProgress)
            _uiModel.value = uiModel
        }
    }
}
