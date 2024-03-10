package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HomeController {

	@Autowired
	private HotelService hotelService;
	
	//API for entering the details of user
	@PostMapping
	public ResponseEntity<Hotel> createBooking(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	//API for getting details of user and hotel
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll()
	{
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	//API for getting details of 1 user booking
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(id));
	}
}
