package com.sardegnaisoladicavalli.example.showjumpingchrono;

import android.content.Context;
import android.os.SystemClock;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomChrono mChronometer;
    long timeWhenStopped;
    String timeDisplayed = "00:00:00";
    int coursePens;
    int timePens;
    int totalPens;
    int coursePens2;
    int timePens2;
    int totalPens2;
    int totalTeamPens;
    final int COURSE_PENS = 4;
    final int TIME_PEN = 1;
    final int COURSE_PENS2 = 4;
    final int TIME_PEN2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTimeSet(timeDisplayed);
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();

    }

    public void onClick(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Displays the time.
     * @param timeDisplayed
     */
    public void displayTimeSet (String timeDisplayed) {
        TextView timeView = (TextView) findViewById(R.id.time_set);
        TextView timeView2 = (TextView) findViewById(R.id.time_set2) ;
        timeView.setText(String.valueOf(timeDisplayed));
        timeView2.setText(String.valueOf(timeDisplayed));
    }

    public void displayChrono () {
        mChronometer = (CustomChrono) findViewById(R.id.chronometer);
        mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
    }

    public void startChrono (View view) {
        mChronometer = (CustomChrono) findViewById(R.id.chronometer);
        mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        mChronometer.start();
    }

    public void stopChrono (View view) {
        timeWhenStopped = mChronometer.getBase() - SystemClock.elapsedRealtime();
        mChronometer.stop();
        timeDisplayed = (String) mChronometer.getText();
        displayTimeSet(timeDisplayed);
    }

    public void displayCoursePens (int coursePens){
        TextView courseView = (TextView) findViewById(R.id.course_pens);
        courseView.setText(String.valueOf(coursePens));
    }

    public void displayCoursePens2 (int coursePens){
        TextView courseView2 = (TextView) findViewById(R.id.course_pens2);
        courseView2.setText(String.valueOf(coursePens2));
    }

    public void displayTimePens (int timePens){
        TextView timeViewPens = (TextView) findViewById(R.id.time_pens);
        timeViewPens.setText(String.valueOf(timePens));
    }

    public void displayTimePens2 (int timePens2){
        TextView timeViewPens2 = (TextView) findViewById(R.id.time_pens2);
        timeViewPens2.setText(String.valueOf(timePens2));
    }

    public void displayTotalPens () {
        TextView totalView = (TextView) findViewById(R.id.total_pens);
        totalPens = timePens + coursePens;
        totalView.setText(String.valueOf(totalPens));
    }

    public void displayTotalPens2 () {
        TextView totalView2 = (TextView) findViewById(R.id.total_pens2);
        totalPens2 = timePens2 + coursePens2;
        totalView2.setText(String.valueOf(totalPens2));
    }

    public void displayTeamPens (){
        TextView teamPens = (TextView) findViewById(R.id.total_TeamPens);
        totalTeamPens = totalPens + totalPens2;
        teamPens.setText(String.valueOf(totalTeamPens));
    }

    public void addCoursePens (View view) {
        coursePens = coursePens + COURSE_PENS;
        displayCoursePens(coursePens);
        displayTotalPens();
        displayTeamPens();

    }

    public void addCoursePens2 (View view) {
        coursePens2 = coursePens2 + COURSE_PENS2;
        displayCoursePens2(coursePens2);
        displayTotalPens2();
        displayTeamPens();

    }

    public void addTimePens (View view) {
        timePens = timePens + TIME_PEN;
        displayTimePens(timePens);
        displayTotalPens();
        displayTeamPens();

    }

    public void addTimePens2 (View view) {
        timePens2 = timePens2 + TIME_PEN2;
        displayTimePens2(timePens2);
        displayTotalPens2();
        displayTeamPens();

    }

    public void resetAll (View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        timeDisplayed = "00:00:00";
        coursePens = 0;
        timePens = 0;
        totalPens = 0;
        coursePens2 = 0;
        timePens2 = 0;
        totalPens2 = 0;
        totalTeamPens = 0;
        displayTimeSet(timeDisplayed);
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("timeWhenStopped", timeWhenStopped);
        savedInstanceState.putString("timeDisplayed", timeDisplayed);
        savedInstanceState.putInt("coursePens", coursePens);
        savedInstanceState.putInt("timePens", timePens);
        savedInstanceState.putInt("totalPens", totalPens);
        savedInstanceState.putInt("coursePens2", coursePens2);
        savedInstanceState.putInt("timePens2", timePens2);
        savedInstanceState.putInt("totalPens2", totalPens2);
        savedInstanceState.putInt("totalTeamPens", totalTeamPens);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        timeWhenStopped  = (long) savedInstanceState.getLong("timeWhenStopped");
        timeDisplayed = savedInstanceState.getString("timeDisplayed");
        coursePens = savedInstanceState.getInt("coursePens");
        timePens = savedInstanceState.getInt("timePens");
        totalPens = savedInstanceState.getInt("totalPens");
        coursePens2 = savedInstanceState.getInt("coursePens2");
        timePens2 = savedInstanceState.getInt("timePens2");
        totalPens2 = savedInstanceState.getInt("totalPens2");
        totalTeamPens = savedInstanceState.getInt("totalTeamPens");
        displayTimeSet(timeDisplayed);
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();
        displayChrono();
    }


}