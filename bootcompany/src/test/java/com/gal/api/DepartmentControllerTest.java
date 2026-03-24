package com.gal.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gal.BootcompanyApplication;
import com.gal.api.DepartmentController;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
@ContextConfiguration(classes = BootcompanyApplication.class)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private DepartmentService depService;

	@Test 
	void testGetDepartment() throws Exception {

		Department department = new Department(1,"HR",205,Date.valueOf("2025-05-08"));

		when(depService.find(1)).thenReturn(department);
		when(depService.find(2000)).thenReturn(null);

		mockMvc.perform(get("/department/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.depname").value("HR"));

		mockMvc.perform(get("/department/2000")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.code").exists())
				.andExpect(jsonPath("$.message").exists());
	}
	

}