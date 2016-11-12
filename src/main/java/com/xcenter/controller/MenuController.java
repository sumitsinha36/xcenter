package com.xcenter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class MenuController {

	@RequestMapping(value="/getAllMenu", method=RequestMethod.POST)
	public void getAllMenu(HttpServletResponse response) throws IOException {
		List<String> l = new ArrayList<>();
		l.add("A");
		l.add("B");
		Map<String, Object> map = new HashMap<>();
		map.put("M", l);
		PrintWriter out = response.getWriter();
		out.print(map);
	}
}
