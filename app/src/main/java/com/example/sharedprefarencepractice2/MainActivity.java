package com.example.sharedprefarencepractice2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText,rollEditText,fatherEditText,motherEditText;
    Button saveBtn,loadBtn;
    TextView answer;
    private String name,roll,fathername,mothername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editNameId);
        rollEditText = findViewById(R.id.editRollId);
        fatherEditText = findViewById(R.id.editFatherId);
        motherEditText= findViewById(R.id.editMotherId);
        saveBtn = findViewById(R.id.savebtnId);
        loadBtn = findViewById(R.id.loadbtnId);
        answer = findViewById(R.id.answerId);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.savebtnId){
                 name = nameEditText.getText().toString();
                 roll = rollEditText.getText().toString();
                 fathername = fatherEditText.getText().toString();
                 mothername = motherEditText.getText().toString();

                 if (name.equals("") && roll.equals("") && fathername.equals("") && mothername.equals("")){

                     Toast.makeText(this,"Please fill all the gaps",Toast.LENGTH_SHORT).show();

                 }
                 else {
                     SharedPreferences sharedPreferences =getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                     SharedPreferences.Editor editor = sharedPreferences.edit();

                     editor.putString("username",name);
                     editor.putString("roll",roll);
                     editor.putString("fathername",fathername);
                     editor.putString("mothername",mothername);
                     editor.commit();
                     Toast.makeText(this,"Data Successfully stored",Toast.LENGTH_SHORT).show();
                 }
        }

        else if (v.getId() == R.id.loadbtnId){

            SharedPreferences sharedPreferences = getSharedPreferences("userDetails",Context.MODE_PRIVATE);
            name = sharedPreferences.getString("username","username not found");
            roll = sharedPreferences.getString("roll","Roll not found");
            fathername = sharedPreferences.getString("fathername","fathers name not found");
            mothername = sharedPreferences.getString("mothername","Mothers name not found");

            answer.setText(name +"\n"+ roll +"\n"+ fathername +"\n"+ mothername );
        }

    }
}
