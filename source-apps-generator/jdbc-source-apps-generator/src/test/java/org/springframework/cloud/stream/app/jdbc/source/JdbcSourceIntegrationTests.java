/*
 * Copyright 2016-2019 the original author or authors.
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

package org.springframework.cloud.stream.app.jdbc.source;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.pivotal.java.function.jdbc.supplier.JdbcSupplierApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = JdbcSupplierApplication.class,
		properties = {"spring.datasource.url=jdbc:h2:mem:test","spring.cloud.stream.function.definition=jdbcSupplier"},
		webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
abstract class JdbcSourceIntegrationTests {

	protected final ObjectMapper objectMapper = new ObjectMapper();

	@Qualifier("jdbcSupplier-out-0")
	@Autowired
	protected MessageChannel output;

	@Autowired
	protected JdbcOperations jdbcOperations;

	@Autowired
	protected MessageCollector messageCollector;

}
