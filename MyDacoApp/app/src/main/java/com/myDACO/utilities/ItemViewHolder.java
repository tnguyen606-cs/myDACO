package com.myDACO.utilities;

import android.view.View;
import android.widget.TextView;

import com.myDACO.R;

public class ItemViewHolder {
    // Declare the object references for our views
    TextView itemLabel;
    // Get the handles by calling findViewById() on View object inside the constructor
    ItemViewHolder(View v)
    {
        itemLabel = v.findViewById(R.id.label);
    }
}
