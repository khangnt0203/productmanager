/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangnt.product;

import khangnt.category.TblCategoryDTO;

/**
 *
 * @author khang
 */
public class TblProductDTO {

    private String proID;
    private String proName;
    private String unit;
    private float price;
    private int quantity;
    String cateID;
    public TblCategoryDTO cate = null;

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public TblProductDTO() {
    }

    public TblProductDTO(String proID, String proName,  String unit, float price,int quantity, TblCategoryDTO cate) {
        this.proID = proID;
        this.proName = proName;
        this.cate = cate;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TblCategoryDTO getCate() {
        return cate;
    }

    public void setCate(TblCategoryDTO cate) {
        this.cate = cate;
    }

}
