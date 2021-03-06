package com.example.game.utilities;

import android.graphics.Color;

import java.io.Serializable;

public class Player implements Serializable {

  private String firstName, lastName, username, password, currentDisplayNameChoice, difficulty;
  private int totalScore, highScore, totalRoundsPlayed, currentRoundProgress,
          currentRoundScore, gameDashboardBackgroundColor, currentGameScore;
  private int[] easyTimes, mediumTimes, hardTimes, timeChoice;

  Player(String firstName, String lastName, String username, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.currentDisplayNameChoice = "USERNAME";
    this.difficulty = "EASY";
    this.totalScore = 0;
    this.highScore = 0;
    this.totalRoundsPlayed = 0;
    this.currentRoundProgress = 0;
    this.currentRoundScore = 0;
    this.gameDashboardBackgroundColor = Color.WHITE;
    this.currentGameScore = 0;
    this.easyTimes = new int[]{30000, 120000, 150000};
    this.mediumTimes = new int[]{60000, 60000, 120000};
    this.hardTimes = new int[]{80000, 30000, 80000};
    this.timeChoice = easyTimes;
  }

  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) {this.firstName = firstName; }

  public String getLastName() { return lastName; }
  public void setLastName(String lastName) {this.lastName = lastName; }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  String getCurrentDisplayNameChoice() { return this.currentDisplayNameChoice; }
  void setCurrentDisplayNameChoice(String newCurrentDisplayNameChoice) { this.currentDisplayNameChoice = newCurrentDisplayNameChoice; }

  String getDifficulty() { return this.difficulty; }
  void setDifficulty(String difficulty) { this.difficulty = difficulty; }

  public int getTotalScore() {
    return totalScore;
  }
  void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public int getHighScore() {
    return highScore;
  }
  void setHighScore(int highScore) {
    this.highScore = highScore;
  }

  public int getTotalRoundsPlayed() {
    return totalRoundsPlayed;
  }
  void setTotalRoundsPlayed(int roundPlayed) {
    this.totalRoundsPlayed = roundPlayed;
  }

  public int getCurrentRoundProgress() {
    return currentRoundProgress;
  }
  public void setCurrentRoundProgress(int currentGameRounds) { this.currentRoundProgress = currentGameRounds; }

  public int getCurrentRoundScore() {
    return currentRoundScore;
  }
  public void setCurrentRoundScore(int currentRoundScore) { this.currentRoundScore = currentRoundScore; }

  public int getGameDashboardBackgroundColor() { return this.gameDashboardBackgroundColor; }
  void setGameDashboardBackgroundColor(int newGameDashboardBackgroundColor) {
    this.gameDashboardBackgroundColor = newGameDashboardBackgroundColor;
  }

  public int getCurrentGameScore() { return this.currentGameScore; }
  public void setCurrentGameScore(int currentGameScore) { this.currentGameScore = currentGameScore; }

  public int[] getTimeChoice() { return this.timeChoice; }
  void setTimeChoice(int[] timeChoice) { this.timeChoice = timeChoice; }

  int[] getEasyTimes() { return this.easyTimes; }
  public void setEasyTimes(int[] easyTimes) { this.easyTimes = easyTimes; }

  int[] getMediumTimes() { return this.mediumTimes; }
  public void setMediumTimes(int[] mediumTimes) { this.mediumTimes = mediumTimes; }

  int[] getHardTimes() { return this.hardTimes; }
  public void setHardTimes(int[] hardTimes) { this.hardTimes = hardTimes; }

}
