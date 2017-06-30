
package my.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.client.Client;
public class ServerThread extends Thread{
    String username,password;

    Server form;
    ServerSocket ss;
    Socket s1;
    DataInputStream din;
    DataOutputStream dout;
    
   ServerThread(Server form){
        try {
            this.form = form;
            JOptionPane.showMessageDialog(form, "Server Started");
            ss = new ServerSocket(2400);
            start();
        } catch (IOException ex) {
            
        }
    }

    @Override
    public void run(){
        try {
            s1 = ss.accept();
            openReader();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void openReader() {
        try {
            din = new DataInputStream(s1.getInputStream());
            dout = new DataOutputStream(s1.getOutputStream());
            username=din.readUTF();
            password=din.readUTF();
            form.client_connect.append(username+"/n");
            Server.db.connectNewUser(username, password);
            
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void response(){
        try {//Responding to TPA's Request
            username = din.readUTF();
            String file_name = din.readUTF();
            form.username_tf.setText(username);
            form.file_tf.setText(file_name);
            dout.writeBoolean(true);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
//    public void sendMessage(String msg){
//        try {
//            dout.writeUTF(msg);
//        } catch (IOException ex) {
//            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static class MsgRecThread extends Thread{
//        Server form;
//        DataInputStream din;
//        DataOutputStream dout;
//        public MsgRecThread(Server form, DataInputStream din, DataOutputStream dout) {
//            this.form = form;
//            this.din = din;
//            this.dout = dout;
//            start();
//        }
//        
//        boolean fn = false;boolean x ;
//        FileOutputStream fout;
//        FileInputStream fin;
//        File f;
//        byte[] buffer = new byte[2048];
//        @Override
//        public void run(){
//            try {
//                int i=0;
//                while(true){
//                    x = din.readBoolean();
//                    if(!x){
//                        form.server_ta.append(din.readUTF()+"\n");
//                    }
//                    else{
//                        if(!fn){
//                            String name = din.readUTF();
//                            f = new File(name);
//                            fout = new FileOutputStream(f);
//                            fn = true;
//                        }
//                        
//                        
//                        int len = din.readInt();
//                        if(len>0 && len<=2048){
//                            din.read(buffer,0,len);
//                            fout.write(buffer,0,len);
//                        }
//                        else{
//                            form.server_ta.append("File Recieved!!!\n");
//                            fout.close();
//                            fn = false;
//                            x = false;
//                        }
//                    }
//                } 
//            } catch (IOException ex) {
//                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    public void fileread(){
        FileRecThread f = new FileRecThread(form, din, dout);
        
    }
    
    class FileRecThread extends Thread{
        Server form;
        DataInputStream din;
        DataOutputStream dout;
        public FileRecThread(Server form, DataInputStream din, DataOutputStream dout) {
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
                System.out.println("Ready to Recieve");
                int n = din.readInt();
                System.out.println("Recieved n");
                String name = din.readUTF();
                System.out.println("Recieved name");
                form.filename_tf.setText(name);
                form.token_tf.setText(n+"");
                Server.db.getstatemet().executeUpdate("insert into "+username+"(filename, tokens) values('"+name+"', '"+n+"')");
                for(int i=0;i<n;i++){
                    fout = new FileOutputStream(new File(Server.path_encrypted+"\\"+name+"_"+i));
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
            } catch (IOException | InterruptedException | SQLException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    FileInputStream fin;
    public void sendFile(){
        try {
            String file_name = form.filename_tf.getText();
            int n = Integer.parseInt(form.token_tf.getText());
            dout.writeInt(n);
            dout.writeUTF(file_name);
            byte[] buffer = new byte[2048];
            int len = 0;
            for(int i=0;i<n;i++){
                fin = new FileInputStream(new File(Server.path_encrypted+"\\"+file_name+"_"+i));
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
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(){
        try {
            String file_name = form.file_tf.getText();
            int n = 20;//Get it from database
            dout.writeInt(n);
            dout.writeUTF(form.file_tf.getText());
            byte[] buffer = new byte[2048];
            int len = 0;
            for(int i=0;i<n;i++){
                fin = new FileInputStream(new File(form.path_encrypted+"\\"+file_name+"_"+i));
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
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
