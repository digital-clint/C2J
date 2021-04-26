package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.util.Objects;

public class MusicItem implements Comparable<MusicItem> {
    private String title;
    private String artist;
    private MusicGenre musicGenre;
    private MusicRegions musicRegions;
    private Date year;
    private String album;
    private static final double DEFAULT_PRICE = 0.25;

    public MusicItem() {

    }

    // Method overloading (String for year)
    public MusicItem(String title, String artist, MusicGenre musicGenre, MusicRegions musicRegions ,String year, String album) {
        this(title, artist, musicGenre, musicRegions ,Date.valueOf(year), album);
    }

    public MusicItem(String title, String artist, MusicGenre musicGenre, MusicRegions musicRegions, Date year, String album) {
        setTitle(title);
        setArtist(artist);
        setMusicGenre(musicGenre);
        setMusicRegions(musicRegions);
        setYear(year);
        setAlbum(album);
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

    // return as MusicGenre (Enum)
    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    // @Param Enum musicGenre
    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    // return as MusicRegion (Enum)
    public MusicRegions getMusicRegions() {
        return musicRegions;
    }

    // @Param Enum MusicRegion
    public void setMusicRegions(MusicRegions musicRegions) {
        this.musicRegions = musicRegions;
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

    // ==========================================
    // =========== Override methods =============
    @Override
    public String toString() {
        return "MusicItem{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", musicGenre=" + musicGenre +
                ", musicRegions=" + musicRegions +
                ", year=" + year +
                ", album='" + album + '\'' +
                '}';
    }

    @Override
    public int compareTo(MusicItem o) {
        // basic compareTo or sorting is use the title
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem musicItem = (MusicItem) o;
        return Objects.equals(title, musicItem.title) && Objects.equals(artist, musicItem.artist)
                && musicGenre == musicItem.musicGenre && musicRegions == musicItem.musicRegions
                && Objects.equals(year, musicItem.year) && Objects.equals(album, musicItem.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, musicGenre, musicRegions, year, album);
    }
}
