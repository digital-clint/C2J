package com.c2j.musicjukebox.usersongrequest;

import com.c2j.musicjukebox.menu.MusicJukeBoxMenu;

import java.io.BufferedReader;
import java.io.FileReader;


// displays to admin song that has already been requested by user
public class SongRequestedByUsers extends MusicJukeBoxMenu {
            public void musicRequested(String text){
            try{
            BufferedReader songsAlreadyRequested = new BufferedReader(
                    new FileReader("C:\\Users\\jhurtaul\\Desktop\\SDE Cohort\\StudentWork\\Java_LabSetup_Part-2\\StudentWork\\IntmJ\\workspace\\C2J"));
                String songFile;

                while ((songFile = songsAlreadyRequested.readLine()) != null){
                    System.out.println(songFile);
                }
                }catch(Exception ex){
                return;
        }
    }
}
