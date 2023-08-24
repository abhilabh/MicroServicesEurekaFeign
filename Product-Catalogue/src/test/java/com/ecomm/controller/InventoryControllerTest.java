package com.ecomm.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecomm.model.Product;
import com.ecomm.service.ProductService;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class ProductControllerTest {
	
	@Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    
    @BeforeEach
    public void setup() {
        // Initialize mocks and setup behavior here if needed
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
//        product.setProductId("abc");
//        product.setQuantity(10);

        when(productService.addProduct(any(Product.class))).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        ResponseEntity<?> responseEntity = productController.addProduct(product);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(productService).addProduct(product);
    }

    @Test
    public void testGetProduct() {
        int productId = 1;
        Product product = new Product();
        product.setProductId(productId);
//        product.setProductId("abc");
//        product.setQuantity(10);
//       
//        when(productService.getProduct(productId)).thenReturn(new ResponseEntity<>(product, HttpStatus.OK));

        ResponseEntity<?> responseEntity = productController.getProduct(productId);
        System.out.println(responseEntity.getBody());

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
        verify(productService).getProduct(productId);
    }
    
//    @Test
//    public void testGetProduct() {
//        int productId = 1;
//        Product product = new Product();
//        product.setProductId(productId);
//        product.setProductId("abc");
//        product.setQuantity(10);
//
//        OngoingStubbing<?> stubbing = 
//            when(productService.getProduct(productId));
//        stubbing.thenReturn(new ResponseEntity<>(product, HttpStatus.OK));
//
//        ResponseEntity<?> responseEntity = productController.getProduct(productId);
//
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(product, responseEntity.getBody());
//        verify(productService).getProduct(productId);
//    }

    @Test
    public void testUpdateProduct() {
        int productId = 1;
        Product updatedProduct = new Product();
        updatedProduct.setProductId(productId);
//        updatedProduct.setProductId("xyz");
//        updatedProduct.setQuantity(15);

        when(productService.updateProduct(any(Product.class), eq(productId)))
            .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<?> responseEntity = productController.updateProduct(updatedProduct, productId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(productService).updateProduct(updatedProduct, productId);
    }

    @Test
    public void testDeleteProduct() {
        int productId = 1;

        when(productService.deleteProduct(productId)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<?> responseEntity = productController.deleteProduct(productId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(productService).deleteProduct(productId);
    }


}
