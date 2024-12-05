package com.aspprothes.sanatanshastra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

import soup.neumorphism.NeumorphImageView;
import soup.neumorphism.NeumorphTextView;

public class HomeGridLayout extends AppCompatActivity {
    private GridView gridView;
    private NetworkConnectionCheckPopUp networkConnectionCheckPopUp = new NetworkConnectionCheckPopUp();
    private ArrayList< HashMap<String,String> > gridArrayList = new ArrayList<>();
    private HashMap<String,String> gridHashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.logo_releted_color_1));
        this.getWindow().setNavigationBarColor(getColor(R.color.logo_releted_color_1));
        setContentView(R.layout.home_grid_layout);

        gridView = findViewById(R.id.gridView);

        myGridItems();

        CustomHomeGridBaseAdapter customHomeGridBaseAdapter = new CustomHomeGridBaseAdapter();
        gridView.setAdapter(customHomeGridBaseAdapter);

    }

    // Grid Items Value Input Here =========================
    public void myGridItems(){
        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Vedas");
        gridHashMap.put("gridItemImg","https://www.researchgate.net/profile/Vijay-Mishra-10/publication/352785786/figure/fig3/AS:1039571676565511@1624864610767/Fig-3-Images-of-books-of-four-Vedas-and-a-page-of-veda-Physiological-concepts-of.jpg");
        gridHashMap.put("catagory","ved");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 2");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 3");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 4");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 1");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 2");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 3");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);

        gridHashMap = new HashMap<>();
        gridHashMap.put("gridItemName","Demo 4");
        gridHashMap.put("gridItemImg","");
        gridHashMap.put("catagory","");
        gridArrayList.add(gridHashMap);
    }

    public class CustomHomeGridBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return gridArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.home_grid_items_layout,parent,false);
            }
            NeumorphImageView imageView = convertView.findViewById(R.id.imageView);
            NeumorphTextView textView = convertView.findViewById(R.id.textView);

            HashMap<String,String> hashMap = new HashMap<>();
            hashMap = gridArrayList.get(position);
            String title = hashMap.get("gridItemName");
            String catagory = hashMap.get("catagory");
            String img_url = hashMap.get("gridItemImg");

            textView.setText(""+title);

            Glide.with(HomeGridLayout.this)
                    .load(img_url)
                    .placeholder(R.drawable.placeholder_loading)
                    .circleCrop()
                    .into(imageView);

            return convertView;
        }
    }



    //================================================================================================================================
    //================================================================================================================================
    //================================================================================================================================
    //================================================================================================================================
    //================================================================================================================================


    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(HomeGridLayout.this)
                    .setTitle("Warning")
                    .setMessage("Do you want to exit this app ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(true)
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.logo_releted_color_1));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.logo_releted_color_1));
        }else{
            super.onBackPressed();
        }
    }



    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectionCheckPopUp,intentFilter);
        super.onStart();
    }



    @Override
    protected void onStop() {
        unregisterReceiver(networkConnectionCheckPopUp);
        super.onStop();
    }
}