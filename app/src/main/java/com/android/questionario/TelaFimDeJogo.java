package com.android.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaFimDeJogo extends AppCompatActivity {
    private TextView txtResult;
    private TextView txtCorrects;
    private TextView txtErrors;
    private Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fim_de_jogo);
        txtResult = findViewById(R.id.textResult);
        txtCorrects = findViewById(R.id.textCorrets);
        txtErrors = findViewById(R.id.textErrors);
        playAgain = findViewById(R.id.playAgain);

        if(TelaQuestionario.corrects>TelaQuestionario.errors){
            txtResult.setText("Parabêns!");
        }else{
            txtResult.setText("Fim de Jogo!");
        }

        this.txtCorrects.setText("ACERTOS: "+Integer.toString(TelaQuestionario.corrects));
        this.txtErrors.setText("ERROS: "+Integer.toString(TelaQuestionario.errors));

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaFimDeJogo.this, TelaQuestionario.class);
                startActivity(i);
                finish();
            }
        });
    }
}