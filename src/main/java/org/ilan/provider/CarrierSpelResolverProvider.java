package org.ilan.provider;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Spring StringValueResolver to resolve the table name spel expression
 * @author Ilankumaran Ilangovan
 */
public class CarrierSpelResolverProvider {


    @Getter
    @Setter
    private static ConfigurableListableBeanFactory configurableListableBeanFactory;

    /**
     * Spring will use it for creating the bean in IOC container
     */
    private CarrierSpelResolverProvider(){

    }
}
