package com.lucascalderon1.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sair = findViewById(R.id.btn_sair);
        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Você saiu do app",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
        Toast.makeText(this, "Você escolheu a pedra", Toast.LENGTH_SHORT).show();
    }

    public void selecionadoPapel(View view) {
        Toast.makeText(this, "Você escolheu o papel", Toast.LENGTH_SHORT).show();
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        Toast.makeText(this, "Você escolheu a tesoura", Toast.LENGTH_SHORT).show();
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView img_resultado = findViewById(R.id.img_resultado);
        ImageView iv_mostrar = findViewById(R.id.iv_mostrar);
        TextView txt_resultado = findViewById(R.id.txt_resultado);


        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                img_resultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                img_resultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                img_resultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario   == "pedra")   ||
                        (escolhaApp == "pedra" && escolhaUsuario   == "tesoura")

        ) { //app ganhador

            txt_resultado.setText("Você perdeu :(");
            iv_mostrar.setImageResource(R.drawable.perdeu);



        } else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp   == "pedra")   ||
                (escolhaUsuario == "pedra" && escolhaApp   == "tesoura")
        ) { //usuario ganhador

            txt_resultado.setText("Você ganhou :)");
            iv_mostrar.setImageResource(R.drawable.trofeu);



        } else { //empate

            txt_resultado.setText("Empate ;)");
            iv_mostrar.setImageResource(R.drawable.empatia);

        }

    }

}