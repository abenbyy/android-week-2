package com.example.androidweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidweek2.models.User;

public class ConfirmActivity extends AppCompatActivity {

    TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvMessage = findViewById(R.id.tv_message);

        User u = getIntent().getParcelableExtra("USER");
        String message = "Halo, " + u.getName() + " yang lahir di tanggal " + u.getBirthday().getDate() + "-"
                + u.getBirthday().getMonth() + "-" + u.getBirthday().getYear() + "."
                + " Kamu suka pacar yang rambutnya " + u.getHairType() + ", kulitnya " + u.getSkinColor()
                + ", dengan tinggi " + u.getHeight();

        tvMessage.setText(message);
    }
}