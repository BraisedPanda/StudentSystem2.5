package com.braisedpanda.shirotest.bean;

import java.io.Serializable;
import java.util.List;

public class ClassGrades implements Serializable{
    private String classGradesId;      //classGradesId
    private String classGradesCardId; //根据classGradesCardId，作为查找入口
    private double totalAve;             //各项班级总分、平均分、最低分、最高分
    private double totalMax;
    private double totalMin;
    private double chineseMax;
    private double chineseMin;
    private double chineseAve;
    private double mathematicsMin;
    private double mathematicsMax;
    private double mathematicsAve;
    private double englishMax;
    private double englishMin;
    private double englishAve;
    private double politicsMin;
    private double politicsMax;
    private double politicsAve;
    private double historyMax;
    private double historyMin;
    private double historyAve;
    private double geographyMin;
    private double geographyAve;
    private double geographyMax;
    private double biologyMax;
    private double biologyMin;
    private double biologyAve;
    private double chemistryMin;
    private double chemistryAve;
    private double chemistryMax;
    private double physicsMin;
    private double physicsAve;
    private double physicsMax;
    private double musicMin;
    private double musicAve;
    private double musicMax;
    private double artsMin;
    private double artsAve;
    private double artsMax;
    private double sportsMin;
    private double sportsMax;
    private double sportsAve;


    public String getclassGradesId() {
        return classGradesId;
    }

    public void setclassGradesId(String classGradesId) {
        this.classGradesId = classGradesId;
    }

    public String getclassGradesCardId() {
        return classGradesCardId;
    }

    public void setclassGradesCardId(String classGradesCardId) {
        this.classGradesCardId = classGradesCardId;
    }

    public double gettotalAve() {
        return totalAve;
    }

    public void settotalAve(double totalAve) {
        this.totalAve = totalAve;
    }

    public double gettotalMax() {
        return totalMax;
    }

    public void settotalMax(double totalMax) {
        this.totalMax = totalMax;
    }

    public double gettotalMin() {
        return totalMin;
    }

    public void settotalMin(double totalMin) {
        this.totalMin = totalMin;
    }

    public double getchineseMax() {
        return chineseMax;
    }

    public void setchineseMax(double chineseMax) {
        this.chineseMax = chineseMax;
    }

    public double getchineseMin() {
        return chineseMin;
    }

    public void setchineseMin(double chineseMin) {
        this.chineseMin = chineseMin;
    }

    public double getchineseAve() {
        return chineseAve;
    }

    public void setchineseAve(double chineseAve) {
        this.chineseAve = chineseAve;
    }

    public double getmathematicsMin() {
        return mathematicsMin;
    }

    public void setmathematicsMin(double mathematicsMin) {
        this.mathematicsMin = mathematicsMin;
    }

    public double getmathematicsMax() {
        return mathematicsMax;
    }

    public void setmathematicsMax(double mathematicsMax) {
        this.mathematicsMax = mathematicsMax;
    }

    public double getmathematicsAve() {
        return mathematicsAve;
    }

    public void setmathematicsAve(double mathematicsAve) {
        this.mathematicsAve = mathematicsAve;
    }

    public double getenglishMax() {
        return englishMax;
    }

    public void setenglishMax(double englishMax) {
        this.englishMax = englishMax;
    }

    public double getenglishMin() {
        return englishMin;
    }

    public void setenglishMin(double englishMin) {
        this.englishMin = englishMin;
    }

    public double getenglishAve() {
        return englishAve;
    }

    public void setenglishAve(double englishAve) {
        this.englishAve = englishAve;
    }

    public double getpoliticsMin() {
        return politicsMin;
    }

    public void setpoliticsMin(double politicsMin) {
        this.politicsMin = politicsMin;
    }

    public double getpoliticsMax() {
        return politicsMax;
    }

    public void setpoliticsMax(double politicsMax) {
        this.politicsMax = politicsMax;
    }

    public double getpoliticsAve() {
        return politicsAve;
    }

    public void setpoliticsAve(double politicsAve) {
        this.politicsAve = politicsAve;
    }

    public double gethistoryMax() {
        return historyMax;
    }

    public void sethistoryMax(double historyMax) {
        this.historyMax = historyMax;
    }

    public double gethistoryMin() {
        return historyMin;
    }

    public void sethistoryMin(double historyMin) {
        this.historyMin = historyMin;
    }

    public double gethistoryAve() {
        return historyAve;
    }

    public void sethistoryAve(double historyAve) {
        this.historyAve = historyAve;
    }

    public double getgeographyMin() {
        return geographyMin;
    }

    public void setgeographyMin(double geographyMin) {
        this.geographyMin = geographyMin;
    }

    public double getgeographyAve() {
        return geographyAve;
    }

    public void setgeographyAve(double geographyAve) {
        this.geographyAve = geographyAve;
    }

    public double getgeographyMax() {
        return geographyMax;
    }

