package grooming.pet;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@QualificacaoBanhoETosa(raca="labrador") // aqui pode ser um enum
public class BanhoLabrador implements BanhoETosa {

  // Construtor e outros métodos da classe
  @Override
  public void darBanho(final Pet pet) {
    System.out.println("Dando banho no Labrador.");
  }

}