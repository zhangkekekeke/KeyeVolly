package com.keye.keyevolly.bean;


import java.util.List;

/**
 * Created by Administrator on 2017-02-08.
 */

public class UpdataResults  {
    private List<GameResult> gameResults;
    private String PatientId;

    public UpdataResults(String patientId, List<GameResult> gameResults) {
        PatientId = patientId;
        this.gameResults = gameResults;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public void setGameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }
}
