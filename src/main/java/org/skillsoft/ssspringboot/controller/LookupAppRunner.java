package org.skillsoft.ssspringboot.controller;

import org.skillsoft.ssspringboot.model.User;
import org.skillsoft.ssspringboot.service.LookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class LookupAppRunner  implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(LookupService.class);

    private final LookupService lookupService;

    public LookupAppRunner(LookupService lookupService) {
        this.lookupService = lookupService;
    }


    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<User> info1 = lookupService.findUser("ranjjose-chaz");
        CompletableFuture<User> info2 = lookupService.findUser("Scikit-learn");
        CompletableFuture<User> info3 = lookupService.findUser("spring-boot");
        CompletableFuture<User> info4 = lookupService.findUser("Pytorch");

        CompletableFuture.allOf(info1, info2, info3, info4).join();

        logger.info(""+info1.get());
        logger.info(""+info2.get());
        logger.info(""+info3.get());
        logger.info(""+info4.get());

    }
}
