import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Album a1 = new Album("a1","Lil nas x");
        a1.addSong("Old town road",4.5);
        a1.addSong("Panini",4.8);
        a1.addSong("Industry baby",3.5);
        a1.addSong("Thats what i want",5.6);
        a1.addSong("Montero",5.6);

        a1.printAllSongs();

        //creating Playlist and adding songs into Playlist from album a1;
        LinkedList<Song> myPlaylist = new LinkedList<>();
        a1.addToPlaylist("Old town road",myPlaylist);
        a1.addToPlaylist("Panini",myPlaylist);
        //a1.addToPlaylist("Industry baby",myPlaylist);

        play(myPlaylist);
    }

    public static void play(LinkedList<Song> myPlaylist) {

        ListIterator itr = myPlaylist.listIterator();
        Scanner sc = new Scanner(System.in);

        if(!itr.hasNext()){
            System.out.println("PlayList is Empty!!");
            return;
        }

        System.out.println("You are now listening to : " + itr.next());
        showMenu();

        boolean forward = true;

        while(true){
            int option = sc.nextInt();
            switch (option){
                case 0:
                    System.out.println("Thanks for Listening! Have a good day!");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printAllSongs(myPlaylist);
                    break;
                case 3:
                    if(!forward){
                        if(itr.hasNext())
                            itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of Playlist");
                    }else{
                        System.out.println("You are now listening to: " + itr.next());
                    }

                    forward = true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious())
                            itr.previous();
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You have reached the start of Playlist");
                    }else{
                        System.out.println("You are now listening to: " + itr.previous());
                    }
                    forward = false;
                    break;
                case 5:
                    if(forward){
                        if(itr.hasPrevious()){
                            System.out.println("You are now listening to: "+ itr.previous());
                            forward = false;
                        }else{
                            System.out.println("You have reached the start of Playlist");
                        }
                    }else{
                        if(itr.hasNext()){
                            System.out.println("You are now listening to: " + itr.next());
                            forward = true;
                        }else{
                            System.out.println("You have reached the end of Playlist");
                        }
                    }
                    break;
                case 6:
                    if(myPlaylist.size()>0){
                        itr.remove();
                        if(itr.hasNext()){
                            System.out.println("You are now listening to: "+ itr.next());
                        }else{
                            if(itr.hasPrevious()){
                                System.out.println("You are now listening to: "+ itr.previous());
                            }
                        }
                    }
                    break;
            }


        }
    }


    public static void printAllSongs(LinkedList<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void showMenu(){

        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");

    }

    //Song application is complete!
}
