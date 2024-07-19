import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Scrapping {
    public static void main(String[] args) {
		new Scrapping();
    }
	Scrapping(){
		System.out.println("Ejemplo practico de web scraping con regex"); 
		System.out.println("Obtiene datos de un estudiante usando el registro");
		String registro = "222106867";
        String url = "https://caja.uagrm.edu.bo/listado.aspx?idper="+registro+"&tipoper=1&sem=&anio=";
		String html = fetch(url); //obtiene el html
		scrapp(html);
	}

	public void scrapp(String html){
		//regex para el nombre, carnet y Registro en el html
		Pattern regexNombre = Pattern.compile("id=\"lNombre\" style=\"display:inline-block;\">(.*?)</span>"); 
		Pattern regexCi = Pattern.compile("id=\"lci\" style=\"display:inline-block;\">(.*?)</span>");
		Pattern regexRegistro = Pattern.compile("id=\"lreg\" style=\"display:inline-block;\">(.*?)</span>");
		Matcher matcher;
		matcher = regexNombre.matcher(html);
		if(matcher.find())
			System.out.println("Nombre: "+matcher.group(1));
		matcher = regexCi.matcher(html);
		if(matcher.find())
			System.out.println("CI: "+matcher.group(1).replaceAll(" ", ""));
		matcher = regexRegistro.matcher(html);
		if(matcher.find())
			System.out.println("Registro: "+matcher.group(1));
	}

    public static String fetch(String urlToRead){
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL(urlToRead);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
				String line;
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return result.toString();
    }
}

