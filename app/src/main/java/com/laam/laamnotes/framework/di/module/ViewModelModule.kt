package com.laam.laamnotes.framework.di.module

import androidx.lifecycle.ViewModel
import com.laam.laamnotes.presentation.main.MainViewModel
import com.laam.laamnotes.presentation.notedetail.NoteDetailViewModel
import com.laam.laamnotes.presentation.notelist.NoteListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoteListViewModel::class)
    abstract fun bindNoteListViewModel(viewModel: NoteListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoteDetailViewModel::class)
    abstract fun bindNoteDetailViewModel(viewModel: NoteDetailViewModel): ViewModel
}