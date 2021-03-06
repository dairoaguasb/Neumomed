package dairo.aguas.feature.main.di

import dairo.aguas.feature.main.domain.*
import dairo.aguas.feature.main.ui.comment.CommentViewModel
import dairo.aguas.feature.main.ui.postDetail.PostDetailViewModel
import dairo.aguas.feature.main.ui.postList.PostListViewModel
import dairo.aguas.feature.main.ui.user.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val mainModule = module {
    factory { SetPostListLocal(get()) }
    factory { SetUserLocal(get()) }
    factory { SetCommentListLocal(get()) }
    factory { GetUserByIdAPI(get()) }
    factory { GetPostListAPI(get()) }
    factory { GetPostListLocalFlow(get()) }
    factory { GetPostFavoriteListLocalFlow(get()) }
    factory { GetCommentListAPI(get()) }
    factory { GetCommentListLocalFlow(get()) }
    factory { GetUserLocalFlow(get()) }
    factory { DeletePostLocal(get()) }
    factory { DeleteAllLocal(get()) }
    factory { UpdatePostReadLocal(get()) }
    factory { UpdatePostFavoriteLocal(get()) }
    viewModel { PostListViewModel(get(), get(), get(), get(), get(), get(), get()) }
    viewModel { PostDetailViewModel(get(), get(), get(), get(), get()) }
    viewModel { UserViewModel(get()) }
    viewModel { CommentViewModel(get()) }
}