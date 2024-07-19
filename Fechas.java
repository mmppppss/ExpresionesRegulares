import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fechas {

	public static void main(String[] args) {
		String[] diario={
			"hoy 1824-06-02 encontre una solucion al problema",
			"1824-06-06 inicie la busqueda de la planta",
			"mañana 1824-06-24 termina la expedicion",
			"el dia de hoy 1824-07-12 iniciamos el retorno"
		};
		Pattern fecha = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		System.out.println("Fechas: ");
		for (String dia : diario) {
			Matcher fechas = fecha.matcher(dia);
			if(fechas.find())
				System.out.println(fechas.group());
		}
	}
}


