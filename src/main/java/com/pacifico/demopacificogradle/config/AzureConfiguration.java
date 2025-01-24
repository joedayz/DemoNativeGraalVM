package com.pacifico.demopacificogradle.config;

import com.azure.spring.cloud.autoconfigure.implementation.context.properties.AzureGlobalProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author josediaz
 **/
@Configuration
public class AzureConfiguration {

  @Bean
  public AzureGlobalProperties azureGlobalProperties() {
    return new AzureGlobalProperties();
  }
}