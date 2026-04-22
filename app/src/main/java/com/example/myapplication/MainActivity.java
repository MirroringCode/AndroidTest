package com.example.myapplication;

import static android.graphics.BlendMode.COLOR;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SwitchMaterial switchToggle = findViewById(R.id.themeSwitcher);

        if (switchToggle.isChecked()) {
            switchToggle.setText("Modo Claro");
        } else {
            switchToggle.setText("Modo Oscuro");
        }

        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES));
                    buttonView.setText("Modo oscuro");
                } else {
                    AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
                    buttonView.setText("Modo claro");
                }
            }
        });
        
        btnRedirects();

        AdFragment ad = new AdFragment();

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.ranuraFragment, ad)
            .commit();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public MaterialButton[] getButtonList() {
        MaterialButton btnHello = findViewById(R.id.toHelloActivity);
        MaterialButton btnGoodbye = findViewById(R.id.toGoodbyeActivity);
        MaterialButton btnCounter = findViewById(R.id.toCounterActivity);

        return new MaterialButton[] {btnHello, btnGoodbye, btnCounter};
    }

    public void btnRedirects() {
        for (MaterialButton btn : getButtonList()) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.toHelloActivity) {
                        startActivity(new Intent(MainActivity.this, HelloActivity.class));
                    }
                    if (v.getId() == R.id.toGoodbyeActivity) {
                        startActivity(new Intent(MainActivity.this, GoodbyeActivity.class));
                    }
                    if (v.getId() == R.id.toCounterActivity) {
                        startActivity(new Intent(MainActivity.this, CounterActivity.class));
                    }
                }
            });
        }
    }
}