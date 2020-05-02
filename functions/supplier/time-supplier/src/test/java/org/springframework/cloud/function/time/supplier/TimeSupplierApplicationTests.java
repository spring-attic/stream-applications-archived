/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.time.supplier;

import java.util.function.Supplier;

import org.springframework.cloud.function.time.supplier.TimeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Soby Chacko
 * @author Artem Bilan
 */
@SpringBootTest
public abstract class TimeSupplierApplicationTests {

	@Autowired
	Supplier<String> timeSupplier;

	@Autowired
	TimeProperties timeProperties;

	protected abstract void testTimeSupplier();

	@SpringBootApplication
	static class TestApplication {}
}
