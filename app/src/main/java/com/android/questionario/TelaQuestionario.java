package com.android.questionario;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TelaQuestionario extends AppCompatActivity {

    private Map<String,String> questionsAndResponsesList = new HashMap<>();
    private List<String> questionsList = new ArrayList<>();

    private List<String> responseList = new ArrayList<>();
    private List<String> badAnswers = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();
    private String selectedAnswer = "";
    private String correctAnswer = "";
    private TextView textProgress;

    public static int errors = 0;
    public static int corrects = 0;
    public int  currentQuestion = 0;
    private Button responseA;
    private Button responseB;
    private Button responseC;
    private Button responseD;

    private Button verify;
    private Button nextQuestion;
    private TextView question;
    private TextView textSelectedAnswer;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_questionario);
        responseA = findViewById(R.id.responseA);
        responseB = findViewById(R.id.responseB);
        responseC = findViewById(R.id.responseC);
        responseD = findViewById(R.id.responseD);
        nextQuestion = findViewById(R.id.buttonNext);
        verify = findViewById(R.id.buttonVerify);
        question = findViewById(R.id.question);
        textSelectedAnswer = findViewById(R.id.answer);
        progressBar = findViewById(R.id.progressBar);
        textProgress = findViewById(R.id.textProgress);
        buttons.add(responseA);
        buttons.add(responseB);
        buttons.add(responseC);
        buttons.add(responseD);



        /***
         * carrega a lista de questões
         */
        questionsAndResponsesList = generateQuestions();
        Set<String> listKeys = questionsAndResponsesList.keySet();

        for (String question: listKeys) {
            questionsList.add(question);
        }

        /***
         * Inicio do questionário com 5 pergunrtas sobre C
         *
         */
        corrects = 0;
        errors = 0;

        game();

        this.responseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = responseA.getText().toString();
                textSelectedAnswer.setText(selectedAnswer);
                verify.setEnabled(true);
                verify.setVisibility(View.VISIBLE);
            }
        });
        this.responseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = responseB.getText().toString();
                textSelectedAnswer.setText(selectedAnswer);
                verify.setEnabled(true);
                verify.setVisibility(View.VISIBLE);
            }
        });
        this.responseC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = responseC.getText().toString();
                textSelectedAnswer.setText(selectedAnswer);
                verify.setEnabled(true);
                verify.setVisibility(View.VISIBLE);
            }
        });
        this.responseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = responseD.getText().toString();
                textSelectedAnswer.setText(selectedAnswer);
                verify.setEnabled(true);
                verify.setVisibility(View.VISIBLE);
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify.setVisibility(View.INVISIBLE);
                verify.setEnabled(false);
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                if(selectedAnswer.equals(correctAnswer)){
                    corrects = corrects + 1;
                    Toast message = Toast.makeText(getApplicationContext(), "Correto!", Toast.LENGTH_SHORT);
                    message.show();
                }else{
                    errors = errors + 1;
                    Toast message = Toast.makeText(getApplicationContext(), "Incorreto!", Toast.LENGTH_SHORT);
                    message.show();
                }
                nextQuestion.setEnabled(true);
                nextQuestion.setVisibility(View.VISIBLE);
                nextQuestion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentQuestion++;
                        if(currentQuestion >= 5){
                            Intent i = new Intent(TelaQuestionario.this, TelaFimDeJogo.class);
                            startActivity(i);
                            finish();
                        }else{
                            game();
                        }

                    }
                });
            }
        });
    }





    private Map<String,String> generateQuestions (){
        List<String> questionsList = new ArrayList<>();
        Map<String,String> questionsXReponses = new HashMap<>();

        List<String> selectedQuestions = new ArrayList<>();
        Map<String, String> questionsXResponseSelected = new HashMap<>();

        questionsList.add("Qual o tipo de dados que armazena um caractere único em C?");
        questionsList.add("Qual palavra-chave é utilizada para declarar uma função em C?");
        questionsList.add(" Qual operador é utilizado para incrementar o valor de uma variável em C?");
        questionsList.add("Qual o operador lógico que retorna true se ambos os operandos forem true?");
        questionsList.add("Qual o tipo de loop que executa um bloco de código enquanto uma condição for verdadeira?");
        questionsList.add("Qual o tipo de ponteiro que aponta para um inteiro em C?");
        questionsList.add(" Qual a função que libera memória alocada dinamicamente em C?");
        questionsList.add("Qual o operador relacional que verifica se um número é menor que outro?");
        questionsList.add("Qual o tipo de dado que armazena um número real em C?");
        questionsList.add("Qual a palavra-chave que define uma variável global em C?");
        questionsList.add("Qual o operador de atribuição em C?");
        questionsList.add(" Qual o tipo de dado que armazena um endereço de memória em C?");
        questionsList.add("Qual a palavra-chave que define uma função que não retorna valor em C");
        questionsList.add("Qual o tipo de dado que armazena um valor booleano em C?");
        questionsList.add("Qual o operador aritmético que realiza a soma de dois números?");
        questionsList.add("Qual o operador de comparação que verifica se dois números são iguais?");
        questionsList.add("Qual palavra-chave é utilizada para alocar memória dinamicamente em C");
        questionsList.add("Qual a função que imprime dados na saída padrão (stdout) em C?");
        questionsList.add("Qual a função que lê dados da entrada padrão (stdin) em C");
        questionsList.add("Qual o tipo de dados que armazena um número inteiro em C?");

        responseList.add("char");
        responseList.add("def");
        responseList.add("++");
        responseList.add("&&");
        responseList.add("while");
        responseList.add("int*");
        responseList.add("free");
        responseList.add("<");
        responseList.add("float");
        responseList.add("extern");
        responseList.add("=");
        responseList.add("void*");
        responseList.add("void");
        responseList.add("_Bool");
        responseList.add("+");
        responseList.add("==");
        responseList.add("malloc");
        responseList.add("printf");
        responseList.add("scanf");
        responseList.add("int");

        for(int i = 0; i < questionsList.size(); i++){
            questionsXReponses.put(questionsList.get(i), responseList.get(i));
        }

        Random random = new Random();
        while(selectedQuestions.size() < 5){
            int select = random.nextInt(20);
            int duplicate = 0;
            for (String question: selectedQuestions) {
                if(question.equals(questionsList.get(select))){
                    duplicate++;
                }
            }
            if(duplicate == 0){
                selectedQuestions.add(questionsList.get(select));
            }
        }
        for (String question:selectedQuestions) {
            String response = questionsXReponses.get(question);
            questionsXResponseSelected.put(question, response);
        }
        return questionsXResponseSelected;
    }

    public List<String> generateBadAnswers(String correctAnswer){
        List<String> badAnswers = new ArrayList<>();
        Random random = new Random();

        while(badAnswers.size() <= 2){
            int index = random.nextInt(20);
            int duplicate = 0;
            String badAnswer = this.responseList.get(index);
            if(!badAnswer.equals(correctAnswer)){
                for (String existendBadAnswer: badAnswers) {
                    if(badAnswer.equals(existendBadAnswer)){
                        duplicate = 1;
                    }
                }
                if(duplicate == 0){
                    badAnswers.add(badAnswer);
                }
            }
        }
        return badAnswers;
    }

    public void buttonsXAnswers(List<Button> buttons, List<String> badAnswersAndCorrectAnswer, String correctAnswer){
        badAnswersAndCorrectAnswer.add(correctAnswer);
        for (Button button: buttons) {
            button.setText("");
        }
        int[] buttonChoose = {0,1,2,3};
        int[] answerChoose = {0,1,2,3};
        int buttonsNotEmpty = 0;

        while (buttonsNotEmpty <=3){
            buttonsNotEmpty = 0;
            int duplicateAnswer = 0;

            Random random = new Random();
            int buttonIndex = random.nextInt(buttonChoose.length);
            int answerIndex = random.nextInt(answerChoose.length);

            for (Button button: buttons) {
                if(button.getText().equals(badAnswersAndCorrectAnswer.get(answerChoose[answerIndex]))){
                    duplicateAnswer = 1;
                }
            }
            if(duplicateAnswer == 0 && buttons.get(buttonChoose[buttonIndex]).getText().equals("")){
                buttons.get(buttonChoose[buttonIndex]).setText(badAnswersAndCorrectAnswer.get(answerChoose[answerIndex]));
                for (Button button: buttons) {
                    if(!button.getText().equals("")){
                        buttonsNotEmpty++;
                    }
                }
            }

        }
    }
    public void game(){
        textProgress.setText(Integer.toString(currentQuestion+1)+"de 5");
        selectedAnswer = "";
        textSelectedAnswer.setText(selectedAnswer);
        progressBar.setMax(4);
        progressBar.setProgress(currentQuestion);
        verify.setEnabled(false);
        verify.setVisibility(View.INVISIBLE);
        nextQuestion.setEnabled(false);
        nextQuestion.setVisibility(View.VISIBLE);
        for (Button button:buttons) {
            button.setEnabled(true);
        }

        correctAnswer = questionsAndResponsesList.get(questionsList.get(currentQuestion));
        question.setText(questionsList.get(currentQuestion));

        badAnswers = generateBadAnswers(questionsAndResponsesList.get(questionsList.get(currentQuestion)));
        buttonsXAnswers(buttons, badAnswers, questionsAndResponsesList.get(questionsList.get(currentQuestion)));
    }

}



