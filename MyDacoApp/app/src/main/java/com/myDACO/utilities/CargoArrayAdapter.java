package com.myDACO.utilities;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.myDACO.R;
import com.myDACO.SingleCargoActivity;
import com.myDACO.data.Cargo;

import java.util.List;

public class CargoArrayAdapter extends ArrayAdapter<Cargo> {

    static List<Cargo> list;
    private Activity context;

    public CargoArrayAdapter(Activity context, List<Cargo> list) {
        super(context, R.layout.custom_single_item, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.custom_single_item, null);
            ItemViewHolder viewHolder = new  ItemViewHolder(view);
            viewHolder.itemLabel = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ItemViewHolder holder = (ItemViewHolder) view.getTag();
        holder.itemLabel.setText(list.get(position).getCargoName());

        ImageView editIcon = (ImageView) view.findViewById(R.id.edit_icon);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates popup menu
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.item_status_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.edit:
                                Intent nextScreen = new Intent(context, SingleCargoActivity.class);
                                nextScreen.putExtra("CARGO_TEXT", list.get(position).getCargoName());
                                nextScreen.putExtra("CARGO_ID", list.get(position).getAssignedPlaneID());
                                nextScreen.putExtra("CARGO_WEIGHT", list.get(position).getWeight());
                                context.startActivity(nextScreen);
                                break;
                            case R.id.delete:
                                FirestoreQuery fq = new FirestoreQuery();
                                // 1. check if the cargo is already assigned to a plane?
                                if (list.get(position).getAssignedPlaneID() == null) {
                                    fq.removeCargo(list.get(position).getId());
                                    Toast.makeText(context.getApplicationContext(), "Deleted " + list.get(position).getCargoName(), Toast.LENGTH_LONG).show();
                                } else { // If the cargo is on plane, then cannot delete it
                                    Toast.makeText(context.getApplicationContext(), "Cannot Deleted " + list.get(position).getCargoName() + " , which is on planes", Toast.LENGTH_LONG).show();
                                }
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        return view;
    }
}


