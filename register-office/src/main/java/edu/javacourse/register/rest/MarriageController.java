package edu.javacourse.register.rest;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarriageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);

    private MarriageManager marriageManager;


    public MarriageResponse findMarriageCertificate(MarriageRequest request) {

        LOGGER.info("findMarriageCertificate is called");
        MarriageResponse marriageCertificate = marriageManager.findMarriageCertificate(request);

        return marriageCertificate;
    }
}
