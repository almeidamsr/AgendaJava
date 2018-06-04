
public class Agenda {

	public static void main(String[] args) {
			
		BancoDeDados bancoDeDados = new BancoDeDados();
		
		bancoDeDados.conectar();
			
			if (bancoDeDados.estaConectado())
			{
				bancoDeDados.listarContatos();
				bancoDeDados.inserirContato("Amanda","99556645");
				bancoDeDados.editarContato("1", "Matheus Almeida", "4198476430");
				bancoDeDados.apagarContato("1");
				bancoDeDados.desconectar();
			}
			else
			{
				System.out.println("Não foi possivel conectar");
			}
	}

}
