package di.modules

import data.repository.DogRepository
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val RepositoryModule = DI.Module(name = "RepositoryModule") {
    bindSingleton { DogRepository(instance()) }
}