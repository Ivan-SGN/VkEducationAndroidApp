package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.presentation.applist.AppListItem
import io.mmaltsev.vkeducation.presentation.applist.AppListItemRow
import io.mmaltsev.vkeducation.presentation.applist.appList
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@Composable
fun Showcase(
    apps: List<AppListItem>,
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val pages = apps.chunked(3)
    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_showcase),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp,
            verticalAlignment = Alignment.Top,
        ) { pageIndex ->
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                pages[pageIndex].forEach { app ->
                    AppListItemRow(
                        item = app,
                        onClick = onAppClick,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEducationTheme {
        Showcase(
            apps = appList.take(9),
            onAppClick = {},
        )
    }
}
