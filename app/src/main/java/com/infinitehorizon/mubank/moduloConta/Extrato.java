package com.infinitehorizon.mubank.moduloConta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

public class Extrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
        Repository repository = new Repository(this);

        ListView listView = findViewById(R.id.idListView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repository.extrato());
        listView.setAdapter(adapter);
    }
}