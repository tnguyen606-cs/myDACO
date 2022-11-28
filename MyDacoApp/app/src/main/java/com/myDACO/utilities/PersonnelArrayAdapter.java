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
import com.myDACO.SinglePersonnelActivity;
import com.myDACO.data.Personnel;

import java.util.List;

public class PersonnelArrayAdapter extends ArrayAdapter<Personnel> {

    static List<Personnel> list;
    private Activity context;

    public PersonnelArrayAdapter(Activity context, List<Personnel> list) {
        super(context, R.layout.custom_single_item, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.custom_single_personnel, null);
            ItemViewHolder viewHolder = new  ItemViewHolder(view);
            viewHolder.itemLabel = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ItemViewHolder holder = (ItemViewHolder) view.getTag();
        holder.itemLabel.setText(list.get(position).getFirstName() + " " + list.get(position).getLastName());

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
                                Intent nextScreen = new Intent(context, SinglePersonnelActivity.class);
                                nextScreen.putExtra("PERSONNEL", list.get(position));
                                context.startActivity(nextScreen);
                                break;
                            case R.id.delete:
                                FirestoreQuery fq = new FirestoreQuery();
                                // 1. check if the personnel is already assigned to a plane?
                                if (list.get(position).getAssignedPlaneID() == null) {
                                    fq.removePersonnel(list.get(position).getId());
                                    Toast.makeText(context.getApplicationContext(), "Deleted " + list.get(position).getFirstName() + " " + list.get(position).getLastName(), Toast.LENGTH_LONG).show();
                                } else { // If the personnel is serving, then cannot delete it
                                    Toast.makeText(context.getApplicationContext(), "Cannot delete " + list.get(position).getFirstName() + " " + list.get(position).getLastName() + " , because they are still on a plane", Toast.LENGTH_LONG).show();
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


