package com.ucs.edu.Review.service;

import java.util.List;

import com.ucs.edu.Review.dto.LocationDTO;
import com.ucs.edu.Review.model.Location;

public interface LocationService {
	public void saveLocation(LocationDTO locationDTO);
	public List<Location> getLocationList();
}
