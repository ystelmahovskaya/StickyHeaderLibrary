package com.example.yuliiastelmakhovska.stickyheaderlibrary.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Trip;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.R;

import java.util.List;

/**
 * Created by ystelmak on 2018-04-25.
 */

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

        private final List<Trip> trips;
        private final LayoutInflater layoutInflater;
        private final int            rowLayout;
        private Context context;

        public TripAdapter(LayoutInflater layoutInflater, List<Trip> trips, @LayoutRes int rowLayout, Context context) {
            this.trips = trips;
            this.layoutInflater = layoutInflater;
            this.rowLayout = rowLayout;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(rowLayout,
                    parent,
                    false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            final Trip trip = trips.get(position);
            holder.fullName.setText(trip.getCountry()+" "+trip.getExpenses());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "item clicked at position" + position,
                            Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return trips.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView fullName;

            public ViewHolder(View view) {
                super(view);
                fullName = (TextView) view.findViewById(R.id.full_name_tv);
            }
        }
    }


