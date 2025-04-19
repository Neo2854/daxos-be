package com.sekai.daxos.llm.agents;

import com.google.genai.Client;
import com.google.genai.types.*;
import com.sekai.daxos.constants.LLMConstants;
import com.sekai.daxos.llm.tools.RemainderTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class RemainderAgent {

    @Value("${google.genai.llm.model.apikey}")
    private String apiKey;

    private Client llmClient;
    private RemainderTool remainderTool;
    private List<Tool> tools;

    @PostConstruct
    public void init(){
        if(StringUtils.isEmpty(apiKey))
            log.error("LLM API key not provided");

        llmClient = Client.builder().apiKey(apiKey).build();
        remainderTool = new RemainderTool();

        tools = new ArrayList<>();

        tools.add(remainderTool.getTool());
    }

    public String ask(){
        GenerateContentConfig config = GenerateContentConfig.builder()
                .tools(tools)
                .build();

        List<Part> parts = new ArrayList<>();

        parts.add(Part.fromText("I have a meeting tomorrow with Jack"));

        Content content = Content.builder()
                .role("user")
                .parts(parts)
                .build();

        try {
            GenerateContentResponse response = llmClient.models.generateContent(LLMConstants.LLM_MODEL, content, config);

            log.info("Got response from: " + LLMConstants.LLM_MODEL);

            return response.toJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (HttpException e) {
            throw new RuntimeException(e);
        }
    }
}
