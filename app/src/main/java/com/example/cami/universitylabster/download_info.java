package com.example.cami.universitylabster;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cami.universitylabster.administrare_resurse.AdapterCursuri;
import com.example.cami.universitylabster.base_classes.CourseId;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.util.ArrayList;

public class download_info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatabaseReference mDatabase, mDataBaseCourses;
    String idStudent = "stud_1", facId = "UPT", facName = "Universitatea Politehnica Timisoara", specializareId = "CALC", specializareNume = "Calculatoare";
    int anId = 2;
    Boolean datePicked = false;
    String dataId;
    boolean newCourse = false;
    int grupaId = 1;
    ArrayList<CourseId> myCoursesList = new ArrayList<CourseId>();
    Button btn_calendar, btn_add;
    Spinner spinner_drop;
    ArrayAdapter spinnerAdapter;
    String numeCurs, numeProf, start, finish, idCurs, tipCurs, notite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_courses);

        setUpResources();
        if (newCourse)
            getNewCourse();
//        alertDialogNetworkSetup();
        if (getIntent() != null)

            btn_calendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(download_info.this, CalendarActivity.class);
                    datePicked = true;
                    newCourse = true;
                    startActivity(intent);
                }
            });
        idStudent = getIntent().getStringExtra("idStudent"); //login

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(download_info.this, AddCourseActivity.class);
                newCourse=true;
                startActivity(addIntent);
            }
        });
        downloadNewData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!haveNetworkConnection()) {
//                alertDialogNetwork.show();
        }
    }


    public void initializeFirebase() {
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        String cId = "MAT2";
//        CourseId test = new CourseId(facName, specializareNume, cId, "Matematica", "sdsad", "Asdasd", "lab", "stud1-BC", "08:00", "10:00", "https/asdas");
//
////        mDatabase.child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId).child("MAT4").setValue(test);
//
//
//        mDatabase.child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId + "").child("MAT10").setValue(test);
//        mDatabase.child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId + "").child("MAT2").setValue(test);

//
    }

    private boolean haveNetworkConnection() {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getActiveNetworkInfo();
                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;

    }


    public void alertDialogNetworkSetup() {
//        alertDialogNetwork = new AlertDialog.Builder(download_info.this).create();
//        alertDialogNetwork.setTitle("Atentie");
//        alertDialogNetwork.setMessage("Nu exista conexiune la internet");
//        alertDialogNetwork.setButton(DialogInterface.BUTTON_POSITIVE, "Setari", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Settings.ACTION_SETTINGS);
//                startActivity(intent);
//            }
//        });


    }

    public void setUpAdapter() {
        ArrayList coursesDetail = myCoursesList;
        final ListView lista = (ListView) findViewById(R.id.list_view);
        lista.setAdapter(new AdapterCursuri(this, coursesDetail));
        lista.setOnLongClickListener(new View.OnLongClickListener() {

            public void onLongClick(AdapterView a, View v, int position, long id) {
                CourseId selectedCourse = (CourseId) lista.getItemAtPosition(position);
                Toast.makeText(download_info.this, "Sunteti validat ca si prezent", Toast.LENGTH_LONG).show();
                // change in firebase as attending
                selectedCourse.addParticipant(idStudent);
            }

            @Override
            public boolean onLongClick(View v) {
                return false;
            }


        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!haveNetworkConnection()) {
//            alertDialogNetwork.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        grupaId = position + 1;
        downloadNewData();

    }

    public void downloadNewData() {
        myCoursesList.clear();
        mDataBaseCourses = FirebaseDatabase.getInstance().getReference().child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId + "");
        mDataBaseCourses.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myCoursesList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    CourseId courseId = postSnapshot.getValue(CourseId.class);
                    if (courseId.valid())
                        myCoursesList.add(courseId);
                    courseId.setIdUser(idStudent);
                    Log.d("test", "Update done ");
                }
                setUpAdapter();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addNewEntry() {

//        CourseId entry = new CourseId(facName, specializareNume, cId, "Matematica", "sdsad", "Asdasd", "lab", "stud1-BC", "08:00", "10:00", "https/asdas");
//
//       mDatabase.child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId).child("MAT4").setValue(test);

    }
public void getNewUser(){


    String idStudent =getIntent().getStringExtra("idStudent");
    facId = getIntent().getStringExtra("FacId");
    facName = getIntent().getStringExtra("facName");
    specializareId = getIntent().getStringExtra("specializareId");
    specializareNume = getIntent().getStringExtra("specializareNume");
    int anId = getIntent().getIntExtra("anId",1);

}


    public void getNewCourse() {

        numeCurs = getIntent().getStringExtra("cNume");
        numeProf = getIntent().getStringExtra("cProf");
        start = getIntent().getStringExtra("cStart");
        finish = getIntent().getStringExtra("cFinish");
        idCurs = getIntent().getStringExtra("cId");
        tipCurs = getIntent().getStringExtra("cTip");
        notite = getIntent().getStringExtra("cNotite");


        CourseId entry = new CourseId(facName, specializareNume, idCurs, numeCurs, numeProf, "To be added", tipCurs, idStudent, start, finish, notite);

       mDatabase.child("Courses").child(facId).child(specializareId).child(anId + "").child(dataId + "").child(grupaId+"").child(idCurs).setValue(entry);
        newCourse= false;

    }

    public void setUpResources() {
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, R.layout.support_simple_spinner_dropdown_item);
        spinner_drop = findViewById(R.id.spinner_drop);
        spinner_drop.setAdapter(spinnerAdapter);
        spinner_drop.setOnItemSelectedListener(download_info.this);
        dataId = getIntent().getStringExtra("data");
        btn_add=findViewById(R.id.btn_add);
        btn_calendar = findViewById(R.id.btn_calendar);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}