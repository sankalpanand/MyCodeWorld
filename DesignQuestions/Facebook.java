import java.util.*;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class User 
{
	int id;  // unique id
	List<Update> self_updates; // owned by user; list of updates in reverse chrono order
	List<Update> friend_updates;  // owned by user friends; list of updates in reverse chronological order
	List<User> friends; // Friend list
	
	public void publish(Message msg)
	{
		Update update = new Update();
		update.msg = msg;
		
		self_updates.add(0, update);
		
		for(User friend : friends)
		{
			friend.friend_updates.add(0, update);
		}			
	}
	
	public void getNewsFeed(Message msg)
	{
		// Get self_updates
		// Get friend_updates
		// mergeSort them as per time stamp
		// Take top 30 and send them
	}
}

class Update 
{
	UpdateType type; // media type of this update - can be photo/video etc
	Date timestamp;
	Message msg; // Message text in this update
	Media media;   // can be pointer to photo/video/audio in the update OR NULL
	List<Comment> comments;  // Comments on this update
}

class Message
{
	
}

class Comment
{
	
}

class Media
{
	
}

enum UpdateType
{
	photo, video, text
}