import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {

     private Connection conect = null;
     private Statement comando  = null;
     private ResultSet resultado = null;
	     
     public void conectar() {
    	 
    	 String servidor = "jdbc:mysql://localhost:3306/banco_pessoal";
	     String usuario = "root";
	     String senha = "matheus";
	     String driver = "com.mysql.jdbc.Driver";
	     
	     try{
	    	 Class.forName(driver);
	    	 this.conect = DriverManager.getConnection(servidor, usuario, senha);
	    	 this.comando = this.conect.createStatement();
	     }catch(Exception e){
	    	 System.out.println("Erro" + e.getMessage());
	     }
     
 }

	public boolean estaConectado() {
		if(this.conect != null){
			return true;
		}else{
			return false;
		}
	}
	public void listarContatos() {
		try{
		String query = "SELECT id,nome,telefone FROM contato ";
		this.resultado = this.comando.executeQuery(query);
			while(this.resultado.next()){
				System.out.println("ID: "+this.resultado.getString("id") +" Nome: "+this.resultado.getString("nome")+" Telefone: "+this.resultado.getString("telefone"));
			}
		}catch(Exception e){
			System.out.println("Erro"+ e.getMessage());
		}
	}
	public void inserirContato(String nome, String telefone){
		try{
			String query = "INSERT INTO contato(nome,telefone) values ('"+ nome +"','" +telefone+ "' );"; 
			this.comando.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Erro"+ e.getMessage());
		}
	}
	
	public void editarContato(String id, String nome, String telefone){
		try{
			String query = "UPDATE contato SET nome = '" + nome + "','" +telefone+ "' WHERE id = '" +id+ "';"; 
			this.comando.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Erro"+ e.getMessage());
		}
	}
	
	public void apagarContato(String id){
		try{
			String query = "DELETE FROM contato where id = '" +id+ "';"; 
			this.comando.executeUpdate(query);
		}catch(Exception e){
			System.out.println("Erro"+ e.getMessage());
		}
	}
	
	public void desconectar() {
		try{
			this.conect.close();
		}catch(Exception e){
			System.out.println("Erro"+ e.getMessage());
		}
	}

}

