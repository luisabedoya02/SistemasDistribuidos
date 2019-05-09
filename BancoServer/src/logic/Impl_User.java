package logic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.rmi.PortableRemoteObject;

import persistence.NotFoundException;
import persistence.User;
import persistence.UserDao;
import interfaces.IUser;

public class Impl_User extends UnicastRemoteObject implements IUser {

	public Impl_User() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public User searchUser(int id) throws RemoteException {
		// crear el value object a retornar
		User u = new User(id);
		// crear los DAO a manipular
		UserDao user = new UserDao();

		try {
			user.load(getConnection(), u);
		} catch (SQLException e) {
			u = null;
			e.printStackTrace();
		} catch (NotFoundException e) {
			u = null;
			e.printStackTrace();
		}
		return u;
	}

	public List searchUsers() throws RemoteException {
		List l = null;
		// crear los DAO a manipular
		UserDao user = new UserDao();

		try {
			l = user.loadAll(getConnection());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public boolean updateUser(int id, String name, String log) throws RemoteException {
		boolean update = true;
		// crear el value object a actualizar
		User u = new User();
		u.setAll(id, name, log);
		// crear los DAO a manipular
		UserDao user = new UserDao();

		try {
			user.save(getConnection(), u);
		} catch (SQLException e) {
			update = false;
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			update = false;
			e.printStackTrace();

		}
		return update;
	}

	public boolean delUser(int id) throws RemoteException {
		boolean del = true;
		// crear el value object a eliminar
		User u = new User(id);
		// crear los DAO a manipular
		UserDao user = new UserDao();

		try {
			user.delete(getConnection(), u);
		} catch (SQLException e) {
			del = false;
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			del = false;
			e.printStackTrace();
		}
		return del;
	}

	public boolean addUser(int id, String name, String log) throws RemoteException {
		boolean add = true;

		// crear el value object de user
		User u = new User(id);
		u.setLogin(log);
		u.setName(name);

		// crear el DAO a manipular
		UserDao user = new UserDao();

		try {
			user.create(getConnection(), u);
		} catch (SQLException e) {
			add = false;
			e.printStackTrace();
		}
		return add;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			// registrar la clase del driver
			Class.forName("com.mysql.jdbc.Driver");
			// obtener el objeto de conexion
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");// login=postgres
																											// ,
																											// contraseña=postgres
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
