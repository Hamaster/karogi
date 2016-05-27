package com.example.toms.karogi;

public class Country {
    private int iD;
    private String countryName;
    private String flagImageName;
    private String region;

    public Country(){
        this(0, null, null, null);
    }

    public Country(int iD, String countryName, String flagImageName, String region){
        this.iD=iD;
        this.countryName=countryName;
        this.flagImageName = flagImageName;
        this.region=region;
    }

    //getters:
    public int getiD(){
        return  iD;
    }
    public String getCountryName(){
        return  countryName;
    }
    public String getFlagImageName(){
        return flagImageName;
    }
    public String getRegion(){
        return region;
    }

    //setters:
    public void setiD(int iD){
        this.iD = iD;
    }
    public  void setCountryName(String countryName){
        this.countryName = countryName;
    }
    public void setFlagImageName(String flagImageName){
        this.flagImageName = flagImageName;
    }
    public void setRegion(String region){
        this.region = region;
    }
}
