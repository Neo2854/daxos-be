package com.sekai.daxos.llm.prompts;

public class DateTImeInfo {
    public static String getCurrentDayPrompt(String currDay){
        return "Today: " + currDay + ". ";
    }

    public static String getCurrTimePrompt(String currTime){
        return  "Current time: " + currTime + ".";
    }
}
