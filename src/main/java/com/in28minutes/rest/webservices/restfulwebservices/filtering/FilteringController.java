package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping(path="/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> retrieveArrayListOfSomeBean() {
		return Arrays.asList(new SomeBean("value12", "value22", "value32"),new SomeBean("value1", "value2", "value3"));
	}
}
