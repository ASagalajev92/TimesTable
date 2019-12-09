package com.devhuba.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListViewAnswer;
    private ListView mListViewMultiplier1;
    private ListView mListViewMultiplier2;
    private ListView mListViewMultiplierSymbol;
    private ListView mListViewEquals;
    private SeekBar mSeekBar;

    private ArrayList<Integer> nAnswers;
    private ArrayList<Integer> nMultiplier1;
    private ArrayList<Integer> nMultiplier2;
    private ArrayList<String> nMultiplierSymbol;
    private ArrayList<String> nEquals;

    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewAnswer = findViewById(R.id.listViewAnswers);
        mListViewMultiplier1 = findViewById(R.id.listViewMultiplier1);
        mListViewMultiplier2 = findViewById(R.id.listViewMultiplier2);
        mListViewMultiplierSymbol = findViewById(R.id.listViewMultiplierSymbol);
        mListViewEquals = findViewById(R.id.listViewEquals);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setMax(max);
        nAnswers = new ArrayList<>();
        nMultiplier1 = new ArrayList<>();
        nMultiplier2 = new ArrayList<>();
        nMultiplierSymbol = new ArrayList<>();
        nEquals = new ArrayList<>();

        final ArrayAdapter<Integer> arrayFirstMAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nMultiplier1);
        mListViewMultiplier1.setAdapter(arrayFirstMAdapter);
        final ArrayAdapter<Integer> arraySecondMAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nMultiplier2);
        mListViewMultiplier2.setAdapter(arraySecondMAdapter);
        final ArrayAdapter<Integer> arrayAnswerAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nAnswers);
        mListViewAnswer.setAdapter(arrayAnswerAdapter);
        final ArrayAdapter<String> arrayMultiplierSymbol = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nMultiplierSymbol);
        mListViewMultiplierSymbol.setAdapter(arrayMultiplierSymbol);
        final ArrayAdapter<String> arrayEquals = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nEquals);
        mListViewEquals.setAdapter(arrayEquals);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nAnswers.clear();
                nMultiplier2.clear();
                nMultiplier1.clear();
                nMultiplierSymbol.clear();
                nEquals.clear();
                if (progress < min) {
                    seekBar.setProgress(min);
                }
                for (int i = min; i <= count; i++) {
                    String plus = "+";
                    String equals = "=";

                    nAnswers.add(progress * i);
                    //nMultiplier2.add(progress * i);
                    nMultiplier1.add(i);
                    nMultiplier2.add(progress);
                    nMultiplierSymbol.add("*");
                    nEquals.add("=");
                }

                arrayAnswerAdapter.notifyDataSetChanged();
                arraySecondMAdapter.notifyDataSetChanged();
                arrayFirstMAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar.setProgress(13);
    }
}
