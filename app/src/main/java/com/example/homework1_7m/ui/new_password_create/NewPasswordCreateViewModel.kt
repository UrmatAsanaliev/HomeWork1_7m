package com.example.homework1_7m.ui.new_password_create

import com.example.core.Resource
import com.example.core.core.BaseViewModel
import com.example.core.core.Dispatcher
import com.example.domain.users.model.SetNewPassword
import com.example.domain.users.use_case.PostNewPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NewPasswordCreateViewModel @Inject constructor(
    private val postNewPasswordUseCase: PostNewPasswordUseCase, appDispatcher: Dispatcher
) : BaseViewModel(appDispatcher) {

    private val _newPassword = MutableStateFlow<Resource<SetNewPassword>>(Resource.Loading())
    val newPassword = _newPassword.asStateFlow()

    fun getNewPassword(setNewPassword: SetNewPassword) {
        launchOnBack {
            postNewPasswordUseCase(setNewPassword).collect {
                _newPassword.value = it
            }
        }
    }
}