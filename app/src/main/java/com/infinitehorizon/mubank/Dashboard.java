package com.infinitehorizon.mubank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.infinitehorizon.mubank.moduloConta.Conta;
import com.infinitehorizon.mubank.moduloPix.Pix;

public class Dashboard extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        repository = new Repository(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView name = findViewById(R.id.idTextDash);
        name.setText("Olá, "+repository.getNome());
        TextView textValor = findViewById(R.id.idTextValor);
        textValor.setText(""+repository.getSaldo());
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

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    public void onClickConta(View view) {
        Intent intent = new Intent(this, Conta.class);
        startActivity(intent);
    }

    public void onClickPix(View view) {
        Intent intent = new Intent(this, Pix.class);
        startActivity(intent);
    }
}