package com.example.tutorial_jetpackcompose

import android.content.res.Configuration
import android.graphics.Bitmap.Config
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial_jetpackcompose.ui.theme.Tutorial_jetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // プロジェクト内で作成されたマテリアルテーマ
            Tutorial_jetpackcomposeTheme {
                // 関数ラップ用
                Surface(modifier = Modifier.fillMaxSize()) {
                    // Add a text element
                    // Text("Hello world!")
                    MessageCard(Message("子在川上曰", "逝者如斯夫，不舍昼夜。"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)

// Define a composable function
@Composable
fun MessageCard(msg: Message) {
    // 水平方向に揃える
    Row(modifier = Modifier.padding( 8.dp)) { // Add padding around message
        // 画像要素
        Image(
            painter = painterResource(id = R.drawable.landmark_tausyubetsu_bridge),
            contentDescription = "Image picture",
            modifier = Modifier
                // set image size to 40dp
                .size(40.dp)
                // Clip image to be shaped as round corner
                .clip(RoundedCornerShape(10.dp))
                // ボーダーを追加
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(10.dp))
        )

        // 画像とコロムの間にスペースを入れる
        Spacer(modifier = Modifier.width(4.dp))

        // 列を使用する
        Column {
            Text(
                text = msg.author,
                // 文字色
                color = MaterialTheme.colorScheme.secondary,
                // タイポグラフィスタイル
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // shapeでラップしたい
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// Preview your function in Android Studio
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    // プロジェクト内で作成されたマテリアルテーマ
    Tutorial_jetpackcomposeTheme {
        // 関数ラップ用
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(msg = Message("李白", "飞流直下三千尺，疑是银河落九天。"))
        }
    }
}