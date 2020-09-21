package com.walrus.manufacturing.admin.dto;

import com.walrus.manufacturing.db.domain.ManufacturingGoods;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsAttribute;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsProduct;
import com.walrus.manufacturing.db.domain.ManufacturingGoodsSpecification;

public class GoodsAllinone {
    ManufacturingGoods goods;
    ManufacturingGoodsSpecification[] specifications;
    ManufacturingGoodsAttribute[] attributes;
    ManufacturingGoodsProduct[] products;

    public ManufacturingGoods getGoods() {
        return goods;
    }

    public void setGoods(ManufacturingGoods goods) {
        this.goods = goods;
    }

    public ManufacturingGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(ManufacturingGoodsProduct[] products) {
        this.products = products;
    }

    public ManufacturingGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(ManufacturingGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public ManufacturingGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(ManufacturingGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
