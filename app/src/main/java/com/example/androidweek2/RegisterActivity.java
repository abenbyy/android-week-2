package com.example.androidweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidweek2.models.User;

import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    User u;
    EditText etName;
    DatePicker dpBirthday;
    Spinner spHair, spSkin, spHeight;
    Button btnReg;

    String gender = "";

    private void setAdapter(Spinner spinner, int array){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onRadioGenderClick(View view){
        switch(view.getId()){
            case R.id.rd_male:
                gender = getString(R.string.male);
                break;

            case R.id.rd_female:
                gender = getString(R.string.female);
                break;
        }
    }

    private boolean validate(){
        if(etName.getText().toString().equals("")){
            Toast.makeText(this,"Nama harus di isi", Toast.LENGTH_SHORT).show();
            return false;
        }else if(gender.equals("") || gender.isEmpty() || gender == null){
            Toast.makeText(this, "Jenis kelamin harus dipilih", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        dpBirthday = findViewById(R.id.dp_birthday);
        spHair = findViewById(R.id.sp_hair);
        spSkin = findViewById(R.id.sp_skin);
        spHeight = findViewById(R.id.sp_height);
        btnReg = findViewById(R.id.btn_gender);

        setAdapter(spHair, R.array.hair_type);
        setAdapter(spSkin, R.array.skin_color);
        setAdapter(spHeight, R.array.height);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    Intent intent = new Intent(RegisterActivity.this, ConfirmActivity.class);
                    User u = new User(
                            etName.getText().toString(),
                            new Date(dpBirthday.getYear(), dpBirthday.getMonth(), dpBirthday.getDayOfMonth()),
                            gender,
                            spHair.getSelectedItem().toString(),
                            spSkin.getSelectedItem().toString(),
                            spHeight.getSelectedItem().toString()
                    );

                    intent.putExtra("USER", u);

                    startActivity(intent);
                }
            }
        });

    }


}