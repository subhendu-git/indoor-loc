package com.example.indoorlocate;

import java.io.Serializable;

public class Location implements Serializable {
	
	public Location(int locationId, int xCoordinate, int yCoordinate, String locationName) {
        this.locationId = locationId;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.locationName = locationName;
    }

    public int locationId;

    public int xCoordinate;

    public int yCoordinate;

    public String locationName;
}
