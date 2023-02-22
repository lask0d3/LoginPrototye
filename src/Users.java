
public class Users {
	public static String firstname;
	public static String lastname;
	public static String email;
	public static String username;
	public static String password;

	public Users(String firstname, String lastnamme, String email, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastnamme;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstname;
	}

	public String getSecondName() {
		return lastname;
	}

	public String getEmail() {
		return email;
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
