package aula6;

public enum Carta {
	SA ("as", "espadas"), 
  	SK ("rei","espadas"), 
  	SQ ("dama", "espadas"), 
  	SJ ("valete", "espadas"),
  	ST ("dez", "espadas"), 
  	S9 ("nove", "espadas"),
  	S8 ("oito","espadas"),
  	S7 ("sete","espadas"),
  	S6 ("seis", "espadas"),
  	S5 ("cinco","espadas"),
  	S4 ("quatro", "espadas"),
  	S3 ("tres","espadas"),
  	S2("dois","espadas"),
  	HA ("as", "copas"), 
  	HK ("rei","copas"), 
  	HQ ("dama", "copas"), 
  	HJ ("valete", "copas"),
  	HT ("dez", "copas"), 
  	H9 ("nove", "copas"),
  	H8 ("oito","copas"),
  	H7 ("sete","copas"),
  	H6 ("seis", "copas"),
  	H5 ("cinco","copas"),
  	H4 ("quatro", "copas"),
  	H3 ("tres","copas"),
  	H2("dois","copas"),
  	DA ("as", "ouros"), 
  	DK ("rei","ouros"), 
  	DQ ("dama", "ouros"), 
  	DJ ("valete", "ouros"),
  	DT ("dez", "ouros"), 
  	D9 ("nove", "ouros"),
  	D8 ("oito","ouros"),
  	D7 ("sete","ouros"),
  	D6 ("seis", "ouros"),
  	D5 ("cinco","ouros"),
  	D4 ("quatro", "ouros"),
  	D3 ("tres","ouros"),
  	D2("dois","ouros"),
  	CA ("as", "paus"), 
  	CK ("rei","paus"), 
  	CQ ("Cama", "paus"), 
  	CJ ("valete", "paus"),
  	CT ("Cez", "paus"), 
  	C9 ("nove", "paus"),
  	C8 ("oito","paus"),
  	C7 ("sete","paus"),
  	C6 ("seis", "paus"),
  	C5 ("cinco","paus"),
  	C4 ("quatro", "paus"),
  	C3 ("tres","paus"),
  	C2("dois","paus");

  	private String face = new String();
  	private String naipe = new String();
  	Carta (String face, String naipe) {
      		this.face = face;
      		this.naipe = naipe;
    	}
 }
