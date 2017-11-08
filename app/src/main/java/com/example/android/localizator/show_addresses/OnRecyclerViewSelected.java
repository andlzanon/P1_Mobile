package com.example.android.localizator.show_addresses;

import android.view.View;

/**
 * Created by Rodrigo on 08/11/2017.
 */

// Interface feita para permitir a comunicacao entre o adapter e a activity show address que exibe os enderecos cadastrados
public interface OnRecyclerViewSelected {
    // funcao responsavel por abrir a intent de mapa na camada de visualizacao do MVP
    void onClickItemView(View view, int position, String endereco);
}
