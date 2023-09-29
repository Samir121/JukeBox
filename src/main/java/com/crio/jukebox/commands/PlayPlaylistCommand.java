package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.IUserService;

public class PlayPlaylistCommand implements ICommand{
    private final IPlaylistService playlistService;

    public PlayPlaylistCommand(IPlaylistService playlistService){
        this.playlistService = playlistService;
    }
    @Override
    public void execute(List<String> tokens){
        // Integer userId = Integer.parseInt(tokens.get(1));
        // Integer playlistId = Integer.parseInt(tokens.get(2));
        // Playlist playlist = playlistService.playPlaylist(userId,playlistId);
        // System.out.println(playlist);
    }
}
