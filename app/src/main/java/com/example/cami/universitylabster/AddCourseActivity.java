package com.example.cami.universitylabster;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Cami on 10.12.2017.
 */

public class AddCourseActivity extends AppCompatActivity {

    EditText d_nume,d_prof,d_start,d_finish,d_id,d_tip,d_notite;
    int count =0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(count>1){
            Intent intent = new Intent(AddCourseActivity.this, download_info.class);
            intent.putExtra("cNume",d_nume.getText());
            intent.putExtra("cProf",d_prof.getText());
            intent.putExtra("cStart",d_start.getText());
            intent.putExtra("cFinish",d_finish.getText());
            intent.putExtra("cId",d_id.getText());
            intent.putExtra("cTip",d_tip.getText());
            intent.putExtra("cNotite",d_notite.getText());
        }
        count ++;

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpResources();
    }
  public void setUpResources(){
      d_nume=findViewById(R.id.d_nume);
       d_prof=findViewById(R.id.d_prof);
       d_start=findViewById(R.id.d_start);
       d_finish=findViewById(R.id.d_finish);
       d_id =findViewById(R.id.d_id);
       d_tip=findViewById(R.id.d_tip);
       d_notite=findViewById(R.id.d_notite);
    }
}
