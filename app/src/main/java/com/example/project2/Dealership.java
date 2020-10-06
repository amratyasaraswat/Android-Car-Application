package com.example.project2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.example.project2.GridLayoutActivity.EXTRA_RES_ID;

public class Dealership extends Activity {
    private Context mContext;
    private static final int PADDING = 8;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] dealerships = {" Toyota of Lincoln Part \n 1561 N Fremont St, Chicago, IL 60642 \n\n Toyota on Western \n 6941 S Western Ave, Chicago, IL 60636 \n\n Midtown Toyota \n 2700 N Cicero Ave, Chicago, IL 60639 ",
            " Honda of Downtown Chicago \n  1111 N Clark St #2, Chicago, IL 60610 \n\n McGrath City Honda \n 6720 W Grand Ave., Chicago, IL 60707 \n\n Ed Napleton Honda in Oak Lawn \n 5800 95th St, Oak Lawn, IL 60453",
            " Berman Nissan of Chicago \n 3456 N Kedzie Ave, Chicago, IL 60618 \n\n Star Nissan \n 5757 W Touhy Ave, Niles, IL 60714 \n\n  94 Nissan of Holland \n 16269 Van Dam Rd, South Holland, IL 60473 ",
            " Mancari's Chrysler Dodge Jeep Ram \n 4630 95th St, Oak Lawn, IL 60453 \n\n Hawk Chrysler Dodge Jeep Service \n 7911 W Roosevelt Rd, Forest Park, IL 60130 \n\n South Chicago Dodge Chrysler Jeep \n 7340 S Western Ave, Chicago, IL 60636",
            " Oak Lawn Mazda \n 6750 W 95th St, Oak Lawn, IL 60453 \n\n McGrath City Mazda \n 3255 N Cicero Ave, Chicago, IL 60641 \n\n Wilkins Mazda \n 740 North York Road, Elmhurst, IL 60126",
            " Metro Ford Chicago \n 6455 S Western Ave, Chicago, IL 60636 \n\n Fox Ford Chicago \n 2501 N Elston Ave, Chicago, IL 60647 \n\n Al Piemonte Ford Chicago \n 2500 W North Ave, Melrose Park, IL 60160",
            " Rogers Hyundai \n 2700 S Michigan Ave, Chicago, IL 60616 \n\n  Knauz Hyundai \n 775 Rockland Rd, Lake Bluff, IL 60044 \n\n McGrath City Hyundai \n 6750 W Grand Ave., Chicago, IL 60707",
            " Volkswagen of Downtown Chicago \n 1111 N Clark St, Chicago, IL 60610 \n\n Volkswagen of Oak Lawn \n 8920 S Cicero Ave, Oak Lawn, IL 60453 \n\n Highland Volkswagen \n 9601 Indianapolis Blvd, Highland, IN 46322"};

    Intent mIntent = getIntent();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView dealershipView = new ListView(this);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 0, dealerships[getIntent().getIntExtra(EXTRA_RES_ID, 0)].split("\n\n")){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                RelativeLayout carLayout = new RelativeLayout(getContext());
                TextView dealershipText = new TextView(getContext());
                dealershipText.setText(getItem(position));
//                dealershipText.setText(dealerships[mIntent.getIntExtra(EXTRA_RES_ID, 0)]);
                carLayout.addView(dealershipText);
                return carLayout;
            }
        };
        dealershipView.setAdapter(adapter);
        setContentView(dealershipView);
    }


}
