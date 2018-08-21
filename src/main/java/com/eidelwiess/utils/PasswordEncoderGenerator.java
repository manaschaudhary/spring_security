package com.eidelwiess.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

  public static void main(String[] args) {

	int i = 0;
	while (i < 10) {
		String password = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		String encryptedPassword = "$2a$10$bVrHq5XqJdoXpBcGh836nu4L286rIwjEYy.8VTsHpmq.DH1zHiOsu";
		System.out.println(hashedPassword + "\t" +passwordEncoder.matches("123456", hashedPassword) + "\t" +passwordEncoder.matches("123456", encryptedPassword));
		i++;
	}
		//System.out.println(passwordEncoder.matches("user","$2a$10$T6wuIFDDVrbnduVKZK2rgO9QF6LvwRj6hay4Hvez7flV8/5RznXiW"));
  }
}