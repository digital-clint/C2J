package com.c2j.musicjukebox.menu;

import com.c2j.musicjukebox.music.MusicCollection;
import com.c2j.musicjukebox.music.MusicItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MusicJukeBoxMenu {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private int userNumChoice;
    private MusicCollection jukeboxConsole = MusicCollection.createInstance();

    String regionName;




    //This method will start the Jukebox
    public void start(){
        welcome();
        displayJukeboxOptions();
    };

    public void welcome(){
        System.out.println("♪ ♪ ♫ Welcome to C2J Jukebox ♪ ♪ ♫ ");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
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
        System.out.println("case 2");
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
            if(userNumChoice != (int)userNumChoice){
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


    public void findSongByReleaseYear(){
        System.out.println("case 5");
    }

    public void findSongByAlbumName(){
        System.out.println("case 6");
    }

    public void loginAsAdmin(){
        System.out.println("case 7");
    }

}
