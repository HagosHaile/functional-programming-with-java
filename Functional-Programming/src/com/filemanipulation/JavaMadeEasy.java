package com.filemanipulation;

import java.util.ArrayList;
import java.util.List;

public class JavaMadeEasy {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices",
				"AWS", "PCF","Azure", "Docker", "Kubernetes");
		
		//courses.replaceAll(str->str.toUpperCase()); throws java.lang.UnsupportedOperationException
		//But the following
		List<String> modifayable = new ArrayList(courses);
		System.out.println(modifayable);
		
		//update to upper case
		modifayable.replaceAll(str->str.toUpperCase());
		System.out.println(modifayable);
		
		
		
		
		
		
	}
}
