
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;
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
public class turnaj extends javax.swing.JFrame {

    String nazovTurnaja = "turnaj.txt";
    int pocetTymov = 0;
    int pocetTymovVSkupine = 0;
    int pocetSkupin = 1;
    String[][][] skore;
    ArrayList<ArrayList<String>> tymy;
    /**
     * Creates new form turnaj
     */
    public turnaj() throws IOException {
        initComponents();
        tymy = new ArrayList<ArrayList<String>>();
        this.setLocationRelativeTo(null);
        
        BufferedReader citac = new BufferedReader(new FileReader(nazovTurnaja));
        pocetTymov = Integer.parseInt(citac.readLine());
        naplnenieMoznosti(pocetTymov);
        nacitanieTymov(citac);
        nacitanieSkore();
        citac.close();
    }
    
    public void naplnenieMoznosti(int pocetTymov){
        if(pocetTymov >= 6){
            pocetSkupin++;
        }
        
        this.volbaTabulky.removeAllItems();
        for(int i = 0;i<pocetSkupin;i++){
            this.volbaTabulky.addItem("skupina" + (i+1));
        }
        this.volbaTabulky.setSelectedItem(null);
        
        if(pocetSkupin != 1){
            pocetTymovVSkupine = pocetTymov/2+pocetTymov%2;
        } else {
            pocetTymovVSkupine = pocetTymov;
        }
        skore = new String[pocetSkupin][pocetTymovVSkupine][pocetTymovVSkupine];
    }
    
    public void nacitanieTymov(BufferedReader citac) throws IOException{
        String pomoc = "";
        
        for(int i = 0;i < pocetTymov;i++){
            tymy.add(new ArrayList<String>());
            citac.readLine();
            tymy.get(i).add(citac.readLine());
            while(!(pomoc = citac.readLine()).equals(";")){
                tymy.get(i).add(pomoc.substring(0, pomoc.indexOf("-")));
                tymy.get(i).add(pomoc.substring(pomoc.indexOf("-") + 1));
            }
        }  
    }
    
    public void nacitanieSkore() throws FileNotFoundException {
        String nazov = "";
        for(int skupina = 0;skupina < pocetSkupin;skupina++){
            for(int tymA = skupina*pocetTymovVSkupine;tymA<skupina*pocetTymovVSkupine+pocetTymovVSkupine;tymA++){
                for(int tymB = skupina*pocetTymovVSkupine;tymB<skupina*pocetTymovVSkupine+pocetTymovVSkupine;tymB++){
                    if(!(skupina == 1 && pocetTymov != pocetTymovVSkupine*2 && (tymA == skupina*pocetTymovVSkupine+pocetTymovVSkupine - 1
                    || tymB == skupina*pocetTymovVSkupine+pocetTymovVSkupine - 1))){
                        if(tymA != tymB){
                            if(skore[skupina][tymA%pocetTymovVSkupine][tymB%pocetTymovVSkupine] == null){
                                nazov = "C:\\Users\\bohuc\\Desktop\\6.semester\\bakalarka\\bakalarka\\bc\\turnaj\\";
                                nazov += tymy.get(tymA).get(0) + "-vs-" + tymy.get(tymB).get(0);
                                File subor = new File(nazov);
                                if(subor.exists()){
                                    Scanner citac = new Scanner(subor);
                                    citac.next();
                                    citac.next();
                                    String skoreA = citac.next();
                                    String skoreB = citac.next();
                                    String skoreZapasu = skoreA + ":" + skoreB;
                                    skore[skupina][tymA%pocetTymovVSkupine][tymB%pocetTymovVSkupine] = skoreZapasu;
                                    skoreZapasu = skoreB + ":" + skoreA;
                                    skore[skupina][tymB%pocetTymovVSkupine][tymA%pocetTymovVSkupine] = skoreZapasu;
                                }
                            }
                        } else {
                            skore[skupina][tymA%pocetTymovVSkupine][tymB%pocetTymovVSkupine] = " X ";
                        }
                    }
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
        jLabelExit = new javax.swing.JLabel();
        jLabelMini = new javax.swing.JLabel();
        volbaTabulky = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonHladatTabulku = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        startZapasu = new javax.swing.JButton();
        nazovDomaci = new javax.swing.JTextField();
        nazovHostia = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 70));
        jPanel2.setLayout(null);

        jLabelExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelExit);
        jLabelExit.setBounds(1450, 0, 50, 70);

        jLabelMini.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMini.setText("—");
        jLabelMini.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabelMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMiniMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelMini);
        jLabelMini.setBounds(1400, 0, 50, 70);

