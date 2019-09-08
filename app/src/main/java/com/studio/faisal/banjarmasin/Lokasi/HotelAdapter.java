package com.studio.faisal.banjarmasin.Lokasi;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.faisal.banjarmasin.R;

import java.util.List;

/**
 * Created by Faisal on 19/02/2019.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;
    CustomItemClickListener listener;

    private List<ListData> productList;

    //getting the context and product list with constructor
    public HotelAdapter(Context mCtx, List<ListData> productList, CustomItemClickListener listener) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.listener = listener;
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.model, null);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, final int position) {
        //getting the product of the specified position
        ListData product = productList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFabClick(v, position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;
        FloatingActionButton fab;

        public HotelViewHolder(View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView) itemView.findViewById(R.id.textViewShortDesc);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            fab = (FloatingActionButton) itemView.findViewById(R.id.fab);
        }
    }
}
