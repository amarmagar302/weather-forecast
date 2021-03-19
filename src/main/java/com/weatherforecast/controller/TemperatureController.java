package com.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weatherforecast.service.TemperatureService;


@RestController
@CrossOrigin({"http://localhost:8080"})
@RequestMapping(value ="/temperature")
public class TemperatureController {

	@Autowired
	TemperatureService temperatureService;
	
	@ResponseBody
	@GetMapping("/getTommarowTemperature/{zipCode}")
	public String getTommarowTemperatureByzip(@PathVariable String zipCode) {
		return temperatureService.getTommarowTemperatureByzip(zipCode);
	}
}
