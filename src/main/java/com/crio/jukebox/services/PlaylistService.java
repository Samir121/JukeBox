package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.User;
import com.crio.jukebox.exceptions.InvalidOperationException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

public class PlaylistService implements IPlaylistService{
    private final IPlaylistRepository playListRepository;
    private final IUserRepository userRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IUserRepository userRepository, ISongRepository songRepository, IPlaylistRepository playlistRepository){
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.playListRepository = playlistRepository;
    }

    @Override
    public Playlist createPlayList(Integer ownerId, String playListName, List<Integer> songIds) {
        // TODO Auto-generated method stub
        final User user = userRepository.findById(ownerId).orElseThrow(() -> new UserNotFoundException("Cannot Create Play List. Play List Creator for given id: " + ownerId + " not found!"));
    
        Playlist playList = new Playlist(user.getUserId(), playListName, songIds);
        return playListRepository.save(playList);
    }

    @Override
    public void removePlayList(Integer userId, Integer playListId) {
        Playlist playList = playListRepository.findById(playListId).orElseThrow(() -> new PlaylistNotFoundException("Playlist Not Found!"));
        playListRepository.delete(playList);
    }

    @Override
    public Playlist modifyPlayList(String cmd, Integer ownerId, Integer playListId,
        List<Integer> songIds) throws PlaylistNotFoundException, InvalidOperationException {
        Playlist playList = playListRepository.findById(playListId).orElseThrow(() -> new PlaylistNotFoundException("Playlist Not Found!"));
        if (cmd.equals("ADD-SONG")) {
            for(int i = 0; i < songIds.size(); i++) {
                if(!songRepository.existsById(songIds.get(i))) {
                    continue;
                    // throw new InvalidOperationException("Some Requested Songs Not Available. Please try again.");
                } else {
                    playList.addSongPlaylist(songIds.get(i));
                }
            }
            playListRepository.save(playList);
        } else if(cmd.equals("DELETE-SONG")) {
            for(int i = 0; i < songIds.size(); i++) {
                if(!songRepository.existsById(songIds.get(i))) {
                    continue;
                    // throw new InvalidOperationException("Some Requested Songs Not Available. Please try again.");
                } else {
                    playList.removeSongPlaylist(songIds.get(i));
                }
            }
            playListRepository.save(playList);
        }
        return playList;
    }

    // public Playlist playPlaylist(Integer userId, Integer playListId){
    //     Playlist playList = playListRepository.findById(playListId).orElseThrow(() -> new PlaylistNotFoundException("Playlist Not Found!"));

    // }
    
}
