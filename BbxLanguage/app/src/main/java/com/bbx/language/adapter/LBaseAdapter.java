package com.bbx.language.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbx.language.R;

import java.util.List;

public class LBaseAdapter extends BaseAdapter {

    private List<String> languages;
    private Context context;
    private int selected = 0;

    private ChangeLanguageCallback changeLanguageCallback;

    public interface ChangeLanguageCallback {
        public void selectAtIndex(int index);
    }

    public void setChangeLanguageCallback(ChangeLanguageCallback changeLanguageCallback) {
        this.changeLanguageCallback = changeLanguageCallback;
    }

    public LBaseAdapter(List<String> languages, Context context, int selected) {
        this.languages = languages;
        this.context = context;
        this.selected = selected;
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public Object getItem(int position) {
        return languages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        TextView languageText;
        ImageView iconState;

        final String text = (String) getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item_language, null);
            viewHolder.iconState = convertView.findViewById(R.id.languageIcon);
            viewHolder.languageText = convertView.findViewById(R.id.languageText);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        languageText = viewHolder.languageText;
        languageText.setText(text);
        iconState = viewHolder.iconState;
        if (selected == position) {
            iconState.setVisibility(View.VISIBLE);
        } else {
            iconState.setVisibility(View.GONE);
        }


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeLanguageCallback != null) {
                    changeLanguageCallback.selectAtIndex(position);
                }
            }
        });


        return convertView;
    }

    class ViewHolder {
        TextView languageText;
        ImageView iconState;
    }
}
