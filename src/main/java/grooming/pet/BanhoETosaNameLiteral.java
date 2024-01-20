package grooming.pet;

import jakarta.enterprise.util.AnnotationLiteral;

// CDI nos permite obter uma instância de qualificador (anotação)
// fazendo um extend na classe AnnotationLiteral
// Quando fazemos extend AnnotationLiteral, o que estamos dizendo
// BanhoETosaNameLiteral também é uma anotação
// ou seja é uma  java.lang.annotation do tipo QualificacaoBanhoETosa.class
// A diferença que quando colocamos a anotaçao QualificacaoBanhoETosa
// diretamente na classe, escrevemos na forma @QualificacaoBanhoETosa("labrador")
// e aqui temos a liberdade de especificar a raça em tempo de execução.

public class BanhoETosaNameLiteral
    extends AnnotationLiteral<QualificacaoBanhoETosa>
    implements QualificacaoBanhoETosa {

  private final String raca;

  public BanhoETosaNameLiteral(String raca) {
    this.raca = raca;
  }
  @Override
  public String raca() {

    return raca;
  }

  @Override
  public boolean equals(final Object obj) {

    if (obj instanceof QualificacaoBanhoETosa){
      return this.raca.equals(((QualificacaoBanhoETosa) obj).raca());
    }

    return false;

  }

  //as vezes é importante sobrescrever o método equals.
}
