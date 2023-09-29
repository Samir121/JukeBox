package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;

public interface IPlaylistService {
    public Playlist createPlayList(Integer ownerId, String playListName, List<Integer> songIds);
    public void removePlayList(Integer userId, Integer playListId);
    public Playlist modifyPlayList(String cmd, Integer ownerId, Integer playListId, List<Integer> songIds);
}
