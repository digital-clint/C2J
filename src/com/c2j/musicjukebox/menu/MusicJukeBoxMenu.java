package com.c2j.musicjukebox.menu;

import java.util.Scanner;

public class MusicJukeBoxMenu {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private int userNumChoice;

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
        userNumChoice = Integer.parseInt(userInput);

        switch (userNumChoice){
            case 1:
                viewAllSongs();

            case 2:
                pickSongFromGenre();

            case 3:
                pickSongFromRegion();

            case 4:
                findSongByTitle();

            case 5:
                findSongByReleaseYear();

            case 6:
                findSongByAlbumName();

            case 7:
                loginAsAdmin();

            default:
                System.out.println("Invalid Selection");

        }
    }

    //Created shell for methods below.
    //Will Add logic later
    public void viewAllSongs(){

    }

    public void pickSongFromGenre(){

    }

    public void pickSongFromRegion(){

    }

    public void findSongByTitle(){

    }

    public void findSongByReleaseYear(){

    }

    public void findSongByAlbumName(){

    }

    public void loginAsAdmin(){

    }





}
