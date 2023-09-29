package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.IPlaylistService;

public class ModifyPlaylistCommand implements ICommand{
    private final IPlaylistService playListService;

    public ModifyPlaylistCommand(IPlaylistService playListService){
        this.playListService = playListService;
    }

    @Override
    public void execute(List<String> tokens){
        String cmd = tokens.get(1);
        Integer ownerId = Integer.parseInt(tokens.get(2));
        Integer playListId = Integer.parseInt(tokens.get(3));
        List<Integer> songIds = new ArrayList<>();
        for(int i=4;i<tokens.size();i++){
            songIds.add(Integer.parseInt(tokens.get(i)));
        }
        Playlist playlist = playListService.modifyPlayList(cmd, ownerId, playListId, songIds);
        System.out.println(playlist);
    }
}
