package dairo.aguas.feature.main.ui.user

import androidx.lifecycle.*
import dairo.aguas.data.model.user.User
import dairo.aguas.feature.main.domain.GetUserLocalFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUserLocalFlow: GetUserLocalFlow
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun getUserLocal(idUser: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getUserLocalFlow.execute(idUser).collect {
                viewModelScope.launch(Dispatchers.Main) {
                    _user.value = it
                }
            }
        }
    }
}
