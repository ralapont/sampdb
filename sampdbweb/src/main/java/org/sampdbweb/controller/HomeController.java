package org.sampdbweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.sampdb.modeljpa.entities.President;
import org.sampdb.service.ConsultaPresidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired ConsultaPresidentService service;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		
		@SuppressWarnings("unused")
		List<President> presidentes = service.obtenerPresidents();
		return new ModelAndView("home");
	}
}
