package com.momentum.activeshops.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.momentum.activeshop.data.repository.CustomerRepository;
import com.momentum.activeshop.service.ActiveShopService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ActiveShopServiceImplTest {

    @Autowired
    private ActiveShopService classUnderTest;
    
    @Test
    void should_get_all_products() {
        assertNotNull(classUnderTest);
        assertEquals(5, classUnderTest.getAllProducts().size());
    }
    
    //TODO: Add some more tests
}
