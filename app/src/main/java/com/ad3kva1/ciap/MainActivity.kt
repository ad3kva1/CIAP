package com.ad3kva1.ciap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.ad3kva1.ciap.di.appModule
import com.ad3kva1.ciap.ui.clients.ClientsListScreen
import com.ad3kva1.ciap.ui.clients.ClientsViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        setContent {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = "clients") {
                composable("clients") {
                    val vm: ClientsViewModel = getViewModel()
                    ClientsListScreen(vm, nav)
                }
                // TODO: add other routes: detail/{id}, addClient, archive
            }
        }
    }
}
