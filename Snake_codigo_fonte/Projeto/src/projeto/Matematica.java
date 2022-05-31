/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.Random;
import javax.swing.JOptionPane;
public class Matematica {
    
    //new String("asdashdasodo")
   static Questao [] questoes = {
       new Questao(" O número de habitantes de determinada cidade é 6.429.923.\n" +
"Quantas centenas há nesse número?", "a)6 b)4 c)2 d)9", "d"),
       new Questao(" Margarida não consegue decidir o que vai vestir. Ela pode escolher entre 4 saias (preta, azul, verde ou branca) e 3 blusas (laranja, rosa ou vermelha). \n De quantas maneiras Margarida pode se vestir?", "a)7 b)8 c)10 d)12", "d"),
       new Questao(" O valor da expressão (42 - 18) : 4 + 7 x 4 é igual a?", "a)12 b)13 c)14 d)15", "c"),
       new Questao("Num artigo de jornal, em que foram apresentados estudos sobre a população da Terra, foi publicado que, no ano 2000, a população chegou a 6,06 bilhões de pessoas. \n Esse número também pode ser escrito como:", "a)6 060 000 000 b)606 000 000 c)6 060 000 d)606 000", "a"),
       new Questao("Uma fábrica de confecções tem 20 funcionárias. O gasto com cada uma é 998 reais de salário mais 150 reais de ajuda de custo. \n Qual é o gasto mensal da fábrica com essas funcionárias?", "a)17 680 b)19 960 c)22 960 d)25 420", "c"),
       new Questao(" Dois elevado à quinta potência é igual a:", "a)10 b)15 c)25 d)32", "d"),
       new Questao(" A metade de 8 aumentada do triplo de 7 é igual a:", "a)8 b)18 c)25 d)29", "c"),
       new Questao(" Em uma adição de duas parcelas, a primeira é igual a 125 e a segunda é o dobro da primeira. \n O resultado da soma é:", "a)375 b)225 c)250 d)175", "a"),
       new Questao("Na padaria, uma torta foi dividida em 6 partes iguais. Cada pedaço custa R$ 2,20. \n Quanto se pagaria por metade dessa torta?", "a)R$ 4,40 b)R$ 6,60 c)R$ 8,80 d)R$ 13,20", "d"),
       new Questao("Clara comprou 2 blusas e 1 calça. Cada blusa custou R$ 45,00 e a calça, R$ 105,00. Deu de entrada R$ 75,00, e o restante dividiu em 3 prestações iguais. \n Qual será o valor de cada prestação?", "a)R$ 40,00 b)R$ 45,00 c)R$ 54,00 d)R$75,00", "a"),
       new Questao(" Na primeira parada da viagem de um ônibus que partiu com 35 passageiros desceram 4 e entraram 7 pessoas. \n Com quantas pessoas o ônibus seguiu viagem?", "a)28 b)31 c)38 d)39", "c"),
       new Questao("O dobro de um número ímpar somado com um número ímpar é um número.", "a)ímpar b)misto c)par d)decimal", "a"),
       new Questao("15. A raiz quadrada de 100, somada com a terceira potência de 10 é o mesmo que:", "a)110 b)1000 c)1010 d)1100", "c"),
       new Questao("Na sequência o número que sucede 12 é o: \n" +
"      16, 20, 14, 22, 12, __:", "a)28 b)26 c)24 d)18", "c"),
       
   };
   
   public static boolean mostrarQuestaoAleatoria(){
       Random rd = new Random();
       int posicaoAleatoria = rd.nextInt(questoes.length);
       Questao questaoAleatoria = questoes[posicaoAleatoria];
       String resposta = JOptionPane.showInputDialog(null, "Responda para \n"
               +questaoAleatoria.getEquacao()+"\n"+questaoAleatoria.getAlte());
       
       if(resposta.equalsIgnoreCase(questaoAleatoria.getResposta())){
           return true;
       }else{
           return false;
       }
   }
}
class Questao {
    private String equacao;
    private String alte;
    private String resposta;

    public Questao(String equacao, String alte, String resposta) {
        this.equacao = equacao;
        this.alte = alte;
        this.resposta = resposta;
    }
    
    public String getEquacao() {
        return equacao;
    }

    public void setEquacao(String equacao) {
        this.equacao = equacao;
    }

    public String getAlte() {
        return alte;
    }

    public void setAlte(String alte) {
        this.alte = alte;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
            
}
