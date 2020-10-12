package com.example.project2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ImageAdapter extends BaseAdapter {
	private static final int PADDING = 8;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private Context mContext;          // This will have to be passed to the ImageView
	private List<Integer> carThumbnail;   // Adapter must store AdapterView's items
	private List<String> carManufactureName;

	// Save the list of image IDs and the context
	public ImageAdapter(Context c, List<Integer> ids, List<String> carNames) {
		mContext = c;
		this.carThumbnail = ids;
		this.carManufactureName = carNames;
	}

	// Now the methods inherited from abstract superclass BaseAdapter

	// Return the number of items in the Adapter
	@Override
	public int getCount() {
		return carThumbnail.size();
	}

	// Return the data item at position
	@Override
	public Object getItem(int position) {
		return carThumbnail.get(position);
	}

	// Will get called to provide the ID that
	// is passed to OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return carThumbnail.get(position);
	}

	// Return an ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		RelativeLayout carLayout = new RelativeLayout(mContext);

		ImageView imageView;
//		= (ImageView) convertView;
		// if convertView's not recycled, initialize some attributes
//		if (imageView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
			imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//		}
		TextView carTextView = new TextView(mContext);
		carTextView.setText(carManufactureName.get(position));
		imageView.setImageResource(carThumbnail.get(position));
		carLayout.addView(imageView);
		carLayout.addView(carTextView);
		return carLayout;
	}
}
