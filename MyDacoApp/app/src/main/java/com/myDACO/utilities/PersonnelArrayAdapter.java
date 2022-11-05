package com.myDACO.utilities;

import android.app.Activity;
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
            view = inflator.inflate(R.layout.custom_single_item, null);
            ItemViewHolder viewHolder = new  ItemViewHolder(view);
            viewHolder.itemLabel = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ItemViewHolder holder = (ItemViewHolder) view.getTag();
        holder.itemLabel.setText(list.get(position).getFirstName());

        ImageView editIcon = (ImageView) view.findViewById(R.id.edit_icon);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirestoreQuery fq = new FirestoreQuery();

                // Creates popup menu
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.item_status_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.edit:
                                Toast.makeText(context.getApplicationContext(), "Edit " + list.get(position).getFirstName(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delete:
                                Toast.makeText(context.getApplicationContext(), "Delete " + list.get(position).getLastName(), Toast.LENGTH_SHORT).show();
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


