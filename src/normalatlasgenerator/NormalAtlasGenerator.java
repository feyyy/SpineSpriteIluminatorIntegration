package normalatlasgenerator;

import normalatlasgenerator.DataStructures.AtlasData;
import normalatlasgenerator.DataStructures.SpriteData;
import normalatlasgenerator.FileIO.FileDrop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NormalAtlasGenerator extends javax.swing.JFrame {

    private String projectOutputFolderPath;
    private String projectInputFolderPath;

    public NormalAtlasGenerator() {
        initComponents();
        setFrameLogo();
        prepareDragAndDropFilesComponent(dropInputHerePanel, v_iFolderLabel);
        prepareDragAndDropFilesComponent(dropOutputHerePanel, v_oFolderLabel);

    }

    // Not working todo later
    private void setFrameLogo() {
        Image im = Toolkit.getDefaultToolkit().getImage("org" + File.separator + "logo.png");
        setIconImage(im);
    }

    private ArrayList<AtlasData> getAtlasDatas() {
        if (projectOutputFolderPath != null) {
            try {
                ArrayList<AtlasData> atlasDatas = new ArrayList<>();
                List<Path> paths = Files.find(Paths.get(projectOutputFolderPath), 16,
                        (path, attr) -> path.toString().endsWith(".txt"))
                        .collect(Collectors.toList());
                for (Path p : paths) {
                    String metaPathStr = p.toString();
                    String imageStr = metaPathStr.substring(0, metaPathStr.lastIndexOf("."));
                    imageStr = imageStr.substring(0, imageStr.lastIndexOf("."))+ ".png";
                    File imageFile = new File(imageStr);
                    if (imageFile.exists()) {
                        AtlasData ad = new AtlasData(imageFile, new File(metaPathStr));
                        if (ad.getImage() != null && ad.getMetadata() != null) {
                            atlasDatas.add(ad);
                        }
                    }
                }
                return atlasDatas;
            } catch (IOException ex) {
                Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exportButton = new javax.swing.JButton();
        dropOutputHerePanel = new javax.swing.JPanel();
        dropInputHerePanel = new javax.swing.JPanel();
        feedbackPanel = new javax.swing.JPanel();
        oFeedbackPanel = new javax.swing.JPanel();
        v_oFolderLabel = new javax.swing.JLabel();
        s_oFolderLabel = new javax.swing.JLabel();
        iFeedbackPanel = new javax.swing.JPanel();
        v_iFolderLabel = new javax.swing.JLabel();
        s_iFolderLabel = new javax.swing.JLabel();
        normalSuffixString = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        dropOutputHerePanel.setBackground(new java.awt.Color(153, 153, 153));
        dropOutputHerePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drop output folder here.", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        dropOutputHerePanel.setPreferredSize(new java.awt.Dimension(380, 150));

        javax.swing.GroupLayout dropOutputHerePanelLayout = new javax.swing.GroupLayout(dropOutputHerePanel);
        dropOutputHerePanel.setLayout(dropOutputHerePanelLayout);
        dropOutputHerePanelLayout.setHorizontalGroup(
            dropOutputHerePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        dropOutputHerePanelLayout.setVerticalGroup(
            dropOutputHerePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        dropInputHerePanel.setBackground(new java.awt.Color(153, 153, 153));
        dropInputHerePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drop input folder here.", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        dropInputHerePanel.setPreferredSize(new java.awt.Dimension(380, 150));

        javax.swing.GroupLayout dropInputHerePanelLayout = new javax.swing.GroupLayout(dropInputHerePanel);
        dropInputHerePanel.setLayout(dropInputHerePanelLayout);
        dropInputHerePanelLayout.setHorizontalGroup(
            dropInputHerePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        dropInputHerePanelLayout.setVerticalGroup(
            dropInputHerePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        oFeedbackPanel.setPreferredSize(new java.awt.Dimension(300, 100));

        v_oFolderLabel.setText("Path is not set.");
        v_oFolderLabel.setSize(new java.awt.Dimension(45, 16));

        s_oFolderLabel.setText("Output folder path : ");

        javax.swing.GroupLayout oFeedbackPanelLayout = new javax.swing.GroupLayout(oFeedbackPanel);
        oFeedbackPanel.setLayout(oFeedbackPanelLayout);
        oFeedbackPanelLayout.setHorizontalGroup(
            oFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oFeedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s_oFolderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(v_oFolderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        oFeedbackPanelLayout.setVerticalGroup(
            oFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oFeedbackPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(oFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s_oFolderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(v_oFolderLabel))
                .addGap(31, 31, 31))
        );

        iFeedbackPanel.setPreferredSize(new java.awt.Dimension(300, 100));

        v_iFolderLabel.setText("Path is not set.");

        s_iFolderLabel.setText("Input folder path : ");

        javax.swing.GroupLayout iFeedbackPanelLayout = new javax.swing.GroupLayout(iFeedbackPanel);
        iFeedbackPanel.setLayout(iFeedbackPanelLayout);
        iFeedbackPanelLayout.setHorizontalGroup(
            iFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iFeedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s_iFolderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(v_iFolderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        iFeedbackPanelLayout.setVerticalGroup(
            iFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iFeedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iFeedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s_iFolderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(v_iFolderLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout feedbackPanelLayout = new javax.swing.GroupLayout(feedbackPanel);
        feedbackPanel.setLayout(feedbackPanelLayout);
        feedbackPanelLayout.setHorizontalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iFeedbackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addComponent(oFeedbackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)))
        );
        feedbackPanelLayout.setVerticalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedbackPanelLayout.createSequentialGroup()
                .addComponent(iFeedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oFeedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        normalSuffixString.setText("_n");

        jLabel2.setText("Normal image suffix :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dropInputHerePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(306, 306, 306))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dropOutputHerePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(normalSuffixString, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(feedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dropOutputHerePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropInputHerePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalSuffixString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        List<AtlasData> atlasInfos = getAtlasDatas();
        handleSpineMetaData(atlasInfos);
    }//GEN-LAST:event_exportButtonActionPerformed

    private ArrayList<String> parseSpriteNormalPaths(List<Path> paths) {
        ArrayList<String> actionableStrings = new ArrayList<>();
        for (Path p : paths) {
            String s = p.toString().replace(projectInputFolderPath + File.separator, "");
            s = s.replace(normalSuffixString.getText(), "");
            s = s.replace(".png", "");
            actionableStrings.add(s);
        }
        return actionableStrings;
    }

    private void handleSpineMetaData(List<AtlasData> data) {
        List<Path> spriteNormalPaths = collectSpriteNormalPaths();
        ArrayList<String> searchThese = parseSpriteNormalPaths(spriteNormalPaths);
        HashMap<String, ArrayList<SpriteData>> spriteDatas = SpineDataParser.parse(data, searchThese);

        for (String atlas : spriteDatas.keySet()) {
            File originalAtlas = new File(atlas);
            File normalAtlas = ImageModifier.prepareEmptyNormalAtlas(originalAtlas);
            ImageModifier.insertNormalsToAtlas(normalAtlas, spriteDatas.get(atlas), projectInputFolderPath, normalSuffixString.getText());
        }
    }

    private void prepareDragAndDropFilesComponent(javax.swing.JPanel Panel, javax.swing.JLabel Label) {
        javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder("Drop 'em");
        dragBorder.setTitleJustification(2);
        new FileDrop(null, Panel, dragBorder, new FileDrop.Listener() {
            public void filesDropped(File[] files) {
                for (int i = 0; i < files.length; i++) {
                    try {
                        Label.setText(files[i].getCanonicalPath());
                        if (files[i].isDirectory()) {
                            if (Panel == dropInputHerePanel) {
                                projectInputFolderPath = files[i].getCanonicalPath();
                            } else {
                                projectOutputFolderPath = files[i].getCanonicalPath();
                            }

                        }
                    } catch (java.io.IOException e) {
                        Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        });
    }

    private List<Path> collectSpriteNormalPaths() {
        if (projectInputFolderPath != null) {
            try {
                List<Path> paths = Files.find(Paths.get(projectInputFolderPath), 16,
                        (path, attr) -> path.toString().endsWith(normalSuffixString.getText() + ".png"))
                        .collect(Collectors.toList());
                return paths;
            } catch (IOException ex) {
                Logger.getLogger(NormalAtlasGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("SystemLookAndFeel".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NormalAtlasGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalAtlasGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalAtlasGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalAtlasGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalAtlasGenerator().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dropInputHerePanel;
    private javax.swing.JPanel dropOutputHerePanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel feedbackPanel;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel iFeedbackPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField normalSuffixString;
    private javax.swing.JPanel oFeedbackPanel;
    private javax.swing.JLabel s_iFolderLabel;
    private javax.swing.JLabel s_oFolderLabel;
    private javax.swing.JLabel v_iFolderLabel;
    private javax.swing.JLabel v_oFolderLabel;
    // End of variables declaration//GEN-END:variables
}
