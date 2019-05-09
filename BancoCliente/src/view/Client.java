package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistence.User;
import control.BankControl;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Client extends JFrame {
	private BankControl bc;
	private MessageBean bm;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField cedula = null;
	private JTextField login = null;
	private JTextField nombre = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton add = null;
	private JButton find = null;
	private JButton update = null;
	private JButton delete = null;
	private JScrollPane jScrollPane = null;
	private JTextArea listUsers = null;
	
	public Client() throws HeadlessException, RemoteException, NotBoundException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Client(GraphicsConfiguration arg0) throws RemoteException, NotBoundException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Client(String arg0) throws HeadlessException, RemoteException, NotBoundException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public Client(String arg0, GraphicsConfiguration arg1) throws RemoteException, NotBoundException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes cedula	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCedula() {
		if (cedula == null) {
			cedula = new JTextField();
			cedula.setBounds(new java.awt.Rectangle(62,15,81,20));
		}
		return cedula;
	}

	/**
	 * This method initializes login	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLogin() {
		if (login == null) {
			login = new JTextField();
			login.setBounds(new java.awt.Rectangle(63,73,80,20));
		}
		return login;
	}

	/**
	 * This method initializes nombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombre() {
		if (nombre == null) {
			nombre = new JTextField();
			nombre.setBounds(new java.awt.Rectangle(62,41,80,20));
		}
		return nombre;
	}

	/**
	 * This method initializes Add	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAdd() {
		if (add == null) {
			add = new JButton();
			add.setBounds(new java.awt.Rectangle(158,8,89,27));
			add.setText("Add");
			add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Add"); // TODO Auto-generated Event stub actionPerformed()
					//agregar un usuario
					if(bc.addUser(Integer.parseInt(cedula.getText()),nombre.getText(),login.getText()))
						clean();
					else
						bm.error("Inserción fallida");
					
				}
			});
		}
		return add;
	}

	/**
	 * This method initializes find	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFind() {
		if (find == null) {
			find = new JButton();
			find.setBounds(new java.awt.Rectangle(159,43,89,28));
			find.setText("Find");
			find.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Find"); // TODO Auto-generated Event stub actionPerformed()
					//encontrar un usuario
					
					User u=bc.searchUser(Integer.parseInt(cedula.getText()));
					if(u!=null){
						cedula.setText(Integer.toString(u.getId()));
						nombre.setText(u.getName());
						login.setText(u.getLogin());
					}
					else
						bm.error("Usuario no encontrado");
				}
			});
		}
		return find;
	}

	/**
	 * This method initializes update	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUpdate() {
		if (update == null) {
			update = new JButton();
			update.setBounds(new java.awt.Rectangle(159,82,90,26));
			update.setText("Update");
			update.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Update"); // TODO Auto-generated Event stub actionPerformed()
					//actualizar un usuario
					if(bc.updateUser(Integer.parseInt(cedula.getText()),nombre.getText(),login.getText()))
						clean();
					else
						bm.error("Actualización fallida");
				}
			});
		}
		return update;
	}

	/**
	 * This method initializes delete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDelete() {
		if (delete == null) {
			delete = new JButton();
			delete.setBounds(new java.awt.Rectangle(160,117,88,27));
			delete.setText("Delete");
			delete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Delete"); // TODO Auto-generated Event stub actionPerformed()
					//agregar un usuario
					if(bc.delUser(Integer.parseInt(cedula.getText())))
						clean();
					else
						bm.error("Borrado fallido");
				}
			});
		}
		return delete;
	}


	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new java.awt.Rectangle(28,113,74,100));
			jScrollPane.setViewportView(getListUsers());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes listUsers	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getListUsers() {
		if (listUsers == null) {
			listUsers = new JTextArea();
		}
		return listUsers;
	}

	/**
	 * @param args
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws HeadlessException 
	 */
	public static void main(String[] args) throws HeadlessException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		Client c=new Client();
		c.show();

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 */
	private void initialize() throws RemoteException, NotBoundException {
		this.setSize(300, 328);
		this.setContentPane(getJContentPane());
		this.setTitle("Cliente");
		bc=new BankControl();
		bm=new MessageBean();
		bm.setCFather(this);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(10,75,45,16));
			jLabel2.setText("Login");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(9,42,45,16));
			jLabel1.setText("Nombre");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(9,17,48,16));
			jLabel.setText("Cédula");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCedula(), null);
			jContentPane.add(getLogin(), null);
			jContentPane.add(getNombre(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getAdd(), null);
			jContentPane.add(getFind(), null);
			jContentPane.add(getUpdate(), null);
			jContentPane.add(getDelete(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}
	
	private void clean(){
		cedula.setText("");
		nombre.setText("");
		login.setText("");
		System.out.println("Luisa escribió algo");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
