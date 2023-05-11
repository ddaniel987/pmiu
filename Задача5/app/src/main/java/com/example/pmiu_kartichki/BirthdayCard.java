package com.example.pmiu_kartichki;
import android.os.Parcel;
import android.os.Parcelable;

public class BirthdayCard implements Parcelable  {
    private String name;
    private Integer age;
    private String text;
    private String color;


    public BirthdayCard(String name, Integer age, String text, String color) {
        this.name = name;
        this.age = age;
        this.text = text;
        this.color = color;
    }

    public BirthdayCard() {

    }

    protected BirthdayCard(Parcel in) {
        name = in.readString();
        age = in.readInt();
        text = in.readString();
        color = in.readString();
    }

    public static final Parcelable.Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(text);
        dest.writeString(color);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
