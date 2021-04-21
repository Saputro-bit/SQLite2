package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;

import com.example.sqlite2.adapter.TemanAdapter;
import com.example.sqlite2.database.DBController;
import com.example.sqlite2.database.Teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.namespace.QName;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    DBController controller = new DBController(this);
    String id, nm, tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TemanBaru.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData() {
        ArrayList<HashMap<String, String>> daftarTeman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();

        //memindah dari hasil query kedalam Teman
        for (int i = 0; i < daftarTeman.size(); i++) {
            Teman teman = new Teman();

            teman.setId(daftarTeman.get(i).get("id").toString());
            teman.setNama(daftarTeman.get(i).get("nama").toString());
            teman.setTelpon(daftarTeman.get(i).get("telpon").toString());
            //pindahkan dari Teman kedalam Arraylist teman di adapter
            temanArrayList.add(teman);
        }
    }
}
