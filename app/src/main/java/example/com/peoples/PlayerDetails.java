package example.com.peoples;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by derri on 07/03/2018.
 */

public class PlayerDetails implements Serializable{
    public  String firstName, lastName, position, country, imageName,largeImage;

    public PlayerDetails(String firstName, String lastName,String position,String country, String imageName,String largeImage){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.country = country;
        this.imageName = imageName;
        this.largeImage = largeImage;
    }


}
