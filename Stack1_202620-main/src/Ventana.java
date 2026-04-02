import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTextField txtURL;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnCima;
    private JButton btnMostrar;
    private JTextArea txtlistar;
    private JButton btnLikes;
    private JButton btnreset;
    private Pila pila1=new Pila();

    public Ventana() {
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = txtURL.getText();
                Post obj=new Post(url);
                pila1.push(obj);
                txtlistar.setText(pila1.showAll());
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Post eliminar = pila1.pop();
                    txtlistar.setText(pila1.showAll());
                    JOptionPane.showMessageDialog(null,"Se elimino"+ btnEliminar.toString());
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        btnCima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Post cima=pila1.peek();
                    txtlistar.setText("La cima es: "+cima.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtlistar.setText(pila1.showAll());
            }
        });
        btnLikes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pila1.peek().aumentarLikes();
                    txtlistar.setText(pila1.showAll());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    pila1.peek().resetLikes();
                    txtlistar.setText(pila1.showAll());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
