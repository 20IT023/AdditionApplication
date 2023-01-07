package com.example.additionapplication;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    public static final String[] languages = {"Select language","English","Hindi",
            "French","Arabic"};
    private EditText num1, num2;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.action_bar_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = parent.getItemAtPosition(position).toString();
                if(selectedLang.equals("English")){
                    setLocal(MainActivity.this,"en");
                    finish();
                    startActivity(getIntent());

                }else if(selectedLang.equals("Hindi")){
                    setLocal(MainActivity.this,"hi");
                    finish();
                    startActivity(getIntent());

                }else if (selectedLang.equals("French")){
                    setLocal(MainActivity.this,"fr");
                    finish();
                    startActivity(getIntent());
                }else if((selectedLang.equals("Arabic"))){
                    setLocal(MainActivity.this,"ar");
                    finish();
                    startActivity(getIntent());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

               addListenerOnButton();

    }
    public void setLocal(Activity activity,String langCode){
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resource = activity.getResources();
        Configuration config = resource.getConfiguration();
        DisplayMetrics dm = resource.getDisplayMetrics();
        config.locale = locale;
        resource.updateConfiguration(config,dm);

    }

    @SuppressLint("SetTextI18n")
    public void addListenerOnButton(){
        num1= findViewById(R.id.num1);
        num2= findViewById(R.id.num2);
        Button sum =  findViewById(R.id.sum);
        answer= findViewById(R.id.showsum);

        sum.setOnClickListener(v -> {
            String value1=num1.getText().toString();
            String value2=num2.getText().toString();
            int a = Integer.parseInt(value1);
            int b = Integer.parseInt(value2);
            int sum1 = a+b;
            answer.setText(Integer.toString(sum1));
            Toast.makeText(getApplicationContext(), String.valueOf(sum1), Toast.LENGTH_LONG).show();
        });
    }
    }


