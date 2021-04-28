package com.c2j.musicjukebox.usersongrequest;

import com.c2j.musicjukebox.menu.MusicJukeBoxMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class UserSongRequest extends MusicJukeBoxMenu{
    public static void main(String[] args) {
        Scanner musicIn = new Scanner(System.in);
        System.out.println("What is the song your wish to be added? ");
        String text= musicIn.nextLine();


        try{
            BufferedWriter songRequested = new BufferedWriter(
                    new FileWriter("C:\\Users\\jhurtaul\\Desktop\\SDE Cohort\\StudentWork\\Java_LabSetup_Part-2\\StudentWork\\IntmJ\\workspace\\C2J\\songsRequested.txt" , true));

            songRequested.append(text + "\n" );
            songRequested.close();

            System.out.println("Your song request has been submitted");

        }catch(Exception ex){
            return;
        }


    }
}