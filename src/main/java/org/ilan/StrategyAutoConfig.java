package org.ilan;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/** Class the scan the package automatically
 * @author Ilankumaran Ilangovan
 */
@AutoConfiguration
@ComponentScan(basePackages = "org.ilan")
public class StrategyAutoConfig {

    /**
     * Spring will use it for creating the bean in IOC container
     */
    public StrategyAutoConfig(){

    }
}
