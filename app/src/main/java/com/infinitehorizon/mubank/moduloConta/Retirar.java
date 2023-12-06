package com.infinitehorizon.mubank.moduloConta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

public class Retirar extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirar);
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

    public void onClickRetirar(View view) {
        EditText editText = findViewById(R.id.idEditValorSacar);
        Double saque = Double.parseDouble(editText.getText().toString());
        if(repository.getSaldo() < saque){
            Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
        }else{
            Double valor = repository.getSaldo() - saque;
            repository.movimentacao(valor);
            repository.log("Saque de "+saque+" saldo atualizado "+valor);
            setResult(1);
            finish();
        }
    }
}