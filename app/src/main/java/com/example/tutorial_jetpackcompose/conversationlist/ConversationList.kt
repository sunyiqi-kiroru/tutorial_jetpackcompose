package com.example.tutorial_jetpackcompose.conversationlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial_jetpackcompose.messagecard.Message
import com.example.tutorial_jetpackcompose.messagecard.MessageCard
import com.example.tutorial_jetpackcompose.ui.theme.Tutorial_jetpackcomposeTheme

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Tutorial_jetpackcomposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}