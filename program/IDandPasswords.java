package program;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("admin","123");
	
	}
	
	public HashMap<String,String> getLoginInfo(){
		return logininfo;
	}
}