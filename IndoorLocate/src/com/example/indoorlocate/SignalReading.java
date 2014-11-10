package com.example.indoorlocate;

import java.io.Serializable;

public class SignalReading implements Serializable {

	public SignalReading(Long signalReadingId, String bssId, int rss, String ssId, Location location) {
        this.signalReadingId = signalReadingId;
        this.bssId = bssId;
        this.rss = rss;
        this.ssId = ssId;
        this.location = location;
    }

    public Long signalReadingId;

    public String bssId;

    public int rss;

    public String ssId;

    public Location location;

}
