package com.nsh.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.nsh.request.SearchRequest;
import com.nsh.response.SearchResponse;

public interface EligibilityService {
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatuses();
	
	public List<SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response)throws Exception; 	
	
	public void generatePdf(HttpServletResponse response)throws Exception; 	
	
	
}
