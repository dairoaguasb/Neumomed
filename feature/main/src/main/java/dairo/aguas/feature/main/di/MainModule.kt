package dairo.aguas.feature.main.di

import dairo.aguas.feature.main.domain.*
import dairo.aguas.feature.main.ui.postDetail.PostDetailViewModel
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
    factory { GetPostFavoriteListLocalFlow(get()) }
    factory { AddPostFavoriteLocal(get()) }
    factory { DeletePostLocal(get()) }
    factory { DeleteAllLocal(get()) }
    viewModel { PostListViewModel(get(), get(), get(), get(), get(), get(), get()) }
    viewModel { PostDetailViewModel() }
}