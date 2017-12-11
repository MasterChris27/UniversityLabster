package com.example.cami.universitylabster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cami.universitylabster.base_classes.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cami on 10.12.2017.
 */

public class CreateAccountActivity extends AppCompatActivity {

    EditText nume, prenume, user, parola, fac, facid, spec, specid, an, tel;
    Button validate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nume = findViewById(R.id.r_nume);
        prenume = findViewById(R.id.r_prenume);
        user = findViewById(R.id.r_user);
        parola = findViewById(R.id.r_pw);
        fac = findViewById(R.id.r_facn);
        facid = findViewById(R.id.r_facid);
        spec = findViewById(R.id.r_specn);
        specid = findViewById(R.id.r_spec);
        an = findViewById(R.id.r_an);
        tel = findViewById(R.id.r_tel);
        validate = findViewById(R.id.btn_validate);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Student student = new Student(user.getText().toString(),parola.getText().toString(),facid.getText().toString(),specid.getText().toString(),an.getText().toString(),"1",nume.getText().toString(),prenume.getText().toString(),tel.getText().toString(),"-");
                student.setFacN(fac.getText().toString());
                student.setSpecN(spec.getText().toString());
                ref.child("Users").child(user.getText().toString()).setValue(student);
                Intent intent = new Intent(CreateAccountActivity.this,FrontLogin.class);
                startActivity(intent);

            }
        });
    }
}