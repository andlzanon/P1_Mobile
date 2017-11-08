package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.localizator.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends AppCompatActivity implements  AddAddressView {

    // Nao eh mais necessario devido ao butterknife
    // TextView edtAddress;
    // Button btnAdd;

    // Faz o bind da view pelo butterknife
    @BindView(R.id.edt_address) TextView edtAddress;
    @BindView(R.id.btn_add) Button btnAdd;
    AddAddressPresenter addAddressPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        // Chama o butterknife
        ButterKnife.bind(this);

        //chama construtor do Presenter
        addAddressPresenter = new AddAddressPresenter(this);

        /* Nao eh mais necessario devido ao butterknife
           edtAddress = findViewById(R.id.edt_address);
           btnAdd = findViewById(R.id.btn_add);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //verifica se há um endereço digitado
                    if (edtAddress.getText().toString().isEmpty()){
                        Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
                    }else {
                        //retorna o endereço para a MainActivity
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie_name", edtAddress.getText().toString());
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    }
                }
            });
        }*/
    }

    /**
     * Funcao do clique no botao de adicionar endereco
     */
    @OnClick(R.id.btn_add)
    public void onClickBtnAdd(){

        //verifica se há um endereço digitado
        if (edtAddress.getText().toString().isEmpty()){
            Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
        }else {
            //retorna o endereço para a MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("movie_name", edtAddress.getText().toString());
            setResult(Activity.RESULT_OK, resultIntent);
            // Exibe toast para indicar que endereco foi adicionado
            Toast.makeText(AddAddressActivity.this, "Endereço cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


}
