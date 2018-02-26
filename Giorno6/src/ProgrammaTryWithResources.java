package it.overnet.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgrammaTryWithResources {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("prova.txt")) {
			try (InputStreamReader isr = new InputStreamReader(fis)) {
				try (BufferedReader br = new BufferedReader(isr)) {
					System.out.println(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		

	}

}
