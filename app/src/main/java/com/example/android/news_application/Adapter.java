package com.example.android.news_application;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<News> {

    List<News> mNewsList;

    public Adapter(@NonNull Context context, List<News> newsList) {
        super(context, 0, newsList);
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        News currentNews = mNewsList.get(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        String trimedDate = currentNews.getDate().substring(0, 10);

        TextView tvAuthor = (TextView) view.findViewById(R.id.author_text_view);
        tvAuthor.setText(currentNews.getAuthor());

        TextView tvTitle = (TextView) view.findViewById(R.id.title_text_view);
        tvTitle.setText(currentNews.getTitle());

        TextView tvDate = (TextView) view.findViewById(R.id.date_text_view);
        tvDate.setText(trimedDate);

        TextView tvType = (TextView) view.findViewById(R.id.type_text_view);
        tvType.setText(currentNews.getSection());

        return view;
    }
}
