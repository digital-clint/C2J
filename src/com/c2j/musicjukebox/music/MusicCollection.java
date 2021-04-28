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
    private static MusicCollection musicCollection = null;

    static {
        musicItemCollections.add(new MusicItem("Goyard", "Keith Ape",
                MusicGenre.RAP, MusicRegions.ASIA, "2015", "MixtAPE #1"));
        musicItemCollections.add(new MusicItem("Main Ka Karoon Ram", "Lata Mangeshkar",
                MusicGenre.CLASSICAL, MusicRegions.ASIA, "1995", "In A Different Mood"));
        musicItemCollections.add(new MusicItem("Silent Jealousy", "X Japan",
                MusicGenre.ROCK, MusicRegions.ASIA, "2002", "Trance X"));
        musicItemCollections.add(new MusicItem("Acoustic Chicken", "Furusawa Ryojiro Quartet",
                MusicGenre.BLUES, MusicRegions.ASIA, "1976", "ou Wanna Rain"));
        musicItemCollections.add(new MusicItem("WISDOMINANT", "TRI4TH",
                MusicGenre.JAZZ, MusicRegions.ASIA, "2010", "Tri4th"));
        musicItemCollections.add(new MusicItem("Boom Boom Boys", "Kumi Koda",
                MusicGenre.POP, MusicRegions.ASIA, "2012", "Japonesque"));
        musicItemCollections.add(new MusicItem("Leave Me Alone", "Amaarae",
                MusicGenre.RAP, MusicRegions.AFRICA, "2020", "The Angel You Don't Know"));
        musicItemCollections.add(new MusicItem("Willow Song", "Miriam Makeba",
                MusicGenre.CLASSICAL, MusicRegions.AFRICA, "1964", "The Voice Of Africa"));
        musicItemCollections.add(new MusicItem("Marathon Dance", "Allez Allez",
                MusicGenre.ROCK, MusicRegions.AFRICA, "1981", "African Queen"));
        musicItemCollections.add(new MusicItem("Bakoytereye", "Ali Farka Touré",
                MusicGenre.BLUES, MusicRegions.AFRICA, "1987", "Ali Farka Touré"));
        musicItemCollections.add(new MusicItem("He's Gone Away", "Hugh Masekela",
                MusicGenre.JAZZ, MusicRegions.AFRICA, "1962", "Trumpet Africaine"));
        musicItemCollections.add(new MusicItem("Ladysmith Black Mambazo", "Nomathemba",
                MusicGenre.POP, MusicRegions.AFRICA, "1973", "Amabutho"));
        musicItemCollections.add(new MusicItem("Black Widow", "Iggy Azalea",
                MusicGenre.RAP, MusicRegions.AUSTRALIA, "2014", "Reclassified"));
        musicItemCollections.add(new MusicItem("Sonatina", "Ross Edwards",
                MusicGenre.CLASSICAL, MusicRegions.AUSTRALIA, "1972", "His Master's Voice"));
        musicItemCollections.add(new MusicItem("Why Won't They Talk To Me?", "Tame Impala",
                MusicGenre.ROCK, MusicRegions.AUSTRALIA, "2012", "Lonerism"));
        musicItemCollections.add(new MusicItem("Pain And Misery", "The Teskey Brothers",
                MusicGenre.BLUES, MusicRegions.AUSTRALIA, "2017", "Half Mile Harvest"));
        musicItemCollections.add(new MusicItem("Too Marvellous For Words", "Katie Noonan",
                MusicGenre.JAZZ, MusicRegions.AUSTRALIA, "2004", "Two Of A Kind"));
        musicItemCollections.add(new MusicItem("Never Coming Back", "Amy Shark",
                MusicGenre.POP, MusicRegions.AUSTRALIA, "2018", "Love Monster"));
        musicItemCollections.add(new MusicItem("Hammer Em Down", "Blade Brown",
                MusicGenre.RAP, MusicRegions.EUROPE, "2010", "Bags And Boxes"));
        musicItemCollections.add(new MusicItem("Straighten Up And Fly Right", "Voces8",
                MusicGenre.CLASSICAL, MusicRegions.EUROPE, "2008", "Evensong"));
        musicItemCollections.add(new MusicItem("Sparks", "Coldplay",
                MusicGenre.ROCK, MusicRegions.EUROPE, "2000", "Parachutes"));
        musicItemCollections.add(new MusicItem("Been Here Before", "Christone “Kingfish” Ingram",
                MusicGenre.BLUES, MusicRegions.EUROPE, "2019", "Kingfish"));
        musicItemCollections.add(new MusicItem("Not That Kind Of Girl", "Mindi Abair & the Boneshakers",
                MusicGenre.JAZZ, MusicRegions.EUROPE, "2019", "The Eastwest Sessions"));
        musicItemCollections.add(new MusicItem("Aural Exam", "Anna Abreu",
                MusicGenre.POP, MusicRegions.EUROPE, "2009", "Just A Pretty Face"));
        musicItemCollections.add(new MusicItem("Hammer Em Down", "Blade Brown",
                MusicGenre.RAP, MusicRegions.NORTH_AMERICA, "2010", "Bags And Boxes"));
        musicItemCollections.add(new MusicItem("Night Of The Living Junkies", "Kendrick Lamar",
                MusicGenre.CLASSICAL, MusicRegions.NORTH_AMERICA, "2010", "Overly Dedicated"));
        musicItemCollections.add(new MusicItem("The Pieces That Fall To Earth", "Christopher Cerrone",
                MusicGenre.ROCK, MusicRegions.NORTH_AMERICA, "2019", "The Pieces That Fall To Earth"));
        musicItemCollections.add(new MusicItem("Holding On To You", "twenty one pilots",
                MusicGenre.BLUES, MusicRegions.NORTH_AMERICA, "2011", "Regional At Best"));
        musicItemCollections.add(new MusicItem("I Heard It Through The Grapevine", "Bettye LaVette",
                MusicGenre.JAZZ, MusicRegions.NORTH_AMERICA, "1982", "Tell Me A Lie"));
        musicItemCollections.add(new MusicItem("Song Of Her", "Charles Lloyd",
                MusicGenre.POP, MusicRegions.NORTH_AMERICA, "1967", "Forest Flower"));
        musicItemCollections.add(new MusicItem("Don't Start Now", "Dua Lipa",
                MusicGenre.POP, MusicRegions.CENTRAL_SOUTH_AMERICA, "2020", "Future Nostalgia"));
        musicItemCollections.add(new MusicItem("Perra Del Futuro", "Tomasa Del Real",
                MusicGenre.RAP, MusicRegions.CENTRAL_SOUTH_AMERICA, "2018", "Bellaca Del Año"));
        musicItemCollections.add(new MusicItem("Prelude In E Flat Minor Op. 16 No. 4", "Gabriela Montero",
                MusicGenre.CLASSICAL, MusicRegions.CENTRAL_SOUTH_AMERICA, "2005", "Piano Recital"));
        musicItemCollections.add(new MusicItem("Big Baby Blues", "Ritchie Valens",
                MusicGenre.ROCK, MusicRegions.CENTRAL_SOUTH_AMERICA, "1959", "Ritchie"));
        musicItemCollections.add(new MusicItem("You Got It Diz", "David Sanchez",
                MusicGenre.BLUES, MusicRegions.CENTRAL_SOUTH_AMERICA, "1994", "The Departure"));
        musicItemCollections.add(new MusicItem("Lejos De Tu Amor", "Shakira",
                MusicGenre.POP, MusicRegions.CENTRAL_SOUTH_AMERICA, "1991", "Magia"));

    }

    private static Queue<MusicItem> playlist = null;
    private static double totalMoneyEarned;


    // private constructor
    private MusicCollection() {
    }

    public static MusicCollection createInstance() {
        if (musicCollection == null) {
            musicCollection = new MusicCollection();
        }
        return musicCollection;
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


        // best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getTitle().toLowerCase()
                            .startsWith(targetTitle.toLowerCase()))
                    .filter(item -> item.getTitle().toUpperCase()
                            .startsWith(targetTitle.toUpperCase()))
                    .collect(Collectors.toList());
        }


        // second best possible matching
        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            // check if target title
            // get every thing starts from partial
            for (int i = 0; i < targetTitle.length(); i++) {
                String firstCharactertargetTitle = targetTitle.substring(0, targetTitle.length() - i);
                // System.out.println(firstCharactertargetTitle);
                foundSongs = musicItemCollections.stream()
                        .filter(item -> item.getTitle().toLowerCase()
                                .startsWith(firstCharactertargetTitle.toLowerCase()))
                        .filter(item -> item.getTitle().toUpperCase()
                                .startsWith(firstCharactertargetTitle.toUpperCase()))
                        .collect(Collectors.toList());
            }
        }

        // if the size of the collection is still null or zero
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByTitle(String targetTitle)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByRegion(String targetByRegion) throws IllegalArgumentException {
        if (targetByRegion == null || targetByRegion.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByRegion(String targetByRegion)" +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getMusicRegions().toString()
                        .equalsIgnoreCase(targetByRegion))
                .sorted()
                .collect(Collectors.toList());

        // best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getMusicRegions().toString()
                            .toLowerCase()
                            .startsWith(targetByRegion.toLowerCase()))
                    .filter(item -> item.getMusicRegions().toString()
                            .toUpperCase()
                            .startsWith(targetByRegion.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // second best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            // System.out.println("Should not get here");
            for (int i = 0; i < targetByRegion.length(); i++) {
                String firstCharactertargetTitle = targetByRegion.substring(0, targetByRegion.length() - i);
                // System.out.println(firstCharactertargetTitle);
                foundSongs = musicItemCollections.stream()
                        .filter(item -> item.getMusicRegions().toString()
                                .toLowerCase()
                                .startsWith(firstCharactertargetTitle.toLowerCase()))
                        .filter(item -> item.getMusicRegions().toString()
                                .toUpperCase()
                                .startsWith(firstCharactertargetTitle.toUpperCase()))
                        .collect(Collectors.toList());
            }
        }

        // if the size of the collection is still null or zero
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByTitle(String targetTitle)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByRegion(MusicRegions targetByRegion) throws IllegalArgumentException {
        if (targetByRegion == null) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByRegion(String targetByRegion)" +
                    " you must put target title as input.");
        }

        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getMusicRegions() == targetByRegion)
                .sorted()
                .collect(Collectors.toList());

        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByRegion(MusicItem.Regions targetTitle)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByArtist(String targetArtist) throws IllegalArgumentException {
        if (targetArtist == null || targetArtist.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByArtist(String targetArtist)" +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getArtist().equalsIgnoreCase(targetArtist))
                .collect(Collectors.toList());

        // best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getArtist()
                            .toLowerCase()
                            .startsWith(targetArtist.toLowerCase()))
                    .filter(item -> item.getArtist()
                            .toUpperCase()
                            .startsWith(targetArtist.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // base logic for if there are no exact matching song
        if (foundSongs == null || foundSongs.size() == 0) {
            for (int i = 0; i < targetArtist.length(); i++) {
                String firstCharacterArtist = targetArtist.substring(0, targetArtist.length() - i);
                foundSongs = musicItemCollections.stream()
                        .filter(item -> item.getArtist().toLowerCase()
                                .startsWith(firstCharacterArtist.toLowerCase()))
                        .filter(item -> item.getArtist().toUpperCase()
                                .startsWith(firstCharacterArtist.toUpperCase()))
                        .collect(Collectors.toList());
            }
        }

        // cannot find what customer really wants
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByArtist(String targetArtist)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByGenre(String targetGenre) throws IllegalArgumentException {
        if (targetGenre == null || targetGenre.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByGenre(String targetGenre)" +
                    " you must put target title as input.");
        }

        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getMusicGenre().toString().equalsIgnoreCase(targetGenre))
                .sorted()
                .collect(Collectors.toList());

        // best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getMusicGenre().toString()
                            .toLowerCase()
                            .startsWith(targetGenre.toLowerCase()))
                    .filter(item -> item.getMusicGenre().toString()
                            .toUpperCase()
                            .startsWith(targetGenre.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // second best possible matching
        if (foundSongs == null || foundSongs.size() == 0) {
            for (int i = 0; i < targetGenre.length(); i++) {
                String firstCharactertargetTitle = targetGenre.substring(0, targetGenre.length() - i);
                // System.out.println(firstCharactertargetTitle);
                foundSongs = musicItemCollections.stream()
                        .filter(item -> item.getMusicGenre().toString()
                                .toLowerCase()
                                .startsWith(firstCharactertargetTitle.toLowerCase()))
                        .filter(item -> item.getMusicGenre().toString()
                                .toUpperCase()
                                .startsWith(firstCharactertargetTitle.toUpperCase()))
                        .collect(Collectors.toList());
            }
        }
        // cannot find what customer really wants
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByGenre(String targetGenre)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }

        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByGenre(MusicGenre targetGenre) throws IllegalArgumentException {
        if (targetGenre == null) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByGenre(MusicGenre targetGenre) " +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getMusicGenre() == targetGenre)
                .sorted()
                .collect(Collectors.toList());

        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByGenre(MusicGenre targetGenre) " +
                    " you must put target title as input.");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByYear(String targetYear) throws IllegalArgumentException {
        if (targetYear == null || targetYear.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByYear(String targetYear" +
                    " you must put target year as input.");
        }
        // check ascii for special character
        for (int i = 0; i < targetYear.length(); i++) {
            char eachLetter = targetYear.charAt(i);
            if (!(eachLetter >= '0' && eachLetter <= '9')) {
                // System.out.println("Got in here");
                throw new IllegalArgumentException("IllegalArgumentException=>findByYear(String targetYear)" +
                        " The year must only contains numbers");
            }
        }

        // check if user year input is length of 4
        if (targetYear.trim().length() > 4) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByYear(String targetYear" +
                    " you must put year\nFor example: 2021.");
        }
        int currentYearInteger = Calendar.getInstance().get(Calendar.YEAR);
        int userInputYearInteger = Integer.parseInt(targetYear);
        // check if user year input is not bigger than current year
        if (userInputYearInteger > currentYearInteger) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByYear(String targetYear" +
                    " you must put target year that is not in future as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getYear().equals(targetYear))
                .sorted()
                .collect(Collectors.toList());

        // if cannot find anything that
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByYear(String targetYear) " +
                    " you must put target targetYear as input.");
        }
        return foundSongs;
    }

    @Override
    public Collection<MusicItem> findByAlbum(String targetAlbum) throws IllegalArgumentException {
        if (targetAlbum == null || targetAlbum.length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByAlbum(String targetAlbum)" +
                    " you must put target title as input.");
        }
        Collection<MusicItem> foundSongs = null;
        foundSongs = musicItemCollections.stream()
                .filter(item -> item.getAlbum().equalsIgnoreCase(targetAlbum))
                .collect(Collectors.toList());

        // find the best possible match
        if (foundSongs == null || foundSongs.size() == 0) {
            foundSongs = musicItemCollections.stream()
                    .filter(item -> item.getAlbum()
                            .toLowerCase()
                            .startsWith(targetAlbum.toLowerCase()))
                    .filter(item -> item.getAlbum()
                            .toUpperCase()
                            .startsWith(targetAlbum.toUpperCase()))
                    .collect(Collectors.toList());
        }

        // base logic for if there are no exact matching song find something similar to the user
        if (foundSongs == null || foundSongs.size() == 0) {
            for (int i = 0; i < targetAlbum.length(); i++) {
                String firstCharactertargetAlbum = targetAlbum.substring(0, targetAlbum.length() - i);
                foundSongs = musicItemCollections.stream()
                        .filter(item -> item.getAlbum().toLowerCase().startsWith(firstCharactertargetAlbum.toLowerCase()))
                        .filter(item -> item.getAlbum().toUpperCase().startsWith(firstCharactertargetAlbum.toUpperCase()))
                        .sorted()
                        .collect(Collectors.toList());
            }
        }
        
        if (foundSongs == null || foundSongs.size() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>findByAlbum(String targetAlbum)" +
                    " we cannot find any matching song or contains any character you had inserted in");
        }
        return foundSongs;
    }

    @Override
    public void displayAllMusic(String sortedWay) throws IllegalArgumentException {
        if (sortedWay == null || sortedWay.trim().length() == 0) {
            throw new IllegalArgumentException("IllegalArgumentException=>displayAllMusic(String sortedWay)" +
                    " parameter cannot be null or empty");
        }
        switch (sortedWay.toLowerCase()) {
            case "region":
            case "r":
                displayAllMusicSortedByRegion();
                break;
            case "genre":
            case "g":
                displayAllMusicSortedByGenre();
                break;
            case "artist":
            case "a":
                displayAllMusicSortedByArtist();
                break;
            case "title":
            case "t":
                displayAllMusicSortedByTitle();
                break;
            case "year":
            case "y":
                displayAllMusicSortedByReleasedYear();
                break;
            default:
                System.out.println("Default Sorting: by title");
                displayAllMusicSortedByTitle();
                break;
        }
    }

    @Override
    public void play() {

    }

    @Override
    public void printInvoice() {

    }

    // ============================================
    // private helper methods for display all music
    private void displayAllMusicSortedByArtist() {
        System.out.println("=".repeat(50));
        System.out.println("Sorted By Music Artist" + "============================\n");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String firstLetter = Character.toString(ch);
            // System.out.println(firstLetter);
            long count = musicItemCollections.stream()
                    .filter(musicItem -> musicItem.getArtist().toLowerCase()
                            .startsWith(firstLetter))
                    .count();

            // if count is 0 (not exist in my music data set no need to operate)
            if (count == 0) {
                continue;
            }

            System.out.println("=Artist starts with '" + firstLetter.toUpperCase() + "'= total count: " + count + " songs exists in the dataset for that year");
            musicItemCollections.stream()
                    .filter(song -> song.getArtist().toLowerCase()
                            .startsWith(firstLetter))
                    .forEach(musicItem -> {
                        System.out.println("Artist: " + musicItem.getArtist() + ", Title: " + musicItem.getTitle()
                                + ", Region: " + musicItem.getMusicRegions() + ", Genre: " + musicItem.getMusicGenre()
                                + ", Album: " + musicItem.getAlbum() + ", Released year: " + musicItem.getYear());
                    });
            System.out.println("=".repeat(50));
        }

    }

    private void displayAllMusicSortedByTitle() {
        // this is the default way of presenting
        System.out.println("=".repeat(50));
        System.out.println("Sorted By Music Title" + "==========================\n");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String firstLetter = Character.toString(ch);
            long count = musicItemCollections.stream()
                    .filter(musicItem -> musicItem.getTitle().toLowerCase()
                            .startsWith(firstLetter))
                    .count();
            if (count == 0) {
                continue;
            }
            System.out.println("= Music title starts with '" + firstLetter.toUpperCase() + "'= total count: " + count
                    + " songs exists in the dataset for that year");
            musicItemCollections.stream()
                    .filter(musicItem -> musicItem.getTitle().toLowerCase().startsWith(firstLetter))
                    .forEach(musicItem -> {
                        System.out.println("Title: " + musicItem.getTitle() + ", Artist: " + musicItem.getArtist()
                                + ", Region: " + musicItem.getMusicRegions() + ", Genre: " + musicItem.getMusicGenre()
                                + ", Album: " + musicItem.getAlbum() + ", Released year: " + musicItem.getYear());
                    });
            System.out.println("=".repeat(50));
        }
    }

    private void displayAllMusicSortedByReleasedYear() {
        // prepare data
        String minimumYearInString = musicItemCollections.stream()
                .map(musicItemReleasedYear -> musicItemReleasedYear.getYear())
                .sorted()
                .limit(1)
                .collect(Collectors.joining());
        // get minimum year from the music data-set to get starting point
        int minYear = Integer.parseInt(minimumYearInString.substring(0,3));
        // get current year to set up the ending point
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String currentYearString = String.valueOf(currentYear).substring(0,3);
        int maxYear = Integer.parseInt(currentYearString);
        // proceed the data to print all music data sorted by released year
        System.out.println("=".repeat(50));
        System.out.println("Sorted By Music Released Year" + "=====================\n");
        for (int i = minYear; i <= maxYear; i++) {
            String targetYear = String.valueOf(i).substring(0, 3);
            long count = musicItemCollections.stream()
                    .filter(musicItem -> musicItem.getYear().startsWith(targetYear))
                    .count();

            // if count is 0 (not exist in my music data set no need to operate)
            if (count == 0) {
                continue;
            }

            System.out.println("=" + targetYear + "0s music= total count: " + count + " songs exists in the dataset for that year");
            musicItemCollections.stream()
                   .filter(musicItem -> musicItem.getYear().startsWith(targetYear))
                   .sorted(Comparator.comparing(MusicItem::getYear))
                   .forEach(musicItem -> {
                       System.out.println("Released year: " + musicItem.getYear() + ", Title: " + musicItem.getTitle()
                               + ", Artist: " + musicItem.getArtist()
                               + ", Region: " + musicItem.getMusicRegions() + ", Genre: " + musicItem.getMusicGenre()
                               + ", Album: " + musicItem.getAlbum());
                   });
            System.out.println("=".repeat(50));
        }
    }

    private void displayAllMusicSortedByGenre() {
        System.out.println("=".repeat(50));
        System.out.println("Sorted By Music Genre ===========================\n");
        for (int i = 0; i < MusicGenre.values().length - 1; i++) {
            MusicGenre targetGenre = MusicGenre.values()[i];
            long count = musicItemCollections.stream()
                    .filter(musicItemGenre -> musicItemGenre.getMusicGenre() == targetGenre)
                    .count();

            // if count is 0 (not exist in my music data set no need to operate)
            if (count == 0) {
                continue;
            }
            System.out.println("=" + targetGenre + "= total count: " + count + " songs exists in the dataset for that Genre");
            musicItemCollections.stream()
                    .filter(musicItemGenre -> musicItemGenre.getMusicGenre() == targetGenre)
                    .forEach(musicItem -> {
                        System.out.println("Genre: "  + musicItem.getMusicGenre() + ", Title: " + musicItem.getTitle()
                                + ", Artist: " + musicItem.getArtist()
                                + ", Region: " + musicItem.getMusicRegions()
                                + ", Album: " + musicItem.getAlbum() + ", Released year: " + musicItem.getYear());
                    });
            System.out.println("=".repeat(50));
        }
    }

    // helper method to print sorted by region
    private void displayAllMusicSortedByRegion() {
        System.out.println("=".repeat(50));
        System.out.println("Sorted By Music Region ===========================\n");
        for (int i = 0; i < MusicRegions.values().length - 1; i++) {
            MusicRegions targetRegion = MusicRegions.values()[i];
            long count = musicItemCollections.stream()
                    .filter(musicItemRegion -> musicItemRegion.getMusicRegions() == targetRegion)
                    .count();

            // if count is 0 (not exist in my music data set no need to operate)
            if (count == 0) {
                continue;
            }
            System.out.println("=" + targetRegion + "= total count: " + count + " songs exists in the dataset for that region");
            musicItemCollections.stream()
                    .filter(musicItemRegion -> musicItemRegion.getMusicRegions() == targetRegion)
                    .forEach(musicItem -> {
                        System.out.println("Region: " + musicItem.getMusicRegions() + ", Title: " + musicItem.getTitle()
                                + ", Artist: " + musicItem.getArtist()
                                + ", Genre: " + musicItem.getMusicGenre()
                                + ", Album: " + musicItem.getAlbum() + ", Released year: " + musicItem.getYear());
                    });
            System.out.println("=".repeat(50));
        }
    }
}
