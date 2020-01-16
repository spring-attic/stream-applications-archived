/*
 * Copyright 2015-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.splitter.processor;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.integration.splitter.DefaultMessageSplitter;
import org.springframework.integration.test.util.TestUtils;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

public class UsingNothingIntegrationTests extends SplitterProcessorIntegrationTests {

//	@Test
//	@Ignore
//	public void test() {
//		assertThat(this.splitter, instanceOf(Function.class));
//		this.input.send(new GenericMessage<>(Arrays.asList("hello", "world")));
//		assertThat(this.collector.forChannel(this.output), receivesPayloadThat(is("hello")));
//		assertThat(this.collector.forChannel(this.output), receivesPayloadThat(is("world")));
//	}

}
