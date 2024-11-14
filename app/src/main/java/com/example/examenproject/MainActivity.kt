package com.example.examenproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examenproject.ui.theme.ExamenProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    newTestExamen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable



fun newTestExamen(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize() // 填充最大空间
            .padding(top = 200.dp), // 仅对顶部添加 padding
    ) {
        // 文本输入框
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Introduzca su texto") },
            modifier = Modifier.fillMaxWidth() // 使 TextField 占满宽度
        )

        // 显示输入的文本
        Text(
            text = input,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            ),
            modifier = Modifier.fillMaxWidth() // 使 Text 占满宽度
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 按钮行
        Row(
            modifier = Modifier
                .fillMaxWidth() // Row 占满宽度
                .padding(start = 16.dp, end = 16.dp), // 可选的 padding，避免按钮贴边
            horizontalArrangement = Arrangement.SpaceEvenly, // 按钮均匀分布
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { input = "Button 1 clicked" }) {
                Text(text = "Button 1")
            }
            Button(onClick = { input = "Button 2 clicked" },
                modifier = Modifier.width(60.dp).width(5.dp)) {
                Text(text = "Button 2")
            }
            Button(onClick = { input = "Button 3 clicked" }) {
                Text(text = "Button 3")
            }
            Button(onClick = { input = "Button 4 clicked" }) {
                Text(text = "Button 4")
            }
        }
    }
}


