package dairo.aguas.data.repository.di

import dairo.aguas.data.repository.post.PostRepository
import dairo.aguas.data.repository.post.PostRepositoryImpl
import dairo.aguas.data.repository.user.UserRepository
import dairo.aguas.data.repository.user.UserRepositoryImpl
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val repositoryModule = module {
    factory { PostRepositoryImpl(get(), get()) as PostRepository }
    factory { UserRepositoryImpl(get()) as UserRepository }
}