package dairo.aguas.feature.main.ui.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dairo.aguas.data.model.comment.Comment
import dairo.aguas.feature.main.domain.GetCommentListLocalFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CommentViewModel(
    private val getCommentListLocalFlow: GetCommentListLocalFlow
) : ViewModel() {

    private val _commentList = MutableLiveData<List<Comment>>()
    val commentList: LiveData<List<Comment>>
        get() = _commentList

    fun getCommentListLocal(idPost: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getCommentListLocalFlow.execute(idPost).collect {
                viewModelScope.launch(Dispatchers.Main) {
                    _commentList.value = it
                }
            }
        }
    }
}
