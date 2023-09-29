package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository{
    private final Map<Integer, Playlist> playListMap;
    private Integer autoIncrement = 0;

    public PlaylistRepository() {
        playListMap = new HashMap<Integer, Playlist>();
    }

    public PlaylistRepository(Map<Integer, Playlist> playListMap) {
        this.playListMap = playListMap;
        this.autoIncrement = playListMap.size();
    }


    @Override
    public Playlist save(Playlist entity) {
        // TODO Auto-generated method stub
        if( entity.getPlayListId() == null ){
            autoIncrement++;
            Playlist pl = new Playlist(autoIncrement,entity.getOwnerId(),entity.getPlaylistName(),entity.getSongsIds());
            playListMap.put(pl.getPlayListId(),pl);
            return pl;
        }
        playListMap.put(entity.getPlayListId(),entity);
        return entity;
    }

    @Override
    public List<Playlist> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(playListMap.get(id));
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void delete(Playlist entity) {
        // TODO Auto-generated method stub
        playListMap.remove(entity.getPlayListId());
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

}
