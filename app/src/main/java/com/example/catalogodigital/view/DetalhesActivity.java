package com.example.catalogodigital.view;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.catalogodigital.R;
import com.example.catalogodigital.model.Produto;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        TextView textResultado = findViewById(R.id.textResultado);

        // Recuperando o objeto da Intent
        Produto p = (Produto) getIntent().getSerializableExtra("dados_produto");

        if (p != null) {
            textResultado.setText("Produto: " + p.getNome() + "\nPreço: R$ " + p.getPreco());
        }
    }
}