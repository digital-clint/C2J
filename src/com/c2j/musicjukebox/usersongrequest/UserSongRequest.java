package com.c2j.musicjukebox.usersongrequest;

import com.c2j.musicjukebox.menu.MusicJukeBoxMenu;

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.List;
    import java.util.Scanner;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;

    public class UserSongRequest {

        // variable to store user input
        Scanner musicIn = new Scanner(System.in);

        public void musicOut (String text) throws IOException {
            System.out.println("What is the song your wish to be added? ");

            // user input captured and text is written with response
            text = musicIn.nextLine();

                // path to the songRequested.txt file in order to check if song has already present or requested
                Path filePath = Paths.get("C:\\Users\\jhurtaul\\Desktop\\SDE Cohort\\StudentWork\\Java_LabSetup_Part-2\\StudentWork\\IntmJ\\workspace\\C2J\\songsRequested.txt");
                List<String> songTitles = Files.lines(filePath).collect(Collectors.toList());

            // validation to ensure that response is not null or 0
            while (text == null || text.length() == 0) {
                System.out.println("Please enter a valid response");
                // will continue to prompt user for a valid response option
                text = musicIn.nextLine();
            }
            boolean anyMatch = displayResults(text, songTitles);
            if (anyMatch){
                return;
            }
            try {
                BufferedWriter songRequested = new BufferedWriter(
                        new FileWriter("C:\\Users\\jhurtaul\\Desktop\\SDE Cohort\\StudentWork\\Java_LabSetup_Part-2\\StudentWork\\IntmJ\\workspace\\C2J\\songsRequested.txt", true));

                songRequested.append(text + "\n");
                songRequested.close();

                System.out.println("Your song request has been submitted");

            } catch (Exception ioe) {
                System.out.println("Please enter a valid song");
            }
        }

            public static boolean displayResults (String searchTitle, List <String> titles) throws IOException {
            boolean songFile = titles.stream().anyMatch(a -> a.equalsIgnoreCase(searchTitle));

            if (songFile) {
                System.out.println("\n This song " + searchTitle + " has already been requested! Please allow us some time to add it");
            }
            return songFile;

    }
}