package com.crio.jukebox.entities;

import java.util.List;

public class Song {
    
    private String songName;
    private final String genre;
    private Integer songId;
    private String album;
    private String albumArtist;
    private List<String> featuredArtist;

    public Song(Song song) {
        this(song.songId, song.songName, song.genre, song.album, song.albumArtist, song.featuredArtist);
    }

    public Song(Integer songId, String songName, String genre, String album, String albumArtist, List<String> featuredArtist) {
        this(songName, genre, album, albumArtist, featuredArtist);
        this.songId = songId;
    }

    public Song(String songName, String genre, String album, String albumArtist, List<String> featuredArtist) {
        this.songName = songName;
        this.genre = genre;
        this.album = album;
        this.albumArtist = albumArtist;
        this.featuredArtist = featuredArtist;
    }

    public String getGenre(){
        return genre;
    }
    
    public String getSongName() {
        return songName;
    }
    
    public Integer getSongId() {
        return songId;
    }
    
    public String getAlbum() {
        return album;
    }
    
    public String getAlbumArtist() {
        return albumArtist;
    }

    public List<String> getFeaturedArtist() {
        return featuredArtist;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((songId == null) ? 0 : songId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (songId == null) {
            if (other.songId != null)
                return false;
        } else if (!songId.equals(other.songId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Song [album=" + album + ", albumArtist=" + albumArtist + ", featuredArtist="
                + featuredArtist + ", genre=" + genre + ", songId=" + songId + ", songName="
                + songName + "]";
    }

    
}
