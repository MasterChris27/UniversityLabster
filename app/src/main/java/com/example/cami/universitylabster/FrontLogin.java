package com.example.cami.universitylabster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cami.universitylabster.base_classes.CourseId;
import com.example.cami.universitylabster.base_classes.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Cami on 10.12.2017.
 */

public class FrontLogin extends AppCompatActivity {

    EditText user, parola;
    Button btnRegister, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = findViewById(R.id.edit_ulogin);
        parola = findViewById(R.id.edit_plogin);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_reg);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbase= FirebaseDatabase.getInstance().getReference().child("Users");
                final ArrayList<Student> useri= new ArrayList<>();
                useri.clear();
                        dbase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        useri.clear();
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Student student = postSnapshot.getValue(Student.class);
                                useri.add(student);
                                if(parola.getText().toString()==student.getParola()){
                                    Intent intent= new Intent(FrontLogin.this,download_info.class);
                                    intent.putExtra("idStudent",student.getId());
                                    intent.putExtra("facId",student.getCodFac());
                                    intent.putExtra("specializareId",student.getCodSpec());
                                    intent.putExtra("anId",student.getAn());

                                    startActivity(intent);
                                }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontLogin.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}
