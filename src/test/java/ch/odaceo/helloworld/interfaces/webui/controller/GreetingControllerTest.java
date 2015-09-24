/*
 * Copyright (C) 2015 Odaceo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.odaceo.helloworld.interfaces.webui.controller;

import ch.odaceo.helloworld.Application;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alexandre Garino <alexandre.garino@odaceo.ch>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class GreetingControllerTest {

    @Value("${local.server.port}")
    private int serverPort;

    private final RestTemplate template = new TestRestTemplate();

    private String buildUrl(String uri) {
        return new StringBuilder("http://localhost:")
                .append(serverPort)
                .append(uri)
                .toString();
    }

    @Test
    public void testGreeting_DefaultValue() throws Exception {

        // given
        final String instance = template.getForEntity(buildUrl("/greeting"), String.class).getBody();

        // then
        assertThat(instance, containsString("Hello, World!"));
    }

    @Test
    public void testGreeting_ToAlexandre() throws Exception {

        // given
        final String instance = template.getForEntity(buildUrl("/greeting?name={name}"), String.class, "Alexandre").getBody();

        // then
        assertThat(instance, containsString("Hello, Alexandre!"));
    }

}
