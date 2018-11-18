package com.logging.logsToElk;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger; 

/**
 * Hello world!
 *
 */
public class MyLog4jConfiguration 
{
	static Logger logger = Logger.getLogger(MyLog4jConfiguration.class);
	 
    public static void main(String[] args)
    {
        //Log in console in and log file
        logger.debug("Log4j appender configuration is successful !!");
        
        //Sample code to generate error logs
        try {
        	List<Integer> data = new ArrayList<Integer>();
        	data.get(3);
        	
        }catch (Exception e) {
        	logger.error("Exception occured:::"+e.getMessage());
        }
    }
}
