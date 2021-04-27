package com.c2j.musicjukebox.music;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class MusicCollectionTest {

    private Collection<MusicItem> musicDataSets = null;
    private MusicCollection defaultCollection = null;

    @Before
    public void setUp() {
        defaultCollection = MusicCollection.createInstance();
        musicDataSets = MusicCollection.getAllMusic();
    }

    @Test
    public void testGetAllMusic() {
        Collection<MusicItem> totalMusicNumberExpect = MusicCollection.getAllMusic();
        int actual = 36;
        assertEquals(musicDataSets.size(), actual);
    }

    // ============================================
    // =============== FindByTitle ================
    @Test
    public void testFindByTitleExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByTitle("Been Here Before");
        System.out.println(matchingDataActual);
    }

    @Test
    public void findByRegion() {
    }

    @Test
    public void testFindByRegion() {
    }

    @Test
    public void findByArtist() {
    }

    @Test
    public void findByGenre() {
    }

    @Test
    public void testFindByGenre() {
    }

    @Test
    public void findByYear() {
    }

    @Test
    public void findByAlbum() {
    }

    @Test
    public void displayAllMusic() {
    }
}