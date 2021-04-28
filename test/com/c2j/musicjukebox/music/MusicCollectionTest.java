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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    @Test
    public void testFindByRegionExactMatchingStringUpperCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByRegion("ASIA");
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    @Test
    public void testFindByRegionExactMatchingStringLowerCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByRegion("asia");
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    // CASE 1.1: Exact Matching using String Input
    @Test
    public void testFindByRegionExactMatchingEnumInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByRegion(MusicRegions.ASIA);
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }


    // CASE 2: Partially Matching
    @Test
    public void testFindByRegionPartiallyMatchingStringInputSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "As"
        // if it could not find "As" then it will look for a song starts with "A"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByRegion("As");
        List<String> actualMusicItemTitle = new ArrayList<>();
        actualMusicItemTitle = matchingPartiallyDataActual.stream()
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    @Test
    public void testFindByRegionPartiallyMatchingStringInputUpperCaseSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "AS"
        // if it could not find "AS" then it will look for a song starts with "A"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByRegion("AS");
        List<String> actualMusicItemTitle = new ArrayList<>();
        actualMusicItemTitle = matchingPartiallyDataActual.stream()
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    @Test
    public void testFindByRegionPartiallyMatchingStringInputLowerCaseSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "as"
        // if it could not find "as" then it will look for a song starts with "a"
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByRegion("as");
        List<String> actualMusicItemTitle = new ArrayList<>();
        actualMusicItemTitle = matchingPartiallyDataActual.stream()
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
        assertEquals(expectedMusicTitle, actualMusicItemTitle);
    }

    // CASE 2: More Partially Matching
    @Test
    public void testFindByRegionPartiallyMatchingStringInputSingleLetterSuccess() {
        // Since Song title "be" does not exist in the dataset
        // this will print every song that is starts with "as"
        // if it could not find "as" then it will look for a song starts with "a"

        // NOTICE: in this case it will search any regions that starts with 'a'
        // Asia, Africa, Australia
        Collection<MusicItem> matchingPartiallyDataActual = defaultCollection.findByRegion("a");
        List<String> actualMusicItemTitle = new ArrayList<>();
        actualMusicItemTitle = matchingPartiallyDataActual.stream()
                .map(item -> item.getTitle())
                .sorted()
                .collect(Collectors.toList());
        // System.out.println(actualMusicItemTitle);
        final int expectedSize = 18;
        final int actualSize = actualMusicItemTitle.size();
        assertEquals(expectedSize, actualSize);
    }

    // CASE 3: Exception
    @Test (expected = IllegalArgumentException.class)
    public void testFindByRegionEmptyStringInput() {
        Collection<MusicItem> nullData = defaultCollection.findByRegion("");
    }

    @Test
    public void testFindByRegionZeroPartial() {
        final String exceptionMessage = "IllegalArgumentException=>findByTitle(String targetTitle)" +
                " we cannot find any matching song or contains any character you had inserted in";
        Collection<MusicItem> randomNoMatchingData = null;
        try {
            randomNoMatchingData = defaultCollection.findByRegion("#$%^");
            fail("This line should never get run. Must throw an exception");
        } catch (IllegalArgumentException iae) {
            assertEquals(exceptionMessage, iae.getMessage());
        }
    }

    // ============================================
    // =============== FindByArtist ================

    // CASE 1: Exact Matching
    @Test
    public void testFindByArtistExactMatchingStringInputSucess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("Twenty one Pilots");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByArtistExactMatchingStringUpperCaseInputSucess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("TWENTY ONE PILOTS");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByArtistExactMatchingStringLowerCaseInputSucess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("twenty one pilots");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    // CASE 2: Partially Matching
    @Test
    public void testFindByArtistPartiallyMatchingStringInputSuccess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("Twen");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByArtistPartiallyMatchingStringInputUpperCaseSuccess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("TWE");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    @Test
    public void testFindByArtistPartiallyMatchingStringInputLowerCaseSuccess() {
        Collection<MusicItem> musicMatchingData = defaultCollection.findByArtist("twe");
        // System.out.println(musicMatchingData);
        String actualMusicTitle = musicMatchingData.stream()
                .map(song -> song.getTitle())
                .collect(Collectors.joining());
        String expectedMusicTitle = "Holding On To You";
        assertEquals(expectedMusicTitle, actualMusicTitle);
    }

    // CASE 3: Exception
    @Test (expected = IllegalArgumentException.class)
    public void testFindByArtistNullStringInput() {
        Collection<MusicItem> nullData = defaultCollection.findByArtist(null);
        fail("This should never get here");
    }

    @Test
    public void testFindByArtistEmptyStringInput() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByArtist(String targetArtist)" +
                " you must put target title as input.";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByArtist("");
            fail("This should never get here");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testFindByArtistZeroPartial() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByArtist(String targetArtist)" +
                " we cannot find any matching song or contains any character you had inserted in";
        Collection<MusicItem> notMatchingAndPartial = null;
        try {
            notMatchingAndPartial = defaultCollection.findByArtist("#$^#@#$");
            fail("This should never get here");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // ==================================
    // ========= Find By Genre ==========

    // CASE 1: Exact Matching
    // CASE 1.1: String input
    @Test
    public void testFindByGenreExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("Blues");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    @Test
    public void testFindByGenreExactMatchingStringUpperCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("BLUES");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    @Test
    public void testFindByGenreExactMatchingStringLowerCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("blues");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    // CASE 1.2: Enum input
    @Test
    public void testFindByGenreExactMatchingEnumInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre(MusicGenre.BLUES);
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    // CASE 2: Partially Matching
    @Test
    public void testFindByGenrePartiallyMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("Bl");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    @Test
    public void testFindByGenrePartiallyMatchingStringUpperCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("BLU");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    @Test
    public void testFindByGenrePatiallyMatchingStringLowerCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("blu");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    @Test
    public void testFindByGenrePartiallyMatchingLongerStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByGenre("blues music");
        // System.out.println(matchingDataActual);
        final int expectedBluesSize = 6;
        final int actualBluesSize = matchingDataActual.size();
        assertEquals(expectedBluesSize, actualBluesSize);

        List<String> actualBluesTitles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Acoustic Chicken");
        expectedBluesTitles.add("Bakoytereye");
        expectedBluesTitles.add("Been Here Before");
        expectedBluesTitles.add("Holding On To You");
        expectedBluesTitles.add("Pain And Misery");
        expectedBluesTitles.add("You Got It Diz");
        assertEquals(expectedBluesTitles, actualBluesTitles);
    }

    // CASE 3: Exception
    @Test (expected = IllegalArgumentException.class)
    public void testFindByGenreNullInput() {
        String nullString = null;
        Collection<MusicItem> nullData = defaultCollection.findByGenre(nullString);
        fail("This line of code should never run");
    }

    @Test
    public void testFindByGenreEmptyStringInput() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByGenre(String targetGenre)" +
                " you must put target title as input.";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByGenre("");
            fail("This line of code should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testFindByGenreNotEvenPartiallyMatching() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByGenre(String targetGenre)" +
                " we cannot find any matching song or contains any character you had inserted in";
        Collection<MusicItem> notEvenPartialData = null;
        try {
            notEvenPartialData = defaultCollection.findByGenre("!@#$");
            fail("This line of code should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }

    }

    // ====================================
    // ========== Find By Year ============

    // CASE 1: Exact Matching
    @Test
    public void testFindYearExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByYear("2010");
        System.out.println(matchingDataActual);
        final int expectedReleasedIn2010sSize = 4;
        final int actualReleased2010Size = matchingDataActual.size();
        assertEquals(expectedReleasedIn2010sSize, actualReleased2010Size);

        List<String> actualReleased2010Titles = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedBluesTitles = new ArrayList<>();
        expectedBluesTitles.add("Hammer Em Down");
        expectedBluesTitles.add("Hammer Em Down");
        expectedBluesTitles.add("Night Of The Living Junkies");
        expectedBluesTitles.add("WISDOMINANT");
        assertEquals(expectedBluesTitles, actualReleased2010Titles);
    }

    // CASE 2: Exception
    // CASE 2.1: null or zero
    @Test (expected = IllegalArgumentException.class)
    public void testFindYearNullInput() {
        Collection<MusicItem> nullData = defaultCollection.findByYear(null);
        fail("This line should never run");
    }

    @Test
    public void testFindYearEmptyInput() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByYear(String targetYear" +
                " you must put target year as input.";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByYear("");
            fail("This line should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // CASE 2.2: Input Length bigger than 4
    @Test
    public void testFindYearLengthLongerThanFourInput() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByYear(String targetYear" +
                " you must put year\nFor example: 2021.";
        Collection<MusicItem> lengthLongerThanFour = null;
        try {
            lengthLongerThanFour = defaultCollection.findByYear("123123");
            fail("This line should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // CASE 2.3: Input year that is bigger than current year
    @Test
    public void testFindYearInputBiggerThanCurrentYear() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByYear(String targetYear" +
                " you must put target year that is not in future as input.";
        Collection<MusicItem> futureYearData = null;
        try {
            // notice the year is future, this code written in 2021
            futureYearData = defaultCollection.findByYear("2040");
            fail("This line should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }


    // CASE 2.4: The year does not exist in the music data-set
    @Test
    public void testFindYearInputDoesNotExist() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByYear(String targetYear)" +
                " The year must only contains numbers";
        Collection<MusicItem> doesNotExistData = null;
        try {
            // notice the year is future, this code written in 2021
            doesNotExistData = defaultCollection.findByYear("!@#!@$");
            fail("This line should never run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // ====================================
    // ========== Find By Album ============

    // CASE 1: Exact Matching
    @Test
    public void testFindByAlbumExactMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("Kingfish");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    @Test
    public void testFindByAlbumExactMatchingStringUpperCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("KINGFISH");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    @Test
    public void testFindByAlbumExactMatchingStringLowerCaseInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("kingfish");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    // CASE 2: Partially Matching
    @Test
    public void testFindByAlbumPartiallyMatchingStringInputSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("King");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    @Test
    public void testFindByAlbumPartiallyMatchingStringInputUpperCaseSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("KIN");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    @Test
    public void testFindByAlbumPartiallyMatchingStringInputLowerCaseSuccess() {
        Collection<MusicItem> matchingDataActual = defaultCollection.findByAlbum("kin");
        // System.out.println(matchingDataActual);
        final int expectedAlbumSize = 1;
        final int actualAlbumSize = matchingDataActual.size();
        assertEquals(expectedAlbumSize, actualAlbumSize);

        List<String> actualAlbumMusicTitle = matchingDataActual.stream()
                .map(song -> song.getTitle())
                .sorted()
                .collect(Collectors.toUnmodifiableList());
        List<String> expectedAlbumMusicTitle = new ArrayList<>();
        expectedAlbumMusicTitle.add("Been Here Before");
        assertEquals(expectedAlbumMusicTitle, actualAlbumMusicTitle);
    }

    // CASE 3: Exception
    @Test (expected = IllegalArgumentException.class)
    public void testFindByAlbumNullInput() {
        Collection<MusicItem> nullData = defaultCollection.findByAlbum(null);
        fail("This line should not run");
    }

    @Test
    public void testFindByAlbumEmptyInput() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByAlbum(String targetAlbum)" +
                " you must put target title as input.";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByAlbum("");
            fail("This line should not run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testFindByAlbumNotExistPartial() {
        final String expectedExceptionMessage = "IllegalArgumentException=>findByAlbum(String targetAlbum)" +
                " we cannot find any matching song or contains any character you had inserted in";
        Collection<MusicItem> emptyData = null;
        try {
            emptyData = defaultCollection.findByAlbum("!@#asdf");
            fail("This line should not run");
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // need
    // displayAllMusic
    // play
    // printInvoice
}