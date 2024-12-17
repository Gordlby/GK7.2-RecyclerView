package com.example.gk72_recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private List<Product> mProduct;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.item_layout, parent, false);

        ViewHolder vHolder = new ViewHolder(productView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
        Product product = mProduct.get(position);
        System.out.println(product);

        TextView tv1 = holder.tv1;
        tv1.setText(product.getId());
        TextView tv2 = holder.tv2;
        tv2.setText(product.getName());
        TextView tv3 = holder.tv3;
        tv3.setText(product.getPreis());
    }

    @Override
    public int getItemCount() {
        return mProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv1;
        public TextView tv2;
        public TextView tv3;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.textView000);
            tv2 = (TextView) itemView.findViewById(R.id.textView001);
            tv3 = (TextView) itemView.findViewById(R.id.textView002);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Product product = mProduct.get(position);

                Intent in = new Intent();
                in.setAction("gordlProductView");
                in.putExtra("Intern-Data-Name", product.getName());
                in.putExtra("Intern-Data-Id", product.getId());
                in.putExtra("Intern-Data-Price", product.getPreis());
                MainActivity.act.startActivity(in);
            }
        }
    }


    public ProductsAdapter(List<Product> products) {
        mProduct = products;
    }


}
