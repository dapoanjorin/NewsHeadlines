import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dapo.headlinenews.ui.features.NewsFeedViewModel
import com.dapo.headlinenews.ui.features.NewsItem
import com.dapo.headlinenews.ui.theme.NewsBackground
import com.dapo.headlinenews.ui.theme.NewsDark
import com.dapo.remote.model.Article

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun NewsFeedRoute(
    viewModel: NewsFeedViewModel = hiltViewModel(),
    openBrowser: (String?) -> Unit
) {

    val uiState by viewModel.newsFeedUIState.collectAsStateWithLifecycle()
    val isOffline by viewModel.isOffline.collectAsStateWithLifecycle()

    NewsFeedScreen(
        isLoading = uiState.isLoading,
        isOffline = isOffline,
        articles = uiState.articles,
        errorMessage = uiState.errorMessage,
        openBrowser = openBrowser
    )
}

@Composable
fun NewsFeedScreen(
    isLoading: Boolean,
    isOffline: Boolean,
    articles: List<Article>,
    errorMessage: String?,
    openBrowser: (String?) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                backgroundColor = NewsDark,
                title = {
                    Text(
                        text = "Newsfeed",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            )
        }
    ) { innerPadding ->

        LaunchedEffect(errorMessage) {
            if (!errorMessage.isNullOrEmpty())
                snackbarHostState.showSnackbar(message = errorMessage ?: "An error occurred")
        }

        LaunchedEffect(isOffline){
            if(isOffline) snackbarHostState.showSnackbar(message = "You are not connected to the internet")
        }

        Column(
            Modifier.background(color = NewsBackground)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                text = "Top News",
                style = TextStyle(color = Color.White, fontSize = 12.sp),
                textAlign = TextAlign.Center
            )
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                if (isLoading) {
                    item {
                        CircularProgressIndicator(
                            color = Color.White
                        )
                    }
                }

                items(articles) { article ->
                    NewsItem(article = article, openBrowser = openBrowser)
                }
            }
        }
    }
}