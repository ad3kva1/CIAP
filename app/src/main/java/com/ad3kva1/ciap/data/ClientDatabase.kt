package com.ad3kva1.ciap.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ClientEntity::class], version = 1)
abstract class ClientDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}
