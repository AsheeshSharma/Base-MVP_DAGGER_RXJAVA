/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 5:09 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import animelabs.baseproject.R;

public class PaginatedListingAdapter extends RecyclerView.Adapter<PaginatedListingAdapter.ListItemViewHolder> {

    private LayoutInflater mInflater;
    private Context context;

    public PaginatedListingAdapter(Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public PaginatedListingAdapter.ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_sample, parent, false);
        return new PaginatedListingAdapter.ListItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PaginatedListingAdapter.ListItemViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // stores and recycles views as they are scrolled off screen
    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView orderId;

        ListItemViewHolder(View itemView) {
            super(itemView);
        }

    }
}