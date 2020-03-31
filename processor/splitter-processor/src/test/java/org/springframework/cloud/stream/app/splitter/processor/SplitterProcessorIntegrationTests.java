///*
// * Copyright 2015-2019 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      https://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package org.springframework.cloud.stream.app.splitter.processor;
//
//import java.util.function.Function;
//
//import javax.naming.Context;
//
//import io.pivotal.java.function.splitter.function.SplitterFunctionApplication;
//import io.pivotal.java.function.splitter.function.SplitterFunctionConfiguration;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration;
//import org.springframework.cloud.stream.binder.test.InputDestination;
//import org.springframework.cloud.stream.binder.test.OutputDestination;
//import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.cloud.stream.test.binder.MessageCollector;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Import;
//import org.springframework.integration.endpoint.EventDrivenConsumer;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;
//import org.springframework.messaging.support.GenericMessage;
//import org.springframework.test.annotation.DirtiesContext;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(classes = SplitterFunctionApplication.class,
//		properties = {"spring.cloud.stream.function.definition=splitterFunction"},
//		webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext
//abstract class SplitterProcessorIntegrationTests {
//
//
//	@Autowired
//	@Qualifier("splitterFunction-out-0")
//	protected MessageChannel output;
//
//	@Autowired
//	@Qualifier("splitterFunction-in-0")
//	protected SubscribableChannel input;
//
//	@Autowired
//	protected MessageCollector collector;
//
//	@Autowired
//	@Qualifier("splitterFunction")
//	protected Function<?, ?> splitter;
//
////	@Autowired
////	@Qualifier("splitterProcessorConfiguration.splitterHandler.splitter")
////	protected EventDrivenConsumer consumer;
//
//}
