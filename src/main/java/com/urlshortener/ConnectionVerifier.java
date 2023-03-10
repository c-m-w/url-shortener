package com.urlshortener;

import java.io.IOException;
import java.net.*;

public class ConnectionVerifier {

	public boolean Verify(String urlString) {
		
		try {			
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setConnectTimeout(2000);
			
			return con.getResponseCode() == HttpURLConnection.HTTP_OK;
			
		} catch(MalformedURLException e) {
			
			return false;
			
		} catch(IOException e) {
			
			return false;
			
		}
	}
}
