package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, gepElet1, gepElet2, gepElet3, jatekosElet1, jatekosElet2, jatekosElet3;
    private TextView textView1, textView2;
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

    private void eletVesztes(int elet, ImageView imageView){

    }

    private void gyozelem(){
        Toast.makeText(this, "Győzelem", Toast.LENGTH_SHORT).show();
        pontEmber++;
        switch (pontEmber){
            case 1:
                gepElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                gepElet1.setImageResource(R.drawable.heart1);
                break;
        }
//        textView1.setText("Eredmény: Ember: " + pontEmber + " Computer: " + pontComputer);
    }

    private void vereseg(){
        Toast.makeText(this, "Vereség", Toast.LENGTH_SHORT).show();
        pontComputer++;
        switch (pontComputer){
            case 1:
                jatekosElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                jatekosElet2.setImageResource(R.drawable.heart1);
                break;
            case 3:
                jatekosElet1.setImageResource(R.drawable.heart1);
                break;
        }
//        textView1.setText("Eredmény: Ember: " + pontEmber + " Computer: " + pontComputer);
    }

    private void dontetlen(){
        Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show();
        dontetlen++;
        textView2.setText("Döntetlenek száma: " + dontetlen);
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

        if (pontEmber >= 3 || pontComputer >= 3){
            jatekVege();
        }
    }

    private void jatekVege(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Szeretne új játékot játszani?");
        if (pontEmber > pontComputer){
            builder.setTitle("Győzelem");
        }
        else{
            builder.setTitle("Vereség");
        }
        builder.setNegativeButton("NEM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton("IGEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujJatek();
            }
        });
        builder.create().show();
    }

    private void ujJatek(){
        kepBeallitas(1, imageView1);
        kepBeallitas(1, imageView2);
        pontComputer = 0;
        pontEmber = 0;
        dontetlen = 0;
//        textView1.setText("Eredmény: Ember: 0 Computer: 0");
        textView2.setText("Döntetlenek száma: 0");
        jatekosElet1.setImageResource(R.drawable.heart2);
        jatekosElet2.setImageResource(R.drawable.heart2);
        jatekosElet3.setImageResource(R.drawable.heart2);
        gepElet1.setImageResource(R.drawable.heart2);
        gepElet2.setImageResource(R.drawable.heart2);
        gepElet3.setImageResource(R.drawable.heart2);
    }

    private void init(){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
//        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        pontEmber = 0;
        pontComputer = 0;
        dontetlen = 0;
        jatekosElet1 = findViewById(R.id.jatekosElet1);
        jatekosElet2 = findViewById(R.id.jatekosElet2);
        jatekosElet3 = findViewById(R.id.jatekosElet3);
        gepElet1 = findViewById(R.id.gepElet1);
        gepElet2 = findViewById(R.id.gepElet2);
        gepElet3 = findViewById(R.id.gepElet3);
    }
}
