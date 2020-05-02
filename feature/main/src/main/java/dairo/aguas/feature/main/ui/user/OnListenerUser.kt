package dairo.aguas.feature.main.ui.user

import dairo.aguas.data.model.user.User

/**
 * Created by Dairo Aguas B on 2/05/2020.
 */
interface OnListenerUser {

    fun onClickOpenWeb(user: User)

    fun onClickOpenMap(user: User)
}