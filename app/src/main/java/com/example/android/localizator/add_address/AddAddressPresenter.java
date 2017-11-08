package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Rodrigo on 08/11/2017.
 */

public class AddAddressPresenter {

    AddAddressView addAddressView;

    //Construtor do AddAddressPresenter
    public AddAddressPresenter(AddAddressView addAddressView){
        this.addAddressView = addAddressView;
    }

    public void adicaoDeEndereco(String textoDaTextView){
        //verifica se há um endereço digitado
        if (TextUtils.isEmpty(textoDaTextView)){
            addAddressView.toastDigiteEndereco();
        }else {
            addAddressView.intentTextoEndereco();
        }
    }
}
