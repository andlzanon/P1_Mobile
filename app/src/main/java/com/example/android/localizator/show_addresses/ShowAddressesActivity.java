package com.example.android.localizator.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.localizator.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowAddressesActivity extends AppCompatActivity {

    // Nao eh mais necessario devido ao butterknife
    // RecyclerView rvAddresses;

    // Faz o bind das views por meio do butterknife
    @BindView(R.id.rv_addresses)
    RecyclerView rvAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);

        // Nao eh mais necessario devido ao butterknife
        // rvAddresses = findViewById(R.id.rv_addresses);

        // Chama o butterknife
        ButterKnife.bind(this);

        //captura a lista enviada pela MainActivity
        ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);
        //seta a interface no adapter para colocar o toque na camada de visualizacao
        addressesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClickItemView(View view, int position, String endereco) {
                //Intent.ACTION_VIEW devido ao fato de ser uma intent de visualizacao
                Intent intentMapa = new Intent(Intent.ACTION_VIEW);
                //seta a localizacao para o endereco que o usuario digitou
                intentMapa.setData(Uri.parse("geo: 0,0?q=" + endereco));
                //if na camada de visuzalicao devido ao getPackageManager que necessita de um contexto
                if(intentMapa.resolveActivity(getPackageManager())!=null){
                    startActivity(intentMapa);
                }
                else {
                    //chama toast que nao tem recurso
                    toastSemRecurso();
                }
            }
        });

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }

    /*
    * toast que avisa que o usuario nao possui um app de mapas
    */
    public void toastSemRecurso(){
        Toast.makeText(this, R.string.erroRecursos, Toast.LENGTH_SHORT).show();
    }
}
