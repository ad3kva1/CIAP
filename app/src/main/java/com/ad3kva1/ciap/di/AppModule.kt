package com.ad3kva1.ciap.di

import android.app.Application
import androidx.room.Room
import com.ad3kva1.ciap.data.ClientDao
import com.ad3kva1.ciap.data.ClientDatabase
import com.ad3kva1.ciap.data.ClientRepository
import com.ad3kva1.ciap.ui.clients.ClientsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            ClientDatabase::class.java,
            "client_db"
        ).build()
    }
    single<ClientDao> { get<ClientDatabase>().clientDao() }
    single { ClientRepository(get()) }
    viewModel { ClientsViewModel(get()) }
}
