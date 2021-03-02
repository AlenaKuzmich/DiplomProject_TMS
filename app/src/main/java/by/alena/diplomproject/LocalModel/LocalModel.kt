//package by.alena.diplomproject.LocalModel
//
//import android.content.Context
//import androidx.room.Room
//
//class LocalModel (context: Context) {
//
//    private val database: YourCoctailsDatabase = Room.databaseBuilder(
//        context,
//        YourCoctailsDatabase::class.java, "yourCoctails_db"
//    ).build()
//
//    suspend fun insertYourCoctails(yourCoctails: MutableList<YourCoctails>){
//        database.yourCoctailsDao().insertAllYourCoctails(yourCoctails)
//    }
//    suspend fun insertOneYourCoctail(yourCoctail: YourCoctails){
//        database.yourCoctailsDao().insertOneYourCoctail(yourCoctail)
//    }
//    suspend fun getAllYourCoctails():MutableList<YourCoctails>{
//        return database.yourCoctailsDao().getAllYourCoctails()
//    }
//    suspend fun getOneYourCoctail(id:String):YourCoctails{
//        return database.yourCoctailsDao().getOneYourCoctail(id)
//    }
//
//}
//
