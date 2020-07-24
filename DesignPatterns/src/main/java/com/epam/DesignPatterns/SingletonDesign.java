package com.epam.DesignPatterns;

class SingletonEagar {
	private static SingletonEagar inst = new SingletonEagar(); 
	private SingletonEagar(){}

	public static SingletonEagar getInstance() {
		return inst;
	}
}

class SingletonE {
	private static SingletonDesign instance; 
	private SingletonE(){}  
	public static SingletonDesign getInstance() {
		if(instance == null) {
			instance = new SingletonDesign();
		}

		return instance;
	}
}

class SingletonSynchronizedMethod {
	private static SingletonSynchronizedMethod instance; 

	private SingletonSynchronizedMethod(){}

	public static synchronized SingletonSynchronizedMethod getInstance() {
		if(instance == null) {
			instance = new SingletonSynchronizedMethod();
		}
		return instance;
	}
}

class SingletonSync {
	private static SingletonSync exInst; 

	private SingletonSync(){}

	public static SingletonSync getInstance() {
		if(exInst == null) {
			synchronized (SingletonSync.class) {
				if(exInst == null) {
					exInst = new SingletonSync();
				}
			}
		}
		return exInst;
	}
}

public class SingletonDesign {
	public static void main(String[] args) {
		SingletonSync exInst1 = SingletonSync.getInstance();

		System.out.println(exInst1);

		SingletonSync exInst2 = SingletonSync.getInstance();

		System.out.println(exInst2);
	}
}