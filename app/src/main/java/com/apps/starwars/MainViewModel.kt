package com.apps.starwars

import androidx.lifecycle.ViewModel
import com.apps.starwars.data.StarwarsApi
import com.apps.starwars.di.ApplicationCoroutineScopeIO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: StarwarsApi,
    @ApplicationCoroutineScopeIO coroutineScope: CoroutineScope
) : ViewModel() {

    val uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())

    init {
        coroutineScope.launch {
            val people = api.getPeople()
            uiState.value = MainUiState(people.count)
        }
    }
}

data class MainUiState(
    val count: Int? = null
)