package com.c2j.musicjukebox.menu;

import com.c2j.musicjukebox.music.MusicCollection;
import com.c2j.musicjukebox.music.MusicItem;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public class MusicJukeBoxMenu {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private int userNumChoice;
    private MusicCollection jukeboxConsole = MusicCollection.createInstance();
    private String regionName;
    boolean onlyViewedSongListing;



    //This method will start the Jukebox
    public void start(){
        welcome();
        displayJukeboxOptions();
        if (onlyViewedSongListing == true){
            noChoiceRunAgain();
        } else {
            runAgain();
        }
    };

    public void welcome(){
        System.out.println("♪ ♪ ♫ Welcome to C2J Jukebox ♪ ♪ ♫ ");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
    }

    public void runAgain(){
        System.out.println();
        System.out.println("Would you like to pick another song to play?");
        System.out.print("Enter - Yes or No: ");
        userInput = scan.nextLine();
        String lowerCaseUserInput = userInput.toLowerCase();
        if (lowerCaseUserInput.equals("y") || lowerCaseUserInput.equals("yes")){
            displayJukeboxOptions();
        } else if (userInput.toLowerCase().equals("n") || userInput.toLowerCase().equals("no")){
            System.out.println("-----------------------------------------");
            System.out.println("Thanks for using the C2J Jukebox!");
            System.out.println("♪ ♪ ♫ See you soon ♪ ♪ ♫");
        }
        else {
            System.out.println();
            System.out.println("Invalid input...try again");
            runAgain();
        }
    }

    public void noChoiceRunAgain(){
        System.out.println();
        System.out.println("You only viewed the inventory of songs...");
        System.out.println("Would you like to pick a song to play this time?");
        System.out.print("Enter - Yes or No: ");
        userInput = scan.nextLine();
        String lowerCaseUserInput = userInput.toLowerCase();
        if (lowerCaseUserInput.equals("y") || lowerCaseUserInput.equals("yes")){
            start();
        } else if (userInput.toLowerCase().equals("n") || userInput.toLowerCase().equals("no")){
            System.out.println("-----------------------------------------");
            System.out.println("Thanks for using the C2J Jukebox!");
            System.out.println("In the future we hope to add the song you'd like to play...");
            System.out.println("♪ ♪ ♫ ♪ ♪ ♫");
        }
        else {
            System.out.println();
            System.out.println("Invalid input...try again");
            runAgain();
        }
    }

    public void displayJukeboxOptions(){
        System.out.println("1) View all songs in Jukebox");
        System.out.println("2) Pick a song from from a certain genre");
        System.out.println("3) Pick a song from a certain region");
        System.out.println("4) Find a song by title");
        System.out.println("5) Find a song by release year");
        System.out.println("6) Find a song by album name");
        System.out.println("7) Login as administrator");
        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if(userNumChoice != (int)userNumChoice){
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            System.out.println();
            displayJukeboxOptions();
        }

        switch (userNumChoice){
            case 1:
                viewAllSongs();
                onlyViewedSongListing = true;
                break;

            case 2:
                pickSongFromGenre();
                break;

            case 3:
                pickSongFromRegion();
                break;

            case 4:
                findSongByTitle();
                break;

            case 5:
                findSongByReleaseYear();
                break;

            case 6:
                findSongByAlbumName();
                break;

            case 7:
                loginAsAdmin();
                break;

            default:
                System.out.println("Invalid Selection..Please try again");
                System.out.println();
                displayJukeboxOptions();
        }
    }

    //View listing of all Songs
    public void viewAllSongs(){
        Collection<MusicItem> allSongs = MusicCollection.getAllMusic();
        System.out.println("Displaying all songs in Jukebox.......");
        System.out.println("-------------------------------------------");
        for (MusicItem song : allSongs) {
            System.out.println(song);
        }
        System.out.println("-------------------------------------------");

    }

    public void pickSongFromGenre(){
        System.out.println("Please enter the Genre that contains the song you are looking for?: ");
        userInput = scan.nextLine();
        Collection<MusicItem> songsFoundByGenre = null;
        boolean isValidOption = true;
        try{
            songsFoundByGenre = jukeboxConsole.findByGenre(userInput);
        } catch (IllegalArgumentException e){
            isValidOption = false;
            System.out.println(e.getMessage());
        } finally {
            if (isValidOption){
                System.out.println("Song to be added to queue: " + songRetrievedByGenre(songsFoundByGenre));
            } else {
                System.out.println("-------------------------------------------");
                pickSongFromGenre();
            }
        }

    }

    public MusicItem songRetrievedByGenre(Collection<MusicItem> songGenreCollectionArg){
        Collection<MusicItem> songGenreCollection = songGenreCollectionArg;
        ArrayList<MusicItem> listOfSongs = new ArrayList<>();

        for (MusicItem song: songGenreCollection) {
            listOfSongs.add(song);
        }

        //Song retrieved is a single music item
        MusicItem songRetrieved = chooseASong(listOfSongs);
        return songRetrieved;
    }


    //Find song based on region methods
    public void pickSongFromRegion(){
        System.out.println("What region would you like to pick a song from?");
        System.out.println();
        System.out.println("1) Asia");
        System.out.println("2) Africa");
        System.out.println("3) Australia");
        System.out.println("4) Europe");
        System.out.println("5) North America");
        System.out.println("6) Central/South America");
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if(userNumChoice != (int)userNumChoice){
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            System.out.println();
            pickSongFromRegion();
        }

        switch (userNumChoice){
            case 1:
                regionName = "Asia";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            case 2:
                regionName = "Africa";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            case 3:
                regionName = "Australia";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            case 4:
                regionName = "Europe";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            case 5:
                regionName = "North America";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            case 6:
                regionName = "Central South America";
                System.out.println("Song to be added to queue: " + songRetrievedFromRegion(regionName));
                break;

            default:
                System.out.println("Invalid Selection..Please try again");
                System.out.println();
                pickSongFromRegion();
        }
    }

    public MusicItem songRetrievedFromRegion(String regionStringName){
        Collection<MusicItem> songsFoundInRegion;
        ArrayList<MusicItem> listOfSongs = new ArrayList<>();
        songsFoundInRegion = jukeboxConsole.findByRegion(regionStringName);

        for (MusicItem song: songsFoundInRegion) {
            listOfSongs.add(song);
        }

        //Song retrieved is a single music item
        MusicItem songRetrieved = chooseASong(listOfSongs);
        return songRetrieved;
    }

    //Choose a song method after songs are in an arrayList
    public MusicItem chooseASong(ArrayList songs){
        MusicItem songChosen = new MusicItem();
        int count = 1;
        System.out.println("What song would you like to choose?");
        System.out.println();
        for (Object song : songs) {
            System.out.println(count + ") " + song );
            count++;
        }

        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if((userNumChoice != (int)userNumChoice) || (userNumChoice > count - 1) || (userNumChoice < 1)){
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            System.out.println();
            chooseASong(songs);
        }
        int userFinalChoice = userNumChoice - 1;
        if(userFinalChoice < 0 || userFinalChoice > songs.size()){
            System.out.println("Please enter a valid number!");
            System.out.println();
            chooseASong(songs);
        } else {
            songChosen = (MusicItem) songs.get(userFinalChoice);

        }

        return songChosen;
    }


    //Find Song based on title methods
    public void findSongByTitle(){
        System.out.println("Please enter the name of the song you are looking for?: ");
        userInput = scan.nextLine();
        Collection<MusicItem> songsFoundByTitle = jukeboxConsole.findByTitle(userInput);
        System.out.println("Song to be added to queue: " + songRetrievedByTitle(songsFoundByTitle));

    }

    public MusicItem songRetrievedByTitle(Collection<MusicItem> songTitleCollectionArg){
        Collection<MusicItem> songTitleCollection = songTitleCollectionArg;
        ArrayList<MusicItem> listOfSongs = new ArrayList<>();

        for (MusicItem song: songTitleCollection) {
            listOfSongs.add(song);
        }

        //Song retrieved is a single music item
        MusicItem songRetrieved = chooseASong(listOfSongs);
        return songRetrieved;
    }

    //Find Song based on Release Year
    public void findSongByReleaseYear(){
        System.out.println("Please enter the year when the song was released?: ");
        userInput = scan.nextLine();
        Collection<MusicItem> songsFoundByYear = null;
        boolean isValidOption = true;
        try{
            songsFoundByYear = jukeboxConsole.findByYear(userInput);
        } catch (IllegalArgumentException e){
            isValidOption = false;
            System.out.println(e.getMessage());
        } finally {
            if (isValidOption){
                System.out.println("Song to be added to queue: " + songRetrievedByReleaseYear(songsFoundByYear));
            } else {
                System.out.println("-------------------------------------------");
                findSongByReleaseYear();
            }
        }
    }

    public MusicItem songRetrievedByReleaseYear(Collection<MusicItem> songReleaseYearCollectionArg){
        Collection<MusicItem> songReleaseYearCollection = songReleaseYearCollectionArg;
        ArrayList<MusicItem> listOfSongs = new ArrayList<>();

        for (MusicItem song: songReleaseYearCollection) {
            listOfSongs.add(song);
        }

        //Song retrieved is a single music item
        MusicItem songRetrieved = chooseASong(listOfSongs);
        return songRetrieved;
    }


    //Find Song based on Album Name
    public void findSongByAlbumName(){
        System.out.println("Please enter the name of the album the song was featured on: ");
        userInput = scan.nextLine();

        Collection<MusicItem> songsFoundByAlbumName = null;
        boolean isValidOption = true;
        try{
            songsFoundByAlbumName = jukeboxConsole.findByAlbum(userInput);
        } catch (IllegalArgumentException e){
            isValidOption = false;
            System.out.println(e.getMessage());
        } finally {
            if (isValidOption){
                System.out.println("Song to be added to queue: " + songRetrievedByAlbumName(songsFoundByAlbumName));
            } else {
                System.out.println("-------------------------------------------");
                findSongByAlbumName();
            }
        }
    }

    public MusicItem songRetrievedByAlbumName(Collection<MusicItem> songAlbumNameCollectionArg){
        Collection<MusicItem> songAlbumNameCollection = songAlbumNameCollectionArg;
        ArrayList<MusicItem> listOfSongs = new ArrayList<>();

        for (MusicItem song: songAlbumNameCollection) {
            listOfSongs.add(song);
        }

        //Song retrieved is a single music item
        MusicItem songRetrieved = chooseASong(listOfSongs);
        return songRetrieved;
    }

    public void loginAsAdmin(){
        System.out.println("case 7");
    }


}
