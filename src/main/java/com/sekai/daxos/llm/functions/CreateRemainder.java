package com.sekai.daxos.llm.functions;

import com.google.genai.types.FunctionDeclaration;
import com.google.genai.types.Schema;

import java.util.Optional;

public class CreateRemainder extends FunctionDeclaration {
    @Override
    public Optional<Schema> response() {
        return Optional.empty();
    }

    @Override
    public Optional<String> description() {
        return ;
    }

    @Override
    public Optional<String> name() {
        return Optional.empty();
    }

    @Override
    public Optional<Schema> parameters() {
        return Optional.empty();
    }

    @Override
    public Builder toBuilder() {
        return null;
    }
}
