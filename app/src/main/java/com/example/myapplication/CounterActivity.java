package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class CounterActivity extends AppCompatActivity {

    int counter = 0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);


        MaterialButton btnCounter = findViewById(R.id.counter);
        text = findViewById(R.id.counterText);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("conteo_orig", 0);

            text.setText("Counter: " + counter);
        }
        clicker(btnCounter, text);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("conteo_orig", counter);
    }


    private void clicker(MaterialButton btn, TextView text) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                Log.d("Contador: ", "Conteo: " + String.valueOf(counter));
                text.setText("Counter: " + String.valueOf(counter));
            }
        });
    }

    
}