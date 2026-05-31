package com.learnig.ai_spring_api.web;

import com.learnig.ai_spring_api.service.AIPythonAgentClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/v2")
public class AIPythonAgentController {

    private final AIPythonAgentClient aiPythonAgentClient;

    public AIPythonAgentController(AIPythonAgentClient aiPythonAgentClient) {
        this.aiPythonAgentClient = aiPythonAgentClient;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return aiPythonAgentClient.askAgent(question);
    }
}