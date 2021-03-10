package com.github.pavelkv96.words.domain

import androidx.annotation.WorkerThread
import com.github.pavelkv96.words.data.local.dao.WordDao
import com.github.pavelkv96.words.data.local.entities.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}