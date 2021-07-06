package com.jiaxy.giants.spring.plugins;

/**
 *
 * @version : Product.java, v 0.1 2021年07月06日 10:21 wutaoyuanxuan Exp $
 */
public class Product {

    private ProductType type;

    public Product(ProductType type) {
        this.type = type;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}