package org.skillsoft.ssspringboot.service;

import org.skillsoft.ssspringboot.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class LookupService {
    private static final Logger logger = LoggerFactory.getLogger(LookupService.class);
    private static final String GITHUB_USER_URL = "https://api.github.com/users/%s";
    private final RestTemplate restTemplate;

    public LookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format(GITHUB_USER_URL, user);
        User results = restTemplate.getForObject(url, User.class);
        //System.out.println("Results available "+ results.getName());
        Thread.sleep(4000L);
        return CompletableFuture.completedFuture(results);
    }






}
