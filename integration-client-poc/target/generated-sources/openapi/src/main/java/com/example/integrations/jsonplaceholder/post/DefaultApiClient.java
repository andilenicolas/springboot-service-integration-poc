package com.example.integrations.jsonplaceholder.post;

import org.springframework.cloud.openfeign.FeignClient;
import org.openapitools.configuration.ClientConfiguration;

@FeignClient(name="${default.name:default}", url="${default.url:http://localhost}", configuration = ClientConfiguration.class)
public interface DefaultApiClient extends DefaultApi {
}
