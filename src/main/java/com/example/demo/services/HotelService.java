package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(String userId);
}
