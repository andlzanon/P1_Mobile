package com.example.android.localizator.show_addresses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        //FOI PASSADO UM CONTEXTO: TROCAR NA QUESTAO 4
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses, this);

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }
}
