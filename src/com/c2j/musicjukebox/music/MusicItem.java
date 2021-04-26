package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.IllegalFormatException;
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

    // take input as String just in case
    // method overloading
    public void setMusicGenre(String musicGenre)
            throws IllegalArgumentException{
        // if the argument pass through is string
        switch (musicGenre.toLowerCase()) {
            case "blues":
                this.musicGenre = MusicGenre.BLUES;
                break;
            case "classical":
                this.musicGenre = MusicGenre.CLASSICAL;
                break;
            case "classical_rock":
            case "classical rock":
                this.musicGenre = MusicGenre.CLASSIC_ROCK;
                break;
            case "country":
                this.musicGenre = MusicGenre.COUNTRY;
                break;
            case "jazz":
                this.musicGenre = MusicGenre.JAZZ;
                break;
            case "pop":
                this.musicGenre = MusicGenre.POP;
                break;
            case "rap":
                this.musicGenre = MusicGenre.RAP;
                break;
            case "rock":
                this.musicGenre = MusicGenre.ROCK;
                break;
            default:
                this.musicGenre = MusicGenre.NOT_SUPPORTED;
                throw new IllegalArgumentException("We are sorry, that music genre you typed " +
                        "is unsupported region in our music junk box." +
                        "\nWe support BLUES, CLASSICAL, CLASSIC_ROCK, " +
                        "COUNTRY, JAZZ, POP, RAP, ROCK");

        }
    }

    // return as MusicRegion (Enum)
    public MusicRegions getMusicRegions() {
        return musicRegions;
    }

    // @Param Enum MusicRegion
    public void setMusicRegions(MusicRegions musicRegions) {
        this.musicRegions = musicRegions;
    }

    // take input as String just in case
    // method overloading
    public void setMusicRegions(String musicRegions)
            throws NullPointerException, IllegalArgumentException {
        if (musicRegions == null || musicRegions.length() == 0) {
            throw new NullPointerException("MusicItem=> setMusicRegion(String musicRegions) " +
                    "parameter require.\nASIA, AFRICA, AUSTRALIA, EUROPE, " +
                    "\"NORTH_AMERICA, CENTRAL_SOUTH_AMERICA");
        }
        // if the argument pass through string is not matching with any regions
        // throw illegalArgumentException
        switch (musicRegions.toLowerCase()) {
            case "asia":
                this.musicRegions = MusicRegions.ASIA;
                break;
            case "africa":
                this.musicRegions = MusicRegions.AFRICA;
                break;
            case "australia":
                this.musicRegions = MusicRegions.AUSTRALIA;
                break;
            case "europe":
                this.musicRegions = MusicRegions.EUROPE;
                break;
            case "north_america":
            case "north america":
                this.musicRegions = MusicRegions.NORTH_AMERICA;
                break;
            case "central_south_america":
            case "central south america":
                this.musicRegions = MusicRegions.CENTRAL_SOUTH_AMERICA;
                break;
            default:
                this.musicRegions = MusicRegions.UNSUPPORTED;
                throw new IllegalArgumentException("We are sorry, that region you typed " +
                        "is unsupported region in our music junk box." +
                        "\nWe support ASIA, AFRICA, AUSTRALIA, EUROPE, " +
                        "NORTH_AMERICA, CENTRAL_SOUTH_AMERICA");
        }
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public void setYear(String year) throws IllegalFormatException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.format(year);
        } catch (IllegalFormatException e) {
            System.out.println("MusicItem=> setYear(String year) " + e.getMessage());
        }
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
