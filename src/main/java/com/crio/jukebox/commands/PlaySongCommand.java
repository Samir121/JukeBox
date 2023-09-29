package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IUserService;

public class PlaySongCommand implements ICommand{
    private final IUserService userService;

    public PlaySongCommand(IUserService userService){
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens){
        
    }
}
