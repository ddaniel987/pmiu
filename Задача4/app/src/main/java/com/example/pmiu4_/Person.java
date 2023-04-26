package com.example.pmiu4_;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private Integer age;
    private String address;
    private String city;
    private String email;
    private String phone;

    public Person() {}

    public void setName(String name) {this.name = name;};
    public void setAge(Integer age) {this.age = age;};
    public void setAddress(String addy) {this.address = addy;};
    public void setCity(String city) {this.city = city;};
    public void setEmail(String email) {this.email = email;};
    public void setPhone(String phone) {this.phone = phone;};

    public String getName() { return this.name;};
    public Integer getAge() { return this.age;};
    public String getAddress() { return this.address;};
    public String getCity() { return this.city;};
    public String getEmail() { return this.email;};
    public String getPhone() { return this.phone;};

    // Parcelable implementation
    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
        city = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(email);
        dest.writeString(phone);
    }
}
