package dairo.aguas.data.repository.di

import dairo.aguas.data.repository.post.PostRepository
import dairo.aguas.data.repository.post.PostRepositoryImpl
import org.koin.dsl.module

/**
 * Created by Dairo Aguas B on 30/04/2020.
 */
val repositoryModule = module {
    factory { PostRepositoryImpl(get()) as PostRepository }
}