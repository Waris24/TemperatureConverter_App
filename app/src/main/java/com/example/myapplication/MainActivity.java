package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editTextCelsius;
    private EditText editTextFahrenheit;
    private Button buttonConvertToCelsius;
    private Button buttonConvertToFahrenheit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonConvertToCelsius = findViewById(R.id.buttonConvertToCelsius);
        buttonConvertToFahrenheit = findViewById(R.id.buttonConvertToFahrenheit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });

        buttonConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });
    }

    private void convertToFahrenheit() {
        String inputTemperature = editTextCelsius.getText().toString().trim();
        if (!inputTemperature.isEmpty()) {
            double celsius = Double.parseDouble(inputTemperature);
            double fahrenheit = celsiusToFahrenheit(celsius);
            String result = String.format("%.2f°F", fahrenheit);
            textViewResult.setText(result);
        } else {
            textViewResult.setText("Please enter a valid temperature in Celsius!");
        }
    }

    private void convertToCelsius() {
        String inputTemperature = editTextFahrenheit.getText().toString().trim();
        if (!inputTemperature.isEmpty()) {
            double fahrenheit = Double.parseDouble(inputTemperature);
            double celsius = fahrenheitToCelsius(fahrenheit);
            String result = String.format("%.2f°C", celsius);
            textViewResult.setText(result);
        } else {
            textViewResult.setText("Please enter a valid temperature in Fahrenheit!");
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
