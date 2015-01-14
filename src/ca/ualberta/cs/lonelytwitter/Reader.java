package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Reader extends User {
	private static Boolean enabled = false;
	public void setName(String newName) throws IOException {
		if (newName.length() > 8){
			throw new IOException("Name too long!");
		}
			this.name = newName;
	}
}
