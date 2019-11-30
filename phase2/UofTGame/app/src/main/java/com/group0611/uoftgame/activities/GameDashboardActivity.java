package com.group0611.uoftgame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.group0611.uoftgame.R;

import com.group0611.uoftgame.utilities.AppManager;

public class GameDashboardActivity extends AppCompatActivity {

  AppManager appManager;
  Intent intentGameDashboard;
  ImageButton imageButtonSettings, imageButtonCardGame, imageButtonSubwayGame, imageButtonBallGame;
  TextView textViewTotalRoundsPlayed, textViewTotalScore, textViewDisplayName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    intentGameDashboard = getIntent();
    this.appManager = (AppManager) intentGameDashboard.getSerializableExtra("appManager");
    setContentView(R.layout.activity_game_dashboard);

    getWindow().getDecorView().setBackgroundColor(appManager.getMainPlayer().getGameDashboardBackgroundColor());

    imageButtonCardGame = findViewById(R.id.cardGameButton);
    imageButtonSubwayGame = findViewById(R.id.subwayGameButton);
    imageButtonBallGame = findViewById(R.id.ballGameButton);

    textViewTotalRoundsPlayed = findViewById(R.id.totalRoundsPlayedStat);
    textViewTotalScore = findViewById(R.id.totalScoreStat);
    textViewDisplayName = findViewById(R.id.displayNameTextLabel);
    imageButtonSettings = findViewById(R.id.gameDashboardSettingsButton);

    // all buttons onClickListener declarations
    imageButtonCardGame.setOnClickListener(
            new View.OnClickListener() {
              public void onClick(View v) {
                Intent gameDashboardToCardGameIntent = new Intent(GameDashboardActivity.this, CardGameActivity.class);
                gameDashboardToCardGameIntent.putExtra("appManager", appManager);
                startActivity(gameDashboardToCardGameIntent);
              }
            });

    imageButtonSubwayGame.setOnClickListener(
            new View.OnClickListener() {
              public void onClick(View v) {
                Intent gameDashboardToSubwayGameIntent = new Intent(GameDashboardActivity.this, SubwayGameActivity.class);
                gameDashboardToSubwayGameIntent.putExtra("appManager", appManager);
                startActivity(gameDashboardToSubwayGameIntent);
              }
            });

    imageButtonBallGame.setOnClickListener(
            new View.OnClickListener() {
              public void onClick(View v) {
                Intent gameDashboardToBallGameIntent = new Intent(GameDashboardActivity.this, BallGameActivity.class);
                gameDashboardToBallGameIntent.putExtra("appManager", appManager);
                startActivity(gameDashboardToBallGameIntent);
              }
            });

    imageButtonSettings.setOnClickListener(
            new View.OnClickListener() {
              public void onClick(View v) {
                Intent gameDashboardToSettings = new Intent(GameDashboardActivity.this, SettingsActivity.class);
                gameDashboardToSettings.putExtra("appManager", appManager);
                startActivity(gameDashboardToSettings);
              }
            });

    // sets visible text fields based on logged in player
    textViewTotalRoundsPlayed.setText(
            String.valueOf(appManager.getMainPlayer().getTotalRoundsPlayed()));
    textViewTotalScore.setText(String.valueOf(appManager.getMainPlayer().getTotalScore()));

    if (appManager.getMainPlayerDisplayName().equals("USERNAME")){
      textViewDisplayName.setText(String.valueOf(appManager.getMainPlayer().getUsername()));
    } else if (appManager.getMainPlayerDisplayName().equals("FIRST NAME")){
      textViewDisplayName.setText(String.valueOf(appManager.getMainPlayer().getFirstName()));
    } else if (appManager.getMainPlayerDisplayName().equals("LAST NAME")){
      textViewDisplayName.setText(String.valueOf(appManager.getMainPlayer().getLastName()));
    }
  }
}
