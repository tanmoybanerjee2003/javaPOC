import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

/**
 * 
 */

/**
 * @author tanmoy
 *
 */
public class Crypto {
	private static final int OFFSET = 4;
	
	public static boolean caesarCipherEncrypt(String inputFile, String outputFile) {
		boolean success = true;
		
		try {
			byte[] data = Files.readAllBytes(Paths.get(inputFile));
			String encoded = Base64.getEncoder().encodeToString(data);
			
			//reverse the string
			String reverse = new StringBuffer(encoded).reverse().toString();
			
			StringBuilder tmp = new StringBuilder();
			for(int i=0; i<reverse.length(); i++) {
				tmp.append((char)(reverse.charAt(i) + OFFSET));
			}
			
			//now write back to file
			Files.write(Paths.get(outputFile), tmp.toString().getBytes("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch(Exception ex) {
			ex.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public static boolean caesarCipherDecrypt(String inputFile, String outputFile) {
		boolean success = true;
		
		try {
			byte[] data = Files.readAllBytes(Paths.get(inputFile));
			String secret = new String(data, "UTF-8");
			
			StringBuilder tmp = new StringBuilder();
			for(int i=0; i<secret.length(); i++) {
				tmp.append((char)(secret.charAt(i) - OFFSET));
			}
			
			String reversed = new StringBuffer(tmp.toString()).reverse().toString();
			String decryptedStr = new String(Base64.getDecoder().decode(reversed));
			
			//now write back to file
			Files.write(Paths.get(outputFile), decryptedStr.getBytes("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch(Exception ex) {
			ex.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	public static void main(String[] args) {
		String option = System.getProperty("option");
		String inputFile = System.getProperty("file");
		
		if((option == null) || (option.length() == 0)) {
			System.err.println("option is mandatory.");
		}
		
		if((inputFile == null) || (inputFile.length() == 0)) {
			System.err.println("file is mandatory.");
		}
		
		switch(option.toUpperCase()) {
			case "ENCRYPT":
				System.out.println("Encrypt...");
				boolean isSuccessful = caesarCipherEncrypt(inputFile, "encrypted.txt");
				if(isSuccessful) {
					System.out.println("encrypted.txt has been generated.");
				}
				break;
			case "DECRYPT":
				System.out.println("Decrypt...");
				isSuccessful = caesarCipherDecrypt(inputFile, "decrypted.txt");
				if(isSuccessful) {
					System.out.println("decrypted.txt has been generated.");
				}
				break;
			default:
				System.err.println("invalid option.");
		}
	}
}
