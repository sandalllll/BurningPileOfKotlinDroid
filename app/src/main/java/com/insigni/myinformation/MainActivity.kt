package com.insigni.myinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insigni.myinformation.ui.theme.MyInformationTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyInformationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        Spacer(modifier = Modifier.weight(1.0f))
                        Column(
                            modifier = Modifier.padding(innerPadding)
                        ){
                            Spacer(modifier = Modifier.weight(1.0f))
                            Image(
                                painter = painterResource(id = R.mipmap.ic_dock2_foreground),
                                contentDescription = stringResource(id = R.string.full_name),
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                            )
                            Text(
                                text = stringResource(R.string.full_name),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
                                    .align(Alignment.CenterHorizontally),
                            )
                            Text(
                                text = stringResource(R.string.title),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                            )
                            Column(
                                modifier = Modifier.weight(1.0f)
                            ){
                                Spacer(modifier = Modifier.weight(1.0f))
                                Row{
                                    Image(
                                        painter = painterResource(id = R.mipmap.ic_dock_foreground),
                                        contentDescription = stringResource(id = R.string.full_name),
                                        modifier = Modifier.size(20.dp),
                                    )
                                    Text(
                                        text = stringResource(R.string.phone),
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                                Row{
                                    Image(
                                        painter = painterResource(id = R.mipmap.ic_dock3_foreground),
                                        contentDescription = stringResource(id = R.string.full_name),
                                        modifier = Modifier.size(20.dp),
                                    )
                                    Text(
                                        text = stringResource(R.string.youtube),
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                                Row{
                                    Image(
                                        painter = painterResource(id = R.mipmap.ic_dock4_foreground),
                                        contentDescription = stringResource(id = R.string.full_name),
                                        modifier = Modifier.size(20.dp),
                                    )
                                    Text(
                                        text = stringResource(R.string.susmail),
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.weight(1.0f))
                    }
                }
            }
        }
    }
}