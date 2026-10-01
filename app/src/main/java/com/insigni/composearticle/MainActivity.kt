package com.insigni.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insigni.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        Image(
                            painter = painterResource(id = R.mipmap.about_compose_foreground),
                            contentDescription = stringResource(id = R.string.comart_title),
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Text(
                            text = stringResource(R.string.comart_title),
                            fontSize = TextUnit(30.0f, TextUnitType.Sp),
                            modifier = Modifier.padding(top = 16.dp),
                        )
                        Text(
                            text = stringResource(R.string.comart_p1),
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(top = 16.dp),
                        )
                        Text(
                            text = stringResource(R.string.comart_p2),
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(top = 16.dp),
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                    }
                }
            }
        }
    }
}