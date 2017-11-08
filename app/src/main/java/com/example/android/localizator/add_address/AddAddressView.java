package com.example.android.localizator.add_address;

/**
 * Created by Rodrigo on 08/11/2017.
 */

// View eh uma interface feita para manipular funcoes da activity sem deixar que o presenter tenha acesso a todos os metodos
public interface AddAddressView {
    //funcao que mostra toast de endereco nao digitado
    public void toastDigiteEndereco();
    //funcao que passa o nome do endereco para a MainActivity
    public void intentTextoEndereco();
}
