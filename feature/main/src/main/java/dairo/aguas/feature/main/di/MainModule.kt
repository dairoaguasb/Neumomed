package dairo.aguas.feature.main.di

import dairo.aguas.feature.main.domain.AddPostFavoriteLocal
import dairo.aguas.feature.main.domain.GetPostListAPI
import dairo.aguas.feature.main.domain.GetPostListLocalFlow
import dairo.aguas.feature.main.domain.SetPostListLocal
import dairo.aguas.feature.main.ui.postList.PostListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val mainModule = module {
    factory { GetPostListAPI(get()) }
    factory { SetPostListLocal(get()) }
    factory { GetPostListLocalFlow(get()) }
    factory { AddPostFavoriteLocal(get()) }
    viewModel { PostListViewModel(get(), get(), get(), get()) }
}