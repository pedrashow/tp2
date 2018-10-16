package aula7_5;

public class Data {
        private int dia;
        private int mes;
        private int ano;

        public Data (int dia, int mes, int ano) {
        /*
         * TODO: criar métodos para não permitir criação de datas inválidas.
         */
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        
        public Data() {
            
        }

        public String imprimeDataAniversario() {
            return String.valueOf(dia) + "/" + String.valueOf(mes);
        }
          
        public static boolean menorDataAniversario(Data data1, Data data2) {
            /*
             * checa se a primeira data é menor do que a segunda
             * desconsidera o ano, para listar apenas aniversários
             */
            if (data1.mes < data2.mes)
              return true;
            if (data1.mes == data2.mes && data1.dia < data2.dia)
              return true;
            return false;
        }

}
