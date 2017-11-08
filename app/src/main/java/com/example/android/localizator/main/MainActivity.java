/**
 * Prova 1 Mobile
 * Autores:
 *          André Levi Zanon    RA - 619922
 *          Rodrigo Ferrari de Souza    RA - 619795
 * Professores:
 *           Bruno Mendonça e Cesar Teixeira
 */

package com.example.android.localizator.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.localizator.R;
import com.example.android.localizator.add_address.AddAddressActivity;
import com.example.android.localizator.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    // Faz o bind das views por meio do butterknife
    @BindView(R.id.btn_add_address) Button btnAddAddress;
    @BindView(R.id.btn_show_addresses) Button btnShowAddresses;
    
    private MainPresenter mainPresenter;
    // Nao eh mais necessario devido ao butterknife
    //Button btnAddAddress;
    //Button btnShowAddresses;

    //código utilizado para adicionar novos endereços
    //variavel virou publica para poder ser acessada pelo presenter
    public static final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Chama o butterknife
        ButterKnife.bind(this);

        //chama contrutor do Presenter
        mainPresenter = new MainPresenter(this);

        /* Trecho de codigo desnecessario devido ao butterknife
            As funcoes foram copiadas para o onclick do butterknife
        //btnAddAddress = findViewById(R.id.btn_add_address);
        // btnShowAddresses = findViewById(R.id.btn_show_addresses);


        abre a activity para adicionar endereços
        btnAddAddress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
                startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
            }

        });

        //abre a activity para exibir os endereços cadastrados
        btnShowAddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifica se há endereços cadastrados antes executar a activity
                if(lstAddresses.size() <= 0){
                    Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
                }else{
                    //abre a ShowAddressActivity enviando a lista de endereços
                    Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
                    openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
                    startActivity(openShowAddressActivity);
                }

            }
        });*/
    }

    /**
     * Funcao para clique do botao de adicionar endereco na tela principal
     */
    @OnClick(R.id.btn_add_address)
    public void onClickBtnAddAddress(){
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    /**
     * Funcao para clique do botao de mostrar endereco na tela principal
     */
    @OnClick(R.id.btn_show_addresses)
    public void onClickBtnShowAddress(){
        mainPresenter.verificaEndereco();
        /* parte de codigo desncessario devido a implementacao do MVP
        verifica se há endereços cadastrados antes executar a activity
        if(lstAddresses.size() <= 0){
            Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
        }else{
            //abre a ShowAddressActivity enviando a lista de endereços
            Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
            openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
            startActivity(openShowAddressActivity);
        }
        */

    }

    /**
     * Funcao que cria toast para quando nao existem enderecos cadastrados
     */
    @Override
    public void toastSemEnderecos() {
        Toast.makeText(MainActivity.this, R.string.semEndereco, Toast.LENGTH_SHORT).show();
    }

    /**
     * Funcao que abre tela de lista de enderecos cadastrados
     * passa para a activity tambem a lista de enderecos
     */
    @Override
    public void abreIntentEnderecos(ArrayList lstAddresses) {
        Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
        openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
        startActivity(openShowAddressActivity);
    }

    /**
     * Funcao que chama no mainPresenter a funcao de captura o resultado da tela de cadastro de endereços e adiciona na lista
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        mainPresenter.resultadoActivity(requestCode, resultCode, data);
        /*if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }*/
    }
}
