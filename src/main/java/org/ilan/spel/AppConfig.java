package org.ilan.spel;

import org.ilan.spel.provider.SpelExpressionResolverProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import(SpelExpressionResolverProvider.class)
public class AppConfig {

}
