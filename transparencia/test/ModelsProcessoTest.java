import static org.junit.Assert.*;
import models.Processo;

import org.junit.Test;

import play.db.ebean.Model.Finder;

import java.util.*;



public class ModelsProcessoTest {
	
	models.Processo op = new models.Processo();
	//models.Processo processo1 = new models.Processo();
	//models.Processo processo2 = new models.Processo();
	//models.Processo processo3 = new models.Processo();
	//ArrayList <models.Processo> processotest = new ArrayList<models.Processo>();
	//public static Finder<Long,models.Processo> find = new Finder<Long,models.Processo>(Long.class, models.Processo.class);
	
	/*public void dadosTest(){
		processo1.id = (long) 1;
		processo1.descricao = "Roubou";
		processo1.acusacoes = "Corrupção";
		processo1.processo = "processo1.txt";
		processo1.status = "Arquivado";
		processo1.defesa = "Sim";
		processo1.textoDefesa = "Não há provas";
		processo1.orgaoDeInvestigacao = "STF";
		
		processo2.id = (long) 2;
		processo2.descricao = "Propina";
		processo2.acusacoes = "Corrupção";
		processo2.processo = "processo2.txt";
		processo2.status = "Em andamento";
		processo2.defesa = "Não";
		processo2.textoDefesa = "Não há defesa";
		processo2.orgaoDeInvestigacao = "MP-RN";

		processo3.id = (long) 3;
		processo3.descricao = "AAA";
		processo3.acusacoes = "BBB";
		processo3.processo = "processo3.txt";
		processo3.status = "Cadastrado";
		processo3.defesa = "Sim";
		processo3.textoDefesa = "CCC";
		processo3.orgaoDeInvestigacao = "DDD";
		
		
		
	
	}*/
	
	@Test
	public void testAll() {
		//processotest.add(processo1);
		//processotest.add(processo2);
		//processotest.add(processo3);
		
		assertEquals(op, Processo.all());
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProcesso() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

}
