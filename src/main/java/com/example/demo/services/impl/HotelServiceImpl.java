package com.example.demo.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.services.HotelService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel create(Hotel hotel) {
		String userId=UUID.randomUUID().toString();
		hotel.setUserId(userId);
		String bookingId=UUID.randomUUID().toString();
		hotel.setBookingId(bookingId);
		return hotelRepository.save(hotel);
	}
	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}
	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found"));
	}

}
