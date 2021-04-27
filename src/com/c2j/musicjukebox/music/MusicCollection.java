package com.c2j.musicjukebox.music;

import java.sql.Date;
import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class MusicCollection implements MusicUtilities {

    // private static final List<MusicItem> musics = Arrays.asList(
//    new MusicItem()
//    );
    // I will just put some random data for now (Dummy data)
    private static Collection<MusicItem> musicItemCollections = new ArrayList<>();
    static {
        musicItemCollections.add(new MusicItem("Shape of You", "Ed Sheeran",
                MusicGenre.POP, MusicRegions.NORTH_AMERICA, "2017-01-04", "Album1"));
        musicItemCollections.add(new MusicItem("See You Again", "Wiz Khalifa, Charlie Puth",
                MusicGenre.RAP, MusicRegions.NORTH_AMERICA, "2015-01-24", "Album2"));
        musicItemCollections.add(new MusicItem("Dynamite", "BTS",
                MusicGenre.POP, MusicRegions.ASIA, "2020-10-03", "Album10"));
        musicItemCollections.add(new MusicItem("Zombie", "The Cranberries",
                MusicGenre.ROCK, MusicRegions.EUROPE, "2021-02-15", "Album5"));
        musicItemCollections.add(new MusicItem("Rollin", "Brave Girls",
                MusicGenre.POP, MusicRegions.ASIA, "2017-05-24", "Album55"));
        musicItemCollections.add(new MusicItem("Rosllin", "Brave Girls",
                MusicGenre.POP, MusicRegions.ASIA, "2017-05-24", "Album55"));
        musicItemCollections.add(new MusicItem("Asllin", "Brave Girls",
                MusicGenre.POP, MusicRegions.ASIA, "2017-05-24", "Album55"));
    }

    private static Queue<MusicItem> playlist = null;
    private static double totalMoneyEarned;


    // Temp Constructor
    private MusicCollection() {
        // I do not think I needed it
    }

    public static MusicCollection createInstance() {
        return new MusicCollection();
    }

    public static Collection<MusicItem> getAllMusic() {
        return Collections.unmodifiableCollection(musicItemCollections);
    }
    // End of Temp Constructor

    @Override
    public Collection<MusicItem> findByTitle(String targetTitle) throws IllegalArgumentException {
        if (targetTitle == null || targetTitle.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByTitle(String targetTitle)" +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(targetTitle))
                .collect(Collectors.toList());

        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            // check if target title
            String firstCharactertargetTitle = targetTitle.substring(0);
            System.out.println(firstCharactertargetTitle);
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getTitle().toLowerCase()
                            .contains(firstCharactertargetTitle.toLowerCase()))
                    .filter(item -> item.getTitle().toUpperCase()
                            .contains(firstCharactertargetTitle.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // if the size of the collection is still null or zero
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByTitle(String targetTitle)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByRegion(String targetByRegion) {
        if (targetByRegion == null || targetByRegion.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByRegion(String targetByRegion)" +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getMusicRegions().toString()
                        .equalsIgnoreCase(targetByRegion))
                .collect(Collectors.toList());

        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            // check if target title
            String firstCharactertargetTitle = targetByRegion.substring(0);
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getMusicRegions().toString().toLowerCase()
                            .contains(firstCharactertargetTitle.toLowerCase()))
                    .filter(item -> item.getMusicRegions().toString().toUpperCase()
                            .contains(firstCharactertargetTitle.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // if the size of the collection is still null or zero
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByTitle(String targetTitle)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByRegion(MusicRegions targetByRegion) {
        return null;
    }

    @Override
    public Collection<MusicItem> findByArtist(String targetArtist) {
        if (targetArtist == null || targetArtist.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByArtist(String targetArtist) " +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getArtist().equalsIgnoreCase(targetArtist))
                .collect(Collectors.toList());

        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getArtist().toLowerCase().contains(targetArtist.toLowerCase()))
                    .filter(item -> item.getArtist().toUpperCase().contains(targetArtist.toUpperCase()))
                    .collect(Collectors.toList());
        }

        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByArtist(String targetArtist)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByGenre(String targetGenre) {
        return null;
    }

    @Override
    public Collection<MusicItem> findByGenre(MusicGenre targetGenre) {
        return null;
    }

    @Override
    public Collection<MusicItem> findByYear(String targetYear) {
        return null;
    }

    @Override
    public Collection<MusicItem> findByYear(Date targetYear) {
        return null;
    }

    @Override
    public Collection<MusicItem> findByAlbum(String targetAlbum) throws IllegalArgumentException {
        if (targetAlbum == null || targetAlbum.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByAlbum(String targetAlbum) " +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getAlbum().equalsIgnoreCase(targetAlbum))
                .collect(Collectors.toList());

        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getAlbum().toLowerCase().contains(targetAlbum.toLowerCase()))
                    .filter(item -> item.getAlbum().toUpperCase().contains(targetAlbum.toUpperCase()))
                    .collect(Collectors.toList());
        }

        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByAlbum(String targetAlbum)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
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
