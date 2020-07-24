package com.epam.DesignPatterns;

interface DatabaseExecuter {
	public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if(name == "Admin" && passwd == "Admin@123") {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	public void executeDatabase(String query) throws Exception {
		if(ifAdmin) {
			dbExecuter.executeDatabase(query);
		} else {
			if(query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyDesign {
	public static void main(String[] args) throws Exception {
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE");

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("ABC", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");

	}

}