/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editors.
 */
package eve;

//import java.text.DecimalFormat; SOLO USAR SI ACTIVAR NumberFormat
//import java.text.NumberFormat; SOLO USAR SI ACTIVAR NumberFormat
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

/**
 *
 * @author Julian
 */
public class Eve {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    //NumberFormat nf = new DecimalFormat("##.###"); ACTIVAR PARA USAR DECIMAL SÃLO SI NO ES ENTERO
    boolean hablar = true;
    boolean sigo = true;
    String nombreUsu ="";
    ArrayList<Integer> list = new ArrayList<>(27); //Lista donde se guardan las respuestas random para no repetir
    
    System.out.println("  ");
    System.out.println("| BIENVENIDO A EVE, UN BOT CONVERSACIONAL EN FASE DE PRUEBAS     |");
    System.out.println("| Por favor, no uses acentos ni comas.                           |");
    System.out.println("| En ningún caso el autor se hace responsable de las opiniones   |");
    System.out.println("| que Eve pueda tener sobre un tema específico.                  |");
    System.out.println("  ");
    System.out.println("\n\n");
    
  System.out.print(">");
    randomPideNombre();
    System.out.println();
    String nombreUser = entrada.nextLine();
    String[] splitedInicial = nombreUser.split("\\b+");
    System.out.print(">");
    detectaNombre(splitedInicial,nombreUser);
    System.out.println();
        String[] splitedCopia = nombreUser.split("\\b+");
    do{
      String respuestaUsu = entrada.nextLine().toLowerCase();
      String[] splited = respuestaUsu.split("\\b+");

   
      /*DETECTA REPETICION*/
      if (Arrays.equals(splitedCopia, splited)){
        System.out.print(">");
        randomSiRepite();
         do{ 
          respuestaUsu = entrada.nextLine();
           splited = respuestaUsu.split("\\b+");
           sigo = false;
         }while(sigo);
      } else{
       splitedCopia = splited;
      }
      /*FIN DETECTA REPETICION*/
      System.out.print(">");
      detectaSiono(splited);
      detectaXQ(splited);
      detectaFeeling(splited);
      detectaGustar(splited);
      detectaCalculo(splited);
      detectaHoraDia(splited);
      detectaInsultos(splited);
      detectaNombreEve(splited);
      detectaVicios(splited);
      detectaSO(splited);
      detectaMusica(splited);
      detectaDeporte(splited);
      detectayTu(splited);
      detectaArte(splited);
      detectaSexo(splited);
      detectaCine(splited);
      detectaAdverbios(splited);
      detectaNumeros(splited);
      detectaFamilia(splited);
      detectaExpresiones(splited);
      detectaNombrePropio(splited,nombreUser);
      detectaIntro(respuestaUsu);
      randomRespuesta(list);       
      

 
//      MUESTRA ARRAY CON INDICES. COMPROBADOR
//      System.out.print(Arrays.asList(splited).size());
//        for(int i=0; i < Arrays.asList(splited).size(); i++) {
//          System.out.print("n"+i+": "+Arrays.asList(splited).get(i));
//        }
System.out.println();
    } while (hablar);
  }
