package com.c2j.musicjukebox.music;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    // CASE 1: Exact Matching
    @Test
    public void testFindByTitleExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByTitle("Been Here Before");
        String actualMusicTitle = matchingDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByTitleExactMatchingStringUpperCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByTitle("BEEN HERE BEFORE");
        String actualMusicTitle = matchingDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByTitleExactMatchingStringInputLowerCaseSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByTitle("been here before");
        String actualMusicTitle = matchingDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    // CASE 2: Partially Matching
    @Test
    public void testFindByTitlePartiallyMatchingStringInputSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "Be"
        // if it could not find "be" then it will look for a song starts with "B"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByTitle("Be");
        System.out.println(matchingPartiallyDataActual);
        String actualMusicTitle = matchingPartiallyDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByTitlePartiallyMatchingStringInputUpperCaseSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "BE"
        // if it could not find "be" then it will look for a song starts with "B"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByTitle("BE");
        System.out.println(matchingPartiallyDataActual);
        String actualMusicTitle = matchingPartiallyDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByTitlePartiallyMatchingStringInputLowerCaseSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "be"
        // if it could not find "be" then it will look for a song starts with "b"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByTitle("be");
        System.out.println(matchingPartiallyDataActual);
        String actualMusicTitle = matchingPartiallyDataActual.stream()
                .map(s -> s.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Been Here Before";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    // CASE 3: Exception
    @Test (expected = IllegalArgumentException.class)
    public void testFindByTitleNullStringInput() {
        Collection<MusicItem> nullData = defaultCollection.findByTitle(null);
    }

    @Test
    public void testFindByTitleEmptyStringInput() {
        final String exceptionMessage = "IllegalArgumentException=>findByTitle(String targetTitle) " +
                "you must put target title as input.";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByTitle("");
            fail("This line should never run. Must throw an exception");
        } catch (IllegalArgumentException iae) {
            assertEquals(exceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testFindByTitleZeroPartial() {
        final String exceptionMessage = "IllegalArgumentException=>findByTitle(String targetTitle) " +
                "we cannot find any matching song or contains any character you had inserted in";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByTitle("#;=-");
            fail("This line should never run. Must throw an exception");
        } catch (IllegalArgumentException iae) {
            assertEquals(exceptionMessage, iae.getMessage());
        }
    }

    // ============================================
    // =============== FindByRegion ================

    // CASE 1: Exact Matching using String Input
    @Test
    public void testFindByRegionExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByRegion("Asia");
        // System.out.println(matchingDataActual);
        final int expectedSize = 6;
        final int actualSize = matchingDataActual.size();
        assertEquals(expectedSize, actualSize);

        List<String> actualMusicItemTitle = new ArrayList<>();
        actualMusicItemTitle = matchingDataActual.stream()
                .map(item -> item.getTitle())
                .sorted()
                .collect(Collectors.toList());
        // System.out.println(actualMusicItemTitle);
        List<String> expectedMusicTitle = new ArrayList<>();
        expectedMusicTitle.add("Acoustic Chicken");
        expectedMusicTitle.add("Boom Boom Boys");
        expectedMusicTitle.add("Goyard");
        expectedMusicTitle.add("Main Ka Karoon Ram");
        expectedMusicTitle.add("Silent Jealousy");
        expectedMusicTitle.add("WISDOMINANT");
        assertEquals(expectedMusicTitle, expectedMusicTitle);
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