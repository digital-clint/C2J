package com.c2j.musicjukebox.menu;

import com.c2j.musicjukebox.admin.MusicJukeBoxAdmin;
import com.c2j.musicjukebox.music.MusicCollection;
import com.c2j.musicjukebox.music.MusicItem;
import com.c2j.musicjukebox.usersongrequest.SongRequestedByUsers;
import com.c2j.musicjukebox.usersongrequest.UserSongRequest;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public class MusicJukeBoxMenu {
    private Scanner scan = new Scanner(System.in);
    private String userInput;
    private int userNumChoice;
    private MusicCollection jukeboxConsole = MusicCollection.createInstance();
    private String regionName;
    boolean onlyViewedSongListing = false;
    boolean adminLogin;
    private static Queue<MusicItem> musicItemQueue = new PriorityQueue<MusicItem>();
    private MusicJukeBoxAdmin adminAccount = new MusicJukeBoxAdmin();
    private int lockoutCount = 1;
    private UserSongRequest songRequest = new UserSongRequest();
    private SongRequestedByUsers viewSongRequests = new SongRequestedByUsers();




    //This method will start the Jukebox
    public void start(){
        welcome();
        displayJukeboxOptions();
        if (onlyViewedSongListing == true){
            noChoiceRunAgain();
        } else if(adminLogin == true){
            adminLogout();
        } else {
            runAgain();
        }
    }

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
            start();
        } else if (userInput.toLowerCase().equals("n") || userInput.toLowerCase().equals("no")){
            continueOrQuit();
        }
        else {
            System.out.println();
            System.out.println("Invalid input...try again");
            runAgain();
        }
    }

    public void goodBye(){
        System.out.println("-----------------------------------------");
        System.out.println("Thanks for using the C2J Jukebox!");
        System.out.println("In the future we hope to add more songs you'd like to play...");
        System.out.println("♪ ♪ ♫ ♪ ♪ ♫");
    }

    public void continueOrQuit(){
        System.out.println("Would you like to play songs in queue or quit jukebox session?");
        System.out.println("1) Play songs");
        System.out.println("2) Quit");
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        userNumChoice = Integer.parseInt(userInput);
        System.out.println();
        System.out.println("------------------------------------------");

        if (userNumChoice == 1){
            jukeboxConsole.play(musicItemQueue);
            while(!musicItemQueue.isEmpty()){
                musicItemQueue.poll();
            }
            
            runAgain();
        } else if (userNumChoice == 2){
            goodBye();
        } else {
            System.out.println("Invalid input...");
            continueOrQuit();
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
            continueOrQuit();
        }
        else {
            System.out.println();
            System.out.println("Invalid input...try again");
            runAgain();
        }
    }

    public void displayJukeboxOptions(){
        int count = 0;
        System.out.println("1) View all songs in Jukebox");
        count++;
        System.out.println("2) Pick a song from from a certain genre");
        count++;
        System.out.println("3) Pick a song from a certain region");
        count++;
        System.out.println("4) Find a song by title");
        count++;
        System.out.println("5) Find a song by release year");
        count++;
        System.out.println("6) Find a song by album name");
        count++;
        System.out.println("7) Don't see a song you like...request one here");
        count++;
        System.out.println("8) Login as administrator");
        count++;
        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if(userNumChoice != (int)userNumChoice || userNumChoice > count || userNumChoice < 1 ){
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
                requestASong();
                break;

            case 8:
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
        int count = 0;
        System.out.println("Please choose an option below...");
        System.out.println();
        System.out.println("1) View all songs sorted by region");
        count++;
        System.out.println("2) View all songs sorted by genre");
        count++;
        System.out.println("3) View all songs sorted by artist");
        count++;
        System.out.println("4) View all songs sorted by year");
        count++;
        System.out.println("5) View all songs sorted by title");
        count++;

        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if(userNumChoice != (int)userNumChoice || userNumChoice > count || userNumChoice < 1 ){
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            System.out.println();
            viewAllSongs();
        }

        songsSortedByOptions(userNumChoice);


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
                musicItemQueue.add(songRetrievedByGenre(songsFoundByGenre));
                System.out.println("Adding song to queue..... ");
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
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
                break;

            case 2:
                regionName = "Africa";
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
                break;

            case 3:
                regionName = "Australia";
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
                break;

            case 4:
                regionName = "Europe";
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
                break;

            case 5:
                regionName = "North America";
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
                break;

            case 6:
                regionName = "Central South America";
                musicItemQueue.add(songRetrievedFromRegion(regionName));
                System.out.println("Adding song to queue..... ");
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
        musicItemQueue.add(songRetrievedByTitle(songsFoundByTitle));
        System.out.println("Adding song to queue..... ");

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
                musicItemQueue.add(songRetrievedByReleaseYear(songsFoundByYear));
                System.out.println("Adding song to queue..... ");

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
                musicItemQueue.add(songRetrievedByAlbumName(songsFoundByAlbumName));
                System.out.println("Adding song to queue..... ");
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

    public void requestASong(){
        String overrideText = "";
        try {
            songRequest.musicOut(overrideText);
        } catch (IOException e){
            System.out.println("Please enter a valid song");
        }
        System.out.println("Song Requested");
    }

    public void loginAsAdmin(){
        adminLogin = true;
        System.out.print("Enter Admin Username: ");
        String adminUserNameInput = scan.nextLine();
        System.out.print("Enter Admin Password: ");
        String adminPasswordInput = scan.nextLine();

        String adminUserName = adminAccount.getAdminUsername();
        String adminUserPassword = adminAccount.getAdminPassword();

        if (lockoutCount == 3){
            System.out.println("You've entered your username or password incorrectly too many times...");
            System.out.println("Please contact the C2J Jukebox Support Team!");
            System.exit(0);
        } else if (!adminUserNameInput.equals(adminUserName) || !adminPasswordInput.equals(adminUserPassword)){
            System.out.println("Invalid username or password!!!");
            lockoutCount++;
            loginAsAdmin();
        } else {
            adminWelcome();
            adminHomePage();
        }

    }

    public void adminWelcome(){
        System.out.println("[-_-] Welcome Admin [-_-] ");
        System.out.println();
        System.out.println("What would you like to do?");
    }

    public void adminHomePage(){
        int count = 0;
        System.out.println("Please choose an option below...");
        System.out.println();
        System.out.println("1) Print Invoice");
        count++;
        System.out.println("2) View User Song Requests");
        count++;
        System.out.println("3) Logout");
        count++;

        System.out.println();
        System.out.print("Please enter the number of your selection: ");
        userInput = scan.nextLine();
        System.out.println("-------------------------------------------");

        try {
            userNumChoice = Integer.parseInt(userInput);
            if(userNumChoice != (int)userNumChoice || userNumChoice > count || userNumChoice < 1 ){
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Please enter a valid number!");
            System.out.println();
            adminHomePage();
        }

        if (userNumChoice == 1){
            System.out.println("$$$$$$$$ Printing Invoice $$$$$$$$$");
            jukeboxConsole.printInvoice();
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("Welcome Back to your home page!");
            adminHomePage();
        }

        if (userNumChoice == 2){
            String overrideText = "";
            viewSongRequests.musicRequested(overrideText);
        }
    }

    public void adminLogout(){
        System.out.println("You are now logged out of the C2J Jukebox...");
    }


}
