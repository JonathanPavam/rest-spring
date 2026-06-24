package rest_springboot.rest_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_springboot.rest_spring.service.PersonService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TesLogController {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    @GetMapping("/test")
    public String testLog (){
        logger.info("This in an INFO log");
        logger.warn("This in an WARN log");
        logger.debug("This in an DEBUG log");
        logger.error("This in an ERROR log");

        return "Logs generated with sucessfully";
    }
}
