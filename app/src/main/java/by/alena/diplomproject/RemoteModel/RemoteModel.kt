package by.alena.diplomproject.RemoteModel

import java.lang.Exception

class RemoteModel {
 val apiService = ApiService.create()

 suspend fun getRemoteData(): MutableList<Drinks>{
     return try {
         val coctails = apiService.getCoctails(KEY, HOST).drinks
         coctails
     } catch (e: Exception){
         mutableListOf()
     }
 }
}