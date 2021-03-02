package by.alena.diplomproject.RemoteModel

data class MyCoctails(
    val drinks: MutableList<Drinks>
)

data class Drinks(
//    val idDrink:String,
    //val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val strDrinkThumb:String,
    val strGlass: String,
    val strInstructions: String,
    val strImageSource: String,
    val strImageAttribution: String
)
