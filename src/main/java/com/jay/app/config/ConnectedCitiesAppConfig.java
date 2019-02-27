package com.jay.app.config;

import com.jay.app.web.rest.ConnectedCities;
import com.jay.app.web.rest.UserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Configuration
public class ConnectedCitiesAppConfig {

    private final Logger log = LoggerFactory.getLogger(ConnectedCitiesAppConfig.class);

    /**
     * Initialise connected cities list from text file.
     * @return the corresponding collection of connected cities.
     */
    @Bean
    Set<ConnectedCities> connectedCities(){
        Set<ConnectedCities> connectedCities = new HashSet<>();
        try (Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("city.txt"))).lines()) {
            stream.forEach((String line) -> {
                if(!line.trim().isEmpty()){
                    connectedCities.add(new ConnectedCities(line));
                }
            });
        } catch (Exception e) {
            log.info("Exception accessing file", e);
        }

        connectedCities.forEach(System.out::println);
        return connectedCities;
    }
}
