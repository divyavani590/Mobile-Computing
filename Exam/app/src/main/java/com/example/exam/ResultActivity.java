package com.example.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    /**
     * @param savedInstanceState
     * onCreate method is the default method when Activity is created
     * the main logic get started from here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        Float valueReceived1 = bundle .getFloat("A");
        Float valueReceived2 = bundle .getFloat("B");
        Float valueReceived3 = bundle .getFloat("C");
        Float valueReceived4 = bundle .getFloat("D");
        Float valueReceived5 = bundle .getFloat("F");

        chart = (BarChart) findViewById(R.id.chart);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Percentages");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

        BARDATA.setValueTextSize(20);

        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();
        XAxis topAxis = chart.getXAxis();
        leftAxis.setAxisMinValue(0f);
        leftAxis.setAxisMaxValue(100f);
        leftAxis.setAxisLineColor(000);
        leftAxis.setTextSize(15);
        rightAxis.setAxisMinValue(0f);
        rightAxis.setAxisMaxValue(100f);
        rightAxis.setGranularityEnabled(true);
        rightAxis.setGranularity(10f);
        rightAxis.setTextSize(15);
        topAxis.setTextSize(15);

    }

    /**
     * Plotting the bar values into the chart
     */
    public void AddValuesToBARENTRY(){

        Bundle bundle = getIntent().getExtras();
        Float valueReceived1 = bundle .getFloat("A");
        Float valueReceived2 = bundle .getFloat("B");
        Float valueReceived3 = bundle .getFloat("C");
        Float valueReceived4 = bundle .getFloat("D");
        Float valueReceived5 = bundle .getFloat("F");

        BARENTRY.add(new BarEntry(valueReceived1, 0));
        BARENTRY.add(new BarEntry(valueReceived2, 1));
        BARENTRY.add(new BarEntry(valueReceived3, 2));
        BARENTRY.add(new BarEntry(valueReceived4, 3));
        BARENTRY.add(new BarEntry(valueReceived5, 4));
    }

    /**
     * labelling different grade percentages
     */
    public void AddValuesToBarEntryLabels(){
        BarEntryLabels.add("A%");
        BarEntryLabels.add("B%");
        BarEntryLabels.add("C%");
        BarEntryLabels.add("D%");
        BarEntryLabels.add("F%");
    }
}