package com.momentum.activeshop.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductDao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code")
    @JsonIgnore
    private int code;

    @Column(name="name")
    private String name;

    @Column(name="cost")
    private int cost;
}
