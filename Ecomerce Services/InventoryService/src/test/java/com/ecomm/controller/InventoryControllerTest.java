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

import com.ecomm.model.Inventory;
import com.ecomm.service.InventoryService;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class InventoryControllerTest {
	
	@Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;
    
    @BeforeEach
    public void setup() {
        // Initialize mocks and setup behavior here if needed
    }

    @Test
    public void testAddInventory() {
        Inventory inventory = new Inventory();
        inventory.setProductId(100);
        inventory.setQuantity(10);

        when(inventoryService.addInventory(any(Inventory.class))).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        ResponseEntity<?> responseEntity = inventoryController.addInventory(inventory);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(inventoryService).addInventory(inventory);
    }

    @Test
    public void testGetInventory() {
        int inventoryId = 1;
        Inventory inventory = new Inventory();
        inventory.setInventoryId(inventoryId);
        inventory.setProductId(100);
        inventory.setQuantity(10);
       
//        when(inventoryService.getInventory(inventoryId)).thenReturn(new ResponseEntity<>(inventory, HttpStatus.OK));

        ResponseEntity<?> responseEntity = inventoryController.getInventory(inventoryId);
        System.out.println(responseEntity.getBody());

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(inventory, responseEntity.getBody());
        verify(inventoryService).getInventory(inventoryId);
    }
    
//    @Test
//    public void testGetInventory() {
//        int inventoryId = 1;
//        Inventory inventory = new Inventory();
//        inventory.setInventoryId(inventoryId);
//        inventory.setProductId("abc");
//        inventory.setQuantity(10);
//
//        OngoingStubbing<?> stubbing = 
//            when(inventoryService.getInventory(inventoryId));
//        stubbing.thenReturn(new ResponseEntity<>(inventory, HttpStatus.OK));
//
//        ResponseEntity<?> responseEntity = inventoryController.getInventory(inventoryId);
//
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(inventory, responseEntity.getBody());
//        verify(inventoryService).getInventory(inventoryId);
//    }

    @Test
    public void testUpdateInventory() {
        int inventoryId = 1;
        Inventory updatedInventory = new Inventory();
        updatedInventory.setInventoryId(inventoryId);
        updatedInventory.setProductId(100);
        updatedInventory.setQuantity(15);

        when(inventoryService.updateInventory(any(Inventory.class), eq(inventoryId)))
            .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        ResponseEntity<?> responseEntity = inventoryController.updateInventory(updatedInventory, inventoryId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(inventoryService).updateInventory(updatedInventory, inventoryId);
    }

    @Test
    public void testDeleteInventory() {
        int inventoryId = 1;

        when(inventoryService.deleteInventory(inventoryId)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<?> responseEntity = inventoryController.deleteInventory(inventoryId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(inventoryService).deleteInventory(inventoryId);
    }


}
