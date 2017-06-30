/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/

package my.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Arrays;
import java.util.Base64;
import my.tpa.TPA_Client;
/**
 *
 * @author Mpaul24
 */
public class EncryptionDecrption {
    public static byte[] deriveKey(String p, byte[] s, int i, int l) throws Exception {
		  PBEKeySpec ks = new PBEKeySpec(p.toCharArray(), s, i, l);
		  SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		  return skf.generateSecret(ks).getEncoded();
	}
	
	public static byte[] encryptDataAES(String name,byte[] a ,String p, String file_name) throws Exception{
		SecureRandom r = SecureRandom.getInstance("SHA1PRNG");
		// Generate 160 bit Salt for Encryption Key
		byte[] esalt = new byte[20]; r.nextBytes(esalt);
		// Generate 128 bit Encryption Key
		byte[] dek = deriveKey(p, esalt, 100000, 128);
		 // Perform Encryption
		SecretKeySpec eks = new SecretKeySpec(dek, "AES");
		Cipher c = Cipher.getInstance("AES/CTR/NoPadding");
		c.init(Cipher.ENCRYPT_MODE, eks, new IvParameterSpec(new byte[16]));
		byte[] es = c.doFinal(a);
		String os = new String(Base64.getEncoder().encode(esalt));
		FileOutputStream fout = new FileOutputStream(new File(Client.path_key+"\\"+file_name+"_key"), true);
		fout.write(name.getBytes(),0, name.getBytes().length);
		fout.write("\n".getBytes());
		fout.write(os.getBytes());
		fout.write("\n".getBytes());
		fout.close();
		return es;
	}
	
	
	public static boolean encryptCipherHMAC(String p,byte[] a,String name, String file_name) throws Exception{
		SecureRandom r = SecureRandom.getInstance("SHA1PRNG");
		// Generate 160 bit Salt for Encryption Key
		byte[] hsalt = new byte[20]; r.nextBytes(hsalt);
		// Generate 160 bit HMAC Key
		byte[] dhk = deriveKey(p, hsalt, 100000, 160);
		 
		  // Perform HMAC using SHA-256
		SecretKeySpec hks = new SecretKeySpec(dhk, "HmacSHA256");
		Mac m = Mac.getInstance("HmacSHA256");
		m.init(hks);
		byte[] hmac = m.doFinal(a);
		String x = new String(Base64.getEncoder().encode(hmac));
		FileOutputStream fout = new FileOutputStream(new File(Client.path_key+"\\"+file_name+"_hmacOriginal"), true);
		fout.write(name.getBytes(),0, name.getBytes().length);
		fout.write("\n".getBytes());
		fout.write(x.getBytes());
		fout.write("\n".getBytes());
		fout.close();
  
		String y = new String(Base64.getEncoder().encode(hsalt));
		fout = new FileOutputStream(new File(Client.path_key+"\\"+file_name+"_hmacKey"), true);
		fout.write(name.getBytes(),0, name.getBytes().length);
		fout.write("\n".getBytes());
		fout.write(y.getBytes());
		fout.write("\n".getBytes());
		fout.close();
  
		return true;
		
	}
	
