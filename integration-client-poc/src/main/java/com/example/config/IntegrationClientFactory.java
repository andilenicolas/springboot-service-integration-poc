package com.example.config;

import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegrationClientFactory {

    private final JsonPlaceholderProperties props;
    private final FeignClientBuilder feignClientBuilder;

    public IntegrationClientFactory(JsonPlaceholderProperties props, FeignClientBuilder feignClientBuilder) {
        this.props = props;
        this.feignClientBuilder = feignClientBuilder;
    }

    @Bean
    public com.example.integrations.jsonplaceholder.post.DefaultApiClient postClient() {
        return feignClientBuilder
                .forType(com.example.integrations.jsonplaceholder.post.DefaultApiClient.class, "jsonplaceholder-post")
                .url(props.getPost().getBaseUrl())
                .build();
    }

    @Bean
    public com.example.integrations.jsonplaceholder.comments.DefaultApiClient commentsClient() {
        return feignClientBuilder
                .forType(com.example.integrations.jsonplaceholder.comments.DefaultApiClient.class,
                        "jsonplaceholder-comments")
                .url(props.getComments().getBaseUrl())
                .build();
    }
}
