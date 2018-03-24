package org.sampdb.service.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JqgridObjectMapper {
	
	public static JqgridFilter map(String jsonString) {
		if (jsonString != null) {
			ObjectMapper mapper = new ObjectMapper();
	    	
	    	try {
	    		JqgridFilter filters = mapper.readValue(jsonString, JqgridFilter.class);
				return filters;
	    	} catch (Exception e) {
				throw new RuntimeException (e);
			}
		}
		
		return null;
	}
}
