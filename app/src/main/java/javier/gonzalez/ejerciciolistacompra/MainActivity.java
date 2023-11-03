package javier.gonzalez.ejerciciolistacompra;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import javier.gonzalez.ejerciciolistacompra.adapters.productAdapter;
import javier.gonzalez.ejerciciolistacompra.databinding.ActivityMainBinding;
import javier.gonzalez.ejerciciolistacompra.modelos.Product;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<Product> productList;
    private productAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        productList = new ArrayList<>();





        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              createProduct().show();
            }
        });
    }
    private AlertDialog createProduct(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.titleCreate);
        builder.setCancelable(false);

        View productViewModel = getLayoutInflater().from(this).inflate(R.layout.product_view_model,null);
        EditText txtName = productViewModel.findViewById(R.id.txtNameProductView);
        EditText txtQuantity = productViewModel.findViewById(R.id.txtQuantityProductView);
        EditText txtPrice = productViewModel.findViewById(R.id.txtPriceProductView);
        TextView lbTotal = productViewModel.findViewById(R.id.txtTotalProductView);
        builder.setView(productViewModel);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int quantity = Integer.parseInt(txtQuantity.getText().toString());
                    float price = Float.parseFloat(txtPrice.getText().toString());
                    float total = quantity * price;

                    lbTotal.setText(String.valueOf(total)+"$");
                }catch (Exception e){

                }
            }
        };
        txtQuantity.addTextChangedListener(textWatcher);
        txtPrice.addTextChangedListener(textWatcher);

        builder.setNegativeButton(R.string.cancel,null);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(txtName.getText().toString().isEmpty()||txtQuantity.getText().toString().isEmpty()||txtPrice.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.missing, Toast.LENGTH_SHORT).show();
                }else{
                    Product product = new Product(
                            txtName.getText().toString(),
                            Integer.parseInt(txtQuantity.getText().toString()),
                                    Float.parseFloat(txtPrice.getText().toString())
                    );
                            productList.add(0,product);
                            //Redibujar recicler view

                    Toast.makeText(MainActivity.this, product.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return builder.create();
    }
}

