package com.learnig.ai_spring_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OpenAIService {

    private final WebClient webClient;

    public OpenAIService(
            WebClient.Builder builder,
            @Value("${openai.api-key}") String apiKey
    ) {

        this.webClient = builder
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public String askAI(String prompt) {
        String requestBody = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "system", "content": "You are a helpful AI assistant."},
            {"role": "user", "content": "%s"}
          ]
        }
        """.formatted(prompt);

        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}