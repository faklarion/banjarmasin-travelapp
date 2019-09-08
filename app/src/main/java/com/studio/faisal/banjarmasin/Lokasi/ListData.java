package com.studio.faisal.banjarmasin.Lokasi;

/**
 * Created by Faisal on 19/02/2019.
 */

public class ListData {
    private int id;
    private String title;
    private String shortdesc;
    private int image;

    public ListData(int id, String title, String shortdesc, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public int getImage() {
        return image;
    }
}
