package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class StudentGrades implements Serializable{
    private String stugradesId;
    private String stugradesCardId;
    private double total;
    private double average;
    private double maxScore;
    private double minScore;
    private double chinese;
    private double mathematics;
    private double english;
    private double politics;
    private double history;
    private double geography;
    private double biology;
    private double chemistry;
    private double physics;
    private double music;
    private double arts;
    private double sports;

    public String getStugradesId() {
        return stugradesId;
    }

    public void setStugradesId(String stugradesId) {
        this.stugradesId = stugradesId;
    }

    public String getStugradesCardId() {
        return stugradesCardId;
    }

    public void setStugradesCardId(String stugradesCardId) {
        this.stugradesCardId = stugradesCardId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public double getMinScore() {
        return minScore;
    }

    public void setMinScore(double minScore) {
        this.minScore = minScore;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getPolitics() {
        return politics;
    }

    public void setPolitics(double politics) {
        this.politics = politics;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getBiology() {
        return biology;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getMusic() {
        return music;
    }

    public void setMusic(double music) {
        this.music = music;
    }

    public double getArts() {
        return arts;
    }

    public void setArts(double arts) {
        this.arts = arts;
    }

    public double getSports() {
        return sports;
    }

    public void setSports(double sports) {
        this.sports = sports;
    }
}
