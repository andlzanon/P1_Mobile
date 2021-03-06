package com.example.android.localizator.main;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.android.localizator.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

import static com.example.android.localizator.add_address.AddAddressActivity.EXTRA_ENDERECO;
import static com.example.android.localizator.main.MainActivity.RC_ADD_ADDRESS;

/**
 * Created by Rodrigo on 08/11/2017.
 */

public class MainPresenter {

    MainView mainView;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    // Interface entre a camada lógica e a de visualização
    public MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    // Funcao para verificar campo de endereco
    public void verificaEndereco(){
        //verifica se há endereços cadastrados antes executar a activity
        if(lstAddresses.size() <= 0){
            mainView.toastSemEnderecos();
        }else{
            //abre a ShowAddressActivity enviando a lista de endereços
            mainView.abreIntentEnderecos(lstAddresses);
        }
    }

    // Funcao que obtem o resultado da activity e adiciona na lista
    public void resultadoActivity(int requestCode, int resultCode, Intent data){
        if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra(EXTRA_ENDERECO));
        }
    }
}
