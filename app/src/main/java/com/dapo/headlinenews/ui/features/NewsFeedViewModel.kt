package com.dapo.headlinenews.ui.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dapo.data.repository.NewsRepository
import com.dapo.data.util.ConnectivityManagerNetworkMonitor
import com.dapo.remote.util.Resource
import com.dapo.remote.model.Article
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    newsRepository: NewsRepository,
    networkMonitor: ConnectivityManagerNetworkMonitor
) : ViewModel() {

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    val newsFeedUIState: StateFlow<NewsFeedUIState> =
        newsRepository.getArticles()
            .map { resource ->
                when (resource) {
                    is Resource.Success -> {
                        NewsFeedUIState(
                            articles = resource.data ?: emptyList(),
                            errorMessage = null,
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        NewsFeedUIState(
                            articles = emptyList(),
                            errorMessage = resource.message,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        NewsFeedUIState(
                            articles = emptyList(),
                            errorMessage = null,
                            isLoading = false
                        )
                    }
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = NewsFeedUIState(true, emptyList(), null, )
            )
}