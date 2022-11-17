package com.restAws.restAws;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
public class SendMessage {
	// Sends the given message to the given telegram ID
	public void sendThroughController(String message, String url, String telegramToken, String id) {
		url = String.format(url, telegramToken, id, message);
		try {
			System.out.println(url);
			URL urlSend = new URL(url);
			URLConnection urlConnection = (HttpURLConnection) urlSend.openConnection();
			InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
