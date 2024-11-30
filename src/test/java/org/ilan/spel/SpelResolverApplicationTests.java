package org.ilan.spel;

import org.ilan.spel.provider.SpelExpressionResolverProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE, classes = {ApplicationTestMain.class})
class SpelResolverApplicationTests {



	@Test
	void contextLoads() {
		String name = SpelExpressionResolverProvider.getStringValueResolver().resolveStringValue("${what.is.my.name}");
		assertEquals(name , "Ilankumaran Ilangovan");
	}

}
