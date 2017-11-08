package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Rodrigo on 08/11/2017.
 */

/**
 * Presenter feito para manipulação da parte logica da activity de adicionar endereco
 */
public class AddAddressPresenter {

    // Interface entre a camada lógica e a de visualização
    AddAddressView addAddressView;

    //Construtor do AddAddressPresenter
    public AddAddressPresenter(AddAddressView addAddressView){
        this.addAddressView = addAddressView;
    }

    /**
     *
     * @param textoDaTextView recebe o texto do usuario no campo de endereco na tela de adicionar endereco
     */
    public void adicaoDeEndereco(String textoDaTextView){
        //verifica se há um endereço digitado e se nao houver ele pede para digitar um endereco
        if (TextUtils.isEmpty(textoDaTextView)){
            addAddressView.toastDigiteEndereco();
        }else {
            addAddressView.intentTextoEndereco();
        }
    }
}
