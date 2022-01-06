package com.me.kt_ontario_colleges.di

import android.app.Application
import androidx.room.Room
import com.me.kt_ontario_colleges.repository.CollegeRepository
import com.me.kt_ontario_colleges.repository.CollegeRepositoryInterface
import com.me.kt_ontario_colleges.room.CollegeDao
import com.me.kt_ontario_colleges.room.CollegeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDataBase(
        app: Application,
        callback: CollegeDataBase.Callback
    ) = Room.databaseBuilder(
        app,
        CollegeDataBase::class.java,
        "college.db"
    )
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Singleton
    @Provides
    fun injectDao(dataBase:  CollegeDataBase) = dataBase.collegeDao()

    @Singleton
    @Provides
    fun injectRepository(dao: CollegeDao) = CollegeRepository(dao) as CollegeRepositoryInterface


    @ApplicationScope
    @Provides
    @Singleton
    fun injectApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope