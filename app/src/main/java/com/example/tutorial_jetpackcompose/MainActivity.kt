package com.example.tutorial_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tutorial_jetpackcompose.conversationlist.Conversation
import com.example.tutorial_jetpackcompose.conversationlist.SampleData
import com.example.tutorial_jetpackcompose.ui.theme.Tutorial_jetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // プロジェクト内で作成されたマテリアルテーマ
            Tutorial_jetpackcomposeTheme {
                // 関数ラップ用
                // Surface(modifier = Modifier.fillMaxSize()) {
                    // Add a text element
                    // Text("Hello world!")
                    // MessageCard(Message("子在川上曰", "逝者如斯夫，不舍昼夜。"))
                // }
                // 会話リスト
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }
}