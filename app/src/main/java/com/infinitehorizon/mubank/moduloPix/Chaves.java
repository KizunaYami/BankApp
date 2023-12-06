package com.infinitehorizon.mubank.moduloPix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = findViewById(R.id.idListViewChaves);
        ArrayAdapter<Double> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repository.getChaves());
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}