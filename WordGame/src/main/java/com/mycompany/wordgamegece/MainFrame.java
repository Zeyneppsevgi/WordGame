/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordgamegece;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author zeynepsevgi
 */
public class MainFrame extends javax.swing.JFrame {

    char[] chars = {'A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'Ğ',
        'H', 'I', 'İ', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö',
        'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z'
    };
    String selectedWord = "";
    JButton selectedButton = null;
    JButton[] charButtons = new JButton[chars.length];
    JLabel[] wordLabels = null;
    Map<String, Integer> charCount = new HashMap<>();

    public MainFrame() {
        initComponents();
        createButtons();
    }

    private void createButtons() {
        GridLayout layout = new GridLayout(0, 8);
        charPanel.setLayout(layout);

        Font font = new Font("Arial", Font.BOLD, 12);
        for (int i = 0; i < chars.length; i++) {
            charButtons[i] = new JButton(String.valueOf(chars[i]));
            charButtons[i].setFont(font);
            charButtons[i].setEnabled(false);
            charButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedButton = (JButton) e.getSource();
                    //System.out.println(selectedButton.getText());
                }
            });

            charPanel.add(charButtons[i]);
        }

        charPanel.revalidate();

    }

    private void createCharMap() {
        for (int i = 0; i < selectedWord.length(); i++) {
            String nextCharacter = selectedWord.substring(i, i + 1);
            if (charCount.containsKey(nextCharacter)) {
                charCount.put(nextCharacter, charCount.get(nextCharacter) + 1);
            } else {
                charCount.put(nextCharacter, i);
            }
        }
    }

    private boolean checkWinControl() {
        for (String key : charCount.keySet()) {
            if (charCount.get(key) != 0) {
                return false;
            }
        }
        return true;

    }

    private void createLabels() {
        wordLabels = new JLabel[selectedWord.length()];
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, HEIGHT, WIDTH);
        wordPanel.setLayout(layout);

        Font font = new Font("Arial", Font.BOLD, 14);
        for (int i = 0; i < selectedWord.length(); i++) {
            wordLabels[i] = new JLabel("___");
            wordLabels[i].setName(i + "");
            wordLabels[i].setFont(font);
            wordLabels[i].addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {
                    JLabel clickedLabel = (JLabel) me.getSource();
                    int charOrder = Integer.parseInt(clickedLabel.getName());

                    if (selectedWord.substring(charOrder, charOrder + 1).equals(selectedButton.getText())) {
                        clickedLabel.setText(selectedButton.getText());
                        charCount.put(selectedButton.getName(),
                                charCount.get(selectedButton.getText()) - 1);

                        if (charCount.get(selectedButton.getText()) == 0) {
                            selectedButton.setEnabled(false);
                        }

                    } else if (!charCount.containsKey(selectedButton.getText())) {
                        selectedButton.setEnabled(false);
                    }

                    if (checkWinControl()) {
                        JOptionPane.showMessageDialog(null, "Tebrikler Kazandınız.");
                    }

                }

            });

            wordPanel.add(wordLabels[i]);
        }
        wordPanel.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        charPanel = new javax.swing.JPanel();
        btn_start = new javax.swing.JButton();
        wordPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        charPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout charPanelLayout = new javax.swing.GroupLayout(charPanel);
        charPanel.setLayout(charPanelLayout);
        charPanelLayout.setHorizontalGroup(
            charPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );
        charPanelLayout.setVerticalGroup(
            charPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });

        wordPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout wordPanelLayout = new javax.swing.GroupLayout(wordPanel);
        wordPanel.setLayout(wordPanelLayout);
        wordPanelLayout.setHorizontalGroup(
            wordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        wordPanelLayout.setVerticalGroup(
            wordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(charPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btn_start)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(wordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(charPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_start)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        File currentDirFile = new File(".");

        try {
            List<String> words = FileUtils.readLines(new File(currentDirFile.getAbsolutePath() + "/words.txt"),
                    StandardCharsets.UTF_8);
            Random rnd = new Random();

            selectedWord = words.get(rnd.nextInt(words.size())).toUpperCase();
            System.out.println(selectedWord);
            for (JButton btn : charButtons) {
                btn.setEnabled(true);
            }

            createCharMap();

            createLabels();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_startActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_start;
    private javax.swing.JPanel charPanel;
    private javax.swing.JPanel wordPanel;
    // End of variables declaration//GEN-END:variables

  

}
