package com.me.kt_ontario_colleges.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.me.kt_ontario_colleges.di.ApplicationScope
import com.me.kt_ontario_colleges.room.entity.Campus
import com.me.kt_ontario_colleges.room.entity.College
import com.me.kt_ontario_colleges.room.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [
    College::class,
    Campus::class
], version = 1)
abstract class CollegeDataBase: RoomDatabase() {
    abstract fun collegeDao(): CollegeDao

    class Callback @Inject constructor(
        private val dataBase: Provider<CollegeDataBase>,
        @ApplicationScope
        private val applicationScope: CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val collegeDao = dataBase.get().collegeDao()

            applicationScope.launch {
                collegeDao.insertCompletedCollege(centennialCollege(), centennialCampuses())
                collegeDao.insertCompletedCollege(senecaCollege(), senecaCampuses())
                collegeDao.insertCompletedCollege(canadoreCollege(), canadoreCampuses())
                collegeDao.insertCompletedCollege(georgeBrownCollege(), georgeBrownCampuses())
                collegeDao.insertCompletedCollege(humberCollege(), humberCampuses())
                collegeDao.insertCompletedCollege(sheridanCollege(), sheridanCampuses())
            }
        }
    }
}