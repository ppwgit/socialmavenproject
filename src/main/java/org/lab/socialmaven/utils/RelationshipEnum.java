package org.lab.socialmaven.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum RelationshipEnum {
    SINGLE("Single"),
    IN_A_RELATIONSHIP("In a Relationship"),
    ENGAGED("Engaged"),
    MARRIED("Married"),
    DIVORCED("Divorced");

    private final String displayName;
    private static final Logger logger = LogManager.getLogger(RelationshipEnum.class);

    RelationshipEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void celebrateAnniversary() {
        logger.info("Anniversary " + displayName);
    }

}