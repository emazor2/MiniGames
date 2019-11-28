package com.group0611.uoftgame.activities;

import android.content.Intent;

import com.group0611.uoftgame.utilities.AppManager;

public interface GameActivity {
  Intent getCurrentIntent();

  Intent getToResultsPageIntent();

  Intent getToDashboardIntent();

  void leaveGame(AppManager manager);
}
