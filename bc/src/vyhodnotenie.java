
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michy70
 */
public class vyhodnotenie extends javax.swing.JFrame {

    String[][][] skore;
    ArrayList<ArrayList<String>> tymy;
    ArrayList<String> celkoveSkore = new ArrayList<String>();
    
    public vyhodnotenie(String[][][] skoreP,ArrayList<ArrayList<String>> tymyP) {
        initComponents();
        this.setLocationRelativeTo(null);
        skore = skoreP;
        tymy = tymyP;
        naplnenieCelkovehoSkore();
        nastavenieCelkovejTabulky();
    }
    
    public void nastavenieCelkovejTabulky(){
        int pocetTymoc = tymy.size();
        tabulkaCelkoveSkore.setRowHeight(372/pocetTymoc);
        for(int i = 0;i<celkoveSkore.size();i+=3){
            DefaultTableModel model = (DefaultTableModel) tabulkaCelkoveSkore.getModel();
            model.addRow(new Object[]{i/3+1,celkoveSkore.get(i),celkoveSkore.get(i+1),celkoveSkore.get(i+2)});
        }
    }
    
    //nacitanie skore z odohtarych zapasov
    public void naplnenieCelkovehoSkore(){
        int obdrzaneGole,streleneGole,skupina,body;
        skupina = 0;
        for(int i = 0;i<tymy.size();i++){
            obdrzaneGole=streleneGole=body = 0;
            celkoveSkore.add(tymy.get(i).get(0));
            if(i == skore[0].length){
                skupina++;
            }
            int pocet = (skupina == 1 && tymy.size() % 2 == 1)? skore[skupina].length-1 : skore[skupina].length;
            for(int j = 0;j< ((skupina == 1 && tymy.size() % 2 == 1)? skore[skupina].length-1 : skore[skupina].length) ;j++){
                if(i%skore[0].length != j){
                    if(skore[skupina][i%skore[0].length][j] != null){
                        String nic = skore[skupina][i%skore[0].length][j].substring(0, skore[skupina][i%skore[0].length][j].indexOf(":"));
                        nic = skore[skupina][i%skore[0].length][j].substring(skore[skupina][i%skore[0].length][j].indexOf(":")+1);
                        streleneGole += Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(0, skore[skupina][i%skore[0].length][j].indexOf(":")));
                        obdrzaneGole += Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(skore[skupina][i%skore[0].length][j].indexOf(":")+1));
                        if(Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(0, skore[skupina][i%skore[0].length][j].indexOf(":"))) > 
                           Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(skore[skupina][i%skore[0].length][j].indexOf(":")+1))){
                            body += 3;
                        } else if(Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(0, skore[skupina][i%skore[0].length][j].indexOf(":"))) ==
                                  Integer.parseInt(skore[skupina][i%skore[0].length][j].substring(skore[skupina][i%skore[0].length][j].indexOf(":")+1))){
                            body++;
                        }
                    }
                }
            }
            celkoveSkore.add(streleneGole + ":" + obdrzaneGole);
            celkoveSkore.add(Integer.toString(body));
        }
        utriedenieCelkovehoSkore();
    }
    
    public void utriedenieCelkovehoSkore(){
        String[] pomocka = new String[3];
        for(int i = 2;i<celkoveSkore.size();i+=3){
            for(int j = i+3;j<celkoveSkore.size();j+=3){
                if(Integer.parseInt(celkoveSkore.get(i)) < Integer.parseInt(celkoveSkore.get(j))){
                    pomocka[0] = celkoveSkore.get(i-2);
                    pomocka[1] = celkoveSkore.get(i-1);
                    pomocka[2] = celkoveSkore.get(i);
                    celkoveSkore.set(i-2, celkoveSkore.get(j-2));
                    celkoveSkore.set(i-1, celkoveSkore.get(j-1));
                    celkoveSkore.set(i, celkoveSkore.get(j));
                    celkoveSkore.set(j-2, pomocka[0]);
                    celkoveSkore.set(j-1, pomocka[1]);
                    celkoveSkore.set(j, pomocka[2]);
                }
            }
        }
        
        for(int i = 1;i<celkoveSkore.size();i+=3){
            for(int j = i+3;j<celkoveSkore.size();j+=3){
                if(Integer.parseInt(celkoveSkore.get(i+1)) == Integer.parseInt(celkoveSkore.get(j+1)))
                if(Integer.parseInt(celkoveSkore.get(i).substring(0,celkoveSkore.get(i).indexOf(":"))) < 
                   Integer.parseInt(celkoveSkore.get(j).substring(0,celkoveSkore.get(i).indexOf(":")))){
                    pomocka[0] = celkoveSkore.get(i-1);
                    pomocka[1] = celkoveSkore.get(i);
                    pomocka[2] = celkoveSkore.get(i+1);
                    celkoveSkore.set(i-1, celkoveSkore.get(j-1));
                    celkoveSkore.set(i, celkoveSkore.get(j));
                    celkoveSkore.set(i+1, celkoveSkore.get(j+1));
                    celkoveSkore.set(j-1, pomocka[0]);
                    celkoveSkore.set(j, pomocka[1]);
                    celkoveSkore.set(j+1, pomocka[2]);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CelkovaTabulka = new javax.swing.JLabel();
        Top10Hraci = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabulkaTopHraci = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabulkaCelkoveSkore = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("—");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CelkovaTabulka.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        CelkovaTabulka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CelkovaTabulka.setText("Celková tabuľka");

        Top10Hraci.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        Top10Hraci.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Top10Hraci.setText("Top 10 hráčov turnaja");

        tabulkaTopHraci.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tabulkaTopHraci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Poradie", "Tým", "Dres", "Meno", "Góle", "Asistencie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabulkaTopHraci.setPreferredSize(new java.awt.Dimension(350, 370));
        tabulkaTopHraci.setRowHeight(37);
        tabulkaTopHraci.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabulkaTopHraci.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabulkaTopHraci);
        if (tabulkaTopHraci.getColumnModel().getColumnCount() > 0) {
            tabulkaTopHraci.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabulkaTopHraci.getColumnModel().getColumn(1).setPreferredWidth(185);
            tabulkaTopHraci.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabulkaTopHraci.getColumnModel().getColumn(3).setPreferredWidth(185);
            tabulkaTopHraci.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabulkaTopHraci.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        tabulkaCelkoveSkore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabulkaCelkoveSkore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poradie", "Názov tímu", "Skóre", "Body"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabulkaCelkoveSkore.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabulkaCelkoveSkore.setPreferredSize(new java.awt.Dimension(350, 372));
        tabulkaCelkoveSkore.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabulkaCelkoveSkore.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tabulkaCelkoveSkore);
        if (tabulkaCelkoveSkore.getColumnModel().getColumnCount() > 0) {
            tabulkaCelkoveSkore.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabulkaCelkoveSkore.getColumnModel().getColumn(1).setPreferredWidth(280);
            tabulkaCelkoveSkore.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabulkaCelkoveSkore.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(60, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(CelkovaTabulka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Top10Hraci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jButton1)
                .addGap(186, 186, 186)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Top10Hraci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CelkovaTabulka, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(924, 924, 924)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(500, 500, 500))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DefaultTableModel model = (DefaultTableModel) tabulkaTopHraci.getModel();
        model.addRow(new Object[]{});
    }//GEN-LAST:event_jButton1MouseClicked

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vyhodnotenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vyhodnotenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vyhodnotenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vyhodnotenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vyhodnotenie(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CelkovaTabulka;
    private javax.swing.JLabel Top10Hraci;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabulkaCelkoveSkore;
    private javax.swing.JTable tabulkaTopHraci;
    // End of variables declaration//GEN-END:variables
}
