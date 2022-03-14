package program;

import java.awt.EventQueue;

@SuppressWarnings("unused")
public class Main {



  
    public static void main(String[] args) {
    		
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FormPage window = new FormPage();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    /*	IDandPasswords idandPasswords = new IDandPasswords();
    	@SuppressWarnings("unused")
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());*/
    
		
    }

}