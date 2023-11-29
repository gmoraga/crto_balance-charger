package cl.gabodev.crto.balger.repository;
import org.springframework.stereotype.Repository;

import cl.gabodev.crto.balger.domain.entity.RawBinanceCard;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RawBinanceCardRepository extends JpaRepository<RawBinanceCard, Long> {
	
//  private static List<BalgerRawBinanceCard> cursos= new ArrayList<BalgerRawBinanceCard>();
  
//  static {
//    
//    cursos.add(new Curso("java",20));
//    cursos.add(new Curso("php",30));
//    cursos.add(new Curso("python",50));
//    
//  }
  
//  public List<BalgerRawBinanceCard> buscarTodos() {
//    
//    return cursos;
//  }
  
	
	
	
}