    public void setgeographyMax(double geographyMax) {
        this.geographyMax = geographyMax;
    }

    public double getbiologyMax() {
        return biologyMax;
    }

    public void setbiologyMax(double biologyMax) {
        this.biologyMax = biologyMax;
    }

    public double getbiologyMin() {
        return biologyMin;
    }

    public void setbiologyMin(double biologyMin) {
        this.biologyMin = biologyMin;
    }

    public double getbiologyAve() {
        return biologyAve;
    }

    public void setbiologyAve(double biologyAve) {
        this.biologyAve = biologyAve;
    }

    public double getchemistryMin() {
        return chemistryMin;
    }

    public void setchemistryMin(double chemistryMin) {
        this.chemistryMin = chemistryMin;
    }

    public double getchemistryAve() {
        return chemistryAve;
    }

    public void setchemistryAve(double chemistryAve) {
        this.chemistryAve = chemistryAve;
    }

    public double getchemistryMax() {
        return chemistryMax;
    }

    public void setchemistryMax(double chemistryMax) {
        this.chemistryMax = chemistryMax;
    }

    public double getphysicsMin() {
        return physicsMin;
    }

    public void setphysicsMin(double physicsMin) {
        this.physicsMin = physicsMin;
    }

    public double getphysicsAve() {
        return physicsAve;
    }

    public void setphysicsAve(double physicsAve) {
        this.physicsAve = physicsAve;
    }

    public double getphysicsMax() {
        return physicsMax;
    }

    public void setphysicsMax(double physicsMax) {
        this.physicsMax = physicsMax;
    }

    public double getmusicMin() {
        return musicMin;
    }

    public void setmusicMin(double musicMin) {
        this.musicMin = musicMin;
    }

    public double getmusicAve() {
        return musicAve;
    }

    public void setmusicAve(double musicAve) {
        this.musicAve = musicAve;
    }

    public double getmusicMax() {
        return musicMax;
    }

    public void setmusicMax(double musicMax) {
        this.musicMax = musicMax;
    }

    public double getartsMin() {
        return artsMin;
    }

    public void setartsMin(double artsMin) {
        this.artsMin = artsMin;
    }

    public double getartsAve() {
        return artsAve;
    }

    public void setartsAve(double artsAve) {
        this.artsAve = artsAve;
    }

    public double getartsMax() {
        return artsMax;
    }

    public void setartsMax(double artsMax) {
        this.artsMax = artsMax;
    }

    public double getsportsMin() {
        return sportsMin;
    }

    public void setsportsMin(double sportsMin) {
        this.sportsMin = sportsMin;
    }

    public double getsportsMax() {
        return sportsMax;
    }

    public void setsportsMax(double sportsMax) {
        this.sportsMax = sportsMax;
    }

    public double getsportsAve() {
        return sportsAve;
    }

    public void setsportsAve(double sportsAve) {
        this.sportsAve = sportsAve;
    }

    @Override
    public String toString() {
        return "ClassGrades{" +
                "classGradesId='" + classGradesId + '\'' +
                ", classGradesCardId='" + classGradesCardId + '\'' +
                ", totalAve=" + totalAve +
                ", totalMax=" + totalMax +
                ", totalMin=" + totalMin +
                ", chineseMax=" + chineseMax +
                ", chineseMin=" + chineseMin +
                ", chineseAve=" + chineseAve +
                ", mathematicsMin=" + mathematicsMin +
                ", mathematicsMax=" + mathematicsMax +
                ", mathematicsAve=" + mathematicsAve +
                ", englishMax=" + englishMax +
                ", englishMin=" + englishMin +
                ", englishAve=" + englishAve +
                ", politicsMin=" + politicsMin +
                ", politicsMax=" + politicsMax +
                ", politicsAve=" + politicsAve +
                ", historyMax=" + historyMax +
                ", historyMin=" + historyMin +
                ", historyAve=" + historyAve +
                ", geographyMin=" + geographyMin +
                ", geographyAve=" + geographyAve +
                ", geographyMax=" + geographyMax +
                ", biologyMax=" + biologyMax +
                ", biologyMin=" + biologyMin +
                ", biologyAve=" + biologyAve +
                ", chemistryMin=" + chemistryMin +
                ", chemistryAve=" + chemistryAve +
                ", chemistryMax=" + chemistryMax +
                ", physicsMin=" + physicsMin +
                ", physicsAve=" + physicsAve +
                ", physicsMax=" + physicsMax +
                ", musicMin=" + musicMin +
                ", musicAve=" + musicAve +
                ", musicMax=" + musicMax +
                ", artsMin=" + artsMin +
                ", artsAve=" + artsAve +
                ", artsMax=" + artsMax +
                ", sportsMin=" + sportsMin +
                ", sportsMax=" + sportsMax +
                ", sportsAve=" + sportsAve +
                '}';
    }
}
