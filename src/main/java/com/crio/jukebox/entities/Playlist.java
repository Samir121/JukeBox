package com.crio.jukebox.entities;

import java.util.List;

public class Playlist {

    private Integer playListId;
    private String playListName;
    private Integer ownerId;
    private List<Integer> songsIds;

    public Playlist (Playlist playList) {
        this(playList.playListId,playList.ownerId,playList.playListName,playList.songsIds);
    }

    public Playlist(Integer playListId, Integer ownerId, String playListName, List<Integer> songsIds) {
        this(ownerId, playListName, songsIds);
        this.playListId = playListId;
    }

    public Playlist(Integer ownerId, String playListName, List<Integer> songsIds) {
        this.ownerId = ownerId;
        this.songsIds = songsIds;
        this.playListName = playListName;
    }

    public Integer getPlayListId() {
        return playListId;
    }
    public String getPlaylistName(){
        return playListName;
    }
    public Integer getOwnerId() {
        return ownerId;
    }
    public List<Integer> getSongsIds() {
        return songsIds;
    }

    public void addSongPlaylist(Integer songId){
        this.songsIds.add(songId);
    }

    public void removeSongPlaylist(Integer songId){
        this.songsIds.remove(songId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((playListId == null) ? 0 : playListId.hashCode());
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
        Playlist other = (Playlist) obj;
        if (playListId == null) {
            if (other.playListId != null)
                return false;
        } else if (!playListId.equals(other.playListId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PlayList [ownerId=" + ownerId + ", playListId=" + playListId + ", playListName="
                + playListName + ", songs=" + songsIds + "]";
    }

}
