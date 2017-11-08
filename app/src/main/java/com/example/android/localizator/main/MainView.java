package com.example.android.localizator.main;

import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Rodrigo on 08/11/2017.
 */

public interface MainView {
    //funcao que mostra Toast que nao existem enderecos cadastrados
    public void toastSemEnderecos();
    //funcao que abre intent da tela de enderecos
    public void abreIntentEnderecos(ArrayList lstAddresses);
}
