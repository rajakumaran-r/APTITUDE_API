package com.example.Apptitudeapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "permutationandcombinations")
public class PermutationandCombination {
    private String id; // Unique identifier
    private String question; // The aptitude question
    private String answer; // The correct answer
    private String explanation; // Explanation for the correct answer
    private String[] options; // Array of options // Unique identifier

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public PermutationandCombination(String id, String question, String answer, String explanation, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.options = options;
    }

    @Override
    public String toString() {
        return "PermutationandCombination{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", explanation='" + explanation + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
    // Array of options
}