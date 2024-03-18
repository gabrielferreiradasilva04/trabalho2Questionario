package com.android.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TelaQuestionario extends AppCompatActivity {

    private Map<String,String> questionsAndResponsesList = new HashMap<>();
    private List<String> questionsList;

    public static int errors = 0;
    public static int corrects = 0;
    public int  currentQuestion = 0;
    public Button responseA;
    public Button responseB;
    public Button responseC;
    public Button responseD;

    public Button verify;
    public Button nextQuestion;
    public TextView question;
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

        questionsAndResponsesList = generateQuestions();
        questionsList = questionsAndResponsesList.keySet();

        for (String question: questionsList) {

        }

        Log.d("LISTA DE QUESTÕES>>>", "LISTA DE QUESTÕES>>> "+ questionsList);
        Log.d("QUESTÕES E RESPOSTAS", "Questões e respostas>>> "+ questionsAndResponsesList);


    }



    public static Map<String,String> generateQuestions (){
        List<String> questionsList = new ArrayList<>();
        List<String> responseList = new ArrayList<>();
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
        responseList.add("malloc");
        responseList.add("printf");
        responseList.add("scanf");
        responseList.add("==");
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
}