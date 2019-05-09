package control;

import interfaces.IUser;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import persistence.User;

public class BankControl {
	private User u=null;;
	private IUser ir=null;
	
	public BankControl() throws RemoteException, NotBoundException{
		Registry r = LocateRegistry.getRegistry(10000);
		ir= (IUser) r.lookup("Usuario");
		
        }
	
	public User searchUser(int id){
		try{
			u=ir.searchUser(id);
		}
		catch(RemoteException e){
			e.printStackTrace();
			u=null;
		}
		return u;
	}
	
	public boolean updateUser(int id,String name,String log){
		boolean update=true;
		try{
			if(!ir.updateUser(id,name,log))
				update=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			update=false;
		}
		return update;
	}
	public boolean delUser(int id){
		boolean del=true;
		try{
			if(!ir.delUser(id))
				del=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			del=false;
		}
		return del;
	}
	
	public boolean addUser(int id,String name,String log){
		boolean add=true;
		try{
			if(!ir.addUser(id,name,log))
				add=false;
		}
		catch(RemoteException e){
			e.printStackTrace();
			add=false;
		}
		return add;
	}

}
