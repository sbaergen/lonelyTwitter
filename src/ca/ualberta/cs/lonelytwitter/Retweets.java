package ca.ualberta.cs.lonelytwitter;

public class Retweets {
	private int retweets;
	
	public Retweets() {
		super();
		this.retweets = 0;
	}

	public int getRetweets() {
		return retweets;
	}
	
	public void addRetweet(){
		this.retweets++;
	}
	
	public void deleteRetweet(){
		this.retweets--;
	}
	
}
