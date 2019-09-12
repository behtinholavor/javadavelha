package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.awt.Window.Type;


public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JButton[] button;
    private JButton button1;
    private JLabel jogador1;
    private JLabel jogador2;
    private JLabel Lpnt1;
    private JLabel Lpnt2;
    private int quemJoga = 0;
    private int pnt1 = 0;
    private int pnt2 = 0;
    private JLabel guia;
    private JLabel copyright;
    private boolean Jogador2Robo = false;
    
    public void acao(int bnt) {
        String XO;
        if (quemJoga == 0) {
            XO = "X";
            quemJoga = 1;
            guia.setText("Vez do Jogador 2");
        } else {
            XO = "O";
            quemJoga = 0;
            guia.setText("Vez do Jogador 1");

        }
        button[bnt].setText(XO);
        button[bnt].setEnabled(false);
//        verifica(XO);
        
        if ((quemJoga == 1) && verifica(XO) && (Jogador2Robo))
        	roboExecuta();
    }
    
    public boolean verifica(String XO) { // Regra do jogo para vitória x derrota

        //verificações horizontais
        if ((button[0].getText().equals(XO)) && (button[1].getText().equals(XO)) && (button[2].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[1].setBackground(Color.green);
            button[2].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[3].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[5].getText().equals(XO))) {
            button[3].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[5].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[6].getText().equals(XO)) && (button[7].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[6].setBackground(Color.green);
            button[7].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verificaçoes verticais
        if ((button[0].getText().equals(XO)) && (button[3].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[3].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[1].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[7].getText().equals(XO))) {
            button[1].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[7].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[5].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[5].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verificações diagonais
        if ((button[0].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verifica se deu velha
        if ((button[0].getText() != "   ") && (button[1].getText() != "   ") && (button[2].getText() != "   ") && (button[3].getText() != "   ") && (button[4].getText() != "   ") && (button[5].getText() != "   ") && (button[6].getText() != "   ") && (button[7].getText() != "   ") && (button[8].getText() != "   ")) {
            for (int i = 0; i < 9; i++) {
                button[i].setBackground(Color.red);
            }
            velha();
            return true;
        }
        return true;
    }
    
    
    public void velha() { // Regra do jogo para empate
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        button1.setVisible(true);
        guia.setText("Deu Velha");
    }

    public void ganhou(String XO) { // Exibição do Resultado
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        String texto;
        if (XO == "X") {
            texto = "Jogador 1 Venceu";
            pnt1++;
        } else {
            texto = "Jogador 2 Venceu";
            pnt2++;
        }
        Lpnt1.setText(Integer.toString(pnt1));
        Lpnt2.setText(Integer.toString(pnt2));
        button1.setVisible(true);
        guia.setText(texto);
    }
    
    public void novojogo() { //Novo Jogo
        button1.setVisible(false);
        guia.setText("Vez do Jogador 1");
        quemJoga = 0;
        for (int i = 0; i < 9; i++) {
            button[i].setText("   ");
            button[i].setBackground(button1.getBackground());
            button[i].setEnabled(true);
        }
    }

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {		
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\JavaDaVelha\\hashtag.png"));
		
		setType(Type.POPUP);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Java da Velha - Minicurso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		setIconImage("C:\\Users\\r.de.lavor.rodrigues\\eclipse\\workspace\\Andromeda\\doc\\png\\tool-blur_large@1x.png");
		setScreen(1);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));				
		
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        Box editBox = Box.createVerticalBox();
        Box[] box = new Box[8];
        
        button = new JButton[9];
        
        guia = new JLabel("Vez do Jogador 1");
        copyright = new JLabel("powered by Roberto Lavôr");

        for (int i = 0; i < 8; i++) {
            box[i] = Box.createHorizontalBox();
        }
        
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton("   ");
        }

        button1 = new JButton("Novo Jogo");
        button1.setVisible(false);
        jogador1 = new JLabel();
        jogador2 = new JLabel();
        jogador1.setText("Jogador 1");
        jogador2.setText("Jogador 2");
        Lpnt1 = new JLabel();
        Lpnt2 = new JLabel();
        Lpnt1.setText("0");
        Lpnt2.setText("0");

        box[0].add(jogador1);
        box[0].add(Box.createHorizontalStrut(30));
        box[0].add(jogador2);
        box[1].add(Lpnt1);
        box[1].add(Box.createHorizontalStrut(30));
        box[1].add(Lpnt2);
        box[2].add(guia);
        box[3].add(button[0]);
        box[3].add(button[1]);
        box[3].add(button[2]);
        box[4].add(button[3]);
        box[4].add(button[4]);
        box[4].add(button[5]);
        box[5].add(button[6]);
        box[5].add(button[7]);
        box[5].add(button[8]);
        box[6].add(button1);
        box[7].add(copyright);

        editBox.add(box[0]);
        editBox.add(box[1]);
        editBox.add(Box.createVerticalStrut(30));
        editBox.add(box[2]);
        editBox.add(box[3]);
        editBox.add(box[4]);
        editBox.add(box[5]);
        editBox.add(box[6]);
        editBox.add(box[7]);

        contentPane.setLayout(new FlowLayout());
        contentPane.add(editBox, BorderLayout.NORTH);                
        setContentPane(contentPane);                
        
        setSize(735, 454);
        setLocation((d.width - 230) / 2, (d.height - 250) / 2);
        setVisible(true);

        button[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(0);
            }
        });
        button[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(1);
            }
        });
        button[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(2);
            }
        });
        button[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(3);

            }
        });
        button[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(4);
            }
        });
        button[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(5);
            }
        });
        button[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(6);
            }
        });
        button[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(7);
            }
        });
        button[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                acao(8);
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	novojogo();
            }
        });
        

        
        
        
    }					
	
	public void setScreen(int screenType){ // Tamanho da Tela
	    Toolkit tk = Toolkit.getDefaultToolkit(); 
	    Dimension scrSize = tk.getScreenSize();
	    switch(screenType){
	        case 0: // Normal
	            this.setSize(this.getWidth(),this.getHeight());
	            int scrWidth = scrSize.width - this.getWidth(); 
	            int scrHeight = scrSize.height - this.getHeight();
	            this.setLocation(scrWidth/2,scrHeight/2);
	            break;
	        case 1: // Maximizada
	            this.setLocation(0,0);
	            this.setSize(scrSize.width, scrSize.height);
	            break;
	    }
	}
	
	public int numeroAleatorio(){
	    Random rand = new Random();
	    int min = 0; 
	    int max = 9;
	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void roboExecuta() {
//		int numero = numeroAleatorio();
		int numero = 0;
		boolean jogou = false;
		
		for (int i = 0; i < 9; i++) {            
			if (i == numero) {								
				if (button[i].isEnabled()) {
					jogou = true;
					acao(i);
					break;
	            } else {
	            	numero = numeroAleatorio();
				}
			} 
			
        }
		
		if ((!jogou) && (!button1.isVisible()))
			roboExecuta();
			
	}


}
