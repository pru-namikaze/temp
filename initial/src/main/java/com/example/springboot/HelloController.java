package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/apod.html")
	public String apod() {
		try{
			String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
			URLConnection conn;
			Gson gson = new Gson();
			HashMap<String, Object> map = new HashMap<String, Object>();

			conn= new URL(url).openConnection();
			conn.connect();
			String jsonResultString = (new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")))).readLine();
			System.out.println(jsonResultString);

			map = (HashMap<String, Object>) gson.fromJson(jsonResultString, map.getClass());

			System.out.println(map.toString());
			System.out.println("APOD!!!");
	
			// return map.toString();
			System.out.println(map.keySet().toArray()[0].toString());
			System.out.println(map.get(map.keySet().toArray()[0].toString()).toString());
			//return map.get(map.keySet().toArray()[0].toString()).toString();
			return "<!doctype html> \n"
			+ "<html lang='en'> \n"
			+ " \n"
			+ "<head> \n"
			+ "    <title>NAStro</title> \n"
			+ "    <meta charset='utf-8'> \n"
			+ "    <meta name='viewport' content='width=device-width, initial-scale=1'> \n"
			+ " \n"
			+ "    <link rel='icon' type='image/x-icon' \n"
			+ "        href='https://raw.githubusercontent.com/pru-namikaze/Nastro/master/src/assets/Nastro_logo.png'> \n"
			+ "    <!-- Bootstrap CDN --> \n"
			+ "    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' \n"
			+ "        integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'> \n"
			+ "    <!-- Font Awesome CDN --> \n"
			+ "    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.8.2/css/all.css' \n"
			+ "        integrity='sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay' crossorigin='anonymous'> \n"
			+ "    <!-- JQuery CDN --> \n"
			+ "    <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' \n"
			+ "        integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' \n"
			+ "        crossorigin='anonymous'></script> \n"
			+ "    <!-- Popper.js CDN --> \n"
			+ "    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js' \n"
			+ "        integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1' \n"
			+ "        crossorigin='anonymous'></script> \n"
			+ "    <!-- Bootstrap.js CDN --> \n"
			+ "    <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' \n"
			+ "        integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' \n"
			+ "        crossorigin='anonymous'></script> \n"
			+ "    <link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'> \n"
			+ "    <link rel='stylesheet' href='styles.76ac4b408b6394c8609c.css'> \n"
			+ "    <script src='chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js'></script> \n"
			+ "</head> \n"
			+ " \n"
			+ "<body id='NAstro'> \n"
			+ " \n"
			+ " \n"
			+ map.toString()
			+ " \n"
			+ " \n"
			+ "</body> \n"
			+ " \n"
			+ "</html>";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/about.html")
	public String about() {
		return "Greetings from about!";
	}

}
