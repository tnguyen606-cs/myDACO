package com.myDACO.utilities;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import com.myDACO.utilities.*;
import com.myDACO.R;
import com.myDACO.data.Planes;

public class PlaneArrayAdapter extends ArrayAdapter<Planes> {
    private List<Planes> list;
    private Activity context;

    public PlaneArrayAdapter(Activity context, List<Planes> list) {
        super(context, R.layout.custom_single_plane, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.custom_single_plane, null);
            PlaneViewHolder viewHolder = new PlaneViewHolder(view);
            viewHolder.planeLabel = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        if (!list.get(position).isActive()) {
            view.setBackgroundColor(Color.RED);
        } else {
            view.setBackgroundColor(Color.WHITE);
        }

        PlaneViewHolder holder = (PlaneViewHolder) view.getTag();
        holder.planeLabel.setText(list.get(position).getPlaneName());

        ImageView editIcon = (ImageView) view.findViewById(R.id.edit_icon);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirestoreQuery fq = new FirestoreQuery();
                fq.setPlaneStatus(list.get(position).getId());;

                String planeName = list.get(position).getPlaneName();
                Toast.makeText(context.getApplicationContext(), "Set " + planeName + "'s status", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}