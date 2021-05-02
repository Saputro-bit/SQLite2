package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.sqlite2.R;
import com.example.sqlite2.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

public class LihatData extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button simpanBtn;
    String nm, tlp, id;
    DBController controller = new DBController(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        tNama = (TextInputEditText)findViewById(R.id.edNama);
        tTelpon = (TextInputEditText)findViewById(R.id.edTelpon);
        simpanBtn = (Button)findViewById(R.id.buttonSave);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("nm");
        tlp = getIntent().getStringExtra("tlp");

        setTitle("EditData");
        tNama.setText(nm);
        tTelpon.setText(tlp);
    }
}