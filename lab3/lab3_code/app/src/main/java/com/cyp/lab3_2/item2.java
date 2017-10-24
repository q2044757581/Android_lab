package com.cyp.lab3_2;

/**
 * Created by Administrator on 2017/10/23.
 */

public class item2 {
    private String name;
    private String price;
    private String prime;
    public item2(String name,String prime,String price){
        this.name = name;
        this.prime = prime;
        this.price = price;
    }
    public  String getName() {
        return name;
    }
    public String getPrime(){
        return prime;
    }
    public String getPrice(){
        return price;
    }

}
