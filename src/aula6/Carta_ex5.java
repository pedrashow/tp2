package aula6;

class Carta_ex5 {
  /**
  * Para representar uma carta o ideal seria haver uma clase com dois atributos contendo duas enumerações.
  * O primeiro atributo, receberia uma enumaeração com os valores de face, indo do 2 até o Ás.
  * --- este modelo poderia ter o nome da face em String e o valor de ordem (2 -para o 2- a 14 -para o as-) em int.
  * O segundo atributo, receberia uma enumeração com os naipes, espadas, copas, ouros e paus.
  * Como no modelo simplificado abaixo
  */
  
  private Face face;
  private Naipe naipe;
  
  public enum Face { AS, REI, DAMA, VALETE, DEZ, NOVE, OITO, SETE, SEIS, CINCO, QUATRO, TRES, DOIS;}
  public enum Naipe { ESPADAS, COPAS, OUROS, PAUS; }
  
  Carta_ex5 (Face face, Naipe naipe) {
    this.face = face;
    this.naipe = naipe;
  }
    
}
