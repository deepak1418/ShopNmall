package com.example.sajan.app3;

/**
 * Created by deepak on 09/03/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;



public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Product> productList;
int p1;
//int sum_p=MainActivity.price_sum;

    public ProductsAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup Parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        Product product = productList.get(position);


        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewdec.setText(String.valueOf(product.getDescription()));
        p1=product.getPrice();

       // Main3Activity.price_sum=p1+Main3Activity.price_sum;

        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
               // MainActivity.price_sum=Integer.parseInt(holder.t1.getText().toString());
                MainActivity.price_sum=p1+MainActivity.price_sum;
                Toast.makeText(mCtx, "your Item added to cart "+MainActivity.price_sum, Toast.LENGTH_SHORT).show();



            }
        });

       // holder.t1.setText(MainActivity.price_sum);







    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice,textViewdec,t1;
        ImageView imageView;
        Button cart,check;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            textViewdec=itemView.findViewById(R.id.textViewdec);
            cart=itemView.findViewById(R.id.cart);
            t1=itemView.findViewById(R.id.t1);






        }
    }

}
