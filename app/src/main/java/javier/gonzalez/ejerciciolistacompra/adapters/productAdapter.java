package javier.gonzalez.ejerciciolistacompra.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javier.gonzalez.ejerciciolistacompra.modelos.Product;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ProductVH> {

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductVH extends RecyclerView.ViewHolder{
        public ProductVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
