package by.alena.diplomproject.Repository

import by.alena.diplomproject.LocalModel.YourCoctails
import by.alena.diplomproject.RemoteModel.Drinks
import by.alena.diplomproject.RemoteModel.MyCoctails
import by.alena.diplomproject.RemoteModel.RemoteModel

class Repository (val remoteModel: RemoteModel) {       //по сети только. localModel пока не подключаем
    suspend fun getData(): MutableList<Drinks> {
    return remoteModel.getRemoteData()
    }


//    suspend fun getOneYourCoctails(id: String): YourCoctails {
//        var yourCoctail = localModel.getOneYourCoctail(id)
//        return yourCoctail
//    }
//
//    suspend fun insertOneYourCoctail(newYourCoctail: YourCoctails){
//        localModel.insertOneYourCoctail(newYourCoctail)
//    }
//
//    suspend fun getAllYourCoctails():MutableList<YourCoctails>{
//        var yourCoctailsList = localModel.getAllYourCoctails()
//        return yourCoctailsList
//    }
//
//    suspend fun saveData(yourCoctailsList: MutableList<YourCoctails>){
//        localModel.insertYourCoctails(yourCoctailsList)
//    }

}