/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.tpa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.server.Server;
import my.server.ServerThread;

/**
 *
 * @author Mpaul24
 */
public class TPA_thread extends Thread{
    
    ServerSocket ss;
    Socket s1;
    DataInputStream din;
    DataOutputStream dout;
    TPA_Client form;
    
    TPA_thread(TPA_Client form){
        try {
            this.form = form;
            ss = new ServerSocket(2500);
            JOptionPane.showMessageDialog(form, "TPA Started");
            start();
        } catch (IOException ex) {
            Logger.getLogger(TPA_thread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void run(){
        try {
            s1 = ss.accept();
            din = new DataInputStream(s1.getInputStream());
            dout = new DataOutputStream(s1.getOutputStream());
            System.out.println("Client Accepted!!");
        } catch (IOException ex) {
            Logger.getLogger(TPA_thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        try {//Closing a Connection
            s1.close();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void response(){
        try {//Responding to the Request by Client
            String username = din.readUTF();
            String filename = din.readUTF();
            form.file_tf.setText(filename);
            form.username_tf.setText(username);
            dout.writeBoolean(true);
        } catch (IOException ex) {
            Logger.getLogger(TPA_thread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fileread() throws IOException{
        FileRecThread f = new FileRecThread(form, din, dout);
    }
    
    class FileRecThread extends Thread{
        TPA_Client form;
        DataInputStream din;
        DataOutputStream dout;
        public FileRecThread(TPA_Client form, DataInputStream din, DataOutputStream dout) {
            this.form = form;
            this.din = din;
            this.dout = dout;
            start();
        }
        
        FileOutputStream fout;
        File f;
        byte[] buffer = new byte[2048];
        int len = 0;
        @Override
        public void run(){
            try {
                int n = din.readInt();
                String name = din.readUTF();
                form.filename_tf.setText(name);
                form.token_tf.setText(n+"");
                for(int i=0;i<n;i++){
                    fout = new FileOutputStream(new File(TPA_Server.path_encrypted+"\\"+name+"_"+i));
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
                Logger.getLogger(TPA_thread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
