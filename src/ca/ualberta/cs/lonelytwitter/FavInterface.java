package ca.ualberta.cs.lonelytwitter;

public interface FavInterface {
	public String getTweet();

	public void setTweet(String tweet);
	
	public boolean checkFav(String text);
}
