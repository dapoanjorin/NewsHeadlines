import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dapo.headlinenews.ui.NewsAppState
import com.dapo.headlinenews.ui.rememberNewsAppState
import com.dapo.headlinenews.ui.theme.NewsTheme

@Composable
fun NewsApp(
    appState: NewsAppState = rememberNewsAppState()
) {

    NewsTheme {
        NewsNavHost(
            navController = appState.navController
        )
    }

}

@Composable
fun NewsNavHost(
    navController: NavHostController,
    startDestination: String = NewsDestination.NewsFeedRoute
) {

    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
    ) {
        composable(route = startDestination) {
            NewsFeedRoute(
                openBrowser = {
                    openChromeTab(context, it)
                }
            )
        }
    }
}

fun openChromeTab(context: Context, url: String?) {

    val packageName = "com.android.chrome"

    val builder = CustomTabsIntent.Builder()
    builder.setShowTitle(true)
    builder.setInstantAppsEnabled(true)

    val customBuilder = builder.build()
    customBuilder.intent.setPackage(packageName)
    customBuilder.launchUrl(context, Uri.parse(url))
}