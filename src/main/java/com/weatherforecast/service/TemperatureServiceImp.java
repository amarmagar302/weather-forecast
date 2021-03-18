package com.weatherforecast.service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.weatherforecast.model.WeatherDetails;

import ch.qos.logback.core.subst.Token.Type;

@Service
public class TemperatureServiceImp implements TemperatureService {

	@Value("${accesskey}")
	public String accesskey;

	@Override
	public String getTommarowTemperatureByzip(String zipCode) {
		try {// 27601

			// get tomorrow’s predicted temperatures - US
			TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
			Date dt = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DATE, 1);
			dt = c.getTime();

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> call = restTemplate
					.getForEntity("https://api.weatherbit.io/v2.0/forecast/hourly=120?postal_code=" + zipCode
							+ "&country=US&key=" + accesskey, String.class);
			List<WeatherDetails> weatherList = getJsonObject(call.getBody().toString());
			List<WeatherDetails> tommarow = new ArrayList<WeatherDetails>();
			for (WeatherDetails wth : weatherList) {
				Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:MM:SS").parse(wth.getTimestamp_utc());
				if (dt.getDate() == date1.getDate()) {
					tommarow.add(wth);
				}
			}

			// check next day coolest hour of day
			Double coloTem = null;
			WeatherDetails colTemp=new WeatherDetails();
			for (WeatherDetails col : tommarow) {
				Double temp = Double.valueOf(col.getTemp());
				if (coloTem == null || coloTem < temp) {
					coloTem = temp;
					colTemp=col;
				}
			}

			return colTemp.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<WeatherDetails> getJsonObject(String str) {
		Gson gson = new GsonBuilder().setLenient().create();
		JsonParser jsonParser = new JsonParser();
		JsonObject jo = (JsonObject) jsonParser.parse(str);
		JsonArray jsonArr = jo.getAsJsonArray("data");
		List<WeatherDetails> users = new ArrayList<WeatherDetails>();
		java.lang.reflect.Type listType = new TypeToken<List<WeatherDetails>>() {
		}.getType();
		List<WeatherDetails> netStatLink = gson.fromJson(jsonArr, listType);
		return netStatLink;
	}

}
