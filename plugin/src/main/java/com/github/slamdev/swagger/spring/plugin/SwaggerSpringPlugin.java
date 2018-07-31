package com.github.slamdev.swagger.spring.plugin;

import com.github.slamdev.swagger.spring.generator.Stub;
import lombok.extern.slf4j.Slf4j;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

@Slf4j
public class SwaggerSpringPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        log.info("{}", Stub.class);
    }
}
