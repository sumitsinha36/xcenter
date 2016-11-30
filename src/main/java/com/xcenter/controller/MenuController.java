package com.xcenter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xcenter.repository.AdminMenuRepository;
import com.xcenter.util.JSONUtil;

@Controller 
public class MenuController {

	@Autowired
	private AdminMenuRepository adminMenuRepository;
	
	@RequestMapping(value="/getAdminMenu", method=RequestMethod.POST)
	public void getAllMenu(HttpServletResponse response) throws IOException, JSONException, IllegalArgumentException, IllegalAccessException {
		
		/*AdminMenu adminMenu = new AdminMenu();
		adminMenu.setId("001");
		adminMenu.setName("New Employee");
		adminMenu.setUrl("/newEmployee");
		adminMenuRepository.save(adminMenu);*/
		
		JSONUtil util = new JSONUtil();
		JSONObject json = util.getJSONObjectFromList(adminMenuRepository.findAll());
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
