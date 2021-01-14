package com.momentum.activeshop.model;

import com.momentum.activeshop.data.CustomerDao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(builderClassName = "CustomerBuilder")
public class Customer {
	
	@ApiModelProperty(value = "Customer ID")
    @NonNull int customerId;
	@ApiModelProperty(value = "Customer name")
    @NonNull String name;
	@ApiModelProperty(value = "Customer points")
    @NonNull int activeDaysPoints;
    
    public static class CustomerBuilder {
        public CustomerBuilder customerSource(CustomerDao customerDao) {
            return name(customerDao.getName())
                    .activeDaysPoints(customerDao.getActiveDaysPoints())
                    .customerId(customerDao.getCustomerId());
        }
    }
}
