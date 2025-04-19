package com.sekai.daxos.llm.functions;

import com.google.genai.types.FunctionDeclaration;
import com.google.genai.types.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;

@Getter
@AllArgsConstructor
public enum RemainderFunctions {

    CREATE_REMAINDER(
            FunctionDeclaration.fromJson(loadSchemaFromResource("llm/function/create_remainder.json"))
    );

    private FunctionDeclaration functionDeclaration;

    private static String loadSchemaFromResource(String resourcePath) {
        try (InputStream inputStream = RemainderFunctions.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource: " + resourcePath, e);
        }
    }
}
