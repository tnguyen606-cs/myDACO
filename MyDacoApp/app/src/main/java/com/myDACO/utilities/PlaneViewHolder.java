package com.myDACO.utilities;

import android.view.View;
import android.widget.TextView;

import com.myDACO.R;

public class PlaneViewHolder {
    // Declare the object references for our views
    TextView planeLabel;
    // Get the handles by calling findViewById() on View object inside the constructor
    PlaneViewHolder(View v)
    {
        planeLabel = v.findViewById(R.id.label);
    }
}
