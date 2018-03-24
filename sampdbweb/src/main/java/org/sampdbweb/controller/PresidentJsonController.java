package org.sampdbweb.controller;

import org.sampdb.service.ConsultaPresidentService;
import org.sampdb.service.dtos.PresidentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/presidentjson")
public class PresidentJsonController {

	@Autowired ConsultaPresidentService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<PresidentDto> showPresidents(
			@RequestParam(value="page", required=false) Integer page,
			@RequestParam(value="rows", required=false) Integer rows,
			@RequestParam(value="sidx", required=false) String  sidx,
			@RequestParam(value="sord", required=false) String  sord,
			@RequestParam("_search") Boolean search,
			@RequestParam(value="filters", required=false) String  filters) {

		Page<PresidentDto> pagePresidents = null;
		if (search == true) {
			pagePresidents = service.findBySearchTerm(page, rows, sidx, sord, filters);
		} else {
			pagePresidents = service.findBySearchTerm(page, rows, sidx, sord);
		}
		
		return pagePresidents;
	}

}
