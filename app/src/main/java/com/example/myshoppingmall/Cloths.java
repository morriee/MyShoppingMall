package com.example.myshoppingmall;

public class Cloths {
    String clothsId;
    String clothsName;
    String clothsKinds;

    public Cloths(){

    }

    public String getClothsId() {
        return clothsId;
    }

    public String getClothsName() {
        return clothsName;
    }

    public String getClothsKinds() {
        return clothsKinds;
    }

    public Cloths(String clothsId, String clothsName, String clothsKinds){
        this.clothsId = clothsId;
        this.clothsName = clothsName;
        this.clothsKinds = clothsKinds;
    }
}
