package com.ucs.edu.Review.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucs.edu.Review.dto.LocationDTO;
import com.ucs.edu.Review.model.Location;
import com.ucs.edu.Review.repository.LocationRepository;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

	@Autowired  
	private LocationRepository locationRepository;
	
	@Override
	public void saveLocation(LocationDTO locationDTO) {
		Location location = new Location();
		location.setName(locationDTO.getName());
		location.setAddress(locationDTO.getAddress());
		location.setLat(locationDTO.getLat());
		location.setLng(locationDTO.getLng());
		location.setType(location.getType());
		locationRepository.save(location);
	}

	@Override
	public List<Location> getLocationList() {
		return locationRepository.findAll();
	}

}
