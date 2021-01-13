import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// You have a bunch of files and folders, 
// Design a playlist which can have any file from any folder and a player that plays it

public class MusicPlayer 
{
	
	private File file;
	private ArrayList<File> files;
	private LinkedList<File> folders;
	private int count = 1;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new MusicPlayer("E:/");
	}

	public MusicPlayer(String path) 
	{
		file = new File(path);
		files = new ArrayList<File>();
		folders = new LinkedList<File>();
		recurSearch(file);
	}

	public void compile(File file) {
		if (file.isDirectory()&&!file.isHidden()) {
			System.out.println("Folder Path>>>>>>>>>>" +
					file.getAbsolutePath());
			folders.add(file);
		} else if (!file.isHidden()) {
			System.out.println("File Path " + file.getAbsolutePath());
			files.add(file);
		}
	}

	public void recurSearch(File file) 
	{
		System.out.println("Cycle no: " + count++);
		
		// If it is a directory
		if (file.isDirectory() || !file.isHidden()) 
		{
			for (File file1 : file.listFiles()) 
			{
				compile(file1);
			}
			
		} 
		
		// If it is a file
		else if (!file.isHidden()) 
		{
			files.add(file);
		}
		
		// It means, yahan tak wo file poori ho gayi aur folder bhi. Ab remove kar do.
		if (!folders.isEmpty()) 
		{
			recurSearch(folders.removeLast());
		}
		else 
		{
			return;
		}

	}
	
	public class Playlist 
	{
	    private Song track;
	    private Queue<Song> queue;
	    public Playlist(Song track, Queue<Song> queue) 
	    {
	        super();
	        this.track = track;
	        this.queue = queue;
	    }

	    public Song getNextTrackToPlay(){ return queue.peek(); }
	    public void queueUpTrack(Song s){ queue.add(s); }
	}
	
	public class Song 
	{
	    private String songName;
	    public String toString() { return songName; }
	}
}
