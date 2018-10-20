package com.example.android.news_application;

import android.content.Context;

import java.util.List;

public class Loader extends android.content.AsyncTaskLoader<List<News>> {
    private String mUrl;

    public Loader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if(mUrl == null) {
            return null;
        }
        return QueryUtils.fetchNewsData(mUrl);
    }
}
