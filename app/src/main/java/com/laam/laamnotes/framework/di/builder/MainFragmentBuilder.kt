package com.laam.laamnotes.framework.di.builder

import com.laam.laamnotes.presentation.notedetail.NoteDetailFragment
import com.laam.laamnotes.presentation.notelist.NoteListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeNoteListFragment(): NoteListFragment

    @ContributesAndroidInjector
    abstract fun contributeNoteDetailFragment(): NoteDetailFragment
}