package by.alena.diplomproject.LocalModel

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "yourCoctails_dp")
data class YourCoctails (
//    @PrimaryKey
                         val title: String?,
                                   val recipe: String?
                                   ,
                                   val photoRes: Bitmap?
)





// : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readParcelable(Bitmap::class.java.classLoader)
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(title)
//        parcel.writeString(recipe)
//        parcel.writeParcelable(photoRes, flags)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<YourCoctails> {
//        override fun createFromParcel(parcel: Parcel): YourCoctails {
//            return YourCoctails(parcel)
//        }
//
//        override fun newArray(size: Int): Array<YourCoctails?> {
//            return arrayOfNulls(size)
//        }
//    }
//}