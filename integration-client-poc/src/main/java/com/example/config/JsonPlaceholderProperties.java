package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ConfigurationProperties(prefix = "jsonplaceholder")
public class JsonPlaceholderProperties {
    private IntegrationProps post;
    private IntegrationProps comments;

    public IntegrationProps getPost() {
        return post;
    }

    public void setPost(IntegrationProps post) {
        this.post = post;
    }

    public IntegrationProps getComments() {
        return comments;
    }

    public void setComments(IntegrationProps comments) {
        this.comments = comments;
    }

    public static class IntegrationProps {
        private String baseUrl;
        private Duration timeoutMs;
        private Retry retry;

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public Duration getTimeoutMs() {
            return timeoutMs;
        }

        public void setTimeoutMs(Duration timeoutMs) {
            this.timeoutMs = timeoutMs;
        }

        public Retry getRetry() {
            return retry;
        }

        public void setRetry(Retry retry) {
            this.retry = retry;
        }
    }

    public static class Retry {
        private int maxAttempts;

        public int getMaxAttempts() {
            return maxAttempts;
        }

        public void setMaxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
        }
    }
}
