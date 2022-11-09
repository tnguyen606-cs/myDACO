package com.myDACO.utilities;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.List;

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
            ItemViewHolder viewHolder = new  ItemViewHolder(view);
            viewHolder.itemLabel = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        if (!list.get(position).isActive()) {
            view.setBackgroundColor(Color.RED);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(context,R.color.rectangle_color));
        }

        ItemViewHolder holder = (ItemViewHolder) view.getTag();
        holder.itemLabel.setText(list.get(position).getPlaneName());

        ImageView editIcon = (ImageView) view.findViewById(R.id.edit_icon);

        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirestoreQuery fq = new FirestoreQuery();

                // Creates popup menu
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.plane_status_menu, popupMenu.getMenu());
                Menu m = popupMenu.getMenu();
                if (list.get(position).isActive()) {
                    m.removeItem(m.findItem(R.id.set_active).getItemId());
                } else {
                    m.removeItem(m.findItem(R.id.set_inactive).getItemId());
                }
                if (list.get(position).isOnMission()) {
                    m.removeItem(m.findItem(R.id.add_to_mission).getItemId());
                } else {
                    m.removeItem(m.findItem(R.id.remove_from_mission).getItemId());
                }

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        boolean onMission = list.get(position).isOnMission();
                        boolean active = list.get(position).isActive();
                        switch (menuItem.getItemId()) {
                            case R.id.set_active:
                                fq.togglePlaneStatus(list.get(position).getId());
                                Toast.makeText(context.getApplicationContext(), "Set " + list.get(position).getPlaneName() + "'s status to active", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.set_inactive:
                                fq.togglePlaneStatus(list.get(position).getId());
                                Toast.makeText(context.getApplicationContext(), "Set " + list.get(position).getPlaneName() + "'s status to inactive", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.add_to_mission:
                                fq.togglePlaneMission(list.get(position).getId());
                                Toast.makeText(context.getApplicationContext(), "Added " + list.get(position).getPlaneName() + " to mission", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.remove_from_mission:
                                fq.togglePlaneMission(list.get(position).getId());
                                Toast.makeText(context.getApplicationContext(), "Removed " + list.get(position).getPlaneName() + " from mission", Toast.LENGTH_SHORT).show();
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