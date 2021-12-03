package com.example.dialog18102021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog,mBtnCustomDialog;
    int mPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog = findViewById(R.id.buttonShowAlertDialog);
        mBtnCustomDialog = findViewById(R.id.buttonCustomDialog);


        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPosition = -1;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String[] arrColors = {"Black","Pink","Blue","Gray","Orange","Red"};
                builder.setTitle("Pick color")
                        .setIcon(android.R.drawable.star_on)
                        .setSingleChoiceItems(arrColors, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mPosition = which;
                            }
                        })
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mPosition > -1){
                                    Toast.makeText(MainActivity.this, arrColors[mPosition], Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Không", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

    }
}