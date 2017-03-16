package com.keye.keyevolly.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-01-19.
 */
public class GameResult {

    public GameResult() {
    }

    private int idGameReult;
    private String GameId;

    /**
     * 平均正确率  正确数/总个数
     */
    private float AverageAccuracy;

    
    private String PatientId;
    
    private int HardLevel;

    private int ForceLevel;

    private int HandType;

    private float SetTime;

    private int Score;

    private float CompleteTime;

    private int Percentage;

    private double CorrectlyNum;

    private double AverageReaction;

    private String CreatUser;

    private Date CreatTime;

    private String Remarks;


    private boolean isUpdata;

    public boolean isUpdata() {
        return isUpdata;
    }

    public void setUpdata(boolean updata) {
        isUpdata = updata;
    }

    public int getIdGameReult() {
        return idGameReult;
    }

    public void setIdGameReult(int idGameReult) {
        this.idGameReult = idGameReult;
    }

    public String getGameId() {
        return GameId;
    }

    public void setGameId(String gameId) {
        GameId = gameId;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }

    public int getHardLevel() {
        return HardLevel;
    }

    public void setHardLevel(int hardLevel) {
        HardLevel = hardLevel;
    }

    public int getForceLevel() {
        return ForceLevel;
    }

    public float getAverageAccuracy() {
        return AverageAccuracy;
    }

    public void setAverageAccuracy(float averageAccuracy) {
        AverageAccuracy = averageAccuracy;
    }

    public void setForceLevel(int forceLevel) {
        ForceLevel = forceLevel;
    }

    public int getHandType() {
        return HandType;
    }

    public void setHandType(int handType) {
        HandType = handType;
    }

    public float getSetTime() {
        return SetTime;
    }

    public void setSetTime(float setTime) {
        SetTime = setTime;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public float getCompleteTime() {
        return CompleteTime;
    }

    public void setCompleteTime(float completeTime) {
        CompleteTime = completeTime;
    }

    public int getPercentage() {
        return Percentage;
    }

    public void setPercentage(int percentage) {
        Percentage = percentage;
    }

    public double getCorrectlyNum() {
        return CorrectlyNum;
    }

    public void setCorrectlyNum(double correctlyNum) {
        CorrectlyNum = correctlyNum;
    }

    public double getAverageReaction() {
        return AverageReaction;
    }

    public void setAverageReaction(double averageReaction) {
        AverageReaction = averageReaction;
    }

    public String getCreatUser() {
        return CreatUser;
    }

    public void setCreatUser(String creatUser) {
        CreatUser = creatUser;
    }

    public Date getCreatTime() {
        return CreatTime;
    }

    public void setCreatTime(Date creatTime) {
        CreatTime = creatTime;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "idGameReult=" + idGameReult +
                ", GameId='" + GameId + '\'' +
                ", PatientId='" + PatientId + '\'' +
                ", HardLevel=" + HardLevel +
                ", ForceLevel=" + ForceLevel +
                ", HandType=" + HandType +
                ", SetTime=" + SetTime +
                ", Score=" + Score +
                ", CompleteTime='" + CompleteTime + '\'' +
                ", Percentage=" + Percentage +
                ", CorrectlyNum=" + CorrectlyNum +
                ", AverageReaction=" + AverageReaction +
                ", CreatUser='" + CreatUser + '\'' +
                ", CreatTime='" + CreatTime + '\'' +
                ", Remarks='" + Remarks + '\'' +
                '}';
    }
}
