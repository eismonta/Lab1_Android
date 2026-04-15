package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinnerPhoneType);
        RadioGroup radioGroup = findViewById(R.id.radioGroupBrands);
        Button buttonOk = findViewById(R.id.buttonOk);
        TextView resultText = findViewById(R.id.textResult);

        String[] types = {"Смартфон", "Кнопковий телефон", "Планшет"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, types);
        spinner.setAdapter(adapter);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioId == -1) {
                    Toast.makeText(MainActivity.this,
                            "Помилка: оберіть виробника!", Toast.LENGTH_LONG).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedRadioId);
                    String brand = selectedRadioButton.getText().toString();

                    String type = spinner.getSelectedItem().toString();

                    String result = "Вибрано: " + type + " від " + brand;
                    resultText.setText(result);
                }
            }
        });
    }
}