package com.github.slamdev.swagger.spring.generator;

import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.converter.SwaggerConverter;
import io.swagger.v3.parser.core.extensions.SwaggerParserExtension;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.junit.Test;

import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StubTest {

    @Test
    public void verify_v3() {
        SwaggerParserExtension parser = new OpenAPIV3Parser();
        String content = readFromClasspath("/petstore-v3.yaml");
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = parser.readContents(content, null, options);
        assertThat(result, notNullValue());
    }

    @Test
    public void verify_v2() {
        SwaggerParserExtension parser = new SwaggerConverter();
        String content = readFromClasspath("/petstore-v2.yaml");
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        SwaggerParseResult result = parser.readContents(content, null, options);
        assertThat(result, notNullValue());
    }

    private String readFromClasspath(String path) {
        return new Scanner(StubTest.class.getResourceAsStream(path), UTF_8.name())
                .useDelimiter("\\A").next();
    }
}
