package com.infinitehorizon.mubank.moduloPix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.infinitehorizon.mubank.R;
import com.infinitehorizon.mubank.Repository;

import java.util.Random;

public class CadastrarChaves extends AppCompatActivity {
    EditText rawChave;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_chaves);
        rawChave = findViewById(R.id.idEditTxtCadastroChave);
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

    public void onClickCadastrar(View view) {
        if(!rawChave.getText().toString().equals("")){
            int chave = Integer.parseInt(rawChave.getText().toString());
            repository.setChave(chave);
            setResult(1);
            finish();
        }else {
            Toast.makeText(this, "a chave não pode estar vazia", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickRemoveChave(View view) {
        Boolean isRemoved = false;
        for (Integer chave : repository.getChaves()) {
            if(Integer.parseInt(rawChave.getText().toString()) == chave){
                repository.rmChave(chave);
                isRemoved = true;
                Toast.makeText(this, "Chave removida", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        if(isRemoved == false){
            Toast.makeText(this, "Esta chave não esta cadastrada", Toast.LENGTH_SHORT).show();
        }
    }
}