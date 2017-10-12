import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Principal {

	; 

	public static void main(String[] args) {
		System.out.println("teste GIT");
		com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco"); 
		Pergunta p = new Pergunta();
		p.setPergunta("Qual é a cor do ceu durante o dia?", 1, "azul", "amarelo", "roxo", "vermelho", "verde");
		//db.store(p);
		try {
			ObjectSet<Pergunta> os = db.queryByExample(p);
			Pergunta achou = os.next();
			System.out.println(achou.descricao);
			System.out.println(achou.resposta2);
			System.out.println(achou.responde(2));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
}
