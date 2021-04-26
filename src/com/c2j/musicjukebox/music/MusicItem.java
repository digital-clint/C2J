package com.c2j.musicjukebox.music;

import java.sql.Date;

public class MusicItem {
    private String title;
    private String artist;
    // place holder data for enum
    private Date year;
    private String album;
    private static final double DEFAULT_PRICE = 0.25;

    public MusicItem() {

    }

    // both of two enum must go in here
    public MusicItem(String title, String artist, String year) {
        this(title, artist,Date.valueOf(year));
    }

    public MusicItem(String title, String artist, Date year) {
        setTitle(title);
        setArtist(artist);
        setYear(year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    // toString method must be updated after we have enum
    @Override
    public String toString() {
        return "MusicItem{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", album='" + album + '\'' +
                '}';
    }
}
