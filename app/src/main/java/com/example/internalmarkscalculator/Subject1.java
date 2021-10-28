package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Subject1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject1);

        StudentDetails stud = (StudentDetails) getIntent().getSerializableExtra("obj");
        Button btn = (Button) findViewById(R.id.nextBtn2);
        TextView courseName = (TextView) findViewById(R.id.course);
        TextView courseCode = (TextView) findViewById(R.id.code);

        courseName.setText(stud.theory[stud.currentSubject].name);
        courseCode.setText(stud.theory[stud.currentSubject].code);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText c1,c2,c3;
                EditText t1,t2;
                EditText ap;

                c1 = findViewById(R.id.pre1);
                c2 = findViewById(R.id.pre2);
                c3 = findViewById(R.id.ca3);
                t1 = findViewById(R.id.rep1);
                t2 = findViewById(R.id.rep2);
                ap = findViewById(R.id.ap);

                stud.theory[stud.currentSubject].CA[0] = Float.parseFloat(c1.getText().toString());
                stud.theory[stud.currentSubject].CA[1] = Float.parseFloat(c2.getText().toString());
                stud.theory[stud.currentSubject].CA[2] = Float.parseFloat(c3.getText().toString());
                stud.theory[stud.currentSubject].tut[0] = Float.parseFloat(t1.getText().toString());
                stud.theory[stud.currentSubject].tut[1] = Float.parseFloat(t2.getText().toString());
                stud.theory[stud.currentSubject].ap = Float.parseFloat(ap.getText().toString());
                stud.currentSubject += 1;

                if(stud.currentSubject == 5) {

                    stud.currentSubject = 0;
                    Intent intent = new Intent(getApplicationContext(), lab.class);
                    intent.putExtra("obj", stud);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), Subject1.class);
                    intent.putExtra("obj", stud);
                    startActivity(intent);
                }
            }
        });


    }
}