package com.jiaxy.giants.spring.plugins;

import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

/**
 *
 * @version : ApplicationConfiguration.java, v 0.1 2021年07月06日 10:23 wutaoyuanxuan Exp $
 */
@Configuration
@EnablePluginRegistries({ProductProcessor.class})
public class ApplicationConfiguration {
}