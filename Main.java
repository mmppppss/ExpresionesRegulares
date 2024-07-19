import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String texto = "hola que tal";
		Pattern patron = Pattern.compile("^hola.*");
		Matcher coincidencia = patron.matcher(texto);
		if (coincidencia.find()) {
			System.out.println(coincidencia.group());
		}
	}
}
