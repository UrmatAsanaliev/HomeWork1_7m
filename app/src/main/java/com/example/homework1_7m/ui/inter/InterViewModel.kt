package com.example.homework1_7m.ui.inter

import com.example.core.Resource
import com.example.core.core.BaseViewModel
import com.example.core.core.Dispatcher
import com.example.domain.users.model.Login
import com.example.domain.users.use_case.PostLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class InterViewModel@Inject constructor(
    private val postLoginUseCase: PostLoginUseCase, appDispatcher: Dispatcher
) : BaseViewModel(appDispatcher) {

    private val _login = MutableStateFlow<Resource<Login>>(Resource.Loading())
    val login = _login.asStateFlow()

    fun getLogin(login: Login) {
        launchOnBack {
            postLoginUseCase(login).collect {
                _login.value = it
            }
        }
    }
}