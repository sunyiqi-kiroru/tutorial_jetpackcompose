package com.example.tutorial_jetpackcompose.messagecard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.example.tutorial_jetpackcompose.R
import com.example.tutorial_jetpackcompose.ui.theme.Tutorial_jetpackcomposeTheme

data class Message(val author: String, val body: String)

// Define a composable function
@Composable
fun MessageCard(msg: Message) {
    // 水平方向に揃える
    Row(modifier = Modifier.padding(8.dp)) { // Add padding around message
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

        // テキストの見た目は変わったかどうかの状態
        var isExpanded by remember { mutableStateOf(false) }
        // テキストゾーンの押下状態に依存する色の状態プロパティ
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        )

        // 列を使用する
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) { // 列をクリックすると状態が変わる
            Text(
                text = msg.author,
                // 文字色
                color = MaterialTheme.colorScheme.secondary,
                // タイポグラフィスタイル
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            // shapeでラップしたい
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // isExpandedの状態によって会話テキストの背景色が変わる
                color = surfaceColor,
                // メッセージコンテナサイズを滑らかにアニメーション化にする
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // メッセージは拡張済みの状態であれば、すべてのラインで表示する
                    // それ以外の場合は１行しか表示しない
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
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