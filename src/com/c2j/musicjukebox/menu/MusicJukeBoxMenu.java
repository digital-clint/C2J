package com.c2j.musicjukebox.menu;

import com.c2j.musicjukebox.music.MusicCollection;

import java.util.Scanner;

public class MusicJukeBoxMenu {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private int userNumChoice;
    private MusicCollection jukeboxConsole = MusicCollection.createInstance();



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

    //Created shell for methods below.
    //Will Add logic later
    public void viewAllSongs(){
        System.out.println("case 1");
    }

    public void pickSongFromGenre(){
        System.out.println("case 2");
    }

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
                jukeboxConsole.findByRegion("Asia");
                break;

            case 2:
                jukeboxConsole.findByRegion("Africa");
                break;

            case 3:
                jukeboxConsole.findByRegion("Australia");
                break;

            case 4:
                jukeboxConsole.findByRegion("Europe");
                break;

            case 5:
                jukeboxConsole.findByRegion("North America");
                break;

            case 6:
                jukeboxConsole.findByRegion("Central South America");
                break;

            default:
                System.out.println("Invalid Selection..Please try again");
                System.out.println();
                pickSongFromRegion();
        }
    }


    public void findSongByTitle(){
        System.out.println("Please enter the name of the song you are looking for?: ");
        userInput = scan.nextLine();
        jukeboxConsole.findByTitle(userInput);
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
