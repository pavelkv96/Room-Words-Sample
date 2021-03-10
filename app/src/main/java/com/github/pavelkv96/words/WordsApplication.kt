package com.github.pavelkv96.words

import android.app.Application
import com.github.pavelkv96.words.data.local.WordRoomDatabase
import com.github.pavelkv96.words.domain.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}