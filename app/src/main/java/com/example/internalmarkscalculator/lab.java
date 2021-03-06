package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        StudentDetails stud = (StudentDetails) getIntent().getSerializableExtra("obj");
        TextView courseName = (TextView) findViewById(R.id.course);
        TextView courseCode = (TextView) findViewById(R.id.code);
        courseName.setText(stud.lab[stud.currentSubject].name);
        courseCode.setText(stud.lab[stud.currentSubject].code);
        Button next = (Button) findViewById(R.id.nextBtn3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText pre1,pre2;
                EditText rep1,rep2;

                pre1 = (EditText) findViewById(R.id.pre1);
                pre2 = (EditText) findViewById(R.id.pre2);
                rep1 = (EditText) findViewById(R.id.rep1);
                rep2 = (EditText) findViewById(R.id.rep2);

                stud.lab[stud.currentSubject].preLab[0] = Float.parseFloat(pre1.getText().toString());
                stud.lab[stud.currentSubject].preLab[1] = Float.parseFloat(pre2.getText().toString());
                stud.lab[stud.currentSubject].report[0] = Float.parseFloat(rep1.getText().toString());
                stud.lab[stud.currentSubject].report[1] = Float.parseFloat(rep2.getText().toString());
                stud.currentSubject += 1;

                if(stud.currentSubject < 2) {
                    Intent intent = new Intent(getApplicationContext(), lab.class);
                    intent.putExtra("obj", stud);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), displayMarks.class);
                    intent.putExtra("obj", stud);
                    startActivity(intent);
                }

            }
        });


    }
}