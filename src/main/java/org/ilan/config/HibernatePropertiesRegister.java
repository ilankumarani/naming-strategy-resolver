package org.ilan.config;


import lombok.extern.slf4j.Slf4j;
import org.ilan.namingStrategy.CustomPhysicalNamingStrategy;
import org.ilan.provider.CarrierSpelResolverProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Objects;
import java.util.Properties;

import static org.ilan.constant.NamingStrategyConstant.*;

/**
 * Register the Naming strategy when Spring creates Bean of entityManager
 * @author Ilankumaran Ilangovan
 */
@Slf4j
@Description("Class for Hibernate naming strategy when developer creates entityManager and Datasource (3) ")
public class HibernatePropertiesRegister implements ApplicationListener<ApplicationPreparedEvent> {

    /**
     * Spring will use it for creating the bean in IOC container
     */
    public HibernatePropertiesRegister(){

    }

    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info("CustomPhysicalNamingStrategy is set for Hibernate properties Environment");

        ApplicationContext applicationContext = event.getApplicationContext();
        ConfigurableEnvironment environment = (ConfigurableEnvironment)applicationContext.getEnvironment();

        ConfigurableListableBeanFactory configurableListableBeanFactory = ((AnnotationConfigApplicationContext)applicationContext).getBeanFactory();
        CarrierSpelResolverProvider.setConfigurableListableBeanFactory(configurableListableBeanFactory);

        String isEnabled = environment.getProperty(PHYSICAL_NAMING_STRATEGY_ENABLED);

        //No flag provided
        //Flag provide but empty value
        //Flag provide but value with space
        //Flag provide and the value is TRUE
        if (Objects.isNull(isEnabled) || isEnabled.isEmpty() || (Objects.nonNull(isEnabled) && isEnabled.trim().isEmpty()) || (Objects.nonNull(isEnabled) && !isEnabled.trim().isEmpty() && Boolean.valueOf(isEnabled.trim()) == Boolean.TRUE)) {
            Properties props = new Properties();
            props.put(HIBERNATE_PHYSICAL_NAMING_STRATEGY, CustomPhysicalNamingStrategy.CLASS_NAME);
            final String NAMING_STRATEGY_PROPERTY = "physicalNamingProperty";
            environment.getPropertySources().addFirst(new PropertiesPropertySource(NAMING_STRATEGY_PROPERTY, props));
        }
    }
}