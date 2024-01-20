package grooming.pet;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@QualificacaoBanhoETosa(raca="bulldog") // aqui pode ser um enum
public class BanhoBulldog implements BanhoETosa {
  // Construtor e outros métodos da classe
  @Override
  public void darBanho(Pet pet) {
    System.out.println("Dando banho no Bulldog.");
  }
  // Outros métodos específicos do Bulldog
}