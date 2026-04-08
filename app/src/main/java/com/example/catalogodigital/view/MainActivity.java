package com.example.catalogodigital.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.catalogodigital.database.DatabaseHelper;
import com.example.catalogodigital.R;
import com.example.catalogodigital.model.Produto;

public class MainActivity extends AppCompatActivity {
    private EditText editNome, editPreco;
    private Button btnSalvar;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        editNome = findViewById(R.id.editNome);
        editPreco = findViewById(R.id.editPreco);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                String precoStr = editPreco.getText().toString();

                try {
                    double preco = Double.parseDouble(precoStr);
                    Produto p = new Produto(nome, preco);

                    android.content.ContentValues valores = new android.content.ContentValues();
                    valores.put("nome", p.getNome());
                    valores.put("preco", p.getPreco());

                    long idInserido = dbHelper.getWritableDatabase().insert("produtos", null, valores);

                    if (idInserido == -1) {
                        Toast.makeText(MainActivity.this, "Erro ao salvar!", Toast.LENGTH_LONG).show();
                    }

                    Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
                    intent.putExtra("dados_produto", p);
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro: Preencha os campos corretamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}