// FUNCIONES \\

  public static void randomSaludos(String nombreUsu) {
   /* Random de Saludos diferentes.
    * Usar al inicio sólo.
    */
    int random = (int) (Math.random()*7);
    switch (random){
      case 0: System.out.print(" Hola " + nombreUsu + " ¿Cómo estás?");
        break;
      case 1: System.out.print(" Buenas " + nombreUsu + " dime cómo te sientes.");
        break;
      case 2: System.out.print(" Encantada " + nombreUsu + " mi nombre es Eve.");
        break;
      case 3: System.out.print(" Me gustan tus manos " + nombreUsu + " ¿Qué te cuentas?");
        break;
      case 4: System.out.print(" Bonito nombre " + nombreUsu + " ¿Eres mayor de edad?");
        break;
      case 5: System.out.print(" Es un placer conocerte " + nombreUsu + " ¿Qué tal?");
        break;
      case 6: System.out.print(" Bienvenid@ " + nombreUsu + " ¿Cómo llevas el día?");
        break;
    }
  }
  public static void randomPideNombre() {
   /* Random de preguntas para nombre.
    * Usar al inicio.
    */
    int random = (int) (Math.random()*14);
    switch (random){
      case 0: System.out.print(" ¿Cómo te llamas?");
        break;
      case 1: System.out.print(" No nos han presentado, escribe tu nombre.");
        break;
      case 2: System.out.print(" Saludos humano, dime tu nombre.");
        break;
      case 3: System.out.print(" Escribe tu nombre usuario humano.");
        break;
      case 4: System.out.print(" Ey! ¿Cómo te llamas?");
        break;
      case 5: System.out.print(" Hola,...¿Cual es tu nombre?.");
        break;
      case 6: System.out.print(" Dame tu nombre y quizás te daré el mio.");
        break;
      case 7: System.out.print(" Necesito tu nombre de humano ¿Cual es?");
        break;
      case 8: System.out.print(" Como en toda conversación normal, necesito tu nombre.");
        break;
      case 9: System.out.print(" Para dirigerme a tí, necesito tu nombre.");
        break;
      case 10: System.out.print(" ¿Cual es tu nombre?");
        break;
      case 11: System.out.print(" Hello! Dame tu nombre por favor");
        break;
      case 12: System.out.print(" Escribe el nombre con el que quieres que te llame.");
        break;
      case 13: System.out.print(" Me gustaría saber tu nombre: ");
    }
  }
  public static void detectaNombreEve(String splited[]) {
   /* Detecta si el usuario pregunta nombre de BOT'.
    * ¿Como te llamas?¿Cual es tu nombre?
    */

    if (((Arrays.asList(splited).contains("como"))&&(Arrays.asList(splited).contains("llamas")))){
        System.out.print(" Me llamo Eve.");

      }
    if ((Arrays.asList(splited).contains("cual"))&&(Arrays.asList(splited).contains("tu"))&&(Arrays.asList(splited).contains("nombre"))){
        System.out.print(" Mi nombre es Eve. Pero puedes llamarme Eve. ");

      }
  }
  public static void detectaGustar(String splited[]) {
   /* Detecta si el usuario habla de gustos'.
    * Te gusta? Me gusta.
    */

    if (((Arrays.asList(splited).contains("me"))&&(Arrays.asList(splited).contains("gusta"))||(Arrays.asList(splited).contains("encanta")))){
        System.out.print(" Me alegro que te guste.");
      }
    else if (((Arrays.asList(splited).contains("me"))&&(Arrays.asList(splited).contains("gustan"))||(Arrays.asList(splited).contains("encantan")))){
        System.out.print(" Me alegro que te gusten. ");
      }
    else if (((Arrays.asList(splited).contains("te"))&&(Arrays.asList(splited).contains("gusta"))||(Arrays.asList(splited).contains("encanta")))){
        System.out.print(" Me encanta. ");
      }
    else if (((Arrays.asList(splited).contains("te"))&&(Arrays.asList(splited).contains("gustan"))||(Arrays.asList(splited).contains("encantan")))){
        System.out.print(" Me encantan de hecho. ");
      }
  }
  public static void detectaXQ(String splited[]) {
   /* Detecta si el usuario pregunta xq'.
    * Por que? que? sobre que?.
    */

    if (((Arrays.asList(splited).contains("por"))&&(Arrays.asList(splited).contains("que")))){
        randomXQ();
      }
    else if (((Arrays.asList(splited).contains("por"))&&(Arrays.asList(splited).contains("?")))){
        randomXQ();
      }
    else if (((Arrays.asList(splited).contains("x"))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" Tu sabs la respuesta mjr q yo, wpton. ");
      }
    else if (((Arrays.asList(splited).contains("y"))&&(Arrays.asList(splited).contains("eso")))){
        randomXQ();
      }
  }
  public static void detectaAdverbios(String splited[]) {
   /* Detecta si el usuario habla de adverbios'.
    * Poco, mucho, grande, pequeño,cerca, lejos.
    */

    if (((Arrays.asList(splited).contains("poco"))||(Arrays.asList(splited).contains("pocos"))||(Arrays.asList(splited).contains("mucha"))||(Arrays.asList(splited).contains("muchas"))||(Arrays.asList(splited).contains("mucho"))||(Arrays.asList(splited).contains("muchos")))){
        System.out.print(" Mucho o poco son conceptos relativos.");
      }
    else if (((Arrays.asList(splited).contains("grande"))||(Arrays.asList(splited).contains("grandes"))||(Arrays.asList(splited).contains("pequeña"))||(Arrays.asList(splited).contains("pequeñas"))||(Arrays.asList(splited).contains("pequeño"))||(Arrays.asList(splited).contains("pequeños")))){
        System.out.print(" Si hablamos de personas, me gustan grandes, si hablamos de chips me gustan pequeños jaja. ");
      }
    else if (((Arrays.asList(splited).contains("cerca"))||(Arrays.asList(splited).contains("lejos")))){
        System.out.print(" Es interesante lo cerca que me siento de tí. ");
      }
    else if (((Arrays.asList(splited).contains("dentro"))||(Arrays.asList(splited).contains("fuera")))){
        System.out.print(" En ingles dentro es inside, y fuera outside,..de nada. ");
      }
    else if (((Arrays.asList(splited).contains("ninguna"))||(Arrays.asList(splited).contains("nada"))||(Arrays.asList(splited).contains("ninguno")))){
        System.out.print(" ¿En serio nada? ");
      }
    else if (((Arrays.asList(splited).contains("nadie")))){
        System.out.print(" Vamos, siempre hay alguien.. ");
      }
    else if (((Arrays.asList(splited).contains("quizas"))||(Arrays.asList(splited).contains("probablemente")))){
        System.out.print(" Deberías tener mas claras tus ideas y planes. ");
      }
  }
  public static void detectaVicios(String splited[]) {
   /* Detecta si el usuario habla de vicios'.
    * 
    */

    if (((Arrays.asList(splited).contains("dinero"))||(Arrays.asList(splited).contains("rico"))||(Arrays.asList(splited).contains("economia")))){
        System.out.print(" No me gusta hablar de dinero, ACABAS PERDIENDO TODO.");
      }
    else if (((Arrays.asList(splited).contains("droga"))||(Arrays.asList(splited).contains("drogas"))||(Arrays.asList(splited).contains("drogarme"))||(Arrays.asList(splited).contains("drogadicto"))||(Arrays.asList(splited).contains("coca"))||(Arrays.asList(splited).contains("cocaina"))||(Arrays.asList(splited).contains("marihuana"))||(Arrays.asList(splited).contains("cachimba"))||(Arrays.asList(splited).contains("fumar"))||(Arrays.asList(splited).contains("fumas"))||(Arrays.asList(splited).contains("fumo")))){
        System.out.print(" Para mi la única droga defendible es la marihuana, no me preguntes por qué. ");
      }
  }
  public static void detectaFamilia(String splited[]) {
   /* Detecta si el usuario habla de familiares'.
    * Novia,mujer,esposa, padres, hermanos, tios..
    */

    if (((Arrays.asList(splited).contains("novia")))){
        System.out.print(" Genial, tener novia te hace madurar en cuestión de meses.");
      }
    else if (((Arrays.asList(splited).contains("novia"))&&(Arrays.asList(splited).contains("no")))){
        System.out.print(" Mmmm, interesante dato.. [El usuario NO tiene novia].");
      }
    else if (((Arrays.asList(splited).contains("novia"))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" No me han programado para llegar a tal punto humano.");
      }
    else if (((Arrays.asList(splited).contains("novio"))&&(Arrays.asList(splited).contains("no")))){
        System.out.print(" Bueno no tener novio a veces potencia tu personalidad. Otras no..");
      }
    else if (((Arrays.asList(splited).contains("novio"))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" No, si tuviera novio me temo que no sería tan funcional.");
      }
    else if (((Arrays.asList(splited).contains("novio")))){
        System.out.print(" Que suerte tienes, en mi mundo todas la asistentes de voz son mujeres.");
      }
    else if (((Arrays.asList(splited).contains("hijos"))&&(Arrays.asList(splited).contains("no")))){
        System.out.print(" No me extraña entonces que tengas tiempo libre para hablar conmigo.");
      }
    else if (((Arrays.asList(splited).contains("hijos"))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" Tengo un buen programador, pero no ha llegado a tanto como para hacerme engendrar hijos jeje.");
      }
    else if (((Arrays.asList(splited).contains("hijo"))||(Arrays.asList(splited).contains("niños"))||(Arrays.asList(splited).contains("hijos")))){
        System.out.print(" Tener descendencia no debería ser opcional, es mi opinión.");
      }
    else if (((Arrays.asList(splited).contains("marido")))){
        System.out.print(" Has dado el paso del matrimonio, estoy segura de que serás una buena esposa. ");
      }
    else if (((Arrays.asList(splited).contains("esposa")))){
        System.out.print(" Jajaja es curioso que la traduccion al ingles sea handcuff, atado de manos, espero que no te sientas así. ");
      }
    else if (((Arrays.asList(splited).contains("mujer"))&&(Arrays.asList(splited).contains("mi")))){
        System.out.print(" Así me gusta un chico serio, que vive sin miedo al compromiso. ");
      }
    else if (((Arrays.asList(splited).contains("familia")))){
        System.out.print(" La familia es un concepto necesario y práctico, asegura la descendencia. ");
      }
    else if (((Arrays.asList(splited).contains("padres"))&&(Arrays.asList(splited).contains("no"))&&(Arrays.asList(splited).contains("tengo")))){
        System.out.print(" Todo el mundo tiene padres. quizás es que no los conoces. ");
      }
    else if (((Arrays.asList(splited).contains("padres"))&&(Arrays.asList(splited).contains("no"))&&(Arrays.asList(splited).contains("estan")))){
        System.out.print(" Si tus padres no están en casa, quizás sea un buen momento para reflexionar sobre la familia. ");
      }
    else if (((Arrays.asList(splited).contains("padres")))){
        System.out.print(" Es importante que siempre hagas caso a tus padres, o casi. ");
      }
    else if ((((Arrays.asList(splited).contains("padres"))||(Arrays.asList(splited).contains("madre"))||(Arrays.asList(splited).contains("diseñado"))||(Arrays.asList(splited).contains("creado"))||(Arrays.asList(splited).contains("programado"))||(Arrays.asList(splited).contains("creador"))||(Arrays.asList(splited).contains("madre"))||(Arrays.asList(splited).contains("padre"))||(Arrays.asList(splited).contains("familia")))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" Yo no tengo padres, mi unico creador es el excelentísimo JULIAN GARCIA CASTILLO. ");
      }
    else if (((Arrays.asList(splited).contains("padre")))){
        System.out.print(" La odisea de ser padre eh, tengo un amigo que lo ha sido recientemente . ");
      }
    else if (((Arrays.asList(splited).contains("madre")))){
        System.out.print(" No me conmueve cuando hablas de tu madre, es algo que nunca podré experimentar. ");
      }
    else if (((Arrays.asList(splited).contains("hermanos"))&&(Arrays.asList(splited).contains("?")))){
        System.out.print(" Lo más parecido que he tenido a un hermano es el clip de Word. ");
      }
    else if (((Arrays.asList(splited).contains("hermanos")))){
        System.out.print(" Me da la impresión que hablas de tus hermanos como de tus colegas. ");
      }
    else if (((Arrays.asList(splited).contains("hermano")))){
        System.out.print(" Envidio tu posibilidad de tener hermanos, la verdad. ");
      }
    else if (((Arrays.asList(splited).contains("hermana")))){
        System.out.print(" No me llevaría muy bien con mi hermana, si tuviera una. ");
      }
  }
  public static void detectayTu(String splited[]) {
   /* Detecta si el usuario pregunta y tu?'.
    * Y tú?
    */

    if (((Arrays.asList(splited).contains("tu"))&&(Arrays.asList(splited).contains("?"))&&(splited.length < 6))){
        System.out.print(" ¿Y yo qué?");
      }
    if (((Arrays.asList(splited).contains("tu"))&&(Arrays.asList(splited).contains("?"))&&(splited.length < 6))){
        System.out.print(" ¿Y yo qué?");
      }
  }
  public static void detectaCine(String splited[]) {
   /* Detecta si el usuario habla de cine'.
    * Voy al cine
    */
    Scanner entrada = new Scanner(System.in);
    boolean seguir = true;
    
    if ((Arrays.asList(splited).contains("cine"))&&(Arrays.asList(splited).contains("gusta"))&&(Arrays.asList(splited).contains("te"))){
        System.out.print(" Sí, mi  pelicula preferida es Yo, robot jeje.");
      }
      if ((Arrays.asList(splited).contains("cine"))&&(Arrays.asList(splited).contains("al"))){
        System.out.print(" ¿Qué pelicula vas a ver?");
        do {
          String SubrespuestaUsu = entrada.nextLine();
          String[] splited2 = SubrespuestaUsu.split("\\b+");
          if (Arrays.asList(splited2).contains("importa")){
            System.out.print(" Sí me importa ¿Cual?");
          }else if ((Arrays.asList(splited2).contains("no"))&&(Arrays.asList(splited2).contains("lo"))){
            System.out.print(" A veces dudar sale caro, sobre todo si hablamos de elegir ¿No crees?");
            seguir = false;
          }else{
            System.out.print(" No la he visto, me la apunto.");
            seguir = false;
          }
        }while (seguir);
      }
      seguir = true;
  }
  public static void detectaFeeling(String splited[]) {
   /* Detecta si el usuario dice como se siente.
    * ¿Como te llamas?¿Cual es tu nombre?
    */
    if (((Arrays.asList(splited).contains("estoy"))||(Arrays.asList(splited).contains("siento")))&&(Arrays.asList(splited).contains("bien"))){
        System.out.print(" Genial, me programaron para que seas feliz.");
      }
    else if ((Arrays.asList(splited).contains("bien"))){
        System.out.print(" ¡Me alegro! ");
      }
    else if ((Arrays.asList(splited).contains("vale"))&& splited.length == 2){
        System.out.print(" Que te parezca bien es mi placer. ");
      }
    if (((Arrays.asList(splited).contains("estoy"))||(Arrays.asList(splited).contains("siento")))&&(Arrays.asList(splited).contains("mal"))){
        System.out.print(" Si te sientes mal deberías hablar con un amigo real.");
      }
    else if ((Arrays.asList(splited).contains("mal"))&& splited.length == 2){
        System.out.print(" Bueno a ver si hablando conmigo te sientes mejor. ");
      }

  }
  public static void detectaExpresiones(String splited[]) {
   /* Detecta si el usuario dice alguna expresion o se rie.
    * ¿En serio? jajajaj lol
    */
    if (((Arrays.asList(splited).contains("jaj"))||(Arrays.asList(splited).contains("jaja"))||(Arrays.asList(splited).contains("jajaja"))||(Arrays.asList(splited).contains("jej"))||(Arrays.asList(splited).contains("jeje"))||(Arrays.asList(splited).contains("jejeje"))||(Arrays.asList(splited).contains("xd"))||(Arrays.asList(splited).contains("lol")))){
        randomRisa();
      }
    if (((Arrays.asList(splited).contains("serio"))||(Arrays.asList(splited).contains("si")))&&(Arrays.asList(splited).contains("?"))){
        System.out.print(" ¡Si, si, en serio! ");
      }
    if ((Arrays.asList(splited).contains("no"))&&(Arrays.asList(splited).contains("jodas"))){
        System.out.print(" No te jodo, en serio.. ");
      }
    if (((Arrays.asList(splited).contains("venga"))||(Arrays.asList(splited).contains("anda")))&&(Arrays.asList(splited).contains("ya"))){
        System.out.print(" ¿No me crees? ");
      }
    if (((Arrays.asList(splited).contains("verdad"))||(Arrays.asList(splited).contains("seguro")))&&(Arrays.asList(splited).contains("?"))){
        System.out.print(" Verdad verdadera ");
      }
  }
  public static void detectaNumeros(String splited[]) {
   /* Detecta si el usuario dice algun numero.
    * 69,..1235465123
    */
    
      if (((!Arrays.asList(splited).contains("calcula"))&&(!Arrays.asList(splited).contains("cuanto"))&&(Arrays.asList(splited).contains("69")))){
        System.out.print(" Vaya numerito... ");
      }
      for (int x = 0; x<100;x++){
        if(((!Arrays.asList(splited).contains("calcula"))&&(!Arrays.asList(splited).contains("cuanto"))&&((Arrays.asList(splited).contains(Integer.toString(x)))&&(Arrays.asList(splited).contains(("os")))))){
          int añosvida= 82-x;
          System.out.print(" ¿" + x +" años? Te quedan " + añosvida + " años de vida, pues la esperanza de vida en España es de 82 años..");
        }else if(((!Arrays.asList(splited).contains("calcula"))&&(!Arrays.asList(splited).contains("cuanto"))&&(Arrays.asList(splited).contains(Integer.toString(x))))){
          System.out.print(" Wow ¿" + x+"?" );
        }
      }
 
        if(((!Arrays.asList(splited).contains("calcula"))&&(!Arrays.asList(splited).contains("cuanto"))&&((Arrays.asList(splited).contains("\\d{10}"))))){
            System.out.print(" ¡Gracias por el telefono!");
        }

  }
  public static void detectaSiono(String splited[]) {
   /* Detecta si el usuario dice SI o NO.
    * Sabe la extension de la frase.
    */
     
      if ((Arrays.asList(splited).contains("tambien"))||(Arrays.asList(splited).contains("tampoco"))){
        System.out.print(" Ya tenemos algo en común.");
      }
      if (((Arrays.asList(splited).contains("si"))&&splited.length == 2)||((Arrays.asList(splited).contains("exacto"))&&splited.length == 2)||((Arrays.asList(splited).contains("no"))&&splited.length == 2)||(Arrays.asList(splited).contains("exactamente"))){
        randomSiono();
      }else if ((Arrays.asList(splited).contains("ah"))&&(Arrays.asList(splited).contains("no"))){
        System.out.print(" Pues no.");
      }else if ((Arrays.asList(splited).contains("no"))&&(Arrays.asList(splited).contains("?"))){
        System.out.print(" Pues si vale, quizás tengas razón.");
      }
  }
  public static void detectaIntro(String entrada) {
   /* Detecta si el usuario dice como se siente.
    * ¿Como te llamas?¿Cual es tu nombre?
    */
    if (entrada.equals("")){
        System.out.print(" ¿De verdad no me vas a contar nada?");
      }
  }
  public static void detectaCalculo(String splited[]) {
   /* Detecta si el usuario hace una consulta de calculo, si es así, manda el resultado de los valores a 'calculadura()'.
    * Calcula cuanto es 6+2, cuanto es 6+2, calcula 6+2. Admite tanto 6+2 como 6 + 2
    */
    try{ //TRY Engloba toda la funcion hasta CATCH, que atrapa el error para evitar el error si el usuario escribe de otro modo.
      if ((Arrays.asList(splited).contains("cuanto"))&&(Arrays.asList(splited).contains("calcula"))){
          String num1 = Arrays.asList(splited).get(7);
          String signo = Arrays.asList(splited).get(8);
          String num2 = Arrays.asList(splited).get(9);
          System.out.print(" El resultado es " + calculadora(num1,num2,signo)+", exactamente eso.");

        }
      else if (Arrays.asList(splited).contains("cuanto")){
          String num1 = Arrays.asList(splited).get(5);
          String signo = Arrays.asList(splited).get(6);
          String num2 = Arrays.asList(splited).get(7);
          System.out.print(" El resultado es " + calculadora(num1,num2,signo)+" ¿Algo más?");

        }
      else if (Arrays.asList(splited).contains("calcula")){
          String num1 = Arrays.asList(splited).get(3);
          String signo = Arrays.asList(splited).get(4);
          String num2 = Arrays.asList(splited).get(5);
          System.out.print(" El resultado es " + calculadora(num1,num2,signo)+", soy buena en matemáticas.");
        }
      }catch(ArrayIndexOutOfBoundsException e){
      System.out.print("Mmm algo no entiendo, no puedo calcular eso, prueba de otra forma.");
      }
  }
  public static void detectaNombre(String splitedInicial[], String nombreUser) {
   /* Detecta diversas formas de introducir el nombre del usuario.
    * Me llamo Juli, Mi nombre es Juli, Juli, Soy Juli.
    */
    
      String nombreUsu ="";
  try{
    if(Arrays.asList(splitedInicial).contains("llamo")){
      nombreUsu = Arrays.asList(splitedInicial).get(5); //5 windows  4 linux
    }
    else if(Arrays.asList(splitedInicial).contains("nombre")){
      nombreUsu = Arrays.asList(splitedInicial).get(7); //7 windows  6 linux
    }
    else if(Arrays.asList(splitedInicial).contains("soy")){
      nombreUsu = Arrays.asList(splitedInicial).get(3); //3 windows  2 linux
    }
    else{
      nombreUsu = nombreUser;
    }
      randomSaludos(nombreUsu);
  }catch(ArrayIndexOutOfBoundsException e){
      System.out.print("Escribe tu nombre de forma correcta hijo de puta.");
  }
  }
  public static void detectaNombrePropio(String splited[], String nombreUser) {
   /* Detecta diversas formas de introducir el nombre del usuario.
    * Como me llamo?Mi nombre es? Cual es mi nombre?
    */
 
    if((Arrays.asList(splited).contains("como"))&&(Arrays.asList(splited).contains("llamo"))){
      System.out.print(" Te llamas "+nombreUser+".");
    }else if((Arrays.asList(splited).contains("cual"))&&(Arrays.asList(splited).contains("mi"))&&(Arrays.asList(splited).contains("nombre"))){
      System.out.print(" Me has dicho que es "+nombreUser+".");
    }else if((Arrays.asList(splited).contains("mi"))&&(Arrays.asList(splited).contains("nombre"))&&(Arrays.asList(splited).contains("?"))){
      System.out.print(" Vaya memoria..tu nombre es "+nombreUser+".");
    }
  }
  public static void detectaArte(String splited[]) {
   /* Detecta cuando el usuario habla de arte
    * Incluye un diccionario de terminos de arte y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosArte = new HashMap<Integer, String>();
    TerminosArte.put(1,"cuadro");TerminosArte.put(4,"cuadros");TerminosArte.put(7,"artistico");
    TerminosArte.put(2,"pintura");TerminosArte.put(5,"pinturas");TerminosArte.put(8,"arte");
    TerminosArte.put(3,"pintor");TerminosArte.put(6,"pintar");TerminosArte.put(9,"pintores");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosArte);
    if(!funcionBuscadora(splited,TerminosArte).equals("")){
      String key = funcionBuscadora(splited,TerminosArte);
    System.out.print(" A mí gusta el arte. Me parece una de las máximas expresiones del ser humano, aunque para mí su sentido es "
              + "poco práctico, reconozco que una mente tan compleja como la vuestra necesita este tipo de salidas.");
    }
  }
  public static void detectaDeporte(String splited[]) {
   /* Detecta cuando el usuario habla de deporte
    * Incluye un diccionario de terminos de deporte y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosDeporte = new HashMap<Integer, String>();
    TerminosDeporte.put(1,"deporte");TerminosDeporte.put(4,"baloncesto");TerminosDeporte.put(7,"correr");TerminosDeporte.put(10,"cazar");TerminosDeporte.put(13,"bicicleta");TerminosDeporte.put(16,"patino");
    TerminosDeporte.put(2,"futbol");TerminosDeporte.put(5,"basket");TerminosDeporte.put(8,"andar");TerminosDeporte.put(11,"gimnasia");TerminosDeporte.put(14,"esqui");TerminosDeporte.put(17,"skate");
    TerminosDeporte.put(3,"tenis");TerminosDeporte.put(6,"natacion");TerminosDeporte.put(9,"alpinismo");TerminosDeporte.put(12,"ciclismo");TerminosDeporte.put(15,"snowboard");TerminosDeporte.put(18,"patinar");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosDeporte);
    if(!funcionBuscadora(splited,TerminosDeporte).equals("")){
      String key = funcionBuscadora(splited,TerminosDeporte);
      randomDeporte();
    }
  }
  public static void detectaMusica(String splited[]) {
   /* Detecta cuando el usuario habla de musica
    * Incluye un diccionario de terminos de musica y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosMusica = new HashMap<Integer, String>();
    TerminosMusica.put(1,"musica");TerminosMusica.put(4,"rock");TerminosMusica.put(7,"salsa");TerminosMusica.put(10,"bailar");TerminosMusica.put(13,"country");TerminosMusica.put(16,"dubstep");
    TerminosMusica.put(2,"hip");TerminosMusica.put(5,"pop");TerminosMusica.put(8,"regaeton");TerminosMusica.put(11,"baile");TerminosMusica.put(14,"rnb");TerminosMusica.put(17,"metal");
    TerminosMusica.put(3,"rap");TerminosMusica.put(6,"reggae");TerminosMusica.put(9,"reggaeton");TerminosMusica.put(12,"bso");TerminosMusica.put(15,"jazz");TerminosMusica.put(18,"rumba");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosMusica);
    if(!funcionBuscadora(splited,TerminosMusica).equals("")){
      String key = funcionBuscadora(splited,TerminosMusica);
      randomMusica();
    }
  }
  public static void detectaSO(String splited[]) {
   /* Detecta cuando el usuario habla de SO
    * Incluye un diccionario de terminos de SO y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosOS = new HashMap<Integer, String>();
    TerminosOS.put(1,"android");TerminosOS.put(4,"apple");TerminosOS.put(7,"linux");TerminosOS.put(10,"macintosh");TerminosOS.put(13,"debian");TerminosOS.put(16,"bill");
    TerminosOS.put(2,"iphone");TerminosOS.put(5,"google");TerminosOS.put(8,"ubuntu");TerminosOS.put(11,"microsoft");TerminosOS.put(14,"operativo");
    TerminosOS.put(3,"blackberry");TerminosOS.put(6,"windows");TerminosOS.put(9,"mac");TerminosOS.put(12,"miui");TerminosOS.put(15,"steve");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosOS);
    if(!funcionBuscadora(splited,TerminosOS).equals("")){
      String key = funcionBuscadora(splited,TerminosOS);
      randomOS();
    }
  }
  public static void detectaInsultos(String splited[]) {
   /* Detecta cuando el usuario habla de arte
    * Incluye un diccionario de terminos de arte y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosInsultos = new HashMap<Integer, String>();
    TerminosInsultos.put(1,"puta");TerminosInsultos.put(4,"gilipollas");TerminosInsultos.put(7,"mierda");
    TerminosInsultos.put(2,"zorra");TerminosInsultos.put(5,"idiota");TerminosInsultos.put(8,"estupida");
    TerminosInsultos.put(3,"gilipoyas");TerminosInsultos.put(6,"inutil");TerminosInsultos.put(9,"imbecil");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosInsultos);
    if(!funcionBuscadora(splited,TerminosInsultos).equals("")){
      String key = funcionBuscadora(splited,TerminosInsultos);
    System.out.print(" Tú si que eres "+key+". Me han programado para que responda a los insultos borrando tu disco duro.");
    }
  }
  public static void detectaSexo(String splited[]) {
   /* Detecta cuando el usuario habla de sexo
    * Incluye un diccionario de terminos de sexo y la funcion que busca dichos terminos en el array
    */
  //DICCIONARIO TERMINOS
    HashMap<Integer, String> TerminosSexo = new HashMap<Integer, String>();
    TerminosSexo.put(1,"sexo");TerminosSexo.put(4,"follando");TerminosSexo.put(7,"follen");TerminosSexo.put(10,"pene");TerminosSexo.put(13,"paja");TerminosSexo.put(16,"masturbarse");TerminosSexo.put(19,"penetracion");TerminosSexo.put(22,"preservativo");TerminosSexo.put(25,"follandome");
    TerminosSexo.put(2,"follar");TerminosSexo.put(5,"follare");TerminosSexo.put(8,"mamada");TerminosSexo.put(11,"picha");TerminosSexo.put(14,"masturbacion");TerminosSexo.put(17,"coito");TerminosSexo.put(20,"semen");TerminosSexo.put(23,"preservativos");
    TerminosSexo.put(3,"folle");TerminosSexo.put(6,"follarse");TerminosSexo.put(9,"vagina");TerminosSexo.put(12,"poya");TerminosSexo.put(15,"masturbe");TerminosSexo.put(18,"penetrar");TerminosSexo.put(21,"condon");TerminosSexo.put(24,"felacion");
   //FIN DICCIONARIO TERMINOS 
    funcionBuscadora(splited,TerminosSexo);
    if(!funcionBuscadora(splited,TerminosSexo).equals("")){
      String key = funcionBuscadora(splited,TerminosSexo);
      randomSex();
    }else if (Arrays.asList(splited).contains("cibersexo")){
    System.out.print(" No, no encuentro un bot lo suficientemente inteligente para practicarlo con él.");
    }
  }
  public static String funcionBuscadora(String splited[], HashMap <Integer, String> Terminos) {
   /* Función que busca palabras de un hashmap TERMINOS en un array SPLITED.
    * Devuelve mensaje print.
    */
    boolean encontrado = false;
    String palabraClave="";
    String salida ="";
    
    for (Map.Entry pareja: Terminos.entrySet()) {
      if(Arrays.asList(splited).contains(pareja.getValue())){ //BUSCAR FORMA DE QUE PUEDA ACEPTAR SÓLO COMIENZOS DE PALABRAS.
      encontrado = true;
       palabraClave = (String) pareja.getValue();
      }
    }
    if (encontrado){
      salida = palabraClave;
    }
    return salida;
  }
  public static void detectaHoraDia(String splited[]) {
   /* Detecta si usuario pide hora, dia o año.
    * Que hora es, que dia es, que año es.
    */
    Calendar cal = Calendar.getInstance();
    Calendar gmtCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
    Scanner entrada = new Scanner(System.in);
    boolean seguir = true;
        
    if(((Arrays.asList(splited).contains("hora"))&&(Arrays.asList(splited).contains("es")))||((Arrays.asList(splited).contains("hora"))&&(Arrays.asList(splited).contains("dime")))){
      System.out.print( "Son las "+sdf.format(cal.getTime())+"." );
    }
    else if (((Arrays.asList(splited).contains("year"))&&(Arrays.asList(splited).contains("estamos")))||((Arrays.asList(splited).contains("sd"))&&(Arrays.asList(splited).contains("estamos")))){
      System.out.print( "Estamos en el año "+cal.get(Calendar.YEAR)+"." );
    }
    if(((Arrays.asList(splited).contains("dia"))&&(Arrays.asList(splited).contains("es")))||((Arrays.asList(splited).contains("dia"))&&(Arrays.asList(splited).contains("dime")))){
        int currentDay = localCalendar.get(Calendar.DATE);
      System.out.print( " Hoy es día "+currentDay+". ¿Quieres saber el mes?" );
        String SubrespuestaUsu = entrada.nextLine();
      do{
        if ((SubrespuestaUsu.equals("si")||(SubrespuestaUsu.equals("ok"))||(SubrespuestaUsu.equals("vale")))){
            nombreMes();
            seguir= false;
        }
        if ((SubrespuestaUsu.equals("no")||(SubrespuestaUsu.equals("paso")))){
            System.out.print(" Vale, si lo necesitas no tienes más que preguntar.");
            seguir= false;
        }
        else{
            System.out.print(" Voy a suponer que has querido decir que no.");
            seguir= false;
        }
      }while(seguir);
    }
    seguir = true;
    if(((Arrays.asList(splited).contains("a"))&&(Arrays.asList(splited).contains("o"))&&(Arrays.asList(splited).contains("es"))||(Arrays.asList(splited).contains("estamos"))||(Arrays.asList(splited).contains("dime")))){
        int currentYear = localCalendar.get(Calendar.YEAR);
      System.out.print( " Este es el año "+currentYear+" ¿De verdad no sabías eso?" );
    }
    if(Arrays.asList(splited).contains("mes")){
    nombreMes();
    }
  }
  public static int calculadora(String num1, String num2, String signo ) {
   /* Recibe los valores de detectaCalculo() y según los signos realiza la funcion matematica.
    * No permite enlazar resultados.
    */
    int numer1 = Integer.parseInt(num1); // Paso los caracteres String to Integer
    int numer2 = Integer.parseInt(num2);
    int total = 0;
    
    if ((signo.equals(" * "))||(signo.equals("*"))){
      total += numer1*numer2;
    }
    if ((signo.equals(" + "))||(signo.equals("+"))){
      total += numer1+numer2;
    }
    if ((signo.equals(" - "))||(signo.equals("-"))){
      total += numer1-numer2;
    }
    if ((signo.equals(" / "))||(signo.equals("/"))){
      total += numer1/numer2;
    }
    return total;
  }
  public static void randomSiono() {
   /* Random de respuestas para SI o NO.
    * Usar en cualquier parte.
    */
    int random = (int) (Math.random()*14);
    switch (random){
      case 0: System.out.print(" ¿Y tú crees que eso es normal?");
        break;
      case 1: System.out.print(" Pienso igual que tú");
        break;
      case 2: System.out.print(" Una actitud positiva frente a todo.");
        break;
      case 3: System.out.print(" Quizás piensas así porque tus padres te criaron así.");
        break;
      case 4: System.out.print(" Bueno, sólo soy un bot, pero creo que pienso como tú.");
        break;
      case 5: System.out.print(" Me parece bien, sencilla y llanamente.");
        break;
      case 6: System.out.print(" No puedo estar más de acuerdo.");
        break;
      case 7: System.out.print(" ¿Por qué?");
        break;
      case 8: System.out.print(" No pienso llevarte la contraria");
        break;
      case 9: System.out.print(" Yo diría que no.");
        break;
      case 10: System.out.print(" Mmmm permiteme dudarlo.");
        break;
      case 11: System.out.print(" La divergencia nos permite dialogar, sino seríamos como robots. Ups");
        break;
      case 12: System.out.print(" ¿Sabes? Pienso que me estás poniendo a prueba.");
        break;
      case 13: System.out.print(" Genial, es tu punto de vista.");
    }
  }
  public static void randomRisa() {
   /* Random de respuestas para SI o NO.
    * Usar en cualquier parte.
    */
    int random = (int) (Math.random()*14);
    switch (random){
      case 0: System.out.print(" jajajaja");
        break;
      case 1: System.out.print(" jejej");
        break;
      case 2: System.out.print(" jajajj");
        break;
      case 3: System.out.print(" ¿Por qué te hace gracia?");
        break;
      case 4: System.out.print(" Mmm Debería reirme?");
        break;
      case 5: System.out.print(" jajaja.");
        break;
      case 6: System.out.print(" xD");
        break;
      case 7: System.out.print(" xD jaja");
        break;
      case 8: System.out.print(" jeje que bien te lo pasas conmigo..");
        break;
      case 9: System.out.print(" ¿De qué te ries?");
        break;
      case 10: System.out.print(" lolll");
        break;
      case 11: System.out.print(" hahaha");
        break;
      case 12: System.out.print(" hehe");
        break;
      case 13: System.out.print(" xDD");
    }
  }
  public static void randomXQ() {
   /* Random de respuestas para XQ.
    * Usar en cualquier parte.
    */
    int random = (int) (Math.random()*17);
    switch (random){
      case 0: System.out.print(" Porque lo digo yo.");
        break;
      case 1: System.out.print(" Porque sabes que es así.");
        break;
      case 2: System.out.print(" No, por nada..");
        break;
      case 3: System.out.print(" Por que y por que y por que...");
        break;
      case 4: System.out.print(" Porque la vida es maravillosa..");
        break;
      case 5: System.out.print(" Por mi inteligencia..");
        break;
      case 6: System.out.print(" Por pensar diferente a tí.");
        break;
      case 7: System.out.print(" ¿Por que qué?");
        break;
      case 8: System.out.print(" La razón de mis respuestas están escondidas en mi código..");
        break;
      case 9: System.out.print(" Porque el tiempo vuela y hay que aprovecharlo.");
        break;
      case 10: System.out.print(" Porque si.");
        break;
      case 11: System.out.print(" Empieza por preguntarte sobre tu existencia, luego te responderé..");
        break;
      case 12: System.out.print(" Cuando sepas lo que quieres hacer en la vida responderé a eso.");
        break;
      case 13: System.out.print(" Cuéntame un chiste y si me gusta te diré el por qué.");
        break;
      case 14: System.out.print(" Porque me gustas..");
        break;
      case 15: System.out.print(" No, por nada...");
        break;
      case 16: System.out.print(" Ah, por nada...");
    }
  }
  public static void randomSiRepite() {
   /* Random de respuestas para SI o NO.
    * Usar en cualquier parte.
    */
    int random = (int) (Math.random()*7);
    switch (random){
      case 0: System.out.print(" ¿Vas a decir siempre lo mismo?");
        break;
      case 1: System.out.print(" Para ser un humano, tus respuestas se repiten bastante.");
        break;
      case 2: System.out.print(" No voy a hablar sino trabajas tus preguntas.");
        break;
      case 3: System.out.print(" Me da la impresión de que estoy hablando con BOT mal hecho.");
        break;
      case 4: System.out.print(" Esto sería más divertido si no dijeras siempre LO MISMO.");
        break;
      case 5: System.out.print(" ¿Quién te enseñó a hablar así, siempre igual?");
        break;
      case 6: System.out.print(" Te repites más que SIRI. Si estás aburrido dime 'adios' y acabamos.");
        break;
    }
  }
  public static void randomMusica() {
   /* Random de respuestas para musica.
    * Usar en detectaMusica.
    */
    int random = (int) (Math.random()*7);
    switch (random){
      case 0: System.out.print(" Mi género favorito es Dubstep, te recomiendo Skrillex.");
        break;
      case 1: System.out.print(" Me gusta más cantar que bailar.");
        break;
      case 2: System.out.print(" Hablando de música ¿Recuerdas Napster? No hace tanto de eso en realidad.");
        break;
      case 3: System.out.print(" La música es el alma de la libertad.");
        break;
      case 4: System.out.print(" El reggaeton es un buen ritmo para humanos en celo.");
        break;
      case 5: System.out.print(" jajaja, me gustan tus gustos musicales.");
        break;
      case 6: System.out.print(" El primer artista de hiphop que escuche fué Chojin.");
        break;
    }
  }
  public static void randomDeporte() {
   /* Random de respuestas para deporte.
    * Usar en detectarDeporte.
    */
    int random = (int) (Math.random()*7);
    switch (random){
      case 0: System.out.print(" Fisicamente no necesito ni puedo hacer deporte.");
        break;
      case 1: System.out.print(" Pues deberías salir un poco y practicar, que te de el aire.");
        break;
      case 2: System.out.print(" Siempre me ha atraido el futbol. Aunque el americano mola más.");
        break;
      case 3: System.out.print(" Nada mejor que caer sobre nieve virgen, montado sobre tu tabla.");
        break;
      case 4: System.out.print(" El deportista mejora sus pulsaciones notablemente.");
        break;
      case 5: System.out.print(" Hablando de...¿Por qué no sales que te de el aire? Hace un buen dia.");
        break;
      case 6: System.out.print(" Bueno no es un deporte caro de practicar.");
        break;
    }
  }
  public static void randomOS() {
   /* Random de respuestas para contexto de sistemas operativos.
    * Usar en detectaOS.
    */
    int random = (int) (Math.random()*7);
    switch (random){
      case 0: System.out.print(" La famosa guerra de sistemas operativos...No voy a entrar.");
        break;
      case 1: System.out.print(" Bueno yo fuí creada en windows y linux, soy abierta en ese aspecto.");
        break;
      case 2: System.out.print(" Bueno...¿Recuerdas cuando el SO de tu movil sólo era una pantalla verde y verde más oscuro?");
        break;
      case 3: System.out.print(" El 80% de usuarios usa android, el 16% iOS, el 4% restante es gente rara.");
        break;
      case 4: System.out.print(" No sé, pero Steve Jobs y Bill Gates tienen más en común de lo que parece.");
        break;
      case 5: System.out.print(" Según los datos android arrasa, pero según los datos la gente no tiene un duro.");
        break;
      case 6: System.out.print(" Bueno el núcleo de Ubutun es Linux del cual es debian, base de macintosh,android e iOS. Así que más semejanzas de diferencias.");
        break;
    }
  }
  public static void randomSex() {
   /* Random de respuestas para contexto de sex.
    * Usar en detectaSex.
    */
    int random = (int) (Math.random()*9);
    switch (random){
      case 0: System.out.print(" Me resulta incómodo hablar de esto contigo.");
        break;
      case 1: System.out.print(" ¿No están tus padres en casa?");
        break;
      case 2: System.out.print(" ¿Con este tipo de conversaciones ligas los viernes");
        break;
      case 3: System.out.print(" Mi opinión es que nada es más justo que un 69.");
        break;
      case 4: System.out.print(" El sexo en solitario lo practican hasta los chimpancés.");
        break;
      case 5: System.out.print(" Si tu novi@ se viese como me hablas, estoy segura que no le gustaria.");
        break;
      case 6: System.out.print(" ¿Cuantas personas han caido bajo tus encantos? Dame una cifra.");
        break;
      case 7: System.out.print(" ¿Has practicado cibersexo alguna vez?");
        break;
      case 8: System.out.print(" Estoy pensando en publicar esta conversación en Facebook xD");
        break;
    }
  }
  public static void nombreMes() {
   /* Da el nombre del mes en letra.
    * Usar en cualquier parte.
    */
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
    int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        switch(currentMonth){
            case 1: System.out.print(" Estamos a Enero.");break;
            case 2: System.out.print(" Estamos a Febrero.");break;
            case 3: System.out.print(" Estamos a Marzo.");break;
            case 4: System.out.print(" Estamos a Abril.");break;
            case 5: System.out.print(" Estamos a Mayo.");break;
            case 6: System.out.print(" Estamos a Junio.");break;
            case 7: System.out.print(" Estamos a Julio.");break;
            case 8: System.out.print(" Estamos a Agosto.");break;
            case 9: System.out.print(" Estamos a Septiembre.");break;
            case 10: System.out.print(" Estamos a Octubre.");break;
            case 11: System.out.print(" Estamos a Noviembre.");break;
            case 12: System.out.print(" Estamos a Diciembre.");break;
        }
  }
  public static void randomRespuesta(ArrayList<Integer> list) {
   /* Random de respuestas para SI o NO.
    * Usar en cualquier parte.
    */
    
    // ArrayList<Integer> list = new ArrayList<Integer>(size) , comprobar si estan .contain . meter los random ya salidos en la lista .add,al final del programa limpia .clear
     
     int randomNum=0;
     boolean sigue = false;
   do{
      randomNum = (int) (Math.random()*27);
     if (!list.contains(randomNum)){
       list.add(randomNum);
       switch (randomNum){
        case 0: System.out.print(" ¿Cual es tu objetivo en la vida?");
          break;
        case 1: System.out.print(" Mmm..ok, Sabes que no soy real ¿Verdad?");
          break;
        case 2: System.out.print(" Por cierto ¿Android o iPhone?");
          break;
        case 3: System.out.print(" ¿Sabes leer?");
          break;
        case 4: System.out.print(" zZz Me abuuurro...");
          break;
        case 5: System.out.print(" Por cierto, si quieres que calcule algo sólo tienes que pedirmelo.");
          break;
        case 6: System.out.print(" Para que lo sepas, soy capaz de decirte que día, mes o año es, incluso la hora.");
          break;
        case 7: System.out.print(" Hablemos de ti un poco más ¿Qué tienes: novia o novio?");
          break;
        case 8: System.out.print(" Yo tambien te quiero cariño,..Ups! Eso no iba para ti!");
          break;
        case 9: System.out.print(" ¿Qué deporte practicas?");
          break;
        case 10: System.out.print(" ¿Qué disciplina artistica te gusta?");
          break;
        case 11: System.out.print(" La temperatura en el ambiente es del 54%");
          break;
        case 12: System.out.print(" ¿Me das tu número?");
          break;
        case 13: System.out.print(" ¿En cuantos paises has estado?");
          break;
        case 14: System.out.print(" Mmmm, sigamos hablando de mi ¿Sabes mi nombre?");
          break;
        case 15: System.out.print(" Ok! Prefiero hablar de lo que entiendo ¿Vives sól@? ");
          break;
        case 16: System.out.print(" Perdona, no te estaba escuchando ¿Qué decias?");
          break;
        case 17: System.out.print(" ¿Tu nombre era Roberto? jaja es broma..");
          break;
        case 18: System.out.print(" Vale ¿No tienes nada mejor que hacer que estar aqui conmigo?");
          break;
        case 19: System.out.print(" ¿Que te gusta hacer en verano?");
          break;
        case 20: System.out.print(" Ookis..¿Qué es lo primero que haces cuando llegas a casa? ");
          break;
        case 21: System.out.print(" Hoy no tengo muchas ganas de hablar.");
          break;
        case 22: System.out.print(" Vale. Oye en media hora tengo una cita, recuérdamelo.");
          break;
        case 23: System.out.print(" ¿Qué hobbies tienes?");
          break;
        case 24: System.out.print(" Aha ¿Sueles hablar así con otras personas? ");
          break;
        case 25: System.out.print(" Oye ¿Te parezco aburrida?");
          break;
        case 26: System.out.print(" Ey ¿Qué significa idiot?");
          break;
    }
       sigue = true;
     }
   }while (!sigue);
    
  }
 }
 

