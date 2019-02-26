package com.jay.app.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * ConnectedResource controller
 */
@RestController
@RequestMapping("/api/connected")
public class ConnectedResource {

    @Value("classpath:city.txt")
    Resource resourceFile;

    ArrayList<String> lines = new ArrayList<>();

    private final Logger log = LoggerFactory.getLogger(ConnectedResource.class);

    /**
     * GET connected
     */
    @GetMapping("/connected")
    public String connected() {
        String content = "";

        try {
            File file = resourceFile.getFile();
            content = new String(Files.readAllBytes(file.toPath()));
            log.info(content);
        } catch (IOException e) {
            log.info("Exception in connected method", e);
        }
        return content;
    }

    /**
     * GET list of connected cities from file
     */
    @GetMapping("/cities")
    public ArrayList readDataFile() {

        try (Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("city.txt"))).lines()) {
            stream.forEach((String line) -> {
                System.out.println(line);
                lines.add(line);
            });
        } catch (Exception e) {
            log.info("Exception accessing file", e);
        }

        return lines;
    }

}
