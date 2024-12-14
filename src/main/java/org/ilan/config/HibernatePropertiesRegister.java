package org.ilan.config;


import lombok.extern.slf4j.Slf4j;
import org.ilan.namingStrategy.CustomPhysicalNamingStrategy;
import org.ilan.provider.StringValueResolverProvider;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Description;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;

import java.util.HashMap;
import java.util.Map;

import static org.hibernate.cfg.AvailableSettings.PHYSICAL_NAMING_STRATEGY;
import static org.ilan.constant.NamingStrategyConstant.PHYSICAL_NAMING_STRATEGY_ENABLED;


/**
 * Register the Naming strategy when user creates Bean of entityManager
 * @author Ilankumaran Ilangovan
 */
@Slf4j
@Configuration
@DependsOn(StringValueResolverProvider.BEAN_NAME)
@ConditionalOnProperty(name = PHYSICAL_NAMING_STRATEGY_ENABLED, havingValue = "true", matchIfMissing = true)
@Description("Class for resolving jpa naming strategy when user creates Bean of entityManager")
public class HibernatePropertiesRegister {

    /**
     * To satisfy java-doc
     */
    public HibernatePropertiesRegister(){

    }

    /**
     * the below builder code is copied from org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration.
     *         Refer the same If you wanted to enhance anything in the future.
     * @param jpaVendorAdapter jpaVendorAdapter
     * @param persistenceUnitManager persistenceUnitManager
     * @param customizers customizers
     * @param jpaProperties jpaProperties
     * @return EntityManagerFactoryBuilder that has the custom naming strategy class add in spring environment properties
     */
    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaVendorAdapter jpaVendorAdapter,
                                                                   ObjectProvider<PersistenceUnitManager>persistenceUnitManager,
                                                                   ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers,
                                                                   JpaProperties jpaProperties) {
        Map properties = new HashMap<>();
        properties.put(PHYSICAL_NAMING_STRATEGY, CustomPhysicalNamingStrategy.CLASS_NAME);
        properties.putAll(jpaProperties.getProperties());
        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(jpaVendorAdapter, properties, persistenceUnitManager.getIfAvailable());
        customizers.orderedStream().forEach((customizer) -> {
            customizer.customize(builder);
        });

        log.info("CustomPhysicalNamingStrategy is set to EntityManagerFactoryBuilder");
        return builder;

    }

}