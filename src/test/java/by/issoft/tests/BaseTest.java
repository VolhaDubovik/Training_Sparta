package by.issoft.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;



@Listeners({TestListener.class})

public class BaseTest {

    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    public static void main(String[] args) {


        //log.

        try{
            Integer.parseInt("dfsdgsg");
        }catch (NumberFormatException e){
            log.error("Port number paring failue.", e);
        }

        log.info("dfsdfsd");
        log.debug("Debug log message");
//        log.info("Info log message");
//        log.error("Error log message");
//        log.warn("AAAA");
    }



    @BeforeMethod
    public void globalBefore(){

    }
}