package com.madura.noteapp.di

import android.app.Application
import androidx.room.Room
import com.madura.noteapp.feature_note.data.data_source.NoteDatabase
import com.madura.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.madura.noteapp.feature_note.domain.repository.NoteRepository
import com.madura.noteapp.feature_note.domain.use_case.AddNoteUseCase
import com.madura.noteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.madura.noteapp.feature_note.domain.use_case.GetNoteUseCase
import com.madura.noteapp.feature_note.domain.use_case.GetNotesUseCase
import com.madura.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(
            db.noteDao
        )
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {

        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository = repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository = repository),
            addNoteUseCase = AddNoteUseCase(repository = repository),
            getNoteUseCase = GetNoteUseCase(repository = repository)
        )
    }
}