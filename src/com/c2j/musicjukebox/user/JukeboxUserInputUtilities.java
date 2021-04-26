package com.c2j.musicjukebox.user;

import java.util.Scanner;

public interface JukeboxUserInputUtilities {

    public String getInputTitle(String songTitle);
    public String getInputRegion(String region);
    public String getInputArtist(String artistName);
    public String getInputAlbum(String albumName);
    public String getInputYear(String releaseYear);
    public double getInputPay();
    public void requestToAddExtraSongOnMachine();
}
