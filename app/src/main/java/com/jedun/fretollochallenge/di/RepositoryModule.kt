package com.jedun.fretollochallenge.di

import com.jedun.fretollochallenge.domain.mapper.DomainMapper
import com.jedun.fretollochallenge.domain.repository.SessionRepository
import com.jedun.fretollochallenge.data.network.ApiService
import com.jedun.fretollochallenge.data.repository.SessionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSessionRepository(
        apiService: ApiService,
        dtoMapper: DomainMapper
    ): SessionRepository {
        return SessionRepositoryImpl(apiService, dtoMapper)
    }

}