        volbaTabulky.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        volbaTabulky.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        volbaTabulky.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel2.add(volbaTabulky);
        volbaTabulky.setBounds(245, 15, 150, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Volba tabulky: ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 15, 200, 40);

        jButtonHladatTabulku.setBackground(new java.awt.Color(0, 0, 0));
        jButtonHladatTabulku.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonHladatTabulku.setForeground(new java.awt.Color(240, 240, 240));
        jButtonHladatTabulku.setText("Hladat");
        jButtonHladatTabulku.setPreferredSize(new java.awt.Dimension(120, 40));
        jButtonHladatTabulku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonHladatTabulkuMouseClicked(evt);
            }
        });
        jPanel2.add(jButtonHladatTabulku);
        jButtonHladatTabulku.setBounds(430, 15, 120, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jButton1.setText("U l o z i ť");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 3));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel2.add(jButton1);
        jButton1.setBounds(900, 5, 250, 60);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.setRowHeight(50);
        jScrollPane1.setViewportView(jTable);

        startZapasu.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        startZapasu.setText("Start");
        startZapasu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startZapasuMouseClicked(evt);
            }
        });

        nazovDomaci.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nazovDomaci.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nazovDomaci.setPreferredSize(new java.awt.Dimension(220, 50));

        nazovHostia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nazovHostia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nazovHostia.setPreferredSize(new java.awt.Dimension(220, 50));

        jPanel3.setBackground(new java.awt.Color(255, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        jPanel3.setForeground(new java.awt.Color(255, 102, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(220, 60));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Volba domaci:");
        jLabel2.setPreferredSize(new java.awt.Dimension(220, 29));
        jPanel3.add(jLabel2);
        jLabel2.setBounds(15, 16, 190, 29);

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        jPanel4.setForeground(new java.awt.Color(255, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Volba hostia:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VOLBA ZAPASU");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tabuľka výsledkov");

        jButton2.setText("jButton2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nazovDomaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(68, 68, 68)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nazovHostia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(startZapasu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton2))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazovDomaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nazovHostia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(startZapasu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMiniMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMiniMouseClicked

    //11 znakov v nazve tymu
    private void jButtonHladatTabulkuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHladatTabulkuMouseClicked
        String akaSkupina = (String)this.volbaTabulky.getSelectedItem();
        if(akaSkupina != null){
            int cisloSkupiny = akaSkupina.charAt(akaSkupina.length()-1)-48;
            tvornaTabulky(cisloSkupiny);
        }
    }//GEN-LAST:event_jButtonHladatTabulkuMouseClicked

    private void startZapasuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startZapasuMouseClicked
        String cesta = "C:\\Users\\bohuc\\Desktop\\6.semester\\bakalarka\\bakalarka\\bc\\turnaj\\";
        cesta += this.nazovDomaci.getText() + "-vs-" + this.nazovHostia.getText();
        try {
            tvorbaZapasu(cesta);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(turnaj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(turnaj.class.getName()).log(Level.SEVERE, null, ex);
        }
        zapas zapas1 = new zapas(cesta);
        zapas1.setVisible(true);
        zapas1.pack();
        zapas1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_startZapasuMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        vyhodnotenie zapas1 = new vyhodnotenie(skore,tymy);
        zapas1.setVisible(true);
        zapas1.pack();
        zapas1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    public void tvornaTabulky(int cisloSkupiny){
        DefaultTableModel model = (DefaultTableModel) this.jTable.getModel();
        int nic = model.getRowCount();
        for(int i = 0;i<nic;i++){
            model.removeRow(0);
        }
        if(cisloSkupiny == 2 && pocetTymov % 2 == 1){
            this.jTable.setRowHeight(580/(pocetTymovVSkupine));
        } else {
            this.jTable.setRowHeight(580/(pocetTymovVSkupine+1));
        }
        
        nazvyTymovUvod(model, cisloSkupiny);
        skoreZapasov(model, cisloSkupiny);
    }
    public void nazvyTymovUvod(DefaultTableModel model,int cisloSkupiny){
        Object obj,objMenu;
        int c = cisloSkupiny-1;
        int d = pocetTymovVSkupine;
        int chyba = d;
        
        if(pocetTymov % 2 == 1 && c == 1){
            chyba--;
        }
        
        if(chyba == 3){
            model.setColumnIdentifiers(new Object[]{"","","",""});
            model.addRow(new Object[]{"",tymy.get(c*d).get(0),tymy.get(c*d+1).get(0),tymy.get(c*d+2).get(0)});
        } else if(chyba == 4){
            model.setColumnIdentifiers(new Object[]{"","","","",""});
            model.addRow(new Object[]{"",tymy.get(c*d).get(0),tymy.get(c*d+1).get(0),tymy.get(c*d+2).get(0),
                                tymy.get(c*d+3).get(0)});
        } else {
            model.setColumnIdentifiers(new Object[]{"","","","","",""});
            model.addRow(new Object[]{"",tymy.get(c*d).get(0),tymy.get(c*d+1).get(0),tymy.get(c*d+2).get(0),
                                tymy.get(c*d+3).get(0),tymy.get(c*d+4).get(0)});
        }
    }
    public void skoreZapasov(DefaultTableModel model,int cisloSkupiny){
        int c = cisloSkupiny-1;
        int d = pocetTymovVSkupine;
        int chyba = d;
        
        if(pocetTymov % 2 == 1 && c == 1){
            chyba--;
        }
        for(int i = 0;i < chyba;i++){
            if(chyba == 3){
                model.addRow(new Object[]{tymy.get(c*d+i).get(0),skore[c][i][0],skore[c][i][1],skore[c][i][2]});
            } else if(chyba == 4){
                model.addRow(new Object[]{tymy.get(c*d+i).get(0),skore[c][i][0],skore[c][i][1],
                                        skore[c][i][2],skore[c][i][3]});
            } else {
                model.addRow(new Object[]{tymy.get(c*d+i).get(0),skore[c][i][0],skore[c][i][1],
                                        skore[c][i][2],skore[c][i][3],skore[c][i][4]});
            }
        }
        
    }
    
    public void tvorbaZapasu(String cesta) throws FileNotFoundException, IOException{
        int tymD,tymH;
        tymD = tymH = -1;
        File subor = new File(cesta);
        if(subor.createNewFile()){
            PrintWriter zapisovac = new PrintWriter(subor);
            zapisovac.println(this.nazovDomaci.getText());
            zapisovac.println(this.nazovHostia.getText());
            
            tymD = zistenieCislaTymov(this.nazovDomaci.getText());
            tymH = zistenieCislaTymov(this.nazovHostia.getText());
            
            nacitanieZostavy(zapisovac, tymD, tymH);
            
            zapisovac.close();
        }
    }
    
    public void nacitanieZostavy(PrintWriter zapisovac,int tymD,int tymH){
        zapisovac.println("0");
        zapisovac.println("0");
        zapisovac.println("0");
        
        nacitanieTymu(zapisovac, tymD, "Domaci");
        nacitanieTymu(zapisovac, tymH, "Hostia");
        
        zapisovac.println("Priebeh");
        zapisovac.println("Tabulka Golov");
        zapisovac.println(";");
        zapisovac.println("Tabulka Trestov");
        zapisovac.println(";");
    }
    
    public void nacitanieTymu(PrintWriter zapisovac,int tym, String rola){
        zapisovac.println(rola);
        zapisovac.println("Supiska");
        ArrayList nic = tymy.get(tym);
        for(int i = 1;i < tymy.get(tym).size();i++){
            zapisovac.println(tymy.get(tym).get(i));
            if(i % 2 == 0){
                zapisovac.println("");
                zapisovac.println("");
            }
        }
        zapisovac.println(";");
        zapisovac.println("Manazment");
        for(int i = 0;i < 4;i++){
            zapisovac.println("");
        }
        zapisovac.println("Zostava");
        for(int i = 0;i < 25;i++){
            zapisovac.println("");
        }
    }
    
    public int zistenieCislaTymov(String nazov){
        for(int i = 0;i<tymy.size();i++){
            if(tymy.get(i).get(0).equals(nazov)){
                return i;
            }
        }
        return -1;
    }
    
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
            java.util.logging.Logger.getLogger(turnaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(turnaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(turnaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(turnaj.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new turnaj().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(turnaj.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonHladatTabulku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelMini;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField nazovDomaci;
    private javax.swing.JTextField nazovHostia;
    private javax.swing.JButton startZapasu;
    private javax.swing.JComboBox<String> volbaTabulky;
    // End of variables declaration//GEN-END:variables
}

