package org.ilan.spel.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringValueResolver;


@Configuration(value = SpelExpressionResolverProvider.BEAN_NAME)
public class SpelExpressionResolverProvider implements EmbeddedValueResolverAware {
    private static final Logger LOG = LoggerFactory.getLogger(SpelExpressionResolverProvider.class);
    public static final String BEAN_NAME = "stringValueResolverProvider";

    private static StringValueResolver stringValueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        LOG.info("StringValueResolverProvider is loaded");
        SpelExpressionResolverProvider.stringValueResolver = stringValueResolver;
    }

    public static StringValueResolver getStringValueResolver(){
        return SpelExpressionResolverProvider.stringValueResolver;
    }
}
