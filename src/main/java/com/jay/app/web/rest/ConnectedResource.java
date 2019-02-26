package com.jay.app.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConnectedResource controller
 */
@RestController
@RequestMapping("/api/connected")
public class ConnectedResource {

    private final Logger log = LoggerFactory.getLogger(ConnectedResource.class);

    /**
     * GET connected
     */
    @GetMapping("/connected")
    public String connected() {
        return "connected";
    }

}
