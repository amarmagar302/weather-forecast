package com.weatherforecast.model;

import java.util.List;

public class WeatherList {

	private List<WeatherDetails> data;

	
	@Override
	public String toString() {
		return "WeatherList [data=" + data + "]";
	}

	public List<WeatherDetails> getData() {
		return data;
	}

	public void setData(List<WeatherDetails> data) {
		this.data = data;
	}
	
	
}
