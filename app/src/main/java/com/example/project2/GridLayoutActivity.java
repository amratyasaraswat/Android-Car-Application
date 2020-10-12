package com.example.project2;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

// AUTHOR: Amratya Saraswat
//This application uses some deprecated methods. 
//See UIViewPager for a more modern version of this application
public class GridLayoutActivity extends Activity {

	protected static final String EXTRA_RES_ID = "POS";
	
	private ArrayList<Integer> carArray = new ArrayList<Integer>(
			Arrays.asList(R.drawable.toyota_rav4, R.drawable.honda_crv,
					R.drawable.nissan_rogue, R.drawable.jeep_grandcherokee, R.drawable.mazda_cx5,
					R.drawable.ford_escape, R.drawable.hyundai_kona, R.drawable.volkswagen_atlas));

	private ArrayList<String> carNames = new ArrayList<String>(
			Arrays.asList("Toyota RAV4","Honda CRV", "Nissan Rogue", "Jeep Grand Cherokee", "Mazda CX5","Ford Escape", "Hyundai Kona", "Volkswagen Atlas"));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		registerForContextMenu(gridview);
		// Create a new ImageAdapter and set it as the Adapter for this GridView
		gridview.setAdapter(new ImageAdapter(this, carArray, carNames));

		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
				
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
//				Toast.makeText(getApplicationContext(),"The value of id is: " + id, Toast.LENGTH_LONG).show();
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) id);
				// Start the ImageViewActivity
				startActivity(intent);

			}
		});
	}
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, v.getId(), 0, "Enlarge Image" );
		menu.add(1, v.getId(), 1, "Go to website" );
		menu.add(2, v.getId(), 2, "List of Dealerships");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if(item.getGroupId() == 0){
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			Intent intent = new Intent(GridLayoutActivity.this, ImageViewActivity.class);
			intent.putExtra(EXTRA_RES_ID, (int) carArray.get(info.position));
			startActivity(intent);
		}
		else if (item.getGroupId() == 1){
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			if (info.position == 0){
				String url = "https://www.toyota.com/rav4/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 1){
				String url = "https://automobiles.honda.com/cr-v";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 2){
				String url = "https://www.nissanusa.com/vehicles/crossovers-suvs/rogue.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 3){
				String url = "https://www.jeep.com/cherokee.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 4){
				String url = "https://www.mazdausa.com/vehicles/2020-cx-5";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 5) {
				String url = "https://www.ford.com/suvs-crossovers/escape/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else if (info.position == 6){
				String url = "https://www.hyundaiusa.com/us/en/vehicles/kona";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
			else{
				String url = "https://www.vw.com/models/atlas/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}

		else if (item.getGroupId() == 2){
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			if (info.position == 0){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 1){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 2){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 3){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 4){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 5){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 6){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
			else if (info.position == 7){
				Intent i = new Intent(this, Dealership.class);
				i.putExtra(EXTRA_RES_ID, (int) info.position);
				startActivity(i);
			}
		}
		return true;
	}
}