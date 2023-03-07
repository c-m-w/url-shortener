package com.urlshortener;

import java.util.Random;

public class RandomString {

	public static String Generate(int length) {
		
		Random r = new Random();
		String str = "";
		
		
		for (int i = 0; i < length; i++) {
			
			char c = (char)r.nextInt('A', 'Z');
			boolean lower = r.nextBoolean();
			
			if (lower) {
				
				c += 'a' - 'A';
			}
			
			str += c;
		}
		
		return str;
	}
}
