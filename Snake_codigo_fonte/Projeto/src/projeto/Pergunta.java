/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tatat
 */
public class Pergunta {
    
    public String textoP;
    
    public Alternativa[] alternativa;
    
    public Pergunta(String texto, Alternativa[] alternativa) {
        this.textoP= texto;
        this.alternativa = alternativa;
                

    }
    
}
