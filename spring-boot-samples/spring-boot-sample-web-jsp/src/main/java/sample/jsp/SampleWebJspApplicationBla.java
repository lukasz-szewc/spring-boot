/*
 * Copyright 2012-2016 the original author or authors.
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

package sample.jsp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SampleWebJspApplicationBla extends SpringBootServletInitializer {


	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(JacksonAutoConfiguration.class, ValidationAutoConfiguration.class);
		springApplication.setWebEnvironment(false);
		ConfigurableApplicationContext context = springApplication.run(args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		ObjectMapper bean = context.getBean(ObjectMapper.class);
		ObjectNode objectNode = bean.createObjectNode();
		ObjectNode put = objectNode.put("abc", "def");
		System.out.println(put.toString());

		Validator bean1 = context.getBean(Validator.class);
		Set<ConstraintViolation<Clazz>> validate = bean1.validate(new Clazz());
		for (ConstraintViolation<Clazz> clazzConstraintViolation : validate) {
			System.out.println(clazzConstraintViolation);
		}
	}

}
