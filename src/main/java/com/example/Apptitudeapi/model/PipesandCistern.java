package com.example.Apptitudeapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection="pipesandcisterns")
public class PipesandCistern {
    private String id; // Unique identifier
    private String question; // The aptitude question
    private String answer;
    private String explanation; // Explanation for the correct answer
    private String[] options;// The correct answer

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public PipesandCistern(String id, String question, String answer, String explanation, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.options = options;
    }

    @Override
    public String toString() {
        return "PipesandCisterns{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", explanation='" + explanation + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
    // Array of options
}
