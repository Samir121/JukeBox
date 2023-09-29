package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService implements ISongService{
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public String loadSongsFromCSV(String file){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] column = line.split(",");
                if(column.length == 6){
                    String songName = column[1];
                    String genre = column[2];
                    String albumName = column[3];
                    String artistName = column[4];
                    String[] featuredArtists = column[5].split("#");

                    Song song = new Song(songName,genre,albumName,artistName,Arrays.asList(featuredArtists));
                    songRepository.save(song);
                }
            }
            br.close();
            return "Songs Loaded Successfully";
        }
        catch(IOException e){
            System.out.println("An error has occured whem reading the file"+e.getMessage());
            return e.getMessage();
        }
    }
}
