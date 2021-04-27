package com.c2j.musicjukebox.music;

import java.util.*;
import java.util.Collection;

public class MusicCollection implements MusicUtilities {

    private static final List<MusicItem> musics = Arrays.asList(


    new MusicItem()
    );
    private static Queue<MusicItem> playlist = null;
    private static double totalMoneyEarned;



    @Override
    public Collection<MusicItem> findByTitle() {
        return null;
    }

    @Override
    public Collection<MusicItem> findByRegion() {
        return null;
    }

    @Override
    public Collection<MusicItem> findByArtist() {
        return null;
    }

    @Override
    public Collection<MusicItem> findByGenre() {
        return null;
    }

    @Override
    public Collection<MusicItem> findByYear() {
        return null;
    }

    @Override
    public Collection<MusicItem> findByAlbum() {
        return null;
    }

    @Override
    public void displayAllMusic() {

    }

    @Override
    public void play() {

    }

    @Override
    public void printInvoice() {

    }
}
