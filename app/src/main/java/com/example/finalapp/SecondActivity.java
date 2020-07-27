package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class SecondActivity extends AppCompatActivity {

    NumberPicker numberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);

        String[] numberPickerStrings={
                "Easy",
                "Medium",
                "Hard"
        };
        numberPicker.setDisplayedValues(numberPickerStrings);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(numberPickerStrings.length-1);
    }

    public void navigate(View view) {
        int choice = numberPicker.getValue();
        Intent goToActivity =new Intent();
        if(choice==0){
            goToActivity.setClass(this,EasyActivity.class);
            startActivity(goToActivity);
        }
        else if(choice==1){
            goToActivity.setClass(this,MediumActivity.class);
            startActivity(goToActivity);
        }
        else if(choice==2){
            goToActivity.setClass(this,HardActivity.class);
            startActivity(goToActivity);
        }
    }
}