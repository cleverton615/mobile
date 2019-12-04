package br.edu.unifavip.aulaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editEditTextEmail;
    private Button buttonConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText) findViewById(R.id.edittext_nome);
        editEditTextEmail = (EditText) findViewById(R.id.edittext_email);
        buttonConfirmar = (Button) findViewById(R.id.button_confirmar);

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String email = editEditTextEmail.getText().toString();

                Toast. makeText(MainActivity.this, "Nome: " + nome, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ContatosActivity.class);
                startActivity(intent);
            }
        });
    }
}
