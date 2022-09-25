package com.myDACO.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.myDACO.R;

public class PlaneArrayAdapter extends ArrayAdapter<String> {
    Context context;
    String[] planeName;

    public PlaneArrayAdapter(Context context, String[] planeName) {
        super(context, R.layout.custom_single_plane, R.id.label, planeName);
        this.context = context;
        this.planeName = planeName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // The parameter convertView is null when your app is creating a new item for the first time. It's not null when recycling.
        // Assign the convertView in a View object
        View singleItem = convertView;
        // Find a View from the entire View hierarchy by calling findViewById() is a fairly expensive task.
        // So, you'll create a separate class to reduce the number of calls to it.
        // First, create a reference of PlaneViewHolder and assign it to null.
        PlaneViewHolder holder = null;
        // Since layout inflation is a very expensive task, you'll inflate only when creating a new item in the ListView. The first
        // time you're creating a new item, convertView will be null. So, the idea is when creating an item for the first time,
        // we should perform the inflation and initialize the ViewHolder.
        if (singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.custom_single_plane, parent, false);
            // Pass the singleItem to the constructor of PlaneViewHolder. This singleItem object contains a LinearLayout
            // as the root element for custom_single_plane.xml file that contains other Views as well for the ListView.
            holder = new PlaneViewHolder(singleItem);
            // When you create an object of PlaneViewHolder, you're actually calling findViewById() method inside the constructor.
            // By creating PlaneViewHolder only when making new items, you call findViewById() only when making new rows.
            // At this point all the Views have been initialized. Now you need to store the holder so that you don't need to
            // create it again while recycling and you can do this by calling setTag() method on singleItem and passing the holder as a parameter.
            singleItem.setTag(holder);
        }
        // If singleItem is not null then we'll be recycling
        else {
            // Get the stored holder object
            holder = (PlaneViewHolder) singleItem.getTag();
        }
        // Set the values for your views in your item by accessing them through the holder
        holder.planeLabel.setText(planeName[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked:"+ planeName[position], Toast.LENGTH_SHORT).show();
            }
        });
        return singleItem;
    }
}