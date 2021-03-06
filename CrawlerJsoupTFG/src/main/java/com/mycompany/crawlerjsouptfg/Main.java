/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crawlerjsouptfg;

import com.google.gson.Gson;
import com.mycompany.crawlerjsouptfg.crawler.Crawler;
import com.mycompany.crawlerjsouptfg.crawler.CrawlerEngine;
import com.mycompany.crawlerjsouptfg.crawler.SearchEngine;
import com.mycompany.crawlerjsouptfg.crawler.Searcher;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author urbano
 */
public class Main extends javax.swing.JFrame {

    Crawler crawler;
    Searcher searcher;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setIcons();
        searcher = new SearchEngine();
    }

    private void setIcons() {
        startCrawlerButton.setIcon(new ImageIcon("/home/urbano/github/TFG/CrawlerJsoupTFG/src/main/java/com/mycompany/crawlerjsouptfg/icons/startIcon.png",
                "Run crawler icon"));
        searchButton.setIcon(new ImageIcon("/home/urbano/github/TFG/CrawlerJsoupTFG/src/main/java/com/mycompany/crawlerjsouptfg/icons/searchIcon.png",
                "Search icon"));
        exportButton.setIcon(new ImageIcon("/home/urbano/github/TFG/CrawlerJsoupTFG/src/main/java/com/mycompany/crawlerjsouptfg/icons/exportIcon.png",
                "Search icon"));
    }

    private void writeArrayInConsole(ArrayList<String> list) {
        for (String txt : list) {
            if (consoleTxt.getText().isEmpty()) {
                consoleTxt.setText(txt);
            } else {
                consoleTxt.setText(consoleTxt.getText() + "\n" + txt);
            }
        }
    }

    private void updateSearchButtonStatus() {
        if (crawler.getScrapedLinks().isEmpty()) {
            searchButton.setEnabled(false);
        } else {
            searchButton.setEnabled(true);
        }
    }

    private void updateExportButtonStatus() {
        if (searcher.getMatchedLinks().isEmpty()) {
            exportButton.setEnabled(false);
        } else {
            exportButton.setEnabled(true);
        }
    }

    private void updateButtons() {
        updateSearchButtonStatus();
        updateExportButtonStatus();
    }

    private int getSeconds(Date start, Date finish) {
        Long mils = finish.getTime() - start.getTime();
        int seconds = (int) (mils / 1000);
        return seconds;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        webSiteTxt = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        startCrawlerButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleTxt = new javax.swing.JTextArea();
        exportButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        crawlerLimitTxt = new javax.swing.JTextField();
        statisticInfoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 400));

        jLabel3.setText("Sitio web:");

        webSiteTxt.setText("https://www.elmundo.es");
        webSiteTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webSiteTxtActionPerformed(evt);
            }
        });

        searchButton.setText("BUSCAR");
        searchButton.setEnabled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        startCrawlerButton.setText("INICIAR");
        startCrawlerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCrawlerButtonActionPerformed(evt);
            }
        });

        consoleTxt.setEditable(false);
        consoleTxt.setColumns(20);
        consoleTxt.setRows(5);
        jScrollPane1.setViewportView(consoleTxt);

        exportButton.setText("EXPORTAR");
        exportButton.setEnabled(false);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("¿Cuántos enlaces quieres obtener?:");

        crawlerLimitTxt.setText("1000");

        statisticInfoLabel.setText("Esperando ejecución del crawler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startCrawlerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(webSiteTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crawlerLimitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statisticInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(webSiteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(crawlerLimitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(startCrawlerButton)
                    .addComponent(exportButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statisticInfoLabel)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(860, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void webSiteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webSiteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_webSiteTxtActionPerformed

    private void startCrawlerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startCrawlerButtonActionPerformed
        String webSite = webSiteTxt.getText();
        int crawlerLimit = Integer.valueOf(crawlerLimitTxt.getText());
        try {
            crawler = new CrawlerEngine(webSite, crawlerLimit);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        Date start = new Date();
        crawler.crawl();
        Date finish = new Date();
        consoleTxt.setText("----------------- URLS OBTENIDAS -------------------");
        writeArrayInConsole(crawler.getScrapedLinks());
        updateButtons();
        statisticInfoLabel.setText("Obtenidos " + crawler.getScrapedLinks().size()
                + " enlaces de " + webSite + " en " + getSeconds(start, finish) + " segundos");
    }//GEN-LAST:event_startCrawlerButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String target = JOptionPane.showInputDialog(this, "Escribe el texto que quieres buscar", "Ajustes de búsqueda", JOptionPane.QUESTION_MESSAGE);
        Date start = new Date();
        if (target != null) {
            try {
                searcher.search(crawler.getScrapedLinks(), target);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error buscando...", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error buscando...", JOptionPane.ERROR_MESSAGE);
            }
            if (!searcher.getMatchedLinks().isEmpty()) {
                consoleTxt.setText("--------------------- RESULTADOS DE LA BÚSQUEDA -------------------");
                writeArrayInConsole(searcher.getMatchedLinks());

            } else {
                consoleTxt.setText("No se han encontrado coincidencias con: \n" + target);
            }

        }
        Date finish = new Date();
        statisticInfoLabel.setText("Obtenidas " + searcher.getMatchedLinks().size()
                + " coincidencias del target \"" + target + "\" en " + getSeconds(start, finish) + " segundos");
        updateButtons();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Exportar resultados de búsqueda a archivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ARCHIVOS JSON", "json");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            Gson gson = new Gson();
            try (FileWriter fileWriter = new FileWriter(fileToSave)) {
                gson.toJson(searcher.getMatchedLinks(), fileWriter);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            statisticInfoLabel.setText("Resultados de búsqueda guardados en " +
                    fileToSave.getAbsolutePath());
            
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consoleTxt;
    private javax.swing.JTextField crawlerLimitTxt;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton startCrawlerButton;
    private javax.swing.JLabel statisticInfoLabel;
    private javax.swing.JTextField webSiteTxt;
    // End of variables declaration//GEN-END:variables
}
