package com.gal.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.model.Department;
import com.gal.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@ExceptionHandler(exception=Exception.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public String getExceptionDetails(Exception e) throws JsonProcessingException {
		 ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> error = new HashMap<>();
	        error.put("message", e.getMessage());
	        error.put("status", HttpStatus.BAD_REQUEST.value());
	        error.put("error", "Bad Request");
	        error.put("timestamp", System.currentTimeMillis());

	        return mapper.writeValueAsString(error);
	}
	@ExceptionHandler(DepartmentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, Object> handleNotFound(DepartmentNotFoundException e) {

	    Map<String, Object> error = new HashMap<>();
	    error.put("message", e.getMessage());
	    error.put("code", 404);

	    return error;
	}
	//private static final Logger Log =LoggerFactory.getLogger("com.gal");
	private static final Logger Log =LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;

    //department by id using RequestParam
    //department?id=10
    @GetMapping
    public Department getDepartmentById(@RequestParam("id") int id) {
    	  Department department = departmentService.find(id);
	   return department;
    }

    // department by id using PathVariable
    @RequestMapping(value="/{id}",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getDepartment(@PathVariable int id) {
        Log.debug("request for department with id: {}", id);

        Department d = departmentService.find(id);
        if (d == null) {
            throw new DepartmentNotFoundException("Department with id " + id + " not found");
        }

        return ResponseEntity.ok(d);
    }

    // department by name
    @GetMapping("byname")
    public Department getDepartmentByName(@RequestParam("name") String name) {
        Department department= departmentService.findByName(name);
        return department;
    }
    @PostMapping(consumes="application/json",produces="application/json")
    Department addDepartmnet(@RequestBody Department department) {
    	Log.debug("request for adding dep"+department);
    	Department saved=departmentService.addDepartment(department);
    	return saved;
    }
    @PutMapping(consumes="application/json",produces="application/json")
    Department updateDepartmnet(@RequestBody Department department) {
    	Log.debug("request for updating dep"+department);
    	Department saved=departmentService.update(department);
    	return saved;
    }
}