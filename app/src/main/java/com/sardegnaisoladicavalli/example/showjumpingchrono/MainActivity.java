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
    long timeWhenStopped = 0;
    String timeDisplayed = "00:00:00";
    String riderName;
    String horseName;
    int coursePens = 0;
    int timePens = 0;
    int totalPens = 0;
    final int COURSE_PENS = 4;
    final int TIME_PEN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputLayout riderInputLayout = (TextInputLayout) findViewById(R.id.rider_name_text_input_layout);
        final TextInputLayout horseInputLayout = (TextInputLayout) findViewById(R.id.horse_name_text_input_layout);
         mChronometer = (CustomChrono) findViewById(R.id.chronometer);

    }

    public void getRiderName (View view) {
        EditText simpleEditText = (EditText) findViewById(R.id.rider_name);
        riderName = simpleEditText.getText().toString();
    }

    public void getHorseName (View view) {
        EditText simpleEditText = (EditText) findViewById(R.id.horse_name);
        horseName = simpleEditText.getText().toString();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putLong("timeWhenStopped", timeWhenStopped);
        savedInstanceState.putString("timeDisplayed", timeDisplayed);
        savedInstanceState.putString("riderName", riderName);
        savedInstanceState.putString("horseName", horseName);
        savedInstanceState.putInt("coursePens", coursePens);
        savedInstanceState.putInt("timePens", timePens);
        savedInstanceState.putInt("totalPens", totalPens);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        long timeWhenStopped  = (long) savedInstanceState.getLong("timeWhenStopped");
        String timeDisplayed = savedInstanceState.getString("timeDisplayed");
        String riderName= savedInstanceState.getString("riderName");
        String horseName = savedInstanceState.getString("horseName");
        int  coursePens = savedInstanceState.getInt("coursePens");
        int  timePens = savedInstanceState.getInt("timePens");
        int  totalPens = savedInstanceState.getInt("totalPens");
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
        timeView.setText(String.valueOf(timeDisplayed));
    }

    public void startChrono (View view) {
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

    public void displayTimePens (int timePens){
        TextView timeView = (TextView) findViewById(R.id.time_pens);
        timeView.setText(String.valueOf(timePens));
    }

    public void displayTotalPens (int totalPens) {
        TextView totalView = (TextView) findViewById(R.id.total_pens);
        totalPens = timePens + coursePens;
        totalView.setText(String.valueOf(totalPens));
    }

    public void displayRiderName (String riderName){
        TextView timeView = (TextView) findViewById(R.id.rider_name);
        timeView.setText(String.valueOf(riderName));
    }

    public void displayHorseName (String horseName){
        TextView timeView = (TextView) findViewById(R.id.horse_name);
        timeView.setText(String.valueOf(horseName));
    }

    public void addCoursePens (View view) {
        coursePens = coursePens + COURSE_PENS;
        displayCoursePens(coursePens);
        displayTotalPens(totalPens);

    }

    public void addTimePens (View view) {
        timePens = timePens + TIME_PEN;
        displayTimePens(timePens);
        displayTotalPens(totalPens);

    }

    public void resetAll (View view) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
        timeDisplayed = "00:00:00";
        coursePens = 0;
        timePens = 0;
        totalPens = 0;
        riderName = " ";
        horseName = " ";
        displayTimeSet(timeDisplayed);
        displayCoursePens(coursePens);
        displayTimePens(timePens);
        displayTotalPens(totalPens);
        displayRiderName(riderName);
        displayHorseName(horseName);
    }


}