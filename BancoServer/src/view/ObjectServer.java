package view;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import logic.Impl_User;

public class ObjectServer {

	/**
	 * @param args
	 */
public static void main(String[] args) throws RemoteException, MalformedURLException{
		
		
		Impl_User impl = new Impl_User();
		Registry r = LocateRegistry.createRegistry(10000);
		r.rebind("Usuario",impl);
		    System.out.println("Objeto Publicado");
		
	}

}

