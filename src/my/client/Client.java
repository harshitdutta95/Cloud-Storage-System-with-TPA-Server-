
package my.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import my.server.Server;
import my.server.ServerThread;


public class Client extends javax.swing.JFrame {

    
    public Client() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        id_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass_tf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ip_tf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        client_ta = new javax.swing.JTextArea();
        message_tf = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        file_button = new javax.swing.JButton();
        file_pb = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        filename_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        filepath_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        token_tf = new javax.swing.JTextField();
        tokenize_bt = new javax.swing.JButton();
        encryption_bt = new javax.swing.JButton();
        org_file_bt = new javax.swing.JButton();
        encry_file_bt = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        getfile_bt = new javax.swing.JButton();
        decrypt_bt = new javax.swing.JButton();
        port_tf = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("UserID");

        id_tf.setText("mpaul24");
        id_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_tfActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        pass_tf.setText("12345");
        pass_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_tfActionPerformed(evt);
            }
        });

        jLabel3.setText("Server's IP");

        ip_tf.setText("127.0.0.1");
        ip_tf.setToolTipText("");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        client_ta.setColumns(20);
        client_ta.setRows(5);
        jScrollPane1.setViewportView(client_ta);

        message_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message_tfActionPerformed(evt);
            }
        });

        send_button.setText("Send");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CLIENT");

        file_button.setText("File");
        file_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_buttonActionPerformed(evt);
            }
        });

        file_pb.setToolTipText("");

        jLabel5.setText("File Name");

        filename_tf.setText("Sample.txt");

        jLabel6.setText("File Path");

        filepath_tf.setText("E:\\Sample.txt");
        filepath_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filepath_tfActionPerformed(evt);
            }
        });

        jLabel7.setText("Tokenization-------------------------------------------------------------");

        jLabel8.setText("Number of Tokens");

        token_tf.setText("20");

        tokenize_bt.setText("Tokenize");
        tokenize_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenize_btActionPerformed(evt);
            }
        });

        encryption_bt.setText("Encrytion");
        encryption_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryption_btActionPerformed(evt);
            }
        });

        org_file_bt.setText("Show Files");

        encry_file_bt.setText("Show Files");

        jButton6.setText("Upload Encrypted File to Cloud/TPA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        getfile_bt.setText("Get File from Cloud");
        getfile_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getfile_btActionPerformed(evt);
            }
        });

        decrypt_bt.setText("Decrypt Files Recieved from Cloud");
        decrypt_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrypt_btActionPerformed(evt);
            }
        });

        port_tf.setText("2500");

        jButton2.setText("Request TPA to check Integrity");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Port");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(file_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(send_button))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(message_tf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(file_pb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(port_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(pass_tf)
                                    .addComponent(id_tf)
                                    .addComponent(ip_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(token_tf))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(org_file_bt)
                                            .addComponent(tokenize_bt))
                                        .addGap(105, 105, 105)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(encryption_bt)
                                            .addComponent(encry_file_bt)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(filename_tf)
                                            .addComponent(filepath_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(getfile_bt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(decrypt_bt))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addGap(66, 66, 66))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(50, 50, 50))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filename_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getfile_bt)
                            .addComponent(decrypt_bt)
                            .addComponent(jLabel3)
                            .addComponent(ip_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pass_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(port_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(message_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(file_pb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(send_button)
                            .addComponent(file_button)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(filepath_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(token_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tokenize_bt)
                            .addComponent(encryption_bt))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(org_file_bt)
                            .addComponent(encry_file_bt))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_tfActionPerformed

    private void pass_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_tfActionPerformed
    
    String response="";
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    static String path_key = "E:\\CloudArchitecture\\LocalMachine\\Key";
    static String path_originals = "E:\\CloudArchitecture\\LocalMachine\\Originals";
    static String path_encrypted = "E:\\CloudArchitecture\\LocalMachine\\Encrypted";
    static String path_recieved = "E:\\CloudArchitecture\\LocalMachine\\Recieved_Encrypted";
    static String path_decrypted = "E:\\CloudArchitecture\\LocalMachine\\Decrypted";
    int buffer_size;
    boolean x = false;int MAX,MIN,len;
    byte[] buffer;
    FileInputStream fin;
    String prev;
    boolean workingInBg = true;
    FileOutputStream fout;
    String file_name,file_path;
    boolean sendFile = false;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try {
            // TODO add your handling code here:
            String ip = ip_tf.getText();
            int port = Integer.parseInt(port_tf.getText());
            s = new Socket(ip,port);
            JOptionPane.showMessageDialog(this, "Connected to Server");
            openreader();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void message_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_message_tfActionPerformed
    
    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        try {
            //System.out.println(""+sendFile);
            if(workingInBg){
                if(!sendFile){
                    dout.writeBoolean(false);
                    dout.writeUTF(message_tf.getText());
                }
                else{
                    prev = client_ta.getText();
                    dout.writeBoolean(true);//
                    File f = new File(file_path);
                    MAX = (int) f.length();
                    MIN = 0;
                    file_pb.setMinimum(MIN);
                    file_pb.setMaximum(MAX);
                    dout.writeUTF(file_name);// sending the file_name
                    fin = new FileInputStream(f);
                    buffer = new byte[2048];

                    Thread h = new Thread(
                            new Runnable() {
                        @Override
                        public void run() {
                            while(true){
                                file_pb.setValue(MIN); //updating the progress bar
                                if(MIN==MAX) break;
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        }
                    });

                    Thread hi = new Thread(
                            new Runnable() {
                        @Override
                        public void run() {
                            h.start();//starting the thread which updates the progress bar
                        do{
                            try {
                                len = fin.read(buffer); //reads 2048 bytes from the file and stores in buffer
                                MIN += len; //incrementing MIN to update the progress bar
                                if(x)
                                    dout.writeBoolean(true); //prevent sending boolean value 2 times to Server
                                x = true;
                                float min = (float) MIN;
                                float max = (float) MAX;
                                float percentage = (min/max)*100;
                                String f = prev + "\n"+ "Sent: "+percentage+" %";
                                if(len!=-1)
                                    client_ta.setText(f);
                                if(len!=-1)
                                    dout.writeInt(len);
                                else
                                    dout.writeInt(5000);
                                if(len!=-1)
                                    dout.write(buffer, 0, len);
                                
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            } catch (IOException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }while(len!=-1);
                            try {
                                fin.close();
                                dout.flush();
                            } catch (IOException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        sendFile = false;
                        x = false;
                        workingInBg = true;
                        }
                    });
                    hi.start();
                    workingInBg = false;
            }}
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_send_buttonActionPerformed
    
    private void file_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_buttonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File f = fileChooser.getSelectedFile();
            file_name = f.getName();
            file_path = f.getPath();
            filename_tf.setText(file_name);
            filepath_tf.setText(file_path);
            JOptionPane.showMessageDialog(this, file_name);
            sendFile = true;
        }
    }//GEN-LAST:event_file_buttonActionPerformed

    private void filepath_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filepath_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filepath_tfActionPerformed

    
    private void tokenize_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokenize_btActionPerformed
        
        try {
            File f = new File(filepath_tf.getText());
            fin = new FileInputStream(f);
            long so = f.length();
            int n = Integer.parseInt(token_tf.getText());
            so = so/n;
            buffer_size = (int) Math.ceil(so);
            int len = 0;
            buffer = new byte[buffer_size];
            for(int i=0;i<n;i++){
                len = fin.read(buffer);
                String name = f.getName()+"_"+i;
                fout = new FileOutputStream(new File(path_originals+"\\"+name));
                fout.write(buffer, 0, len);
                fout.close();
            }
            System.out.println("File Tokenized!!!");
            fin.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_tokenize_btActionPerformed

    private void encryption_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryption_btActionPerformed
        int n = Integer.parseInt(token_tf.getText());
        buffer = new byte[buffer_size];
        String name;
        for(int i=0;i<n;i++){
            try {
                fin = new FileInputStream(new File(path_originals+"\\"+file_name+"_"+i));
                name = file_name+"_"+i;
                len = fin.read(buffer);
                fout = new FileOutputStream(new File(path_encrypted+"\\"+name));
                buffer = EncryptionDecrption.encryptDataAES(name,buffer, "HelloHowareyou",file_name);
		fout.write(buffer, 0, len);
                boolean status = EncryptionDecrption.encryptCipherHMAC("Howresdkasdbk", buffer, name,file_name);
                if(status) System.out.println("HMAC Generated");
                else System.out.println("HMAC not Generated");
                fin.close();
                fout.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("File Encrpted!!!");
    }//GEN-LAST:event_encryption_btActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            file_name = filename_tf.getText();
            int n = Integer.parseInt(token_tf.getText());
            dout.writeInt(n);
            dout.writeUTF(filename_tf.getText());
            buffer = new byte[2048];
            int len = 0;
            for(int i=0;i<n;i++){
                fin = new FileInputStream(new File(path_encrypted+"\\"+file_name+"_"+i));
                do{
                    len = fin.read(buffer);
                    dout.writeInt(len);
                    Thread.sleep(10);
                    dout.write(buffer,0,len);
                }while(len==2048);
                len = 0;
                dout.flush();
                fin.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void getfile_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getfile_btActionPerformed
        FileRecThread f = new FileRecThread(din, dout);
    }//GEN-LAST:event_getfile_btActionPerformed

    private void decrypt_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrypt_btActionPerformed
        try {
            file_name = filename_tf.getText();
            int n = Integer.parseInt(token_tf.getText());
            buffer = new byte[buffer_size];
            String name;
            fout = new FileOutputStream(new File(path_decrypted+"\\"+file_name));
            for(int i=0;i<n;i++){
                try {
                    fin = new FileInputStream(new File(path_recieved+"\\"+file_name+"_"+i));
                    name = file_name+"_"+i;
                    len = fin.read(buffer);
                    boolean status = EncryptionDecrption.decryptCipherHMAC("Howresdkasdbk", buffer, name,file_name);
                    if(status){
                        System.out.println("MAC Verification cleared!!!");
                        buffer = EncryptionDecrption.decryptDataAES(buffer, name, "HelloHowareyou",file_name);
                        fout.write(buffer, 0, len);
                    }else{
                        System.out.println("MAC verification failed!!!");
                        break;
                    }
                    fin.close();
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fout.close();
            System.out.println("File Decrpted!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_decrypt_btActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            dout.writeUTF(id_tf.getText());
            dout.writeUTF(filename_tf.getText());
            boolean x = din.readBoolean();
            if(x){
                JOptionPane.showMessageDialog(this, "Filename and username recieved");
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        boolean x;
        x = new File(path_key).mkdirs();
        x = new File(path_originals).mkdirs();
        x = new File(path_encrypted).mkdirs();
        x = new File(path_recieved).mkdirs();
        x = new File(path_decrypted).mkdirs();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea client_ta;
    private javax.swing.JButton decrypt_bt;
    private javax.swing.JButton encry_file_bt;
    private javax.swing.JButton encryption_bt;
    private javax.swing.JButton file_button;
    public javax.swing.JProgressBar file_pb;
    private javax.swing.JTextField filename_tf;
    private javax.swing.JTextField filepath_tf;
    private javax.swing.JButton getfile_bt;
    private javax.swing.JTextField id_tf;
    private javax.swing.JTextField ip_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message_tf;
    private javax.swing.JButton org_file_bt;
    private javax.swing.JTextField pass_tf;
    private javax.swing.JTextField port_tf;
    private javax.swing.JButton send_button;
    private javax.swing.JTextField token_tf;
    private javax.swing.JButton tokenize_bt;
    // End of variables declaration//GEN-END:variables

    private void openreader() {
        try {
            din = new DataInputStream(s.getInputStream());
           dout = new DataOutputStream(s.getOutputStream());
           String username=id_tf.getText();
           String password=pass_tf.getText();
           dout.writeUTF(username);
           dout.writeUTF(password);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private static class MsgRecThread extends Thread{
//        Client form;
//        DataInputStream din;
//        DataOutputStream dout;
//        public MsgRecThread(Client form, DataInputStream din, DataOutputStream dout) {
//            this.form = form;
//            this.din = din;
//            this.dout = dout;
//            start();
//        }
//        
//        @Override
//        public void run(){
//            try {
//                while(true)
//                    form.client_ta.append(din.readUTF().toString()+"\n");
//            } catch (IOException ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    class FileRecThread extends Thread{
        DataInputStream din;
        DataOutputStream dout;
        public FileRecThread(DataInputStream din, DataOutputStream dout) {
            this.din = din;
            this.dout = dout;
            start();
        }
        
        boolean fn = false;boolean x ;
        FileOutputStream fout;
        File f;
        byte[] buffer = new byte[2048];
        int len = 0;
        @Override
        public void run(){
            try {
                System.out.println("Ready to Recieve");
                int n = din.readInt();
                System.out.println("Recieved n");
                String name = din.readUTF();
                System.out.println("Recieved name");
                for(int i=0;i<n;i++){
                    fout = new FileOutputStream(new File(path_recieved+"\\"+name+"_"+i));
                    do{
                        len = din.readInt();
                        Thread.sleep(10);
                        if(len>0 && len<=2048){
                            din.readFully(buffer,0,len);
                            fout.write(buffer,0,len);
                        }
                    }while(len==2048);
                    len = 0;
                    fout.flush();
                    fout.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
