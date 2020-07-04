import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Window {
    private JPanel panel1;
    private JTextField input;
    private JTextField output;
    private JButton but;
    private JButton readBut;

    private Window(){

        but.addActionListener(actionEvent -> {
            MyLinkedList values = toList(input.getText().split(" "));
            output.setText(String.valueOf(values.findElement().value));
        });

        readBut.addActionListener(actionEvent -> {
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showDialog(null, "Загрузить списки");
            File file = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = jfc.getSelectedFile();
            }
            try {
                assert file != null;
                Scanner scn = new Scanner(file);
                input.setText(scn.nextLine());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private MyLinkedList toList(String[] text){
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < text.length; i++) {
            list.add(Integer.parseInt(text[i]));
        }
        return list;
    }

    public static void main (String[] args){
        JFrame frame = new JFrame("Test list");
        frame.setContentPane(new Window().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tkt = Toolkit.getDefaultToolkit();
        Dimension dim = tkt.getScreenSize();
        frame.setBounds(dim.width / 2 - 250, dim.height / 2 - 150, 500, 300);
        frame.setVisible(true);
    }
}
