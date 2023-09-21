//package com.example.assignment.db.postdata
//
//import android.content.Context
//import androidx.room.*
//import com.example.assignment.data.model.D
//
//@TypeConverters(Converter::class)
//@Database(entities = [D::class], version = 1, exportSchema = false)
//abstract class ADPost : RoomDatabase() {
//
//    abstract fun pdao(): PDao
//
//    companion object {
//        private var instance: ADPost? = null
//
//        @Synchronized
//        fun getInstance(ctx: Context): ADPost {
//            if (instance == null)
//                instance = Room.databaseBuilder(
//                    ctx.applicationContext, ADPost::class.java,
//                    "post.db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
//                    .build()
//
//            return instance!!
//        }
//    }
//}