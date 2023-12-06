package com.infinitehorizon.mubank.moduloConta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

public class Depositar extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depositar);
        repository = new Repository(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        EditText editText = findViewById(R.id.idEditValorSacar);
        Double deposito = Double.parseDouble(editText.getText().toString());
        Double valor = repository.getSaldo() + deposito;
        repository.movimentacao(valor);
        repository.log("Deposito de "+deposito+" Saldo atualizado "+valor);
        setResult(1);
        finish();
    }
}