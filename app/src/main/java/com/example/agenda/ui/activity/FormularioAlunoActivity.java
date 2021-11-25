package com.example.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        AlunoDAO dao = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);

        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(v -> {
            String nome = campoNome.getText().toString();
            String telefone = campoTelefone.getText().toString();
            String email = campoEmail.getText().toString();
            Toast.makeText(FormularioAlunoActivity.this,
                    "Salvo", Toast.LENGTH_SHORT).show();

            Aluno alunoCriado = new Aluno(nome, telefone, email);
            dao.salvar(alunoCriado);

            finish();
        });
    }

}