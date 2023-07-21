package com.The_10th_Finance.config;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.paramstore.AwsParamStoreProperties;
import org.springframework.cloud.aws.paramstore.AwsParamStorePropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterStoreConfig {

    @Value("${aws.parameterstore.prefix}")
    private String parameterStorePrefix;

    @Autowired
    private AWSSimpleSystemsManagement awsSimpleSystemsManagement;

    @Bean
    public AwsParamStoreProperties awsParamStoreProperties() {
        return new AwsParamStoreProperties();
    }

    @Bean
    public AwsParamStorePropertySourceLocator awsParamStorePropertySourceLocator(AwsParamStoreProperties awsParamStoreProperties) {
        return new AwsParamStorePropertySourceLocator(awsSimpleSystemsManagement, awsParamStoreProperties);
    }
}
