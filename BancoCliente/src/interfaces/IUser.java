package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import persistence.User;

public interface IUser extends Remote {
	User searchUser(int id) throws RemoteException;

	boolean updateUser(int id, String name, String log) throws RemoteException;

	boolean delUser(int id) throws RemoteException;

	boolean addUser(int id, String name, String log) throws RemoteException;
}
