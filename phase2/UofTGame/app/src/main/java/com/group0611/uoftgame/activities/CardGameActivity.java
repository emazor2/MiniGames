package com.group0611.uoftgame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.group0611.uoftgame.R;
import com.group0611.uoftgame.games.Game;
import com.group0611.uoftgame.games.cardgame.CardGame;
import com.group0611.uoftgame.utilities.AppManager;

import java.util.ArrayList;

public class CardGameActivity extends AppCompatActivity implements GameActivity {
  AppManager appManager;
  private Intent currentIntent;
  private Intent toResultsPageIntent;
  private Intent toDashBoardIntent;
  // Structure of memory game loosely adapted from
  // https://stackoverflow.com/questions/51002449/developing-a-memory-game
  public ArrayList<ImageView> buttons = new ArrayList<>();
  public TextView score;
  TextView time;
  CardGame cardGame;
  public int cardWidth = 4;
  public int cardHeight = 3;

  @Override
  public Intent getCurrentIntent() {
    return currentIntent;
  }

  private void setCurrentIntent(Intent currentIntent) {
    this.currentIntent = currentIntent;
  }

  @Override
  public Intent getToResultsPageIntent() {
    return toResultsPageIntent;
  }

  private void setToResultsPageIntent(Intent toResultsPageIntent) {
    this.toResultsPageIntent = toResultsPageIntent;
  }

  @Override
  public Intent getToDashboardIntent() {
    return toDashBoardIntent;
  }

  /**
   * Constructor method which overrides the onCreate method. Sets the score and time. Adds the
   * buttons and sets the as Clickable. Source:
   * https://developer.android.com/reference/android/widget/Button
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setCurrentIntent(getIntent());
    AppManager appManager = (AppManager) getCurrentIntent().getSerializableExtra("appManager");
    setContentView(R.layout.activity_card_game);
    score = findViewById(R.id.score);
    time = findViewById(R.id.time);
    time.setText(String.valueOf(0));
    addButtons();
    // cardGame = new CardGame(60, appManager, this);
    int timeLimit = appManager.getCurrentPlayer().getTimeChoice()[1];
    cardGame =
        (CardGame)
            new Game.GameBuilder(CardGame.class, appManager, this)
                .addTimedGameMode(true)
                .setTimeLimit(timeLimit)
                .build()
                .getGame();
    addButtonOnClick();
  }

  /** Add all the buttons to an array so that they can be iterated through. */
  public void addButtons() {
    // Adds all the images to an array so they can be iterated through.
    // Source: https://stackoverflow.com/questions/15112742/how-to-set-an-imageview-array
    buttons.add((ImageView) findViewById(R.id.card_11));
    buttons.add((ImageView) findViewById(R.id.card_12));
    buttons.add((ImageView) findViewById(R.id.card_13));
    buttons.add((ImageView) findViewById(R.id.card_14));
    buttons.add((ImageView) findViewById(R.id.card_21));
    buttons.add((ImageView) findViewById(R.id.card_22));
    buttons.add((ImageView) findViewById(R.id.card_23));
    buttons.add((ImageView) findViewById(R.id.card_24));
    buttons.add((ImageView) findViewById(R.id.card_31));
    buttons.add((ImageView) findViewById(R.id.card_32));
    buttons.add((ImageView) findViewById(R.id.card_33));
    buttons.add((ImageView) findViewById(R.id.card_34));
  }

  /**
   * For each button in the array, set an indexing tag and turn on the Click Listener. Once the
   * Click Listener has been turned out, call the flip method and the accompanying sound.
   */
  public void addButtonOnClick() {
    // for each card button, set an indexing tag and turn on the Click Listener
    for (int i = 0; i < buttons.size(); i++) {
      buttons.get(i).setTag(i);
      buttons
          .get(i)
          .setOnClickListener(
              new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  System.out.println(v);
                  cardGame.flip((int) v.getTag(), (ImageView) v);
                  flipSound();
                }
              });
    }
  }

  /**
   * Sets the Textview time as the parameter timeLeftText. This is called on by the equivalent
   * method in CardGame.
   *
   * @param timeLeftText A string input of the time left in the game.
   */
  public void setTime(String timeLeftText) {
    // sends amount of time left to display
    time.setText(timeLeftText);
  }

  /**
   * WRITE THIS!
   *
   * @param appManager The app Manager
   */
  public void leaveGame(AppManager appManager) {
    // uses class objects to go to end screen at time end
    setToResultsPageIntent(new Intent(CardGameActivity.this, ResultsPageActivity.class));
    getToResultsPageIntent().putExtra("appManager", appManager);
    startActivity(getToResultsPageIntent());
  }

  /**
   * Using the MediaPlayer calls the 'card_flip' sound effect that is stored in the raw res files.
   * Source: https://freesound.org/people/f4ngy/sounds/240776/
   */
  public void flipSound() {
    MediaPlayer cardflip = MediaPlayer.create(this, R.raw.card_flip);
    cardflip.start();
  }
  /**
   * Using the MediaPlayer calls the 'correct' sound effect that is stored in the raw res files.
   * Source: https://freesound.org/people/LittleRainySeasons/sounds/335908/
   */
  public void correctSound() {
    MediaPlayer correct = MediaPlayer.create(this, R.raw.correct);
    correct.start();
  }

  // TODO: Diego implement this in all other games
  @Override
  public void onBackPressed() {
    cardGame.getCardGameTimer().cancel();
    finish();
  }
}
