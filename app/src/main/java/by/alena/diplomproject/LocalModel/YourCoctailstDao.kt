//package by.alena.diplomproject.LocalModel
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//
//@Dao
//interface YourCoctailsDao {
//    @Insert
//    suspend fun insertAllYourCoctails(posts: MutableList<YourCoctails>)
//
//    @Query("SELECT * FROM yourCoctails")
//    suspend fun getAllYourCoctails(): MutableList<YourCoctails>
//
//    @Insert
//    suspend fun insertOneYourCoctail(yourCoctails: YourCoctails)
//
//    @Query("SELECT * FROM yourCoctails WHERE title = :id")
//    suspend fun getOneYourCoctail(id: String): YourCoctails
//}