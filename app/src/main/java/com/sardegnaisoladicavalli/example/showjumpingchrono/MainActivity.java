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
    String timeDisplayed;
    String riderNsme;
    String horseNsme;
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
        riderInputLayout.setHint("Rider name");
        horseInputLayout.setHint("Horse name");
         mChronometer = (CustomChrono) findViewById(R.id.chronometer);

    }

    public void getRiderName (View view) {
        EditText simpleEditText = (EditText) findViewById(R.id.rider_name);
        riderNsme = simpleEditText.getText().toString();
    }

    public void getHorseName (View view) {
        EditText simpleEditText = (EditText) findViewById(R.id.horse_name);
        horseNsme = simpleEditText.getText().toString();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putLong("timeWhenStopped", timeWhenStopped);
        savedInstanceState.putString("timeDisplayed", timeDisplayed);
        savedInstanceState.putString("riderName", riderNsme);
        savedInstanceState.putString("horseName", horseNsme);
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

    public void displayTotalPens (int totalPens){
        TextView totalView = (TextView) findViewById(R.id.total_pens);
        totalPens = timePens + coursePens;
        totalView.setText(String.valueOf(totalPens));
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
        displayTimeSet(timeDisplayed);
        displayCoursePens(coursePens);
        displayTimePens(timePens);
        displayTotalPens(totalPens);

    }


}


        /*I HAVE DONE MANY TRIALS - UNUSED BIT OF CODE

            private final String[][] DATA_TO_SHOW = {
            {ROW_1, " ", "0"},
            {ROW_2, " ", "0"},
            {ROW_3, " ", "0"},
            {ROW_4, " ", "0"}
    };

    private static final String ROW_1 = "Chrono";
    private static final String ROW_2 = "Course penalties";
    private static final String ROW_3 = "Time penalties";
    private static final String ROW_4 = "Total penalties";


        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
                mChronometer.start();
            }
            });

        stop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
                mChronometer.stop();
            }
        });*/




/*        TableView<String[]> tableRows = (TableView<String[]>) findViewById(R.id.result_table);
        TableColumnWeightModel columnModel = new TableColumnWeightModel(3);
        columnModel.setColumnWeight(1, 3);
        columnModel.setColumnWeight(2, 1);
        columnModel.setColumnWeight(3, 1);
        tableRows.setColumnCount(3);
        tableRows.setHeaderVisible(false);
        tableRows.setColumnModel(columnModel);
        tableRows.setDataAdapter(new SimpleTableDataAdapter(this, DATA_TO_SHOW));
        if (Build.VERSION.SDK_INT >= 17) {
            tableRows.setTextAlignment(TEXT_ALIGNMENT_TEXT_END);
        }*/