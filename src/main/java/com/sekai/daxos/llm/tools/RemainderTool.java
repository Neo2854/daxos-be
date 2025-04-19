package com.sekai.daxos.llm.tools;

import com.google.genai.types.FunctionDeclaration;
import com.google.genai.types.Tool;
import com.sekai.daxos.llm.functions.RemainderFunctions;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
public class RemainderTool{

    private final Tool tool;
    private final List<FunctionDeclaration> declarations;

    public RemainderTool(){
        declarations = new ArrayList<>();

        declarations.add(RemainderFunctions.CREATE_REMAINDER.getFunctionDeclaration());

        tool = Tool.builder()
                .functionDeclarations(declarations)
                .build();
    }
}
