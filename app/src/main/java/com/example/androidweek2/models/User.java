package com.example.androidweek2.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class User implements Parcelable {
    private String name;
    private Date birthday;
    private String gender;
    private String hairType;
    private String skinColor;
    private String height;


    public User(String name, Date birthday, String gender, String hairType, String skinColor, String height) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.hairType = hairType;
        this.skinColor = skinColor;
        this.height = height;
    }

    protected User(Parcel in) {
        name = in.readString();
        birthday = new Date(in.readString());
        gender = in.readString();
        hairType = in.readString();
        skinColor = in.readString();
        height = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getHairType() {
        return hairType;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.birthday.toString());
        parcel.writeString(this.gender);
        parcel.writeString(this.hairType);
        parcel.writeString(this.skinColor);
        parcel.writeString(this.height);
    }
}
