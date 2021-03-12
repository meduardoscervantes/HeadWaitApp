package com.example.headwaitapp.appclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Server implements Parcelable {

    private Double tipPool;
    private String name;
    private Double remit;

    public Server(Double tipPool, String name, Double remit){
        this.tipPool = tipPool;
        this.name = name;
        this.remit = remit;
    }

    /*************/
    /** Getters **/
    /*************/
    public Double getRemit() {
        return remit;
    }

    public Double getTipPool() {
        return tipPool;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return ("Server: " + name + "\nTip Pool: " + tipPool + "\nRemit: " +  remit);
    }

    /*************/
    /** Setters **/
    /*************/
    public void setName(String name) {
        this.name = name;
    }

    public void setRemit(Double remit) {
        this.remit = remit;
    }

    public void setTipPool(Double tipPool) {
        this.tipPool = tipPool;
    }
    /***************************/
    /** Parcel Implementation **/
    /***************************/
    protected Server(Parcel in) {
        tipPool = in.readDouble();
        name = in.readString();
        remit = in.readDouble();
    }

    public static final Creator<Server> CREATOR = new Creator<Server>() {
        @Override
        public Server createFromParcel(Parcel in) {
            return new Server(in);
        }

        @Override
        public Server[] newArray(int size) {
            return new Server[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(tipPool);
        parcel.writeString(name);
        parcel.writeDouble(remit);
    }
}
