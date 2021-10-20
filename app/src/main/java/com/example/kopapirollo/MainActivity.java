package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2;
    private TextView textView1;
    private Button btn1, btn2, btn3;
    private int pontEmber, pontComputer, dontetlen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mutat(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mutat(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mutat(3);
            }
        });
    }

    private void kepBeallitas(int valasztas, ImageView imageView){
        switch (valasztas){
            case 1:
                imageView.setImageResource(R.drawable.rock);
                break;
            case 2:
                imageView.setImageResource(R.drawable.paper);
                break;
            case 3:
                imageView.setImageResource(R.drawable.scissors);
                break;
        }
    }

    private void gyozelem(){
        Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        pontEmber++;
        textView1.setText("Eredmény: Ember: " + pontEmber + " Computer: " + pontComputer);
    }

    private void vereseg(){
        Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        pontComputer++;
        textView1.setText("Eredmény: Ember: " + pontEmber + " Computer: " + pontComputer);
    }

    private void dontetlen(){
        Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show();
        dontetlen++;
    }

    private void mutat(int valasztas){
        kepBeallitas(valasztas, imageView1);
        int gepValasztas = (int) (Math.random() * 3) + 1;
        kepBeallitas(gepValasztas, imageView2);

        if (valasztas == gepValasztas){
            dontetlen();
        }
        else if (valasztas == 1){
            if (gepValasztas == 2){
                vereseg();
            }
            else{
                gyozelem();
            }
        }
        else if (valasztas == 2){
            if (gepValasztas == 1){
                gyozelem();
            }
            else{
                vereseg();
            }
        }
        else if (valasztas == 3){
            if (gepValasztas == 1){
                vereseg();
            }
            else{
                gyozelem();
            }
        }

    }

    private void init(){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        textView1 = findViewById(R.id.textView1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
    }
}
