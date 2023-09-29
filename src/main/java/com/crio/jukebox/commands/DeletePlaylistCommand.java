package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IPlaylistService;

public class DeletePlaylistCommand implements ICommand{
    private final IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        Integer userId = Integer.parseInt(tokens.get(1));
        Integer playListId = Integer.parseInt(tokens.get(2));

        playlistService.removePlayList(userId, playListId);
        System.out.println("Removed!!");
        
    }
    
}
