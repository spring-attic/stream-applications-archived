package org.springframework.cloud.stream.app.splitter.processor;

import javax.naming.Context;

import io.pivotal.java.function.splitter.function.SplitterFunctionConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterProcessorIntegrationTests {

	@Test
	@Ignore
	public void basicSplitterTest() {
		ApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration.getCompleteConfiguration(FooApplication.class))
				.web(WebApplicationType.NONE)
				.run("--spring.jmx.enabled=false", "--spring.cloud.stream.function.definition=splitterFunction");

		InputDestination source = context.getBean(InputDestination.class);
		OutputDestination target = context.getBean(OutputDestination.class);

		source.send(new GenericMessage("hello,world".getBytes()));
		Message<byte[]> outputMessage = target.receive();
		assertThat(new String(outputMessage.getPayload())).isEqualTo("hello");
		outputMessage = target.receive();
		assertThat(new String(outputMessage.getPayload())).isEqualTo("world");
	}

	@SpringBootApplication
	@Import({SplitterFunctionConfiguration.class, ContextFunctionCatalogAutoConfiguration.class})
	public static class FooApplication {

	}


}
