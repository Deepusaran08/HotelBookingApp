package com.example.demo.test;
import com.example.demo.controllers.HomeController;
import com.example.demo.entity.Hotel;
import com.example.demo.services.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class HomeControllerTest {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HomeController homeController;

    public HomeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBooking() {
        // Arrange
        Hotel mockHotel = new Hotel(/* Set necessary properties for the mock hotel */);
        when(hotelService.create(any(Hotel.class))).thenReturn(mockHotel);

        // Act
        ResponseEntity<Hotel> responseEntity = homeController.createBooking(mockHotel);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockHotel, responseEntity.getBody());

        // Verify that hotelService.create was called with the correct argument
        verify(hotelService, times(1)).create(mockHotel);
    }

    @Test
    void testGetAll() {
        // Arrange
        List<Hotel> mockHotels = Arrays.asList(new Hotel(), new Hotel()); // Add more mock hotels as needed
        when(hotelService.getAll()).thenReturn(mockHotels);

        // Act
        ResponseEntity<List<Hotel>> responseEntity = homeController.getAll();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockHotels, responseEntity.getBody());

        // Verify that hotelService.getAll was called
        verify(hotelService, times(1)).getAll();
    }

    @Test
    void testGetHotel() {
        // Arrange
        String mockHotelId = "123";
        Hotel mockHotel = new Hotel(/* Set necessary properties for the mock hotel */);
        when(hotelService.get(mockHotelId)).thenReturn(mockHotel);

        // Act
        ResponseEntity<Hotel> responseEntity = homeController.getHotel(mockHotelId);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockHotel, responseEntity.getBody());

        // Verify that hotelService.get was called with the correct argument
        verify(hotelService, times(1)).get(mockHotelId);
    }
}

