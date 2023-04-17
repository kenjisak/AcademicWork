import java.util.ArrayList;

public class User {
  private String     userName;
  private boolean    online;
  private ArrayList<Song> songList;

  public User()  {
    this("");
  }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<Song>();
  }

  public void addSong(Song s){
    s.setOwner(this);
    songList.add(s);
  }
  public Song songWithTitle(String title){
    for (Song song: songList){
      if(song.getTitle().equals(title)){
        return song;
      }
    }
    return null;
  }
  public int totalSongTime(){
    int time = 0;
    for (Song song : songList) {
      time += song.getSeconds();
    }
    return time;
  }
  public String getUserName() {
    return userName;
  }
  public ArrayList<Song> getSongList(){
    return songList;
  }
  public boolean isOnline()  {
    return online;
  }
  
  public String toString()  {
    String s = "" + userName + ": "+ getSongList().size() +" songs (";
    if (!online) s += "not ";
    return s + "online)";
  }
  public void register(MusicExchangeCenter m){
    //System.out.print(m.userWithName(getUserName()));
    m.registerUser(this);
  }
  public void logon(){
   online = true;
  }
  public void logoff(){
    online = false;
  }
  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
    ArrayList<Song> completesonglist = m.allAvailableSongs();
    ArrayList<String> returnthis = new ArrayList<String>();

    Song temp;
    String artist;
    String title;
    int minutes;
    int seconds;
    String owner;
    String all = String.format("    %-30s %-16s %-6s %-20s","TITLE","ARTIST","TIME","OWNER");
    returnthis.add(all);

    for (int i = 0; i<completesonglist.size();i++){
      temp = completesonglist.get(i);
      artist=temp.getArtist();
      title=temp.getTitle();
      minutes = temp.getMinutes();
      seconds = temp.getSeconds();
      owner = temp.getOwner().getUserName();
      all = String.format("%2d. %-30s %-15s %2d:%02d   %-20s",(i+1), title,artist,minutes,seconds,owner);
      returnthis.add(all);
    }
    return returnthis;
  }
  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
    ArrayList<Song> completesonglist = m.allAvailableSongs();
    ArrayList<Song> artistonlysonglist = new ArrayList<Song>();
    ArrayList<String> returnthis = new ArrayList<String>();

    Song temp;
    String artistname;
    String title;
    int minutes;
    int seconds;
    String owner;
    String all = String.format("    %-30s %-16s %-6s %-20s","TITLE","ARTIST","TIME","OWNER");
    returnthis.add(all);

    for (Song song : completesonglist) {
      if (song.getArtist().equals(artist)) {
        artistonlysonglist.add(song);
      }
    }
    for (int i = 0; i<artistonlysonglist.size();i++){
      temp = artistonlysonglist.get(i);
      artistname=temp.getArtist();
      title=temp.getTitle();
      minutes = temp.getMinutes();
      seconds = temp.getSeconds();
      owner = temp.getOwner().getUserName();
      all = String.format("%2d. %-30s %-15s %2d:%02d   %-20s",(i+1), title,artistname,minutes,seconds,owner);
      returnthis.add(all);
    }
    return returnthis;
  }
  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
    Song check = m.getSong(title,ownerName);
    if( check != null){
      addSong(check);
    }
  }

}
