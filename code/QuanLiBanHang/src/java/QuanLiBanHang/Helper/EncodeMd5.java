/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang.Helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author user
 */
public class EncodeMd5 {
    public static String encodeMD5Password(String string){
	String result = "";
        MessageDigest digest;
	try {
                digest = MessageDigest.getInstance("MD5");
		digest.update(string.getBytes());
		BigInteger bigInteger = new BigInteger(1,digest.digest());
		result = bigInteger.toString(16);
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return result;
    }
}
