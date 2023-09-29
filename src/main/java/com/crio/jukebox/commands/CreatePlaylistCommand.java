package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.IPlaylistService;

public class CreatePlaylistCommand implements ICommand{
    private final IPlaylistService playListService;

    public CreatePlaylistCommand (IPlaylistService playListService) {
        this.playListService = playListService;
    }
    

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        Integer ownerId = Integer.parseInt(tokens.get(1));
        String playListName = tokens.get(2);
        List<Integer> songIds = new ArrayList<>();
        for(int i = 3; i<tokens.size(); i++) {
            songIds.add(Integer.parseInt(tokens.get(i)));
        }
        Playlist playList = playListService.createPlayList(ownerId, playListName, songIds);
        System.out.println(playList);
    }
    
}
