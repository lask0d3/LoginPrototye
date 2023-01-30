
public class Users {
	public static String username;
	public static String password;
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toSTRING() {
		return "USERNAME " + username + "\nPASSWORD " +password;
	}
	
//	public boolean equals(Object obj) {
//		Users cred = (Users) obj;
//		if(cred.equals(obj))
//		return true;
//		return false;
//	
//	}
	
	
	public boolean equals(String usernameln, String passwordln) {
		if(username.equals(usernameln) && password.equals(passwordln)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	public String myString(){
		return "Username " + username + " password " + password;
	}
}
