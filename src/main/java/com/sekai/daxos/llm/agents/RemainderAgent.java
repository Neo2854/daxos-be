package com.sekai.daxos.llm.agents;

import com.google.genai.Client;
import com.google.genai.types.*;
import com.sekai.daxos.constants.LLMConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Slf4j
public class RemainderAgent {

    @Value("${google.genai.llm.model.apikey}")
    private String apiKey;

    private Client llmClient;

    @PostConstruct
    public void init(){
        if(StringUtils.isEmpty(apiKey))
            log.error("LLM API key not provided");

        llmClient = Client.builder().apiKey(apiKey).build();
    }

    public String ask(){
        GenerateContentConfig config = GenerateContentConfig.builder().build();
        Tool remainderTool = Tool.builder().functionDeclarations(null).build();


        try {
            GenerateContentResponse response = llmClient.models.generateContent(LLMConstants.LLM_MODEL, "Hello", config);

            log.info("Got response from: " + LLMConstants.LLM_MODEL);

            return response.text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (HttpException e) {
            throw new RuntimeException(e);
        }
    }
}
