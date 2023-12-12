package com.example.projectnew21

class KoinModule {
    val appModule = module {
        single<UserRepository> { UserRepositoryImpl() }
    }
}