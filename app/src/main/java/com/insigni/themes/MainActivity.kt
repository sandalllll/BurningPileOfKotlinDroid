package com.insigni.themes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.insigni.themes.model.Topic
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalLayoutDirection
import com.insigni.themes.data.Datasource
import com.insigni.themes.ui.theme.ThemesTheme
import androidx.compose.ui.Alignment

import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThemesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThemesApp()
                }
            }
        }
    }


    @Preview
    @Composable
    private fun TopicCardPreview() {
        TopicCard(Topic(R.string.fashion, 85, R.drawable.fashion))
    }
}

@Composable
fun ThemesApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier.fillMaxSize().statusBarsPadding().padding(
            start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection),
        ),
    ) {
        TopicsList(
            topicsList = Datasource().loadTopics(),
        )
    }

}

@Composable
fun TopicsList(topicsList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(topicsList) { topic ->
            TopicCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row() {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.topicNameId),
                modifier = Modifier.height(68.dp).width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text(
                    text = stringResource(topic.topicNameId),
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 8.dp, end = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row() {
                    Image(
                        painter = painterResource(R.drawable._8dots),
                        contentDescription = stringResource(R.string._8dots),
                        modifier = Modifier,
                    )
                    Text(
                        text = topic.themesCount.toString(),
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}