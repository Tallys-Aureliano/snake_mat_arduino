/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.awt.Image;

/**
 *
 * @author tatat
 */
public class Alternativa {

    public boolean resposta;
    public Image opImage;
    public int z = 0;
    public int w = 0;
    public int s = 0;
    public int t = 0;
    public int r = 0;
    public int u = 0;
    public int a = 0;
    public int b = 0;

    public Alternativa(boolean resposta, Image opImage) {
        this.resposta = resposta;
        this.opImage = opImage;
    }

    public Alternativa(boolean resposta, Image opImagem,
            int z, int w, int s, int t, int y,int r , int u,int a, int b) {
        //
        this.resposta = resposta;
        this.opImage = opImagem;
        this.z = z;
        this.w = w;
        this.s = s;
        this.t = t;
        this.r = r;
        this.u = u;
        this.a = a;
        this.b = b;

    }

}
