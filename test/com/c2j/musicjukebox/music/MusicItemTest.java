package com.c2j.musicjukebox.music;

import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.MutableCallSite;
import java.sql.Date;

import static org.junit.Assert.*;

public class MusicItemTest {

    MusicItem basicMusicItemAllString = null;
    @Before
    public void setUp() {
        basicMusicItemAllString =
                new MusicItem("SongTitle1", "Artist1",
                        "pop", "asia",
                        "1990", "album1");
    }

    // ============ Title ============
    @Test
    public void testGetTitleSuccess() {
        String expectedTitle = "SongTitle1";
        String actualTitle = basicMusicItemAllString.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testSetTitleToNullFail() {
        // this test is to make sure it throws exception
        String expectedExceptionMessage = "IllegalArgumentException=>setTitle(String title)" +
                " the parameter is empty or null";
        MusicItem musicItemNullTitle = null;
        try {
            musicItemNullTitle = new MusicItem(null, "Artist1",
                    "pop", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicItemNullTitle);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testSetTitleToEmptyFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setTitle(String title)" +
                " the parameter is empty or null";
        MusicItem musicItemEmptyTitle = null;
        try {
            musicItemEmptyTitle = new MusicItem("", "Artist1",
                    "pop", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicItemEmptyTitle);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // =========== Artist =============
    @Test
    public void testGetArtistSuccess() {
        String expectedArtist = "Artist1";
        String acutalArtist = basicMusicItemAllString.getArtist();
        assertEquals(expectedArtist, acutalArtist);
    }

    @Test
    public void testSetArtistToNullFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setArtist(String artist)" +
                " the parameter is empty or null";
        MusicItem musicItemNullArtist = null;
        try {
            musicItemNullArtist = new MusicItem("SongTitle1", null,
                    "pop", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicItemNullArtist);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testSetArtistToEmptyFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setArtist(String artist)" +
                " the parameter is empty or null";
        MusicItem musicEmptyArtist = null;
        try {
            musicEmptyArtist = new MusicItem("SongTitle1", "",
                    "pop", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicEmptyArtist);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // =========== Year =============
    @Test
    public void testGetYearSuccess() {
        String expectedDate = "1990";
        String actualDate = basicMusicItemAllString.getYear();
        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testSetYearUsingStringSuccess() {
        MusicItem musicSetYearString = null;
        musicSetYearString = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        String actualDate = musicSetYearString.getYear();
        assertEquals("1990", actualDate);
    }

    @Test
    public void testSetYearEmptyStringFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setYear(String year)"+
                " the parameter is empty or null";
        MusicItem musicEmptyYear = null;
        try {
            musicEmptyYear = new MusicItem("SongTitle1", "Artist1",
                    "pop", "asia",
                    "", "album1");
            fail("This should never print it out");
            System.out.println(musicEmptyYear);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testSetYearNullFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setYear(String year)"+
                " the parameter is empty or null";
        MusicItem musicNullYear = null;
        try {
            musicNullYear = new MusicItem("SongTitle1", "Artist1",
                    "pop", "asia",
                    null, "album1");
            fail("This should never print it out");
            System.out.println(musicNullYear);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // ========== MusicGenre ==============

    @Test
    public void testGetMusicGenreSuccess() {
        MusicGenre expectedGenre = MusicGenre.POP;
        MusicGenre actualGenre = basicMusicItemAllString.getMusicGenre();
        System.out.println(expectedGenre);
        System.out.println(actualGenre);
        assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testSetMusicGenreUsingStringSuccess() {
        MusicItem musicSetMusicGenrerString = null;
        musicSetMusicGenrerString = new MusicItem("SongTitle1", "Artist1",
                "blues", "asia",
                "1990", "album1");
        MusicGenre expectedGenre = MusicGenre.BLUES;
        MusicGenre actualGenre = musicSetMusicGenrerString.getMusicGenre();
        assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testSetMusicGenreUsingEnumSuccess() {
        MusicItem musicSetMusicGenrerEnum = null;
        musicSetMusicGenrerEnum = new MusicItem("SongTitle1", "Artist1",
                MusicGenre.BLUES, "asia",
                "1990", "album1");
        MusicGenre expectedGenre = MusicGenre.BLUES;
        MusicGenre actualGenre = musicSetMusicGenrerEnum.getMusicGenre();
        assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testSetMusicGenreUsingStringFail() {
        String expectedExceptionMessage = "We are sorry, that music genre you typed " +
                "is unsupported region in our music junk box." +
                "\nWe support BLUES, CLASSICAL, CLASSIC_ROCK, " +
                "COUNTRY, JAZZ, POP, RAP, ROCK";
        MusicItem musicNullGenre = null;
        try {
            // notice that musicGenre is something else
            musicNullGenre = new MusicItem("SongTitle1", "Artist1",
                    "asdf", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicNullGenre);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testSetMusicGenreUsingEmptyStringFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setMusicGenre(String musicGenre)" +
                " the parameter is empty or null";
        MusicItem musicNullGenre = null;
        try {
            // notice that musicGenre is something else
            musicNullGenre = new MusicItem("SongTitle1", "Artist1",
                    "", "asia",
                    "1990-01-03", "album1");
            fail("This should never print it out");
            System.out.println(musicNullGenre);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // ========= Music Region ==========

    @Test
    public void testGetMusicRegionSuccess() {
        MusicRegions expectedRegion = MusicRegions.ASIA;
        MusicRegions actualRegion = basicMusicItemAllString.getMusicRegions();
        assertEquals(expectedRegion, actualRegion);
    }

    @Test
    public void testSetMusicRegionUsingStringSuccess() {
        MusicItem musicSetMusicRegionString = null;
        musicSetMusicRegionString = new MusicItem("SongTitle1", "Artist1",
                "classical rock", "North america",
                "1990", "album1");
        MusicRegions expectedRegion = MusicRegions.NORTH_AMERICA;
        MusicRegions actualRegion = musicSetMusicRegionString.getMusicRegions();
        assertEquals(expectedRegion, actualRegion);
    }

    @Test
    public void testSetMusicRegionUsingEnumSuccess() {
        MusicItem musicSetMusicRegionEnum = null;
        musicSetMusicRegionEnum = new MusicItem("SongTitle1", "Artist1",
                "blues", MusicRegions.AUSTRALIA,
                "1990", "album1");
        MusicRegions expectedRegion = MusicRegions.AUSTRALIA;
        MusicRegions actualRegion = musicSetMusicRegionEnum.getMusicRegions();
        assertEquals(expectedRegion, actualRegion);
    }

    @Test
    public void testSetMusicRegionUsingStringFail() {
        String expectedExceptionMessage = "We are sorry, that region you typed" +
                " is unsupported region in our music junk box." +
                "\nWe support ASIA, AFRICA, AUSTRALIA, EUROPE, " +
                "NORTH_AMERICA, CENTRAL_SOUTH_AMERICA";
        MusicItem musicRandomRegion = null;
        try {
            // notice that musicGenre is something else
            musicRandomRegion = new MusicItem("SongTitle1", "Artist1",
                    "rock", "asdfasdf",
                    "1990", "album1");
            fail("This should never print it out");
            System.out.println(musicRandomRegion);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    @Test
    public void testSetMusicRegionUsingEmptyStringFail() {
        String expectedExceptionMessage = "IllegalArgumentException=>setMusicRegion(String musicRegions) " +
                "parameter require.\nASIA, AFRICA, AUSTRALIA, EUROPE, " +
                "NORTH_AMERICA, CENTRAL_SOUTH_AMERICA";
        MusicItem musicEmptyRegion = null;
        try {
            // notice that musicGenre is something else
            musicEmptyRegion = new MusicItem("SongTitle1", "Artist1",
                    "rap", "",
                    "1990", "album1");
            fail("This should never print it out");
            System.out.println(musicEmptyRegion);
        } catch (IllegalArgumentException iae) {
            assertEquals(expectedExceptionMessage, iae.getMessage());
        }
    }

    // ============ Album ==============

    @Test
    public void testGetAlbumSuccess() {
        String expectedAlbum = "album1";
        String actualAlbum = basicMusicItemAllString.getAlbum();
        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetAlbumToNullFail() {
        // null should throw an illegal argument exception
        MusicItem musicItemNullAlbum = null;
        musicItemNullAlbum = new MusicItem("SongTitle1", "artist1",
                "pop", "asia",
                "1990", null);
        fail("This should never print it out");
        System.out.println(musicItemNullAlbum);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetAlbumToEmptyFail() {
        // Empty string should throw an illegal argument exception
        MusicItem musicItemNullAlbum = null;
        musicItemNullAlbum = new MusicItem("SongTitle1", "artist1",
                "pop", "asia",
                "1990", "");
        fail("This should never print it out");
        System.out.println(musicItemNullAlbum);
    }

    @Test
    public void getDefaultPrice() {
        final double EXPECTED_DEFAULT_PRICE = 0.25;
        double expectedDefaultPrice = MusicItem.getDefaultPrice();
        assertEquals(EXPECTED_DEFAULT_PRICE, expectedDefaultPrice, 0.0001);
    }

    @Test
    public void testEquals() {
        // compare actual object
        MusicItem musicItem1 = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        MusicItem musicItem2 = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        assertEquals(musicItem1, musicItem2);
    }

    @Test
    public void testNotEquals() {
        // compare actual object
        MusicItem musicItem1 = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        MusicItem musicItem2 = new MusicItem("SongTitle1", "Artist1",
                MusicGenre.BLUES, "asia",
                "1990", "album1");
        assertNotEquals(musicItem1, musicItem2);
    }

    @Test
    public void testDifferentMemoryAddress() {
        // compare actual object
        MusicItem musicItem1 = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        MusicItem musicItem2 = new MusicItem("SongTitle1", "Artist1",
                "pop", "asia",
                "1990", "album1");
        assertNotSame(musicItem1, musicItem2);
    }
}