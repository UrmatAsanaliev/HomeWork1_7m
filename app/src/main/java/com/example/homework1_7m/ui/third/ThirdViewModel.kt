package com.example.homework1_7m.ui.third

import com.example.core.Resource
import com.example.core.core.BaseViewModel
import com.example.core.core.Dispatcher
import com.example.domain.users.model.Registration
import com.example.domain.users.use_case.PostRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    private val postRegisterUseCase: PostRegisterUseCase, appDispatcher: Dispatcher
) : BaseViewModel(appDispatcher) {

    private val _register = MutableStateFlow<Resource<Registration>>(Resource.Loading())
    val register = _register.asStateFlow()

    fun getRegister(registration: Registration) {
        launchOnBack {
            postRegisterUseCase(registration).collect {
                _register.value = it
            }
        }
    }
}