import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    //find
    public boolean findSong(String title){
        for(Song checkedSong:songs){
            if(checkedSong.getTitle().equals(title)){
                System.out.println("The Song exist in the Album!");
                return true;
            }
        }
        return false;
    }

    //Add Song
    public boolean addSong(String title, double duration){
        if(findSong(title)==true){
            System.out.println("Song already exists!");
            return false;
        }

        Song newSong = new Song(title,duration);
        this.songs.add(newSong);
        return true;
    }

    //Add to playlist using Song title
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){

        for(Song checkedSong:this.songs){
            if(checkedSong.getTitle().equals(title)){
                playlist.add(checkedSong);
                return true;
            }
        }

        return false;

    }

    //Add to playlist using Song track Number
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber-1;
        if(index>=0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }

        return false;

    }

    //print all songs in the album
    public void printAllSongs(){
        System.out.println("Album: "+this.name + ", Artist: "+this.artist);
        for(Song checkedSong:this.songs){
            System.out.println(checkedSong.toString());
        }
    }











}
