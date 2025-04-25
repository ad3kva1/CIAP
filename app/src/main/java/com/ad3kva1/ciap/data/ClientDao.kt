package com.ad3kva1.ciap.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {
    @Query("SELECT * FROM clients WHERE isArchived = 0")
    fun getActiveClients(): Flow<List<ClientEntity>>

    @Insert
    suspend fun insert(client: ClientEntity)

    @Query("UPDATE clients SET isArchived = 1 WHERE id = :id")
    suspend fun archive(id: Long)
}
