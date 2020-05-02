package dairo.aguas.feature.main.ui.postDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dairo.aguas.data.model.user.UserResponse
import dairo.aguas.data.model.vo.Result
import dairo.aguas.feature.main.domain.GetUserByIdAPI
import dairo.aguas.feature.main.domain.SetUserLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val getUserByIdAPI: GetUserByIdAPI,
    private val setUserLocal: SetUserLocal
) : ViewModel() {

    private val _uiModel = MutableLiveData<PostDetailUiModel>()
    val uiModel: LiveData<PostDetailUiModel>
        get() = _uiModel

    fun getUserById(idUser: Int) {
        emitUiState(showProgress = true)
        viewModelScope.launch(Dispatchers.IO) {
            getUserByIdAPI.execute(idUser).also {
                validateUserResult(it)
            }
        }
    }

    private fun validateUserResult(userResult: Result<UserResponse>) {
        when (userResult) {
            is Result.Failure -> {
                emitUiState(showMessageAlert = userResult.exception.message!!)
            }
            is Result.Success -> {
                setUserLocal(userResult.data)
            }
        }
    }

    private fun setUserLocal(userResponse: UserResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            setUserLocal.execute(userResponse).also {
                emitUiState(showProgress = false)
            }
        }
    }

    private fun emitUiState(showProgress: Boolean = false, showMessageAlert: String = "") {
        viewModelScope.launch(Dispatchers.Main) {
            val uiModel = PostDetailUiModel(showMessageAlert, showProgress)
            _uiModel.value = uiModel
        }
    }
}
