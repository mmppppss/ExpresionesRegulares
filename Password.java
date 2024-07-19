import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
	
		
	public static void main(String[] args) {
		new Password();
	}
	
	public Password() {
		for (int i = 0; i < 10; i++) {
			String password = generarPassword();
			System.out.println("Contraseña generada: " + password);
			if (validarPassword(password)) {
				System.out.println("Contraseña valida\n\n");
			} else {
				System.out.println("Contraseña no valida\nRazon:");
				razon(password);
				System.out.println("\n");
			}

		}
	}
	/**
	 * valida una contrasena
	 * @param password contrasena a validar
	 * @return true si la contrasena es valida
	 * false si la contrasena no es valida
	 */
	boolean validarPassword(String password) {
		String patron = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		Pattern pattern = Pattern.compile(patron);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	/**
	 * valida una contrasena y te devuelve la razon
	 * @param password contrasena a validar
	 */
	void razon(String password) {
		String regexNum="(?=.*\\d)";
		String regexMayus="(?=.*[A-Z])";
		String regexMinus="(?=.*[a-z])";
		String regexCaracter="(?=.*[@$!%*?&])";
		String regexCantidad="[A-Za-z\\d@$!%*?&]{8,}";
		Pattern pattern = Pattern.compile(regexNum);
		Matcher matcher = pattern.matcher(password);
		if(!matcher.find()) {
			System.out.println("\tLa contraseña debe contener un numero");
		}
		pattern = Pattern.compile(regexMayus);
		matcher = pattern.matcher(password);
		if(!matcher.find()) {
			System.out.println("\tLa contraseña debe contener una mayúscula");
		}
		pattern = Pattern.compile(regexMinus);
		matcher = pattern.matcher(password);
		if(!matcher.find()) {
			System.out.println("\tLa contraseña debe contener una minúscula");
		}
		pattern = Pattern.compile(regexCaracter);
		matcher = pattern.matcher(password);
		if(!matcher.find()) {
			System.out.println("\tLa contraseña debe contener un caracter especial @$!%*?&");
		}
		pattern = Pattern.compile(regexCantidad);
		matcher = pattern.matcher(password);
		if(!matcher.find()) {
			System.out.println("\tLa contraseña debe tener al menos 8 caracteres");
		}
	}
	/**
	 * genera una contrasena aleatoria de al menos 7 caracteres no necesariamente valida
	 * para probar la validación
	 * 
	 * @return contrasena generada
	 */
	String generarPassword() {
		String cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@$!%*?&";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7 +(int) (Math.random() * 10); i++) {
			int indice = (int) (Math.random() * cadena.length());
			sb.append(cadena.charAt(indice));
		}
		return sb.toString();
	}

}
