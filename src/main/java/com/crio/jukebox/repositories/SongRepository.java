package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Song;

public class SongRepository implements ISongRepository{
    private final Map<Integer,Song> songMap;
    private Integer autoIncrement = 0;

    public SongRepository(){
        songMap = new HashMap<Integer,Song>();
    }

    public SongRepository(Map<Integer,Song> songMap){
        this.songMap = songMap;
        this.autoIncrement = songMap.size();
    }

    @Override
    public Song save(Song entity){
        if(entity.getSongId() == null){
            autoIncrement++;
            Song s = new Song(autoIncrement,entity.getSongName(),entity.getGenre(),entity.getAlbum(),entity.getAlbumArtist(),entity.getFeaturedArtist());
            songMap.put(s.getSongId(),s);
            return s;
        }
        songMap.put(entity.getSongId(),entity);
        return entity;
    }

    @Override
    public List<Song> findAll() {
        return songMap.values().stream().collect(Collectors.toList());

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public boolean existsById(Integer id) {
        return songMap.containsKey(id);
    }

    @Override
    public void delete(Song entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

}
