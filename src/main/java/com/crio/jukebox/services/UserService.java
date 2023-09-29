package com.crio.jukebox.services;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IUserRepository;

public class UserService implements IUserService{
    private final IUserRepository userRepository;
    // private final IPlaylistRepository playListRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
        // this.playListRepository = playlistRepository;
    }

    @Override
    public User createUser(String name){
        final User user = new User(name);
        return userRepository.save(user);
    }
    
}
