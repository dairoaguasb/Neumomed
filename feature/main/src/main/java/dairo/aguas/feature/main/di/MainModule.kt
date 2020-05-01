package dairo.aguas.feature.main.di

import dairo.aguas.feature.main.ui.postList.PostListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val mainModule = module {
    viewModel { PostListViewModel() }
}