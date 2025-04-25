package com.ad3kva1.ciap.data

import kotlinx.coroutines.flow.Flow

class ClientRepository(private val dao: ClientDao) {
    fun getActiveClients(): Flow<List<ClientEntity>> = dao.getActiveClients()
    suspend fun archiveClient(id: Long) = dao.archive(id)
    suspend fun addClient(name: String) = dao.insert(ClientEntity(fullName = name))
}
