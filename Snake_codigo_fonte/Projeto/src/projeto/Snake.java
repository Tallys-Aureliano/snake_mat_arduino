package projeto;

import javax.swing.JFrame;


public class Snake extends JFrame
{

    public Snake (String cabecaAvatar, String corpoAvatar)
    {
        try{
          add(new Grade(cabecaAvatar, corpoAvatar));
        }catch(Exception ea){
                
          
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(520, 540);

        setLocationRelativeTo(null);

        setTitle("Jogo da Cobrinha");


        setResizable(false);

        setVisible(true);
    }

    public static void main(String[] args) 
    {
        
        //Tini t = new Tini(null, true);
        
        new Tini();
        
       
    }

 
   /* Snake() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    Snake() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

   



