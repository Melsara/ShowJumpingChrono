package com.sardegnaisoladicavalli.example.showjumpingchrono;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomChrono mChronometer;
    long timeWhenStopped = 0;
    String timeDisplayed;
    int coursePens = 0;
    int timePens = 0;
    int totalPens = 0;
    final int COURSE_PENS = 4;
    final int TIME_PEN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mChronometer = (CustomChrono) findViewById(R.id.chronometer);


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