package com.ad3kva1.ciap.ui.clients

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ClientsListScreen(vm: ClientsViewModel, nav: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Клиенты") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("addClient") }) {
                Icon(Icons.Default.Add, contentDescription = "Добавить")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(vm.clients.collectAsState().value) { client ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { nav.navigate("detail/${client.id}") }
                        .padding(16.dp)
                ) {
                    Text(client.fullName, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
