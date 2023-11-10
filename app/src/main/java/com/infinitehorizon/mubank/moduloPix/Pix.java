package com.infinitehorizon.mubank.moduloPix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infinitehorizon.mubank.R;

public class Pix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);
    }

    public void onClickCadastrarChave(View view) {
        Intent intent = new Intent(this, CadastrarChaves.class);
        startActivity(intent);
    }

    public void onClickChaves(View view) {
        Intent intent = new Intent(this, Chaves.class);
        startActivity(intent);
    }

    public void onClickEnviarPix(View view) {
        Intent intent = new Intent(this, EnviarPix.class);
        startActivity(intent);
    }

    public void onClickFavoritos(View view) {
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }
}