package com.infinitehorizon.mubank.moduloConta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

public class Conta extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        repository = new Repository(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = findViewById(R.id.idTextSaldo);
        textView.setText(""+repository.getSaldo());
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

    public void onClickDepositar(View view) {
        Intent intent = new Intent(this, Depositar.class);
        startActivityForResult(intent,1);
    }

    public void onClickRetirar(View view) {
        Intent intent = new Intent(this, Retirar.class);
        startActivityForResult(intent,1);
    }

    public void onClickExtrato(View view) {
        Intent intent = new Intent(this, Extrato.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            recreate();
        }
    }
}