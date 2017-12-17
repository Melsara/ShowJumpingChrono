package com.sardegnaisoladicavalli.example.showjumpingchrono;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sardegnaisoladicavalli.example.showjumpingchrono.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;

import static android.view.View.TEXT_ALIGNMENT_CENTER;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;

public class MainActivity extends AppCompatActivity {

    private static final String ROW_1 = "Chrono";
    private static final String ROW_2 = "Course penalties";
    private static final String ROW_3 = "Time penalties";
    private static final String ROW_4 = "Total penalties";


/*    private final String[][] DATA_TO_SHOW = {
            {ROW_1, " ", "0"},
            {ROW_2, " ", "0"},
            {ROW_3, " ", "0"},
            {ROW_4, " ", "0"}
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}