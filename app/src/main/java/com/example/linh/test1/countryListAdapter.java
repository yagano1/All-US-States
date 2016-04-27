package com.example.linh.test1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by linh on 4/25/2016.
 */
public class countryListAdapter extends BaseAdapter {
    private Context mContext;
    private String[] countryName;
    private String[] countryCode;
    private TypedArray countryImg;
    public countryListAdapter(Context mContext, String[] countryName, String[] CountryCode, TypedArray countryImg) {
        this.mContext = mContext;
        this.countryName = countryName;
        this.countryCode = CountryCode;
        this.countryImg = countryImg;

    }
    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.country_listview, null);
            holder = new ViewHolder();
            holder.textViewCountryName = (TextView) convertView.findViewById(R.id.countryName);
            holder.textViewCountryCode = (TextView) convertView.findViewById(R.id.countryCode);
            holder.imageViewCountry = (ImageView) convertView.findViewById(R.id.countryImg);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textViewCountryName.setText(countryName[position]);
        holder.textViewCountryCode.setText(countryCode[position]);
        holder.imageViewCountry.setImageResource(countryImg.getResourceId(position,-1));
        return convertView;
    }




    private static class ViewHolder
    {
        TextView textViewCountryName;
        TextView textViewCountryCode;
        ImageView imageViewCountry;

    }


}
