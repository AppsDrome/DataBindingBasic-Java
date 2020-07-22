package com.appsdrome.databindingexampleusingjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.appsdrome.databindingexampleusingjava.databinding.ActivityAddNewStudentBinding;


public class AddNewStudentActivity extends AppCompatActivity {



    private ActivityAddNewStudentBinding activityAddNewStudentBinding;
    Student student;
    private AddNewStudentActivityClickHandlers addNewStudentActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        student=new Student();
        activityAddNewStudentBinding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_student);
        activityAddNewStudentBinding.setStudnet(student);

        addNewStudentActivityClickHandlers=new AddNewStudentActivityClickHandlers(this);
        activityAddNewStudentBinding.setClickHandler(addNewStudentActivityClickHandlers);

    }

    public class AddNewStudentActivityClickHandlers {

        Context context;

        public AddNewStudentActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view) {

            if(student.getName()==null){

                Toast.makeText(getApplicationContext(),"Name field cannot be empty",Toast.LENGTH_LONG).show();

            }else{

                Intent intent=new Intent();
                intent.putExtra("NAME",student.getName());
                intent.putExtra("EMAIL",student.getEmail());
                intent.putExtra("COUNTRY",student.getCountry());
                setResult(RESULT_OK,intent);
                finish();

            }

        }
    }
}
