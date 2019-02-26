package com.jay.app.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConnectedResource controller
 */
@RestController
@RequestMapping("/api/connected")
public class ConnectedResource {

    @Value("classpath:city.txt")
    Resource resourceFile;

    private final Logger log = LoggerFactory.getLogger(ConnectedResource.class);

    /**
     * GET connected
     */
    @GetMapping("/connected")
    public Resource connected() {
        return resourceFile;
    }

}
