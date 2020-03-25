

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cv_Gen {

  public static void main(String[] args) {

    if (args.length != 2) {
      System.out.println("USO: Introducir dos parametros, [TXT] [HTML]");
      System.out.println("Ejempo: java Cv_Gen cv curriculum");
      System.exit(-1);
    }

    String archivo = "";

    try {

      BufferedReader br = new BufferedReader(new FileReader(args[0] + ".txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter(args[1] + ".html"));

      String line = "";
      while ((line = br.readLine()) != null) {
        archivo += line + "\n";
      }

      bw.write("<!DOCTYPE html>\n"
        + "<html>\n"
        + "<head>\n"
        + "<title>Curriculum Vitae</title>\n"
        + "\n"
        + "<meta name=\"viewport\" content=\"width=device-width\"/>\n"
        + "<meta name=\"description\" content=\"The Curriculum Vitae\"/>\n"
        + "<meta charset=\"UTF-8\"> \n"
        + "\n"
        + "<link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\">\n"
        + "<link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet' type='text/css'>\n"
        + "\n"
        + "\n"
        + "</head>\n"
        + "<body id=\"top\">\n"
        + "<div id=\"cv\" class=\"instaFade\">\n"
        + "	<div class=\"mainDetails\">\n"
        + "		<div id=\"headshot\" class=\"quickFade\">\n"
        + "			<img src=\"img/img.jpg\" alt=\"foto-perfil\" />\n"
        + "		</div>\n"
        + "		\n"
        + "		<div id=\"name\">\n");
      String nombre = archivo.substring(archivo.indexOf(">>>nombre") + 9, archivo.indexOf(">>>edad")).trim();
      bw.write("<h1 class=\"quickFade delayTwo\">" + nombre + "</h1>\n"
        + "		</div>\n"
        + "		\n"
        + "		<div id=\"contactDetails\" class=\"quickFade delayFour\">\n"
        + "			<ul>\n");
      String edad = archivo.substring(archivo.indexOf(">>>edad") + 7, archivo.indexOf(">>>telefono")).trim();
      String telefono = archivo.substring(archivo.indexOf(">>>telefono") + 11, archivo.indexOf(">>>correo")).trim();
      String correo = archivo.substring(archivo.indexOf(">>>correo") + 9, archivo.indexOf(">>>formacion")).trim();
      bw.write("		<li><b>Edad: </b>" + edad + "</li>\n"
        + "				<li><b>Tlf: </b>" + telefono + "</li>\n"
        + "				<li><b>Email: </b>" + correo + "</li>\n"
        + "			</ul>\n"
        + "		</div>\n"
        + "		<div class=\"clear\"></div>\n"
        + "	</div>\n"
        + "	\n"
        + "	<div id=\"mainArea\" class=\"quickFade delayFive\">\n"
        + "		<section>\n"
        + "			<article>\n"
        + "				<div class=\"sectionTitle\">\n"
        + "					<h1>Perfil Personal</h1>\n"
        + "				</div>\n"
        + "				\n"
        + "				<div class=\"sectionContent\">\n");

      String[] perfil = archivo.substring(archivo.indexOf(">>>perfil") + 9).trim().split("\n");
      for (String per : perfil) {
        bw.write("<p>" + per + "</p>\n");
      }
      bw.write("			</div>\n"
        + "			</article>\n"
        + "			<div class=\"clear\"></div>\n"
        + "		</section>\n"
        + "		\n"
        + "		\n"
        + "		<section>\n"
        + "			<div class=\"sectionTitle\">\n"
        + "				<h1>Experiencia laboral</h1>\n"
        + "			</div>\n"
        + "			\n"
        + "			<div class=\"sectionContent\">\n"
        + "				<article>\n");

      String[] experiencia = archivo.substring(archivo.indexOf(">>>experiencia") + 14, archivo.indexOf(">>>habilidades")).trim().split("\n");
      for (String expe : experiencia) {
        bw.write("<p>" + expe + "</p>\n");
      }
      bw.write("		</article>\n"
        + "			</div>\n"
        + "			<div class=\"clear\"></div>\n"
        + "		</section>\n"
        + "		\n"
        + "		\n"
        + "		<section>\n"
        + "			<div class=\"sectionTitle\">\n"
        + "				<h1>Habilidades</h1>\n"
        + "			</div>\n"
        + "			\n"
        + "			<div class=\"sectionContent\">\n"
        + "				<ul class=\"Habilidades\">\n");
      String[] habilidades = archivo.substring(archivo.indexOf(">>>habilidades") + 14, archivo.indexOf(">>>perfil")).trim().split("\n");
      for (String hab : habilidades) {
        bw.write("<li>" + hab + "</li>\n");
      }
      bw.write("		</ul></br>\n"
        + "			</div>\n"
        + "			<div class=\"clear\"></div>\n"
        + "		</section>\n"
        + "		\n"
        + "		\n"
        + "		<section>\n"
        + "			<div class=\"sectionTitle\">\n"
        + "				<h1>Formación</h1>\n"
        + "			</div>\n"
        + "			\n"
        + "			<div class=\"sectionContent\">\n"
        + "				<article>\n");

      String[] formacion = archivo.substring(archivo.indexOf(">>>formacion") + 12, archivo.indexOf(">>>experiencia")).trim().split("\n");
      for (String forma : formacion) {
        bw.write("<p>" + forma + "</p>");
      }
      bw.write("		</article>\n"
        + "				\n"
        + "			</div>\n"
        + "			<div class=\"clear\"></div>\n"
        + "		</section>\n"
        + "		\n"
        + "	</div>\n"
        + "</div>\n"
        + "<script type=\"text/javascript\">\n"
        + "var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");\n"
        + "document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));\n"
        + "</script>\n"
        + "<script type=\"text/javascript\">\n"
        + "var pageTracker = _gat._getTracker(\"UA-3753241-1\");\n"
        + "pageTracker._initData();\n"
        + "pageTracker._trackPageview();\n"
        + "</script>\n"
        + "</body>\n"
        + "</html>");

      br.close();
      bw.close();
    } catch (FileNotFoundException fnfe) {

      System.out.println("Archivo no encontrado");
    } catch (IOException ioe) {

      System.out.println("No se ha podido leer el archivo");
    }
  }
}
