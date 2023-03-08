package com.dapo.headlinenews.ui.features

import com.dapo.remote.model.Article

data class NewsFeedUIState(
    val isLoading: Boolean,
    val articles: List<Article>,
    val errorMessage: String?
)