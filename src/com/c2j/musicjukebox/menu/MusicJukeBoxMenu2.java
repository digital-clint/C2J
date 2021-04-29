package com.c2j.musicjukebox.menu;

import com.c2j.musicjukebox.admin.MusicJukeBoxAdmin;
import com.c2j.musicjukebox.music.MusicCollection;
import com.c2j.musicjukebox.music.MusicItem;
import com.c2j.musicjukebox.usersongrequest.SongRequestedByUsers;
import com.c2j.musicjukebox.usersongrequest.UserSongRequest;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MusicJukeBoxMenu2 {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
//    private int userNumChoice;
    private MusicCollection jukeboxConsole = MusicCollection.createInstance();
    private String regionName;
    boolean onlyViewedSongListing = false;
    boolean adminLogin;
    private static Queue<MusicItem> musicItemQueue = new PriorityQueue<MusicItem>();
    private MusicJukeBoxAdmin adminAccount = new MusicJukeBoxAdmin();
    private int lockoutCount = 1;
    private UserSongRequest songRequest = new UserSongRequest();
    private SongRequestedByUsers viewSongRequests = new SongRequestedByUsers();
    boolean songRequested = false;

    public void start(){
        welcome();
        displayJukeboxOptions();
        goodBye();
    }

    public void displayJukeboxOptions(){
        System.out.println("1) View all songs in Jukebox");
        System.out.println("2) Pick a song from from a certain genre");
        System.out.println("3) Pick a song from a certain region");
        System.out.println("4) Find a song by title");
        System.out.println("5) Find a song by release year");
        System.out.println("6) Find a song by album name");
        System.out.println("7) Don't see a song you like...request one here");
        System.out.println("8) Login as administrator");
        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        int userNumChoice = -1;
        while (userInput.length() != 1) {
            System.out.println("Please enter a valid number!");
            System.out.println("Please enter the number of your selection: 1-8");
            userInput = scan.nextLine();
        }
        System.out.println("It should not get in here");
        // if it the option is not valid
        while ( (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 8)) {
            try {
                System.out.println("Please enter a valid number!");
                System.out.println("Please enter the number of your selection: 1-8");
                userInput = scan.nextLine();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("validation pass");
        userNumChoice = Integer.parseInt(userInput);
        System.out.println(userNumChoice);
        // if it is valid
        // run infinite loop
//        while (true) {
//            switch (userNumChoice){
//                case 1:
//                    viewAllSongs();
//                    break;
//                case 2:
//                    //pickSongFromGenre();
//                    break;
//                case 3:
//                    //pickSongFromRegion();
//                    break;
//                case 4:
//                    //findSongByTitle();
//                    break;
//                case 5:
//                    //findSongByReleaseYear();
//                    break;
//                case 6:
//                    //findSongByAlbumName();
//                    break;
//                case 7:
//                    //requestASong();
//                    break;
//                case 8:
//                    //loginAsAdmin();
//                    break;
//                default:
//                    System.out.println("Invalid Selection..Please try again");
//                    System.out.println();
////                displayJukeboxOptions();
//            }
//        }
    }

    //View listing of all Songs
    public void viewAllSongs(){
        final int MAX_OPTION = 5;
        // int count = 0;
        System.out.println("Please choose an option below...");
        System.out.println();
        System.out.println("1) View all songs sorted by region");
        //count++;
        System.out.println("2) View all songs sorted by genre");
        // count++;
        System.out.println("3) View all songs sorted by artist");
        // count++;
        System.out.println("4) View all songs sorted by year");
        // count++;
        System.out.println("5) View all songs sorted by title");
        // count++;

        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        // check if the user input is valid
        while (Integer.parseInt(userInput) >= 0 || Integer.parseInt(userInput) <= MAX_OPTION) {
            System.out.print("Please enter the number of your selection: ");
            userInput = scan.nextLine();
        }

        // if it is valid
        int userNumChoice = Integer.parseInt(userInput);
        songsSortedByOptions(userNumChoice);
    }



    public void welcome(){
        System.out.println("♪ ♪ ♫ Welcome to C2J Jukebox ♪ ♪ ♫ ");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
    }

    // Good bye
    // terminate the program
    public void goodBye(){
        System.out.println("-----------------------------------------");
        System.out.println("Thanks for using the C2J Jukebox!");
        System.out.println("In the future we hope to add more songs you'd like to play...");
        System.out.println("♪ ♪ ♫ ♪ ♪ ♫");
        System.exit(0);
    }



    public void songsSortedByOptions(int sortNumChoice){
        switch (sortNumChoice) {
            case 1:
                jukeboxConsole.displayAllMusic("region");
                break;

            case 2:
                jukeboxConsole.displayAllMusic("genre");
                break;

            case 3:
                jukeboxConsole.displayAllMusic("artist");
                break;

            case 4:
                jukeboxConsole.displayAllMusic("year");
                break;

            case 5:
                jukeboxConsole.displayAllMusic("title");
                break;

            default:
                viewAllSongs();

        }
    }
}
