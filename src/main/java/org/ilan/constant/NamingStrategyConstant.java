package org.ilan.constant;

/**
 * Constant file for Registering the naming-strategy
 * @author Ilankumaran Ilangovan
 */
public class NamingStrategyConstant {

    /**
     * Spring property registering the naming-strategy
     */
    public static final String SPRING_PHYSICAL_NAMING_STRATEGY = "spring.jpa.hibernate.naming.physical-strategy";

    /**
     * Hibernate registering the naming-strategy
     */
    public static final String PHYSICAL_NAMING_STRATEGY_ENABLED = "naming.physical-strategy.enabled";

    private NamingStrategyConstant() {

    }
}
