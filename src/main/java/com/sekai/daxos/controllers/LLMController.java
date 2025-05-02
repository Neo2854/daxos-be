package com.sekai.daxos.controllers;

import com.sekai.daxos.llm.agents.RemainderAgent;
import com.sekai.daxos.models.RemainderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LLMController {
    @Autowired
    private RemainderAgent remainderAgent;

    @RequestMapping(value = "/remainderagent", method = RequestMethod.POST)
    public ResponseEntity<Object> hello(@RequestBody RemainderRequest request){
        String response = remainderAgent.ask(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
