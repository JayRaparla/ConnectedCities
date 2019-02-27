package com.jay.app.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * ConnectedResource controller
 */
@RestController
@RequestMapping("/api/connected")
public class ConnectedResource {

    String connected;

    @Autowired
    Set<ConnectedCities> connectedCities;

    private final Logger log = LoggerFactory.getLogger(ConnectedResource.class);

    /**
     * GET : retrieve list of connected cities.
     */
    @GetMapping("/listConnectedCities")
    public Set<ConnectedCities> listConnectedCities() {
        return connectedCities;
    }

    /**
     * GET :  Check if origin and destination cities are connected..
     */

    @GetMapping
    public String checkCitiesConnected(@RequestParam("origin") String origin, @RequestParam("destination") String destination ) {
        connected="no";
        connectedCities.forEach((ConnectedCities cities)->{
            if (cities.checkCitiesConnected(origin, destination)){connected="yes";}
        });

        return connected;
    }

}
