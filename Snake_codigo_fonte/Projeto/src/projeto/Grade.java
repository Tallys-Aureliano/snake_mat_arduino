package projeto;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import arduino.LerArduino;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JOptionPane;

public class Grade extends JPanel implements ActionListener {

    Thread t1 = new Thread(new LerArduino("COM4"));

    public static int nivel = 0;
    private final int WIDTH_ = 500;
    private final int HEIGHT_ = 500;

    private int TAMANHO_PONTO = 10;
    public static int Tese = 0;
    private final int TODOS_PONTOS = 280800;

    private final int RAND_POSICAO = 46;
    private int DELAY = 140;

    private int[] x = new int[TODOS_PONTOS];
    private int[] y = new int[TODOS_PONTOS];
    String texts[] = {"1", "2", "3", "4"};

    private int pontos;
    boolean certoss1[] = {true, false, false, false};
    boolean certoss2[] = {false, true, false, false};
    boolean certoss3[] = {false, false, true, false};
    boolean certoss4[] = {false, false, false, true};
    int j = 0;

    private int PONTUAÇÃO = 0;
    String SCORE = "PONTUAÇÃO: " + PONTUAÇÃO;
    String SCORE2 = "PONTUAÇÃO: " + pontos;
    Font SCORE_FONT = new Font("Consolas", Font.BOLD, 12);
    FontMetrics SCORE_METRICA = this.getFontMetrics(SCORE_FONT);

    public static boolean left = false;
    public static boolean right = false;
    public static boolean up = false;
    public static boolean down = false;

    private boolean estaJogando = true;
    private Timer tempo;
    Graphics g;
    private Image bola;

    private Image cabeça;

    public String cabecaAvatar;

    public String corpoAvatar;
    String[] texto = {
        "Equação (32/4/2/2)-1",
        "Equação( 4 x 7 + 12)/( 3 x 5 + 5)",
        "Equação( 18 + 3 x 9)/( 4 x 7 – 13)",
        "dsafsfgjdflv"
    };

    Pergunta p;
    JLabel lbconta;

    public void newP(String textoP, Alternativa[] alts) {
        p = new Pergunta(textoP, alts);
        // System.out.println(p.textoP);
        lbconta.setText(textoP);
        j++;
    }
    
    
    private Alternativa[] alts(String texs[], boolean certos[]) {
        Alternativa[] al = new Alternativa[4];
        for (int i = 0; i < 4; i++) {
            al[i] = newAlt(texs[i], certos[i]);
        }
        return al;
    }

    private Alternativa newAlt(String num, boolean certo) {
        String imagemNome = "comida" + num + ".jpg";
        return new Alternativa(certo, getI(imagemNome));
    }

    private Image getI(String nome) {
        return new ImageIcon(getClass().getResource(nome)).getImage();
    }

    public Grade(String cabecaAvatar, String corpoAvatar) throws InterruptedException {
        
        t1.start();
        addKeyListener(new TAdapter());
        
        Alternativa[] al = alts(texts, certoss1);

        setBackground(Color.GREEN);
        ImageIcon iconfundo = new ImageIcon(getClass().getResource("grama.jpg"));
        lbconta = new JLabel(new ImageIcon(getClass().getResource("cabeca.png")));
        lbconta.setBounds(0, 15, 45, 63);
        newP(texto[j], al);

        JLabel lbfundo = new JLabel(iconfundo);
        lbfundo.setBounds(0, 0, 520, 540);
        //add(lbconta);

        ImageIcon bola_ = new ImageIcon(getClass().getResource(corpoAvatar));
        bola = bola_.getImage();

        ImageIcon cabeça_ = new ImageIcon(getClass().getResource(cabecaAvatar));
        cabeça = cabeça_.getImage();

        setFocusable(true);
        setSize(WIDTH_, HEIGHT_);

        add(lbfundo);

        initJogo();
    }

