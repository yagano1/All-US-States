package com.example.linh.test1;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by linh on 4/25/2016.
 */
public class countryListAdapter extends BaseAdapter {
    private Context mContext;
    private List<country> mCountry;

    public countryListAdapter(Context mContext,List<country> mCountry) {
        this.mContext = mContext;
        this.mCountry = mCountry;
    }

    @Override
    public int getCount() {
        return mCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return mCountry.get(position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.country_listview,null);
        TextView countryName = (TextView) v.findViewById(R.id.countryName);
        TextView countryCode = (TextView) v.findViewById(R.id.countryCode);
        ImageView countryImg = (ImageView) v.findViewById(R.id.countryImg);
        countryName.setText(mCountry.get(position).getName());
        countryCode.setText(mCountry.get(position).getCode());
        countryImg.setImageURI(Uri.parse("@drawable/"+mCountry.get(position).getImg()));
        return null;
    }
}
