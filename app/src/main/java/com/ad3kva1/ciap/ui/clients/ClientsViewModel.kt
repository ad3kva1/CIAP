package com.ad3kva1.ciap.ui.clients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad3kva1.ciap.data.ClientRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClientsViewModel(private val repo: ClientRepository) : ViewModel() {
    val clients: StateFlow<List<ClientItem>> =
        repo.getActiveClients()
            .map { list -> list.map { ClientItem(it.id, it.fullName) } }
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun archive(id: Long) = viewModelScope.launch {
        repo.archiveClient(id)
    }
    fun add(name: String) = viewModelScope.launch {
        repo.addClient(name)
    }
}

data class ClientItem(val id: Long, val fullName: String)
