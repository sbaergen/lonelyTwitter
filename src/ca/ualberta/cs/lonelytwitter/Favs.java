package ca.ualberta.cs.lonelytwitter;

public class Favs implements FavInterface{

	private String tweet;
	
	public Favs(String tweet) {
		super();
		this.tweet = tweet;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	public boolean checkFav(String text){
		if (text == this.tweet){
			return true;
		}
		return false;
	}
}