    public void initJogo() {

        pontos = 3;

        for (int i = 0; i < pontos; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }

        localComida();
        try {
            
        } catch (Exception e) {
        }
        Timer x = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //  System.out.println("O arduino ta mandao pra grade : " + LerArduino.Posicaov);
                if (LerArduino.Posicaov == "ESQUERDA" && !right) {
                    if (left == false) {
                        Tese++;
                    }
                    left = true;
                    up = false;
                    down = false;
                }

                if (Tese == nivel) {
                    localComida();
                    Tese = 0;
                } if (pontos ==5 && PONTUAÇÃO == 21) {
                    JOptionPane.showMessageDialog(null,
                    "PARABENS VOÇE ACHOU O EASTER EGG \n QUERO AGRADECER A IDASLON, BRUNO"
                            + " \n E PRINCIPALMENTE AO NOSSO DIRETOR MAX MILER (94 HEHE) AGORA FALTA SÓ ZERAR"
                            + "QUE POR SINAL NAO SEI SE É POSSIVEL");

                }

//To change body of generated methods, choose Tools | Templates.
            }
        }
        );
        x.start();
        tempo = new Timer(DELAY, this);
        // tempo.
        tempo.start();
    }
    boolean mostrouQuestao = false;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        if (estaJogando) {
            g.drawImage(p.alternativa[0].opImage, p.alternativa[0].z, p.alternativa[0].w, this);
            g.drawImage(p.alternativa[1].opImage, p.alternativa[1].s, p.alternativa[1].t, this);
            g.drawImage(p.alternativa[2].opImage, p.alternativa[2].r, p.alternativa[2].u, this);
            g.drawImage(p.alternativa[3].opImage, p.alternativa[3].a, p.alternativa[3].b, this);
            checarComida();
            checarColisão();
            mover();

            for (int i = 0; i < pontos; i++) {
                if (i == 0) {
                    g.drawImage(cabeça, x[i], y[i], this);
                } else {
                    g.drawImage(bola, x[i], y[i], this);
                }
                if (pontos < 3) {
                    FimDeJogo(g);
                    estaJogando = false;
                }

            }

            desenharPontuacao(g);

            Toolkit.getDefaultToolkit().sync();

            g.dispose();
        } else {
            if (mostrouQuestao == false) {
                mostrouQuestao = true;
                boolean acertou = Matematica.mostrarQuestaoAleatoria();
                mostrouQuestao = false;
                if (acertou == true) {
                    for (int i = 0; i < pontos; i++) {
                        x[i] = 100;
                        y[i] = 100;
                        pontos = 3;
                        PONTUAÇÃO = 0;
                    }
                    estaJogando = true;
                } else {
                    System.exit(0);
                }
            }

        }
        if (Tese == nivel) {
            localComida();
            Tese = 0;
        }
    }

    public void desenharPontuacao(Graphics g) {
        SCORE = "PONTUAÇÃO: " + PONTUAÇÃO;
        SCORE_METRICA = this.getFontMetrics(SCORE_FONT);

        g.setColor(Color.white);
        g.setFont(SCORE_FONT);
        g.drawString(SCORE, (WIDTH_ - SCORE_METRICA.stringWidth(SCORE)) - 10, HEIGHT_ - 10);
    }

    public void FimDeJogo(Graphics g) {
        String msg = "FIM DE JOGO! Sua pontuação: " + PONTUAÇÃO;

        Font pequena = new Font("Consolas", Font.BOLD, 14);

        FontMetrics metrica = this.getFontMetrics(pequena);

        g.setColor(Color.white);
        g.setFont(pequena);
        g.drawString(msg, (WIDTH_ - metrica.stringWidth(msg)) / 2, HEIGHT_ / 2);
    }

    public void checarComida() {
        
        if ((x[0] == p.alternativa[0].z) && (y[0] == p.alternativa[0].w)) { // 1
            pontos++;
            PONTUAÇÃO++;
            Tese = 0;
            localComida();
            //MAÇAN
        }
        if ((x[0] == p.alternativa[1].s) && (y[0] == p.alternativa[1].t)) { // 2
            if (DELAY <= 200) {
                DELAY += 15;
            }
            tempo.setDelay(DELAY);
            Tese = 0;
            localComida();
            //PERA
        }
        if ((x[0] == p.alternativa[2].r) && (y[0] == p.alternativa[2].u)) { // 3
            pontos = pontos / 2;
            //PONTUAÇÃO = PONTUAÇÃO / 2;
            Tese = 0;
            localComida();
            //LARANJA
        }
        if ((x[0] == p.alternativa[3].a) && (y[0] == p.alternativa[3].b)) { // 3
            if (DELAY >= 80) {
                DELAY -= 15;
            }
            tempo.setDelay(DELAY);
            Tese = 0;
            //BERINJELA
            localComida();

        }
    }

    public void mover() {
        for (int i = pontos; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (left) {
            x[0] -= TAMANHO_PONTO;
        }

        if (right) {
            x[0] += TAMANHO_PONTO;
        }

        if (up) {
            y[0] -= TAMANHO_PONTO;
        }

        if (down) {
            y[0] += TAMANHO_PONTO;
        }

    }

    public void checarColisão() {

        for (int i = pontos; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                estaJogando = false;
            }

        }

        if (y[0] > HEIGHT_) {
            estaJogando = false;
        }

        if (y[0] < 0) {
            estaJogando = false;
        }

        if (x[0] > WIDTH_) {
            estaJogando = false;
        }

        if (x[0] < 0) {
            estaJogando = false;
        }

        if (pontos < 3) {
            FimDeJogo(g);
        }
    }

    private int getRandom() {
        return (int) (Math.random() * RAND_POSICAO);
    }

    public void localComida() {

        p.alternativa[0].z = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[1].s = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[2].r = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[3].a = ((getRandom() * TAMANHO_PONTO));

        p.alternativa[0].w = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[1].t = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[2].u = ((getRandom() * TAMANHO_PONTO));
        p.alternativa[3].b = ((getRandom() * TAMANHO_PONTO));

    }
////////

    public void actionPerformed(ActionEvent e) {

        if (estaJogando) {
            checarComida();
            checarColisão();
            mover();
        }

        repaint();
    }

    public static void a(String b) {

    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            // System.out.println("O arduino ta mandao pra grade : " + LerArduino.Posicaov);
            if ((((key == KeyEvent.VK_LEFT) && (!right))) || (LerArduino.Posicaov == "ESQUERDA" && !right)) {
                if (left == false) {
                    Tese++;
                }
                left = true;
                up = false;
                down = false;
            }

            if (((key == KeyEvent.VK_RIGHT) && (!left)) || (LerArduino.Posicaov == "DIREITA" && !left)) {
                if (right == false) {
                    Tese++;
                }
                right = true;
                up = false;
                down = false;
            }

            if (((key == KeyEvent.VK_UP) && (!down)) || (LerArduino.Posicaov == "CIMA" && !down)) {
                if (up == false) {
                    Tese++;
                }
                up = true;
                left = false;
                right = false;

            }

            if (((key == KeyEvent.VK_DOWN) && (!up)) || (LerArduino.Posicaov == "CIMA" && !up)) {
                if (down == false) {
                    Tese++;
                }
                down = true;
                left = false;
                right = false;
            }
            if (Tese == nivel) {
                localComida();
                Tese = 0;
            }
        }
    }
}
