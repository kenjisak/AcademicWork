import java.util.*;

public class MusicExchangeCenter {
    private ArrayList<User> users;
    private HashMap<String,Float> royalties;
    private ArrayList<Song> downloadedSongs;
    public MusicExchangeCenter(){
        users = new ArrayList<User>();
        royalties = new HashMap<String, Float>();
        downloadedSongs = new ArrayList<Song>();
    }
    public ArrayList<User> onlineUsers(){
        ArrayList<User> onlineusers = new ArrayList<User>();
        for (User user : users) {
            if (user.isOnline()) {
                onlineusers.add(user);
            }
        }
        return onlineusers;
    }
    public ArrayList<Song> getDownloadedSongs(){
        return downloadedSongs;
    }
    public void displayRoyalties(){
        String artist;
        Float amount;
        ArrayList<String> printthis = new ArrayList<String>();
        printthis.add(String.format("%-11s %-15s","Amount","Artist"));
        printthis.add("-----------------------");
        //String printthis=String.format("$%-10.2f %-15s",amount,artist);
        for(HashMap.Entry<String,Float> entry : royalties.entrySet()){
            artist = entry.getKey();
            amount = entry.getValue();
            printthis.add(String.format("$%-10.2f %-15s",amount,artist));
        }
        for(String print: printthis){
            System.out.println(print);
        }

        //have hashmap only have 1 key but keep adding the value after the download
    }
    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> allavailablesongs = new ArrayList<Song>();
        ArrayList<User> onlineusers = onlineUsers();
        for (User user: onlineusers){
            ArrayList<Song> songlist = user.getSongList();
            allavailablesongs.addAll(songlist);
        }
        return allavailablesongs;
    }
    public String toString()  {
        int numsongs = allAvailableSongs().size();
        int numuser = onlineUsers().size();
        return "Music Exchange Center (" + numuser + " users on line, " + numsongs + " songs available)";

    }
    public User userWithName(String s){
        //System.out.println(users);
        for (User user : users) {
            if (user.getUserName().equals(s)) {
               // System.out.print(s);
                return user;
            } else {
                return null;
            }
        }
        return null;
    }
    public void registerUser(User x){
       /*
        if (!users.contains(x)){
            users.add(x);
        }
        */
        if(userWithName(x.getUserName()) == null){
            users.add(x);
        }


       // System.out.print(x);
    }
    public ArrayList<Pair<Integer,Song>> songsByPopularity(){
        List<Pair<Integer,Song>> listofpairs = new ArrayList<Pair<Integer,Song>>();
        for (Song song: uniqueDownloads()){
            int counter = 0;
            for(Song songs :downloadedSongs){
                if(song.getTitle().equals(songs.getTitle())){
                    counter +=1;
                }
            }
            listofpairs.add(new Pair<Integer,Song>(counter,song));
        }
        listofpairs.sort(new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                // PUT YOUR CODE IN HERE
                if (p1.getKey() > p2.getKey()) {
                    return -1;
                }
                return 0;
            }
        });
        return new ArrayList<Pair<Integer, Song>>(listofpairs);
    }
    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> availablesongsbyartist = new ArrayList<Song>();
        ArrayList<Song> songlist = allAvailableSongs();
        /*
        for (User user: users){
            //get all users, then look through all their songs and add the songs with the artist name. use get artist
            songlist.addAll(user.getSongList());
        }
         */

        for (Song song : songlist){
            if(song.getArtist().equals(artist)){
                availablesongsbyartist.add(song);
            }
        }
        return availablesongsbyartist;
    }
    public TreeSet<Song> uniqueDownloads(){
        return new TreeSet<Song>(downloadedSongs);
    }
    public Song getSong(String title, String ownerName){
        ArrayList<User> onlineusers = onlineUsers();
        for(User user: onlineusers){
            if(user.getUserName().equals(ownerName)){
                for(Song song: user.getSongList()){
                    if(song.getTitle().equals(title)){
                        downloadedSongs.add(user.songWithTitle(title));
                        if(royalties.isEmpty()||!royalties.containsKey(user.songWithTitle(title).getArtist())){
                            royalties.put(user.songWithTitle(title).getArtist(),0.25f);
                        }else{
                            royalties.put(user.songWithTitle(title).getArtist(),royalties.get(user.songWithTitle(title).getArtist()) + 0.25f);
                        }
                        return user.songWithTitle(title);
                    }
                }
             }
        }
        return null;
    }
}
