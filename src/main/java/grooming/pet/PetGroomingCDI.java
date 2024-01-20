package grooming.pet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class PetGroomingCDI {

  //Adicionamos o qualificador @Any ao ponto de injeção,
  // para suprimir o qualificador @Default.
  //Nossa váriavel servicosBanhoETosa irá conter, em tempo de execução,
  //a lista de todos os beans que implementam "BanhoETosa"
  //dentro de uma variável chamada "resolvedBeans"
  @Inject
  @Any
  private Instance<BanhoETosa> servicosBanhoETosa;

  public void executarServicos(Pet pet) {

    final Instance<BanhoETosa> instance = this.servicosBanhoETosa.select(
        BanhoETosa.class, new BanhoETosaNameLiteral(pet.getRaca()));
    //o que estamos dizendo é "dentro dos beans que implementam
    // BanhoETosa", selecione aquele que possua a anotação
    // QualificacaoBanhoETosa(pet.getRaca()),
    // no caso se for um labrador
    // selecione aquele que possua a anotação QualificacaoBanhoETosa('labrador')

    if (instance.isUnsatisfied()){
      throw new RuntimeException("Ainda não trabalhamos com essa raça");
    }

    instance.get().darBanho(pet);

  }
}
