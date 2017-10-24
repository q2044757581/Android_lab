package com.cyp.lab3_2;

import android.widget.Button;

/**
 * Created by Administrator on 2017/10/22.
 */

public class item {
    private String name;
    private String prime;
    public item(String name,String prime){
        this.name = name;
        this.prime = prime;
    }
    public  String getName() {
        return name;
    }
    public String getPrime(){
        return prime;
    }
}
