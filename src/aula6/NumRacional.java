package aula6;

class NumRacional {
  
  private int numerador;
  private int denominador;
  
  NumRacional (int numerador, int denominador) {
    if (denominador == 0)
      throw new IllegalArgumentException( "Denominador precisa ser diferente de zero" );
    else {
    	this.numerador = numerador;
    	this.denominador = denominador;
    }
  }
  
  public int getNumerador () {
    return this.numerador;
  }
  
  public int getDenominador () {
    return this.denominador;
  }
  
  public static NumRacional divideRacional (NumRacional a, NumRacional b) {
    if (b.getNumerador() == 0)
      throw new IllegalArgumentException( "Não é possível dividir por zero" );
    else {
      int numerador = a.getNumerador() * b.getDenominador();
      int denominador = a.getDenominador() * b.getNumerador();
      NumRacional divisao = new NumRacional(numerador, denominador);
      return divisao;
    }
  }
  
}
