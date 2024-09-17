package odev12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class odev12 extends JFrame {

    private JPanel panel;
    private JTextField textField1;
    private JButton button1;
    private JProgressBar progressBar1;
    private JProgressBar pb1;
    private JEditorPane editorPane1;
    private JProgressBar pb2;
    private JProgressBar pb3;
    private JProgressBar pb4;
    private JProgressBar pb5;
    private JProgressBar pb6;
    static int deger;

    odev12()
    {
        add(panel);
        setSize(500,500);
        setTitle("Odev12");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Random random = new Random();





        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                deger = Integer.parseInt(textField1.getText());
                ArrayList<Integer> randomSayilar = new ArrayList<>();





                for(int i =0;i<deger;i++)
                {
                    int rnd = random.nextInt(6)+1;
                    randomSayilar.add(rnd);

                }

                StringBuilder builder = new StringBuilder();
                for (int sayi : randomSayilar) {
                    builder.append(sayi).append("-");
                }

                editorPane1.setText(builder.toString());


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for(int i =0;i<=100;i++)
                        {

                            try {
                                TimeUnit.MILLISECONDS.sleep(deger/10);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            progressBar1.setValue(i);
                        }

                    }
                }).start();


                int c1 = Collections.frequency(randomSayilar,1);
                yuzdebelirle(c1,pb1);
                int c2 = Collections.frequency(randomSayilar,2);
                yuzdebelirle(c2,pb2);
                int c3 = Collections.frequency(randomSayilar,3);
                yuzdebelirle(c3,pb3);
                int c4 = Collections.frequency(randomSayilar,4);
                yuzdebelirle(c4,pb4);
                int c5 = Collections.frequency(randomSayilar,5);
                yuzdebelirle(c5,pb5);
                int c6 = Collections.frequency(randomSayilar,6);
                yuzdebelirle(c6,pb6);












            }
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                odev12 odevim = new odev12();
                odevim.setVisible(true);
            }
        });
    }

    public static void yuzdebelirle(int sayimiktar, JProgressBar progressBar) {
        int c2= (100*sayimiktar)/deger;

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i =0;i<=c2;i++)
                {

                    try {
                        TimeUnit.MILLISECONDS.sleep(deger/10);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    progressBar.setValue(i);
                }

            }
        }).start();

    }
}

