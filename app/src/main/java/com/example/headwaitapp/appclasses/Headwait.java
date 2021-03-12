package com.example.headwaitapp.appclasses;


import android.os.Parcel;
import android.os.Parcelable;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Headwait implements Parcelable {
    private DecimalFormat df = new DecimalFormat("#0.00");
    private ArrayList<Server> servers;
    private Double cash;
    private ArrayList<Server> tipRetrievalServers;

    public Headwait(){
        servers = new ArrayList<>();
        tipRetrievalServers = new ArrayList<>();
        cash = 0.0;
        df.setRoundingMode(RoundingMode.DOWN);
    }

    /*************/
    /** Getters **/
    /*************/
    public Double getCash() {
        return Double.valueOf(df.format(cash));
    }

    public Double getTotalTipRetrieval(){
        Double total = 0.0;
        for(Server x : tipRetrievalServers) total += x.getRemit();
        return Double.valueOf(df.format(total));
    }
    public Double getTotalTipPool(){
        Double total = 0.0;
        for(Server x : servers) total += x.getTipPool();
        return Double.valueOf(df.format(total));
    }
    public Double getTotalRemit(){
        Double total = 0.0;
        for(Server x : servers) total += x.getRemit();
        return Double.valueOf(df.format(total));
    }

    public ArrayList<Server> getTipRetrievalServers() {
        return tipRetrievalServers;
    }

    public ArrayList<Server> getServers() {
        return servers;
    }

    /*************/
    /** Setters **/
    /*************/
    public void addTipRetrievalServer(Server server){
        tipRetrievalServers.add(server);
    }
    public void addCash(Double cash){
        this.cash += cash;
    }
    public void addServer(Server x){
        servers.add(x);
    }

    /***************************/
    /** Parcel Implementation **/
    /***************************/
    protected Headwait(Parcel in) {
        servers = in.readArrayList(Server.class.getClassLoader());
        cash = in.readDouble();
        tipRetrievalServers = in.readArrayList(Server.class.getClassLoader());
    }

    public static final Creator<Headwait> CREATOR = new Creator<Headwait>() {
        @Override
        public Headwait createFromParcel(Parcel in) {
            return new Headwait(in);
        }

        @Override
        public Headwait[] newArray(int size) {
            return new Headwait[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(cash);
        parcel.writeList(servers);
        parcel.writeList(tipRetrievalServers);
    }
}

