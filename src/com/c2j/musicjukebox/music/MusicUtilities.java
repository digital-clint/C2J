package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.util.Collection;
import java.util.Queue;

public interface MusicUtilities {
    public Collection<MusicItem> findByTitle(String targetTitle) throws IllegalArgumentException;
    // method overloading param is String
    public Collection<MusicItem> findByRegion(String targetByRegion) throws IllegalArgumentException;
    // method overloading param is Enum
    public Collection<MusicItem> findByRegion(MusicRegions targetByRegion) throws IllegalArgumentException;
    public Collection<MusicItem> findByArtist(String targetArtist) throws IllegalArgumentException;
    // method overloading param is String
    public Collection<MusicItem> findByGenre(String targetGenre) throws IllegalArgumentException;
    // method overloading param is Enum
    public Collection<MusicItem> findByGenre(MusicGenre targetGenre) throws IllegalArgumentException;
    // method overloading param is String
    public Collection<MusicItem> findByYear(String targetYear) throws IllegalArgumentException;
    // method overloading param is Date
    // public Collection<MusicItem> findByYear(Date targetYear) throws IllegalArgumentException;
    public Collection<MusicItem> findByAlbum(String targetAlbum) throws IllegalArgumentException;
    public void displayAllMusic(String sortedWay) throws IllegalArgumentException;
    public void play(Queue<MusicItem> userSelectedSong) throws IllegalArgumentException;
    public void printInvoice();
    public void displayTop10PlayedSong();
}
