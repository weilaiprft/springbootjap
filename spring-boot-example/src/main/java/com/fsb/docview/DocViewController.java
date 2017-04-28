package com.fsb.docview;


import com.fsb.docview.model.DocView;
import com.fsb.docview.service.DocViewService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
@RestController
@EnableAutoConfiguration

public class DocViewController {

	@Autowired
    private DocViewService docViewedService;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiRequestController.class);

    @RequestMapping(value = "/dummydocview", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> dummyDocViewRequest() {
        logger.info("dummy docview request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            DocView docView = new DocView(new Date());
            docViewedService.create(docView);
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }
        return response;
    }          
    
    @RequestMapping(value = "/docview", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> inserNewDocVeiwRecord(@RequestParam(value="loanNumber", required = true) final String loanNumber,
    		@RequestParam(value="docGuid", required = true) final String docGuid,
    		@RequestParam(value="documentType", required = true) final String documentType,
    		@RequestParam(value="documentCreatedDate", required = true) final Date documentCreatedDate,
    		@RequestParam(value="userName", required = true) final String userName,
    		@RequestParam(value="mortracStatus", required = true) final String mortracStatus,
    		@RequestParam(value="uwStatus", required = true) final String uwStatus) {
        logger.info("new docview request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            //DocView docView = new DocView(new Date());
        	DocView docView = new DocView(loanNumber, docGuid, documentType, documentCreatedDate, userName, mortracStatus, uwStatus, new Date());
            docViewedService.create(docView);
            response.put("status", "success");
            logger.info("new docview request completed with success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
            logger.error("new docview request failed " + e.getMessage());
        }
        return response;
    }    
    
    // TODO: test only
    @RequestMapping(value = "/docviewdata", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> inserNewDocVeiwRecord(@RequestParam(value="count", required = true) final int count) {
        logger.info("generate dummy new docview data request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            //DocView docView = new DocView(new Date());
        	for(int i = 0; i<count; i++){
        		DocView docView = getRandomDocView();
                docViewedService.create(docView);
        	}        	
            response.put("status", "success");
            logger.info("new docview request completed with success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
            logger.error("new docview request failed " + e.getMessage());
        }
        return response;
    }    
    
    private DocView getRandomDocView(){
    	Random rand = new Random();
    	int loanNumber = rand.nextInt(99) + 1;    	
    	String docGuid = UUID.randomUUID().toString();
    	Date documentCreatedDate = new Date();   
    	String[] randDocType = {"w2", "tax return", "appraisal", "id", "flood cert", "insurance"};
    	String[] randNames = {"wei", "joe", "jane", "christina", "ryan", "ivan"};
    	String[] randMortracStatus = {"funding ready", "new loan", "review", "process", "funding", "closing"};
    	String[] randUwStatus = {"uwStatus1", "uwStatus2", "uwStatus3", "usStatus4", "uwStatus5", "uwStatus6"}; 
    			    	    	    
    	DocView docView =  new DocView(String.valueOf(loanNumber), docGuid, randDocType[rand.nextInt(5) + 1], documentCreatedDate, 
    			randNames[rand.nextInt(5) + 1], randMortracStatus[rand.nextInt(5) + 1], randUwStatus[rand.nextInt(5) + 1], new Date());
    	return docView;
    }
    
}
