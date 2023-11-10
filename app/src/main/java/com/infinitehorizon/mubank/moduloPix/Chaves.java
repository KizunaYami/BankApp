package com.infinitehorizon.mubank.moduloPix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

public class Chaves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaves);
        Repository repository = new Repository(this);

        ListView listView = findViewById(R.id.idListViewChaves);
        ArrayAdapter<Double> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repository.getChaves());
        listView.setAdapter(adapter);
    }
}