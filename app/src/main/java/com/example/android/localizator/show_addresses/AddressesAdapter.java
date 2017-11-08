package com.example.android.localizator.show_addresses;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.localizator.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder>{

    private List<String> addressesList;
    Context context;

    //Construtor para receber a lista
    //TROCAR NA QUESTAO 4 O CONTEXT
    AddressesAdapter(List<String> addressesList, Context context){
        this.addressesList = addressesList;
        this.context = context;
    }

    //Infla o layout XML
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item, parent, false);
        return new ViewHolder(v);
    }

    //Seta os dados na lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAddress.setText(addressesList.get(position));
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return addressesList.size();
    }

    //Mapeamento dos componentes da View
    public class ViewHolder extends RecyclerView.ViewHolder{
        // Faz o bind da view pelo butterknife
        @BindView(R.id.tv_address) TextView tvAddress;

        // nao eh mais necessario devido ao butterknife
        // TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            // nao eh mais necessario devido ao butterknife
            // tvAddress = itemView.findViewById(R.id.tv_address);
            // Chama o butterknife
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.address_item)
        public void intentMapa(){
            Intent intentMapa = new Intent(Intent.ACTION_VIEW);
            intentMapa.setData(Uri.parse("geo: 0,0?q=" + tvAddress.getText().toString()));
            if(intentMapa.resolveActivity(context.getPackageManager())!=null){
                context.startActivity(intentMapa);
            }
            else {
                Toast.makeText(context, "Impossivel abiri recursos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