	public static boolean decryptCipherHMAC(String p,byte[] a,String name, String file_name) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Client.path_key+"\\"+file_name+"_hmacOriginal")));
		String x = "";
		while((x = bufferedReader.readLine())!=null){
			if(x.equals(name)){
				x = bufferedReader.readLine();
				bufferedReader.close();
				break;
			}
		}
		String hmac_original = x;
		
		bufferedReader = new BufferedReader(new FileReader(new File(Client.path_key+"\\"+file_name+"_hmacKey")));
		x="";
		while((x = bufferedReader.readLine())!=null){
			if(x.equals(name)){
				x = bufferedReader.readLine();
				bufferedReader.close();
				break;
			}
		}
		byte[] hsalt = Base64.getDecoder().decode(x.getBytes());
		byte[] dhk = deriveKey(p, hsalt, 100000, 160);
 
		// Perform HMAC using SHA-256
		SecretKeySpec hks = new SecretKeySpec(dhk, "HmacSHA256");
		Mac m = Mac.getInstance("HmacSHA256");
		m.init(hks);
		byte[] hmac = m.doFinal(a);
		String hmac_calculated = new String(Base64.getEncoder().encode(hmac));
		if(hmac_calculated.equals(hmac_original)){
			return true;
		}
		else{
                    System.out.println(hmac_calculated);
                    System.out.println(hmac_original);
			return false;
		}
		
	}
	
	
	
	public static byte[] decryptDataAES(byte[] a ,String name,String p,String file_name) throws Exception{
		//FileInputStream fin = new FileInputStream(new File("key"));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Client.path_key+"\\"+file_name+"_key")));
		String x = "";
		while((x = bufferedReader.readLine())!=null){
			if(x.equals(name)){
				x = bufferedReader.readLine();
				bufferedReader.close();
				break;
			}
		}
		byte[] esalt = Base64.getDecoder().decode(x.getBytes());
		byte[] dek = deriveKey(p, esalt, 100000, 128);
		
		SecretKeySpec eks = new SecretKeySpec(dek, "AES");
	    Cipher c = Cipher.getInstance("AES/CTR/NoPadding");
	    c.init(Cipher.DECRYPT_MODE, eks, new IvParameterSpec(new byte[16]));
	    byte[] s = c.doFinal(a);
		
		return s;
	}
        
        
        public static void CHECKencryptCipherHMAC(String p,byte[] a,String name, String file_name) throws Exception{
		SecureRandom r = SecureRandom.getInstance("SHA1PRNG");
		// Generate 160 bit Salt for Encryption Key
		byte[] hsalt = new byte[20]; r.nextBytes(hsalt);
		// Generate 160 bit HMAC Key
		byte[] dhk = deriveKey(p, hsalt, 100000, 160);
		 
		  // Perform HMAC using SHA-256
		SecretKeySpec hks = new SecretKeySpec(dhk, "HmacSHA256");
		Mac m = Mac.getInstance("HmacSHA256");
		m.init(hks);
		byte[] hmac = m.doFinal(a);
		String x = new String(Base64.getEncoder().encode(hmac));
		FileOutputStream fout = new FileOutputStream(new File(TPA_Client.path_key+"\\"+file_name+"_hmacOriginal"), true);
		fout.write(x.getBytes());
		fout.close();
  
		String y = new String(Base64.getEncoder().encode(hsalt));
		fout = new FileOutputStream(new File(TPA_Client.path_key+"\\"+file_name+"_hmacKey"), true);
		fout.write(name.getBytes(),0, name.getBytes().length);
		fout.write("\n".getBytes());
		fout.write(y.getBytes());
		fout.write("\n".getBytes());
		fout.close();
  
		
	}
        
        public static void CHECKCLIENTencryptCipherHMAC(String p,byte[] a,String name, String file_name) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(TPA_Client.path_key+"\\"+file_name+"_hmacKey")));
		String x="";
		while((x = bufferedReader.readLine())!=null){
			if(x.equals(name)){
				x = bufferedReader.readLine();
				bufferedReader.close();
				break;
			}
		}
                System.out.println(x);
		byte[] hsalt = Base64.getDecoder().decode(x.getBytes());
		// Generate 160 bit HMAC Key
		byte[] dhk = deriveKey(p, hsalt, 100000, 160);
		 
		  // Perform HMAC using SHA-256
		SecretKeySpec hks = new SecretKeySpec(dhk, "HmacSHA256");
		Mac m = Mac.getInstance("HmacSHA256");
		m.init(hks);
		byte[] hmac = m.doFinal(a);
		x = new String(Base64.getEncoder().encode(hmac));
		FileOutputStream fout = new FileOutputStream(new File(TPA_Client.path_key+"\\"+file_name+"_hmacOriginalFromClient"), true);
		fout.write(x.getBytes());
		fout.close();
  
		
	}
}
