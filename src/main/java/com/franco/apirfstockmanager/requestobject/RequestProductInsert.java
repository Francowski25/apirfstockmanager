package com.franco.apirfstockmanager.requestobject;

public class RequestProductInsert {
    private String name;
    private String category;
    private Integer stock;
    private Integer minStock;
    
    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
