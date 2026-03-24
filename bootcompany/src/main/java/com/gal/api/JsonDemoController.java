package com.gal.api;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.model.Department;

@RestController
@RequestMapping("/json/")
public class JsonDemoController{
	@GetMapping("/department")
	public ResponseEntity<String> getDepartmentJson() throws JsonProcessingException {
		Department obj=new Department();
		obj.setDepartmentid(65);
		obj.setDepname("Test department");
		obj.setEstablishedDate(Date.valueOf("2020-05-05"));
		obj.setManagerid(201);
		ObjectMapper mapper=new ObjectMapper();
		String string =mapper.writeValueAsString(obj);
	//ReflectionAPI: getAllPropertiesNames getPropertyValue, json put
		ResponseEntity.ok().body(string);//OK code 200
		ResponseEntity.status(HttpStatus.CREATED).body(string);// created new dept
		ResponseEntity.status(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().header("content-type","application/json").body(string);
		
	}
}