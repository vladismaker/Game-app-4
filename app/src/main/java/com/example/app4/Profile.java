package com.example.app4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("number")
    @Expose
    private int number;

    @SerializedName("question")
    @Expose
    private String question;

    @SerializedName("colorAnswer")
    @Expose
    private String colorAnswer;

    @SerializedName("textAnswer")
    @Expose
    private String textAnswer;

    @SerializedName("backgroundLeft")
    @Expose
    private String backgroundLeft;

    @SerializedName("backgroundRight")
    @Expose
    private String backgroundRight;

    @SerializedName("textLeft")
    @Expose
    private String textLeft;

    @SerializedName("textRight")
    @Expose
    private String textRight;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getColorAnswer() {
        return colorAnswer;
    }

    public void setColorAnswer(String colorAnswer) {
        this.colorAnswer = colorAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public String getBackgroundLeft() {
        return backgroundLeft;
    }

    public void setBackgroundLeft(String backgroundLeft) {
        this.backgroundLeft = backgroundLeft;
    }

    public String getBackgroundRight() {
        return backgroundRight;
    }

    public void setBackgroundRight(String backgroundRight) {
        this.backgroundRight = backgroundRight;
    }

    public String getTextLeft() {
        return textLeft;
    }

    public void setTextLeft(String textLeft) {
        this.textLeft = textLeft;
    }

    public String getTextRight() {
        return textRight;
    }

    public void setTextRight(String textRight) {
        this.textRight = textRight;
    }
}
