package com.example.android.localizator.show_addresses;

import android.view.View;

/**
 * Created by Rodrigo on 08/11/2017.
 */

public interface OnRecyclerViewSelected {
    //funcao responsavel por abrir a intent de mapa na camada de visualizacao do MVP
    void onClickItemView(View view, int position, String endereco);
}
