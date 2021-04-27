package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.util.Collection;

public interface MusicUtilities {
    public Collection<MusicItem> findByTitle(String targetTitle) throws IllegalArgumentException;
    // method overloading param is String
    public Collection<MusicItem> findByRegion(String targetByRegion);
    // method overloading param is Enum
    public Collection<MusicItem> findByRegion(MusicRegions targetByRegion);
    public Collection<MusicItem> findByArtist(String targetArtist);
    // method overloading param is String
    public Collection<MusicItem> findByGenre(String targetGenre);
    // method overloading param is Enum
    public Collection<MusicItem> findByGenre(MusicGenre targetGenre);
    // method overloading param is String
    public Collection<MusicItem> findByYear(String targetYear);
    // method overloading param is Date
    public Collection<MusicItem> findByYear(Date targetYear);
    public Collection<MusicItem> findByAlbum(String targetAlbum) throws IllegalArgumentException;
    public void displayAllMusic();
    public void play();
    public void printInvoice();
}
