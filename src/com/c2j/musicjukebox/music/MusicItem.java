package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.IllegalFormatException;
import java.util.Objects;

public class MusicItem implements Comparable<MusicItem> {
    private String title;
    private String artist;
    private MusicGenre musicGenre;
    private MusicRegions musicRegions;
    private String year;
    private String album;
    private static final double DEFAULT_PRICE = 0.25;
    // counter to keep track how much song did it play
    private static int SONG_COUNTER = 0;

    public MusicItem() {

    }

    // Initialize MusicGenre and MusicRegion with received Enum datatype
    public MusicItem(String title, String artist, MusicGenre musicGenre, MusicRegions musicRegions, String year, String album) {
        setTitle(title);
        setArtist(artist);
        setMusicGenre(musicGenre);
        setMusicRegions(musicRegions);
        setYear(year);
        setAlbum(album);
    }

    // Initialize MusicGenre and Music Region with received String datatype
    public MusicItem(String title, String artist, String musicGenre, String musicRegions, String year, String album) {
        setTitle(title);
        setArtist(artist);
        setMusicGenre(musicGenre);
        setMusicRegions(musicRegions);
        setYear(year);
        setAlbum(album);
    }

    // overloading
    // Enum musicGenre, String musicRegion
    public MusicItem(String title, String artist, MusicGenre musicGenre, String musicRegions, String year, String album) {
        setTitle(title);
        setArtist(artist);
        setMusicGenre(musicGenre);
        setMusicRegions(musicRegions);
        setYear(year);
        setAlbum(album);
    }

    // overloading
    // String musicGenre, Enum musicRegion
    public MusicItem(String title, String artist, String musicGenre, MusicRegions musicRegions, String year, String album) {
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

    public void setTitle(String title) throws IllegalArgumentException {
        // if the length of the title is zero or null
        if (title == null || title.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setTitle(String title)" +
                    " the parameter is empty or null");
        }
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) throws IllegalArgumentException {
        // if the length of the artist is zero or null
        if (artist == null || artist.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setArtist(String artist)" +
                    " the parameter is empty or null");
        }
        this.artist = artist;
    }

    public String getYear() {
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
        if (musicGenre == null || musicGenre.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setMusicGenre(String musicGenre)" +
                    " the parameter is empty or null");
        }
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
    public void setMusicRegions(String musicRegions) throws IllegalArgumentException {
        if (musicRegions == null || musicRegions.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setMusicRegion(String musicRegions) " +
                    "parameter require.\nASIA, AFRICA, AUSTRALIA, EUROPE, " +
                    "NORTH_AMERICA, CENTRAL_SOUTH_AMERICA");
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

    public void setYear(String year) throws IllegalArgumentException {
        // input year should not be null or 0
        if (year == null || year.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setYear(String year)"+
                    " the parameter is empty or null");
        }
        if (year.trim().length() != 4) {
            throw new IllegalArgumentException("IllegalArgumentException=>setYear(String year)"+
                    " the parameter should be four length long");
        }

        // get current year to check if user input makes sense
        int currentYearInInteger = Calendar.getInstance().get(Calendar.YEAR);
        int yearInputInInteger = Integer.parseInt(year);
        if (yearInputInInteger > currentYearInInteger) {
            throw new IllegalArgumentException("IllegalArgumentException=>setYear(String year)" +
                    " the parameter is empty or null");
        }
        this.year = year;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) throws IllegalArgumentException {
        if (album == null || album.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>setAlbum(String album)"+
                    " the parameter is empty or null");
        }
        this.album = album;
    }

    public static double getDefaultPrice() {
        return DEFAULT_PRICE;
    }

    synchronized public void play() {
        // increase song counter
        SONG_COUNTER++;
        // created thread

        Thread playSongThread = new Thread();
        System.out.println(getTitle() + " is playing ♪ ♪ ♫");
        try {
            playSongThread.sleep(3000);
            System.out.println(getTitle() + " is Finished.");
        } catch (InterruptedException e) {}
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
