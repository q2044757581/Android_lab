package com.cyp.lab3_2;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/23.
 */

public class information implements Serializable {

    public information(int imageId,String name,String info1,String info2,String price) {
        this.imageId=imageId;
        this.name=name;
        this.price=price;
        this.info1=info1;
        this.info2=info2;
    }
    public int getimageId() {
        return imageId;
    }

    public void setimageId(int imageId) {
        this.imageId = imageId;
    }
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String weight) {
        this.info1 = weight;
    }
    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String weight) {
        this.info2 = weight;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private int imageId;
    private String name;
    private String info1;
    private String info2;
    private String price;
}

