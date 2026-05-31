package com.learnig.ai_spring_api.service;

import com.learnig.ai_spring_api.config.AIAgentProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AIPythonAgentClient {

    private final WebClient webClient;

    public AIPythonAgentClient(
            WebClient.Builder builder,
            AIAgentProperties agentService) {

        this.webClient = builder
                .baseUrl(agentService.getBaseUrl())
                .build();
    }

    public String askAgent(String question) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/ask")
                        .queryParam("question", question)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}