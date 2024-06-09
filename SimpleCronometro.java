import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCronometro extends JFrame {
    private JLabel labelTempo;
    private JButton botaoIniciarParar;
    private Timer timer;
    private int segundos = 0;
    private boolean rodando = false;

    public SimpleCronometro() {
        // Configurações da janela
        setTitle("Cronômetro Simples");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        labelTempo = new JLabel("00:00", SwingConstants.CENTER);
        labelTempo.setBounds(50, 20, 100, 30);
        add(labelTempo);

        botaoIniciarParar = new JButton("Iniciar");
        botaoIniciarParar.setBounds(50, 70, 100, 30);
        add(botaoIniciarParar);

        
        
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                segundos++;
                int minutos = segundos / 60;
                int segundosRestantes = segundos % 60;
                labelTempo.setText(String.format("%02d:%02d", minutos, segundosRestantes));
            }
        });

       
        
        botaoIniciarParar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rodando) {
                    timer.stop();
                    botaoIniciarParar.setText("Iniciar");
                } else {
                    timer.start();
                    botaoIniciarParar.setText("Parar");
                }
                rodando = !rodando;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCronometro().setVisible(true);
            }
        });
    }
}
