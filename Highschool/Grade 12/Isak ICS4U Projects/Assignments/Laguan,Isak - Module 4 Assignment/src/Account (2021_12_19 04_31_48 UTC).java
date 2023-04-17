
public class Account {
	private String email,name,user,pass;
	private double balance;
	/**
	* constructor
	* pre: none
	* post: Account object created. The user is given a guest account.
	*/
	public Account(){
		email = " ";
		name = "Guest";
		user = "Guest";
		pass = " ";
		balance = 200;
	}
	/**
	* constructor
	* pre: none
	* post: Account object created. The user is has signed into existing account.
	*/
	public Account(String emailsignin, String password){
		email = emailsignin;
		pass = password;
		name = "Kenji Isak ";
		user = "Kenjjji";
		balance = 200;
		
	}
	/**
	* constructor
	* pre: none
	* post: Account object created. The user is given a new account that they make.
	*/
	public Account(String newemail,String newname,String newuser,String newpass){
		email = newemail;
		name = newname;
		user = newuser;
		pass =	newpass;
		balance = 200;
	}
	/**
	* Sets the Account email,name,user,pass.
	* pre: none.
	* post: Account email,name,user,pass has been made.
	*/
	public void setemail(String newemail){
		email = newemail;
	}
	public void setname(String newname){
		name = newname;
	}
	public void setuser(String newuser){
		user = newuser;
	}
	public void setpass(String newpass){
		pass = newpass;
	}
	
	
	/**
	* Returns the Account email,name,user,pass.
	* pre: none
	* post: Account email,name,user,pass has been returned.
	*/
	public String getemail(){
		return email;
	}
	public String getname(){
		return name;
	}
	public String getuser(){
		return user;
	}
	public String getpass(){
		return pass;
	}
	/**
	* Sets the Account balance.
	* pre: balance is set to 200
	* post: Account balance has been calculated and set.
	*/
	public void setbalance(double total){
		balance = balance - total;
	}
	/**
	* Returns the Account balance.
	* pre: 
	* post: Account balance has been returned.
	*/
	public double getbalance(){
		return balance;
	}
	/**
	* Returns a boolean depending if the 2 accounts have the same email and password .
	* pre: 
	* post: Boolean returned.
	*/
	public boolean equals(Object acc){
		Account testObj = (Account) acc;
		if (testObj.getemail().equals(email) && testObj.getpass().equals(pass)){
			return true;
		}else{
			return false;
		}
	}
}
