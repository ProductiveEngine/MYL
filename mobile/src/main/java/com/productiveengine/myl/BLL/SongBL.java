package com.productiveengine.myl.BLL;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.productiveengine.myl.DomainClasses.Song;

import java.io.Serializable;
import java.util.List;

public class SongBL implements Serializable{

    public Song fetchNextSong(){

        Song song = new Select().from(Song.class).orderBy("RANDOM()").executeSingle();

        return song;
    }

    public void saveAll(List<Song> songList){

        ActiveAndroid.beginTransaction();

        try {
            for (Song song: songList) {
                song.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }

    public void deleteByPath(String path){

        if(path != null){
            new Delete().from(Song.class).where("Path = ?", path).execute();
        }
    }

    public List<Song> getAll() {
        return new Select()
                .from(Song.class)
                .execute();
    }

    public int countAll() {
        return new Select()
                .from(Song.class)
                .count();
    }

    public void clearAll() {

        ActiveAndroid.beginTransaction();

        try {
            new Delete().from(Song.class).execute();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}
