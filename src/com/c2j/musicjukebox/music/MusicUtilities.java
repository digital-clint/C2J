package com.c2j.musicjukebox.music;

import java.util.Collection;

public interface MusicUtilities {
    public Collection<MusicItem> findByTitle();
    public Collection<MusicItem> findByRegion();
    public Collection<MusicItem> findByArtist();
    public Collection<MusicItem> findByGenre();
    public Collection<MusicItem> findByYear();
    public void displayAllMusic();
    public void play();
    public void printInvoice();
}
