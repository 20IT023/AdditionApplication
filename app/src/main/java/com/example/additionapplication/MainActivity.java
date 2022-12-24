package com.example.additionapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText num1, num2;
    private Button sum;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        sum=(Button) findViewById(R.id.sum);
        answer=(TextView) findViewById(R.id.showsum);

        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String value1=num1.getText().toString();
                String value2=num2.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int sum = a+b;
                answer.setText(Integer.toString(sum));
                Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_LONG).show();
            }
        });
    }
    }


