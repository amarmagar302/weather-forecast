package com.weatherforecast.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDetails {

	@SerializedName("timestamp_utc")
	@Expose
	@JsonProperty("timestamp_utc")
	private String timestamp_utc;
	@SerializedName("temp")
	@Expose
	@JsonProperty("temp")
	private String temp;
	@SerializedName("snow_depth")
	@Expose
	@JsonProperty("snow_depth")
	private String snow_depth;
	@SerializedName("clouds")
	@Expose
	@JsonProperty("clouds")
	private String clouds;
	@SerializedName("wind_spd")
	@Expose
	@JsonProperty("wind_spd")
	private String wind_spd;

	@SerializedName("snow")
	@Expose
	@JsonProperty("snow")
	private String snow;

	public WeatherDetails() {
	}

	
	
	@Override
	public String toString() {
		return "United State :coolest hour of the day [timestamp_utc=" + timestamp_utc + ", temp=" + temp + ", snow_depth=" + snow_depth
				+ ", clouds=" + clouds + ", wind_spd=" + wind_spd + ", snow=" + snow + "]";
	}



	public String getTimestamp_utc() {
		return timestamp_utc;
	}

	public void setTimestamp_utc(String timestamp_utc) {
		this.timestamp_utc = timestamp_utc;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getSnow_depth() {
		return snow_depth;
	}

	public void setSnow_depth(String snow_depth) {
		this.snow_depth = snow_depth;
	}

	public String getClouds() {
		return clouds;
	}

	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	public String getWind_spd() {
		return wind_spd;
	}

	public void setWind_spd(String wind_spd) {
		this.wind_spd = wind_spd;
	}

	public String getSnow() {
		return snow;
	}

	public void setSnow(String snow) {
		this.snow = snow;
	}

}
