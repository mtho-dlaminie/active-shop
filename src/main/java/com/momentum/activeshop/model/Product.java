package com.momentum.activeshop.model;

import com.momentum.activeshop.data.ProductDao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderClassName = "ProductBuilder")
@ApiModel(value="Product Model")
public class Product {
    @ApiModelProperty(value = "Product name")
    @NonNull String name;
    @ApiModelProperty(value = "Product code")
    @NonNull int code;
    @ApiModelProperty(value = "Product Points Cost")
    @NonNull int points;

    public static class ProductBuilder {
        public ProductBuilder productSource(ProductDao productDao) {
            return name(productDao.getName())
                    .code(productDao.getCode())
                    .points(productDao.getCost());
        }
    }
}
