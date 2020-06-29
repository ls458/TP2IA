package chatbot;

import java.util.ArrayList;
import java.util.Random;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import sistemadeproduccion.GestorDeFrases;
import sistemadeproduccion.NoDuplication;
import sistemadeproduccion.Priority;
import sistemadeproduccion.RandomCriterio;
import sistemadeproduccion.Rule;
import sistemadeproduccion.Specificity;
import sistemadeproduccion.Tema;
import tp2ia.InterfaceUpdater;

public class ChatbotAgent extends Agent{
	
	
	public static ArrayList<Rule> listaReglas = cargarReglas();
	public static ArrayList<Tema> listaTemas;
	public static Rule reglaInicial;
	public String ultimaRespuestaAgente = "";
	
	private static ArrayList<Rule> cargarReglas() {
		
		ArrayList<Rule> reglasGenerales = new ArrayList<Rule>();
		ArrayList<Rule> reglasNoRiesgoNoInfectado = new ArrayList<Rule>();
		ArrayList<Rule> reglasNoRiesgoSiInfectado = new ArrayList<Rule>();
		ArrayList<Rule> reglasSiRiesgoNoInfectado = new ArrayList<Rule>();
		ArrayList<Rule> reglasSiRiesgoSiInfectado = new ArrayList<Rule>();
		
		listaTemas = new ArrayList<Tema>();
				
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		ArrayList<String> sinonimosT1 = new ArrayList<String>();
		sinonimosT1.add("hola");
		Tema t1 = new Tema("Saludo", sinonimosT1);
		
		listaTemas.add(t1);

		ArrayList<String> sinonimosT2 = new ArrayList<String>();
		sinonimosT2.add("chau");
		sinonimosT2.add("adios");
		sinonimosT2.add("saludos");
		sinonimosT2.add("nosvemos");
		sinonimosT2.add("hastaluego");
		sinonimosT2.add("hastapronto");
		Tema t2 = new Tema("Despedida", sinonimosT2);
		
		listaTemas.add(t2);
		
		ArrayList<String> sinonimosTsi = new ArrayList<String>();
		sinonimosTsi.add("si");
		sinonimosTsi.add("afirmativo");
		sinonimosTsi.add("correcto");
		sinonimosTsi.add("verdadero");
		Tema tsi = new Tema("afirmación", sinonimosTsi);
		
		listaTemas.add(tsi);
		
		ArrayList<String> sinonimosTno = new ArrayList<String>();
		sinonimosTno.add("no");
		sinonimosTno.add("negativo");
		sinonimosTno.add("incorrecto");
		sinonimosTno.add("falso");
		Tema tno = new Tema("negación", sinonimosTno);
		
		listaTemas.add(tno);
		
		ArrayList<String> sinonimosTsaber = new ArrayList<String>();
		sinonimosTsaber.add("se");
		Tema tsaber = new Tema("saber", sinonimosTsaber);
		
		listaTemas.add(tsaber);

		
		
		
		
		
		//ayuda -> ayuda ayuden ayudar
		ArrayList<String> sinonimosT3 = new ArrayList<String>();
		sinonimosT3.add("ayuda");
		sinonimosT3.add("ayuden");
		sinonimosT3.add("ayudar");
		Tema t3 = new Tema("ayuda", sinonimosT3);
		
		listaTemas.add(t3);
		
		//caso -> caso casos
		ArrayList<String> sinonimosT4 = new ArrayList<String>();
		sinonimosT4.add("caso");
		sinonimosT4.add("casos");
		Tema t4 = new Tema("caso", sinonimosT4);
		
		listaTemas.add(t4);
		
		//ciudad -> ciudad
		ArrayList<String> sinonimosT5 = new ArrayList<String>();
		sinonimosT5.add("ciudad");
		Tema t5 = new Tema("ciudad", sinonimosT5);
		
		listaTemas.add(t5);
		
		//contagio -> contagio contagia contagios contagiarse contagiado contagiarme contagiarnos
		ArrayList<String> sinonimosT6 = new ArrayList<String>();
		sinonimosT6.add("contagio");
		sinonimosT6.add("contagia");
		sinonimosT6.add("contagios");
		sinonimosT6.add("contagiarse");
		sinonimosT6.add("contagiado");
		sinonimosT6.add("contagiarme");
		sinonimosT6.add("contagiarnos");
		Tema t6 = new Tema("contagio", sinonimosT6);
		
		listaTemas.add(t6);
		
		//como -> como que
		ArrayList<String> sinonimosT7 = new ArrayList<String>();
		sinonimosT7.add("como");
		sinonimosT7.add("que");
		Tema t7 = new Tema("como", sinonimosT7);
		
		listaTemas.add(t7);
		
		//coronavirus -> coronavirus covid-19 covid19 covid enfermedad
		ArrayList<String> sinonimosT8 = new ArrayList<String>();
		sinonimosT8.add("coronavirus");
		sinonimosT8.add("covid-19");
		sinonimosT8.add("covid19");
		sinonimosT8.add("covid");
		sinonimosT8.add("enfermedad");
		Tema t8 = new Tema("coronavirus", sinonimosT8);
		
		listaTemas.add(t8);
		
		//cual -> cual cuales
		ArrayList<String> sinonimosT9 = new ArrayList<String>();
		sinonimosT9.add("cual");
		sinonimosT9.add("cuales");
		Tema t9 = new Tema("cual", sinonimosT9);
		
		listaTemas.add(t9);
		
		//cuanto -> cuanto cuantos
		ArrayList<String> sinonimosT10 = new ArrayList<String>();
		sinonimosT10.add("cuanto");
		sinonimosT10.add("cuantos");
		Tema t10 = new Tema("cuanto", sinonimosT10);
		
		listaTemas.add(t10);
		
		//donde -> donde lugar
		ArrayList<String> sinonimosT11 = new ArrayList<String>();
		sinonimosT11.add("donde");
		sinonimosT11.add("lugar");
		Tema t11 = new Tema("donde", sinonimosT11);
		
		listaTemas.add(t11);
		
		//infeccion -> infeccion infectado infectados
		ArrayList<String> sinonimosT12 = new ArrayList<String>();
		sinonimosT12.add("infeccion");
		sinonimosT12.add("infectado");
		sinonimosT12.add("infectados");
		Tema t12 = new Tema("infeccion", sinonimosT12);
		
		listaTemas.add(t12);
		
		//mayor -> mayor mas
		ArrayList<String> sinonimosT13 = new ArrayList<String>();
		sinonimosT13.add("mayor");
		sinonimosT13.add("mas");
		Tema t13 = new Tema("mayor", sinonimosT13);
		
		listaTemas.add(t13);
		
		//mundo -> mundo planeta
		ArrayList<String> sinonimosT14 = new ArrayList<String>();
		sinonimosT14.add("mundo");
		sinonimosT14.add("planeta");
		Tema t14 = new Tema("mundo", sinonimosT14);
		
		listaTemas.add(t14);
		
//		//no -> no
//		ArrayList<String> sinonimosT15 = new ArrayList<String>();
//		sinonimosT15.add("no");
//		Tema t15 = new Tema("no", sinonimosT15);
//		
//		listaTemas.add(t15);
		
		//numero -> numero cantidad
		ArrayList<String> sinonimosT16 = new ArrayList<String>();
		sinonimosT16.add("numero");
		sinonimosT16.add("cantidad");
		Tema t16 = new Tema("numero", sinonimosT16);
		
		listaTemas.add(t16);
		
		//pais -> pais argentina nacion
		ArrayList<String> sinonimosT17 = new ArrayList<String>();
		sinonimosT17.add("pais");
		sinonimosT17.add("argentina");
		sinonimosT17.add("nacion");
		Tema t17 = new Tema("pais", sinonimosT17);
		
		listaTemas.add(t17);
		
		//provincia -> provincia
		ArrayList<String> sinonimosT18 = new ArrayList<String>();
		sinonimosT18.add("provincia");
		Tema t18 = new Tema("provincia", sinonimosT18);
		
		listaTemas.add(t18);
		
		//recomendacion -> recomendacion recomendaciones cuidado cuidados
		ArrayList<String> sinonimosT19 = new ArrayList<String>();
		sinonimosT19.add("recomendacion");
		sinonimosT19.add("recomendaciones");
		sinonimosT19.add("cuidado");
		sinonimosT19.add("cuidados");
		Tema t19 = new Tema("recomendacion", sinonimosT19);
		
		listaTemas.add(t19);
		
		//riesgo -> riesgo riesgos riesgoso
		ArrayList<String> sinonimosT20 = new ArrayList<String>();
		sinonimosT20.add("riesgo");
		sinonimosT20.add("riesgos");
		sinonimosT20.add("riesgoso");
		sinonimosT20.add("riesgosos");
		sinonimosT20.add("riesgosa");
		sinonimosT20.add("riesgosas");
		Tema t20 = new Tema("riesgo", sinonimosT20);
		
		listaTemas.add(t20);
		
		//ser -> ser es son seria
		ArrayList<String> sinonimosT21 = new ArrayList<String>();
		sinonimosT21.add("ser");
		sinonimosT21.add("soy");
		sinonimosT21.add("es");
		sinonimosT21.add("son");
		sinonimosT21.add("seria");
		sinonimosT21.add("serian");
		Tema t21 = new Tema("ser", sinonimosT21);
		
		listaTemas.add(t21);
		
		//sintoma -> sintoma sintomas
		ArrayList<String> sinonimosT22 = new ArrayList<String>();
		sinonimosT22.add("sintoma");
		sinonimosT22.add("sintomas");
		Tema t22 = new Tema("sintoma", sinonimosT22);
		
		listaTemas.add(t22);
		
		//tasa -> tasa
		ArrayList<String> sinonimosT23 = new ArrayList<String>();
		sinonimosT23.add("tasa");
		Tema t23 = new Tema("tasa", sinonimosT23);
		
		listaTemas.add(t23);
		
		//tener -> tener tiene tienen tenemos
		ArrayList<String> sinonimosT24 = new ArrayList<String>();
		sinonimosT24.add("tener");
		sinonimosT24.add("tiene");
		sinonimosT24.add("tienen");
		sinonimosT24.add("tenemos");
		sinonimosT24.add("tengo");
		Tema t24 = new Tema("tener", sinonimosT24);
		
		listaTemas.add(t24);
		
		//zona -> zona lugar ubicacion
		ArrayList<String> sinonimosT25 = new ArrayList<String>();
		sinonimosT25.add("zona");
		sinonimosT25.add("zonas");
		sinonimosT25.add("lugar");
		sinonimosT25.add("lugares");
		sinonimosT25.add("ubicacion");
		sinonimosT25.add("ubicaciones");
		Tema t25 = new Tema("zona", sinonimosT25);
		
		listaTemas.add(t25);
		
		//tiempo -> tiempo
		ArrayList<String> sinonimosT26 = new ArrayList<String>();
		sinonimosT26.add("tiempo");
		Tema t26 = new Tema("tiempo", sinonimosT26);
		
		listaTemas.add(t26);
		
		//duracion -> duracion dura
		ArrayList<String> sinonimosT27 = new ArrayList<String>();
		sinonimosT27.add("duracion");
		sinonimosT27.add("dura");
		Tema t27 = new Tema("duracion", sinonimosT27);
		
		listaTemas.add(t27);
		
		//comercio -> comercio comerciante
		ArrayList<String> sinonimosT29 = new ArrayList<String>();
		sinonimosT29.add("comercio");
		sinonimosT29.add("comercios");
		sinonimosT29.add("comerciante");
		sinonimosT29.add("comerciantes");
		
		Tema t29 = new Tema("comercio", sinonimosT29);
		
		listaTemas.add(t29);
		
		//forma -> forma formas metodo metodos
		ArrayList<String> sinonimosT30 = new ArrayList<String>();
		sinonimosT30.add("forma");
		sinonimosT30.add("formas");
		sinonimosT30.add("metodo");
		sinonimosT30.add("metodos");
		
		Tema t30 = new Tema("comercio", sinonimosT30);
		
		listaTemas.add(t30);
		
		//personal -> personal empleado
		ArrayList<String> sinonimosT31 = new ArrayList<String>();
		sinonimosT31.add("personal");
		sinonimosT31.add("empleado");
				
		Tema t31 = new Tema("personal", sinonimosT31);
				
		listaTemas.add(t31);
		
		//salud -> salud
		ArrayList<String> sinonimosT32 = new ArrayList<String>();
		sinonimosT32.add("salud");
						
		Tema t32 = new Tema("salud", sinonimosT32);
						
		listaTemas.add(t32);
		
		//trabajo -> trabajo trabajador
		ArrayList<String> sinonimosT33 = new ArrayList<String>();
		sinonimosT33.add("trabajo");
		sinonimosT33.add("trabajador");
						
		Tema t33 = new Tema("trabajo", sinonimosT33);
						
		listaTemas.add(t33);
		
		//hospital -> hospital clinica
		ArrayList<String> sinonimosT34 = new ArrayList<String>();
		sinonimosT34.add("hospital");
		sinonimosT34.add("clinica");
								
		Tema t34 = new Tema("hospital", sinonimosT34);
								
		listaTemas.add(t34);
		
		//medico -> medico medica enfermero enfermera
		ArrayList<String> sinonimosT35 = new ArrayList<String>();
		sinonimosT35.add("medico");
		sinonimosT35.add("medicos");
		sinonimosT35.add("medica");
		sinonimosT35.add("medicas");
		sinonimosT35.add("enfermero");
		sinonimosT35.add("enfermeros");
		sinonimosT35.add("enfermera");
		sinonimosT35.add("enfermeras");
										
		Tema t35 = new Tema("medico", sinonimosT35);
										
		listaTemas.add(t35);
		
		//santafe -> santafe
		ArrayList<String> sinonimosT36 = new ArrayList<String>();
		sinonimosT36.add("santafe");
												
		Tema t36 = new Tema("santafe", sinonimosT36);
												
		listaTemas.add(t36);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//Regla terminación
////////////////////R
		ArrayList<Tema> temasRterminacion = new ArrayList<Tema>();
		Rule reglaterminacion = new Rule();
		reglaterminacion.setId(Integer.MAX_VALUE);
		reglaterminacion.setListaTemas(temasRterminacion);
		reglaterminacion.Respuesta = "Adiós! Me alegra haber podido aclarar tus dudas!<br>"
				+ "Me voy en 5...4...3...";
		reglasGenerales.add(reglaterminacion);
		temasRterminacion.add(t2);//chau
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//Reglas generales
////////////////////R		
		ArrayList<Tema> temasR1_1 = new ArrayList<Tema>();
		Rule regla1_1 = new Rule();
		regla1_1.setId(1_1);
		regla1_1.setListaTemas(temasR1_1);
		regla1_1.Respuesta = "El COVID-19 es la enfermedad infecciosa " + 
					"causada por el coronavirus que se ha " + 
					"descubierto recientemente.";
		reglasGenerales.add(regla1_1);
		temasR1_1.add(t7);//que
		temasR1_1.add(t21);//ser
		temasR1_1.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR1_2 = new ArrayList<Tema>();
		Rule regla1_2 = new Rule();
		regla1_2.setId(1_2);
		regla1_2.setListaTemas(temasR1_2);
		regla1_2.Respuesta = "El COVID-19 es una enfermedad " +
					"infecciosa causada por el virus SARS-CoV-2.";
		reglasGenerales.add(regla1_2);
		temasR1_2.add(t7);//que
		temasR1_2.add(t21);//ser
		temasR1_2.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR2_1 = new ArrayList<Tema>();
		Rule regla2_1 = new Rule();
		regla2_1.setId(2_1);
		regla2_1.setListaTemas(temasR2_1);
		regla2_1.Respuesta = "Lávese las manos con frecuencia. Use " + 
				"agua y jabón o un desinfectante de manos a " + 
				"base de alcohol.";
		reglasGenerales.add(regla2_1);
//		temasR2_1.add(t7);//que
		temasR2_1.add(t19);//recomendacion
		temasR2_1.add(tno);//no
		temasR2_1.add(t6);//contagio
		
////////////////////R
		ArrayList<Tema> temasR2_2 = new ArrayList<Tema>();
		Rule regla2_2 = new Rule();
		regla2_2.setId(2_2);
		regla2_2.setListaTemas(temasR2_2);
		regla2_2.Respuesta = "Manténgase a una distancia segura de cualquier "
				+ "persona que tosa o estornude. No se toque los ojos, la nariz o la boca.";
		reglasGenerales.add(regla2_2);
//		temasR2_2.add(t7);//que
		temasR2_2.add(t19);//recomendacion
		temasR2_2.add(tno);//no
		temasR2_2.add(t6);//contagio
		
////////////////////R
		ArrayList<Tema> temasR2_3 = new ArrayList<Tema>();
		Rule regla2_3 = new Rule();
		regla2_3.setId(2_3);
		regla2_3.setListaTemas(temasR2_3);
		regla2_3.Respuesta = "Cuando tosa o estornude, cúbrase la nariz y "
				+ "la boca con el codo flexionado o con un pañuelo.";
		reglasGenerales.add(regla2_3);
//		temasR2_3.add(t7);//que
		temasR2_3.add(t19);//recomendacion
		temasR2_3.add(tno);//no
		temasR2_3.add(t6);//contagio
		
////////////////////R
		ArrayList<Tema> temasR2_4 = new ArrayList<Tema>();
		Rule regla2_4 = new Rule();
		regla2_4.setId(2_4);
		regla2_4.setListaTemas(temasR2_4);
		regla2_4.Respuesta = "Quédese en casa. En caso de salir use barbijo.";
		reglasGenerales.add(regla2_4);
//		temasR2_4.add(t7);//que
		temasR2_4.add(t19);//recomendacion
		temasR2_4.add(tno);//no
		temasR2_4.add(t6);//contagio
		
////////////////////R (particular No riesgo Sí infectado)
		ArrayList<Tema> temasR2_5 = new ArrayList<Tema>();
		Rule regla2_5 = new Rule();
		regla2_5.setId(2_5);
		regla2_5.setListaTemas(temasR2_5);
		regla2_5.Respuesta = "Quédese en casa. Aunque no sea paciente de riesgo, si tiene el virus podría "
				+ "perjudicar a personas más vulnerables que usted.";
		regla2_5.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoSiInfectado.add(regla2_5);
//		temasR2_5.add(t7);//que
		temasR2_5.add(t19);//recomendacion
		temasR2_5.add(tno);//no
		temasR2_5.add(t6);//contagio
		
////////////////////R (particular Sí riesgo Sí infectado)
		ArrayList<Tema> temasR2_6 = new ArrayList<Tema>();
		Rule regla2_6 = new Rule();
		regla2_6.setId(2_6);
		regla2_6.setListaTemas(temasR2_6);
		regla2_6.Respuesta = "Trate de no salir de su casa. Pero le pedimos que si no se siente bien, no dude en pedir ayuda médica, "
				+ "su salud es muy importante para nosotros, y su caso tendrá prioridad en los centros de salud.";
		regla2_6.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoSiInfectado.add(regla2_6);
//		temasR2_6.add(t7);//que
		temasR2_6.add(t19);//recomendacion
		temasR2_6.add(tno);//no
		temasR2_6.add(t6);//contagio
		
////////////////////R (particular Sí riesgo No infectado)
		ArrayList<Tema> temasR2_7 = new ArrayList<Tema>();
		Rule regla2_7 = new Rule();
		regla2_7.setId(2_7);
		regla2_7.setListaTemas(temasR2_7);
		regla2_7.Respuesta = "Trate de no salir de su casa. Usted es paciente de riesgo, y su salud es "
				+ "lo primordial.";
		regla2_7.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoNoInfectado.add(regla2_7);
//		temasR2_7.add(t7);//que
		temasR2_7.add(t19);//recomendacion
		temasR2_7.add(tno);//no
		temasR2_7.add(t6);//contagio
		
////////////////////R (particular No riesgo No infectado)
		ArrayList<Tema> temasR2_8 = new ArrayList<Tema>();
		Rule regla2_8 = new Rule();
		regla2_8.setId(2_8);
		regla2_8.setListaTemas(temasR2_8);
		regla2_8.Respuesta = "Salga de su casa solo si es necesario. Intente colaborar con la gente que "
				+ "sí tiene riesgos con esta enfermedad por lo que no puede salir casi en lo absoluto "
				+ "de su casa.";
		regla2_8.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoNoInfectado.add(regla2_8);
//		temasR2_8.add(t7);//que
		temasR2_8.add(t19);//recomendacion
		temasR2_8.add(tno);//no
		temasR2_8.add(t6);//contagio
				
////////////////////R
		ArrayList<Tema> temasR3_1 = new ArrayList<Tema>();
		Rule regla3_1 = new Rule();
		regla3_1.setId(3_1);
		regla3_1.setListaTemas(temasR3_1);
		regla3_1.Respuesta = "Los síntomas más comunes de la enfermedad son el cansancio, "
				+ "tos seca y fiebre. Otros síntomas menos comunes pueden ser molestias y dolores "
				+ "en el cuerpo, dolor de garganta, diarrea, conjuntivitis, dolor de cabeza y "
				+ "pérdida del sentido del olfato o del gusto.";
		reglasGenerales.add(regla3_1);
		temasR3_1.add(t7);//que
		temasR3_1.add(t22);//sintoma
		temasR3_1.add(t24);//tener
//		temasR3_1.add(t8);//coronavirus
//		temasR3_1.add(t9);//cual
//		temasR3_1.add(t21);//ser
		
////////////////////R
		ArrayList<Tema> temasR3_2 = new ArrayList<Tema>();
		Rule regla3_2 = new Rule();
		regla3_2.setId(3_2);
		regla3_2.setListaTemas(temasR3_2);
		regla3_2.Respuesta = "Los síntomas más comunes de la enfermedad son el cansancio, "
			+ "tos seca y fiebre. Otros síntomas menos comunes pueden ser molestias y dolores "
			+ "en el cuerpo, dolor de garganta, diarrea, conjuntivitis, dolor de cabeza y "
			+ "pérdida del sentido del olfato o del gusto.";
		reglasGenerales.add(regla3_2);
		temasR3_2.add(t9);//cual
		temasR3_2.add(t21);//ser
		temasR3_2.add(t22);//sintoma
				
////////////////////R
		ArrayList<Tema> temasR3_3 = new ArrayList<Tema>();
		Rule regla3_3 = new Rule();
		regla3_3.setId(3_3);
		regla3_3.setListaTemas(temasR3_3);
		regla3_3.Respuesta = "Los síntomas son muy variados. Generalmente se caracteriza por "
				+ "fiebre muy alta y problemas o molestias al respirar.";
		reglasGenerales.add(regla3_3);
		temasR3_3.add(t7);//que
		temasR3_3.add(t22);//sintoma
		temasR3_3.add(t24);//tener
//		temasR3_3.add(t8);//coronavirus
//		temasR3_3.add(t9);//cual
//		temasR3_3.add(t21);//son
		
////////////////////R
		ArrayList<Tema> temasR3_4 = new ArrayList<Tema>();
		Rule regla3_4 = new Rule();
		regla3_4.setId(3_4);
		regla3_4.setListaTemas(temasR3_4);
		regla3_4.Respuesta = "Los síntomas son muy variados. Generalmente se caracteriza por "
			+ "fiebre muy alta y problemas o molestias al respirar.";
		reglasGenerales.add(regla3_4);
		temasR3_4.add(t9);//cual
		temasR3_4.add(t21);//ser
		temasR3_4.add(t22);//sintoma
		
////////////////////R
		ArrayList<Tema> temasR3_5 = new ArrayList<Tema>();
		Rule regla3_5 = new Rule();
		regla3_5.setId(3_5);
		regla3_5.setListaTemas(temasR3_5);
		regla3_5.Respuesta = "Los síntomas más comunes de la enfermedad son el cansancio, "
			+ "tos seca y fiebre. Otros síntomas menos comunes pueden ser molestias y dolores "
			+ "en el cuerpo, dolor de garganta, diarrea, conjuntivitis, dolor de cabeza y "
			+ "pérdida del sentido del olfato o del gusto.";
		reglasGenerales.add(regla3_5);
		temasR3_5.add(t7);//que
		temasR3_5.add(t22);//sintoma
		temasR3_5.add(t24);//tener
		temasR3_5.add(t8);//coronavirus

////////////////////R
		ArrayList<Tema> temasR3_6 = new ArrayList<Tema>();
		Rule regla3_6 = new Rule();
		regla3_6.setId(3_6);
		regla3_6.setListaTemas(temasR3_6);
		regla3_6.Respuesta = "Los síntomas más comunes de la enfermedad son el cansancio, "
		+ "tos seca y fiebre. Otros síntomas menos comunes pueden ser molestias y dolores "
		+ "en el cuerpo, dolor de garganta, diarrea, conjuntivitis, dolor de cabeza y "
		+ "pérdida del sentido del olfato o del gusto.";
		reglasGenerales.add(regla3_6);
		temasR3_6.add(t9);//cual
		temasR3_6.add(t21);//ser
		temasR3_6.add(t22);//sintoma
		temasR3_6.add(t8);//coronavirus
	
////////////////////R
		ArrayList<Tema> temasR3_7 = new ArrayList<Tema>();
		Rule regla3_7 = new Rule();
		regla3_7.setId(3_7);
		regla3_7.setListaTemas(temasR3_7);
		regla3_7.Respuesta = "Los síntomas son muy variados. Generalmente se caracteriza por "
			+ "fiebre muy alta y problemas o molestias al respirar.";
		reglasGenerales.add(regla3_7);
		temasR3_7.add(t7);//que
		temasR3_7.add(t22);//sintoma
		temasR3_7.add(t24);//tener
		temasR3_7.add(t8);//coronavirus

////////////////////R
		ArrayList<Tema> temasR3_8 = new ArrayList<Tema>();
		Rule regla3_8 = new Rule();
		regla3_8.setId(3_8);
		regla3_8.setListaTemas(temasR3_8);
		regla3_8.Respuesta = "Los síntomas son muy variados. Generalmente se caracteriza por "
		+ "fiebre muy alta y problemas o molestias al respirar.";
		reglasGenerales.add(regla3_8);
		temasR3_8.add(t9);//cual
		temasR3_8.add(t21);//ser
		temasR3_8.add(t22);//sintoma
		temasR3_8.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR4_1 = new ArrayList<Tema>();
		Rule regla4_1 = new Rule();
		regla4_1.setId(4_1);
		regla4_1.setListaTemas(temasR4_1);
		regla4_1.Respuesta = "Se transmite de una persona a otra a través de las gotas procedentes "
				+ "de la nariz o la boca que salen despedidas cuando la persona infectada tose, "
				+ "estornuda o habla, por contacto con manos, superficies u objetos contaminados.";
		reglasGenerales.add(regla4_1);
		temasR4_1.add(t7);//como
		temasR4_1.add(t6);//contagia
		temasR4_1.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR4_2 = new ArrayList<Tema>();
		Rule regla4_2 = new Rule();
		regla4_2.setId(4_2);
		regla4_2.setListaTemas(temasR4_2);
		regla4_2.Respuesta = "Se transmite de una persona a otra a través de las gotas procedentes "
			+ "de la nariz o la boca que salen despedidas cuando la persona infectada tose, "
			+ "estornuda o habla, por contacto con manos, superficies u objetos contaminados.";
		reglasGenerales.add(regla4_2);
		temasR4_2.add(t9);//cual (cuál es forma de contagio)
		temasR4_2.add(t30);//forma
		temasR4_2.add(t6);//contagia
		
////////////////////R
		ArrayList<Tema> temasR4_3 = new ArrayList<Tema>();
		Rule regla4_3 = new Rule();
		regla4_3.setId(4_3);
		regla4_3.setListaTemas(temasR4_3);
		regla4_3.Respuesta = "El COVID-19 se propaga principalmente a través del contacto "
				+ "cercano de persona a persona infectada.";
		reglasGenerales.add(regla4_3);
		temasR4_3.add(t7);//como
		temasR4_3.add(t6);//contagia
		temasR4_3.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR4_4 = new ArrayList<Tema>();
		Rule regla4_4 = new Rule();
		regla4_4.setId(4_4);
		regla4_4.setListaTemas(temasR4_2);
		regla4_4.Respuesta = "Se transmite de una persona a otra a través de las gotas procedentes "
		+ "de la nariz o la boca que salen despedidas cuando la persona infectada tose, "
		+ "estornuda o habla, por contacto con manos, superficies u objetos contaminados.";
		reglasGenerales.add(regla4_4);
		temasR4_4.add(t9);//cual (cuál es forma de contagio)
		temasR4_4.add(t30);//forma
		temasR4_4.add(t6);//contagia
		
////////////////////R
		ArrayList<Tema> temasR5_1 = new ArrayList<Tema>();
		Rule regla5_1 = new Rule();
		regla5_1.setId(5_1);
		regla5_1.setListaTemas(temasR5_1);
		regla5_1.Respuesta = "La Organización Mundial de la Salud estima que la tasa de "
				+ "contagio del virus es de 1,4 a 2,5. Esto quiere decir que una persona puede "
				+ "contagiar de 1,4 a 2,5 personas promedio.";
		reglasGenerales.add(regla5_1);
		temasR5_1.add(t9);//cual
		temasR5_1.add(t21);//es
		temasR5_1.add(t23);//tasa
		temasR5_1.add(t6);//contagio

////////////////////R
		ArrayList<Tema> temasR5_2 = new ArrayList<Tema>();
		Rule regla5_2 = new Rule();
		regla5_2.setId(5_2);
		regla5_2.setListaTemas(temasR5_2);
		regla5_2.Respuesta = "Estimaciones hablan de un rango entre 2 y 3. Esto quiere decir que cada "
				+ "persona infectada puede a su vez infectar a entre 2 y 3 personas.";
		reglasGenerales.add(regla5_2);
		temasR5_2.add(t9);//cual
		temasR5_2.add(t21);//es
		temasR5_2.add(t23);//tasa
		temasR5_2.add(t6);//contagio
		
////////////////////R
		ArrayList<Tema> temasR5_3 = new ArrayList<Tema>();
		Rule regla5_3 = new Rule();
		regla5_3.setId(5_3);
		regla5_3.setListaTemas(temasR5_3);
		regla5_3.Respuesta = "La Organización Mundial de la Salud estima que la tasa de "
			+ "contagio del virus es de 1,4 a 2,5. Esto quiere decir que una persona puede "
			+ "contagiar de 1,4 a 2,5 personas promedio.";
		reglasGenerales.add(regla5_3);
		temasR5_3.add(t9);//cual
		temasR5_3.add(t21);//es
		temasR5_3.add(t23);//tasa
		temasR5_3.add(t6);//contagio
		temasR5_3.add(t8);//coronavirus

////////////////////R
		ArrayList<Tema> temasR5_4 = new ArrayList<Tema>();
		Rule regla5_4 = new Rule();
		regla5_4.setId(5_4);
		regla5_4.setListaTemas(temasR5_4);
		regla5_4.Respuesta = "Estimaciones hablan de un rango entre 2 y 3. Esto quiere decir que cada "
			+ "persona infectada puede a su vez infectar a entre 2 y 3 personas.";
		reglasGenerales.add(regla5_4);
		temasR5_4.add(t9);//cual
		temasR5_4.add(t21);//es
		temasR5_4.add(t23);//tasa
		temasR5_4.add(t6);//contagio
		temasR5_4.add(t8);//coronavirus
		
////////////////////R
		ArrayList<Tema> temasR6_1 = new ArrayList<Tema>();
		Rule regla6_1 = new Rule();
		regla6_1.setId(6_1);
		regla6_1.setListaTemas(temasR6_1);
		regla6_1.Respuesta = "Los síntomas leves en un individuo sano pueden desaparecer solos en unos "
				+ "pocos días, generalmente alrededor de una semana.";
		reglasGenerales.add(regla6_1);
		temasR6_1.add(t9);//cual
		temasR6_1.add(t21);//es
		temasR6_1.add(t27);//duracion
		
////////////////////R
		ArrayList<Tema> temasR6_2 = new ArrayList<Tema>();
		Rule regla6_2 = new Rule();
		regla6_2.setId(6_2);
		regla6_2.setListaTemas(temasR6_2);
		regla6_2.Respuesta = "Los síntomas leves en un individuo sano pueden desaparecer solos en unos "
			+ "pocos días, generalmente alrededor de una semana.";
		reglasGenerales.add(regla6_2);
		temasR6_2.add(t9);//cual
		temasR6_2.add(t21);//es
		temasR6_2.add(t27);//duracion
		temasR6_2.add(t8);//enfermedad

////////////////////R
		ArrayList<Tema> temasR6_3 = new ArrayList<Tema>();
		Rule regla6_3 = new Rule();
		regla6_3.setId(6_3);
		regla6_3.setListaTemas(temasR6_3);
		regla6_3.Respuesta = "La edad, el género y padecer otros problemas de salud aumentan el riesgo "
		+ "de enfermarse más gravemente a causa del nuevo virus. Lograr una recuperación completa "
		+ "podría llevar varias semanas.";
		reglasGenerales.add(regla6_3);
		temasR6_3.add(t10);//cuanto
		temasR6_3.add(t27);//duracion
		
////////////////////R
		ArrayList<Tema> temasR6_4 = new ArrayList<Tema>();
		Rule regla6_4 = new Rule();
		regla6_4.setId(6_4);
		regla6_4.setListaTemas(temasR6_4);
		regla6_4.Respuesta = "La edad, el género y padecer otros problemas de salud aumentan el riesgo "
		+ "de enfermarse más gravemente a causa del nuevo virus. Lograr una recuperación completa "
		+ "podría llevar varias semanas.";
		reglasGenerales.add(regla6_4);
		temasR6_4.add(t10);//cuanto
		temasR6_4.add(t27);//duracion
		temasR6_4.add(t8);//enfermedad
		
////////////////////R  (particular No riesgo No infectado)
		ArrayList<Tema> temasR7_1 = new ArrayList<Tema>();
		Rule regla7_1 = new Rule();
		regla7_1.setId(7_1);
		regla7_1.setListaTemas(temasR7_1);
		regla7_1.Respuesta = "Personas jóvenes y saludables no presentan riesgos mayores.";
		regla7_1.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoNoInfectado.add(regla7_1);
		temasR7_1.add(t9);//cual
		temasR7_1.add(t21);//es
		temasR7_1.add(t20);//riesgo
		
////////////////////R  (particular No riesgo No infectado)
		ArrayList<Tema> temasR7_2 = new ArrayList<Tema>();
		Rule regla7_2 = new Rule();
		regla7_2.setId(7_2);
		regla7_2.setListaTemas(temasR7_2);
		regla7_2.Respuesta = "Personas jóvenes y saludables no presentan riesgos mayores.";
		regla7_2.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoNoInfectado.add(regla7_2);
		temasR7_2.add(t9);//cual
		temasR7_2.add(t21);//es
		temasR7_2.add(t20);//riesgo
		temasR7_2.add(t8);//coronavirus
		
////////////////////R  (particular Sí riesgo No infectado)
		ArrayList<Tema> temasR7_3 = new ArrayList<Tema>();
		Rule regla7_3 = new Rule();
		regla7_3.setId(7_3);
		regla7_3.setListaTemas(temasR7_3);
		regla7_3.Respuesta = "Personas mayores de 60, las que tienen enfermedades respiratorias o cardiovasculares "
				+ "y las que tienen afecciones como diabetes presentan mayores riesgos en caso de contagio.";
		regla7_3.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoNoInfectado.add(regla7_3);
		temasR7_3.add(t9);//cual
		temasR7_3.add(t21);//es
		temasR7_3.add(t20);//riesgo
		
////////////////////R  (particular Sí riesgo No infectado)
		ArrayList<Tema> temasR7_4 = new ArrayList<Tema>();
		Rule regla7_4 = new Rule();
		regla7_4.setId(7_4);
		regla7_4.setListaTemas(temasR7_4);
		regla7_4.Respuesta = "Personas mayores de 60, las que tienen enfermedades respiratorias o cardiovasculares "
			+ "y las que tienen afecciones como diabetes presentan mayores riesgos en caso de contagio.";
		regla7_4.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoNoInfectado.add(regla7_4);
		temasR7_4.add(t9);//cual
		temasR7_4.add(t21);//es
		temasR7_4.add(t20);//riesgo
		temasR7_4.add(t8);//coronavirus
		
////////////////////R  (particular No riesgo Sí infectado)
		ArrayList<Tema> temasR7_5 = new ArrayList<Tema>();
		Rule regla7_5 = new Rule();
		regla7_5.setId(7_5);
		regla7_5.setListaTemas(temasR7_5);
		regla7_5.Respuesta = "Personas jóvenes y saludables no presentan riesgos mayores. Sin embargo, el contagio "
				+ "es muy peligroso para personas de riesgo, por lo que le pedimos extremo cuidado y aislamiento social.";
		regla7_5.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoSiInfectado.add(regla7_5);
		temasR7_5.add(t9);//cual
		temasR7_5.add(t21);//es
		temasR7_5.add(t20);//riesgo

////////////////////R  (particular No riesgo Sí infectado)
		ArrayList<Tema> temasR7_6 = new ArrayList<Tema>();
		Rule regla7_6 = new Rule();
		regla7_6.setId(7_6);
		regla7_6.setListaTemas(temasR7_6);
		regla7_6.Respuesta = "Personas jóvenes y saludables no presentan riesgos mayores. Sin embargo, el contagio \"\r<br>" + 
				"		+ \"es muy peligroso para personas de riesgo, por lo que le pedimos extremo cuidado y aislamiento social.";
		regla7_6.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoSiInfectado.add(regla7_6);
		temasR7_6.add(t9);//cual
		temasR7_6.add(t21);//es
		temasR7_6.add(t20);//riesgo
		temasR7_6.add(t8);//coronavirus
		
////////////////////R  (particular Sí riesgo Sí infectado)
		ArrayList<Tema> temasR7_7 = new ArrayList<Tema>();
		Rule regla7_7 = new Rule();
		regla7_7.setId(7_7);
		regla7_7.setListaTemas(temasR7_7);
		regla7_7.Respuesta = "Si bien usted tiene un riesgo superior en cuanto a esta y otras enfermedades, nuestro "
				+ "personal de salud está capacitado para atenderlo si así lo necesita.";
		regla7_7.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoSiInfectado.add(regla7_7);
		temasR7_7.add(t9);//cual
		temasR7_7.add(t21);//es
		temasR7_7.add(t20);//riesgo

////////////////////R  (particular Sí riesgo Sí infectado)
		ArrayList<Tema> temasR7_8 = new ArrayList<Tema>();
		Rule regla7_8 = new Rule();
		regla7_8.setId(7_8);
		regla7_8.setListaTemas(temasR7_8);
		regla7_8.Respuesta = "Si bien usted tiene un riesgo superior en cuanto a esta y otras enfermedades, nuestro "
				+ "personal de salud está capacitado para atenderlo si así lo necesita.";
		regla7_8.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoSiInfectado.add(regla7_8);
		temasR7_8.add(t9);//cual
		temasR7_8.add(t21);//es
		temasR7_8.add(t20);//riesgo
		temasR7_8.add(t8);//coronavirus
		
////////////////////R  (particular No riesgo No infectado)
		ArrayList<Tema> temasR8_1 = new ArrayList<Tema>();
		Rule regla8_1 = new Rule();
		regla8_1.setId(8_1);
		regla8_1.setListaTemas(temasR8_1);
		regla8_1.Respuesta = "Si tiene síntomas leves, como tos o fiebre leves, generalmente no es necesario que "
				+ "busque atención médica. Quédese en casa, aíslese y vigile sus síntomas.";
		regla8_1.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoNoInfectado.add(regla8_1);
		temasR8_1.add(t3);//ayuda
		temasR8_1.add(t12);//infeccion/infectado
		
////////////////////R  (particular Sí riesgo Sí infectado)
		ArrayList<Tema> temasR8_2 = new ArrayList<Tema>();
		Rule regla8_2 = new Rule();
		regla8_2.setId(8_2);
		regla8_2.setListaTemas(temasR8_2);
		regla8_2.Respuesta = "Busque inmediatamente atención médica si tiene dificultad para respirar o "
				+ "siente dolor o presión en el pecho. Si es posible, llame a su dispensador de atención de la salud con "
				+ "antelación para que pueda dirigirlo hacia el centro de salud adecuado.";
		regla8_2.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoSiInfectado.add(regla8_2);
		temasR8_2.add(t3);//ayuda
		temasR8_2.add(t12);//infeccion/infectado
		
////////////////////R  (particular Sí riesgo No infectado)
		ArrayList<Tema> temasR8_3 = new ArrayList<Tema>();
		Rule regla8_3 = new Rule();
		regla8_3.setId(8_3);
		regla8_3.setListaTemas(temasR8_3);
		regla8_3.Respuesta = "Si tiene problemas para respirar o presión en el pecho, no dude en consultar "
				+ "a su médico. Si así lo prefiere y le es posible, llame a su dispensador de atención de la salud con "
			+ "antelación para que pueda dirigirlo hacia el centro de salud adecuado.";
		regla8_3.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasSiRiesgoNoInfectado.add(regla8_3);
		temasR8_3.add(t3);//ayuda
		temasR8_3.add(t12);//infeccion/infectado

////////////////////R  (particular No riesgo Sí infectado)
		ArrayList<Tema> temasR8_4 = new ArrayList<Tema>();
		Rule regla8_4 = new Rule();
		regla8_4.setId(8_4);
		regla8_4.setListaTemas(temasR8_4);
		regla8_4.Respuesta = "Por su condición, las probabilidades de complicaciones son bajas. Sin embargo, si tiene "
				+ "dificultades para respirar o presión en el pecho, no dude en consultar a su médico. Si así lo prefiere "
				+ "y le es posible, llame a su dispensador de atención de la salud con antelación para que pueda dirigirlo "
				+ "hacia el centro de salud adecuado.";
		regla8_4.setPriority(1); //Añade prioridad 1 por ser una respuesta particular
		reglasNoRiesgoSiInfectado.add(regla8_4);
		temasR8_4.add(t3);//ayuda
		temasR8_4.add(t12);//infeccion/infectado
		
////////////////////R
		ArrayList<Tema> temasR9_1 = new ArrayList<Tema>();
		Rule regla9_1 = new Rule();
		regla9_1.setId(9_1);
		regla9_1.setListaTemas(temasR9_1);
		regla9_1.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_1);
		temasR9_1.add(t16);//numero
		temasR9_1.add(t4);//casos
		temasR9_1.add(t5);//ciudad
		
////////////////////R
		ArrayList<Tema> temasR9_2 = new ArrayList<Tema>();
		Rule regla9_2 = new Rule();
		regla9_2.setId(9_2);
		regla9_2.setListaTemas(temasR9_2);
		regla9_2.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_2);
		temasR9_2.add(t16);//numero
		temasR9_2.add(t12);//infectados
		temasR9_2.add(t5);//ciudad
		
////////////////////R
		ArrayList<Tema> temasR9_3 = new ArrayList<Tema>();
		Rule regla9_3 = new Rule();
		regla9_3.setId(9_3);
		regla9_3.setListaTemas(temasR9_3);
		regla9_3.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_3);
		temasR9_3.add(t16);//numero
		temasR9_3.add(t4);//casos
		temasR9_3.add(t8);//coronavirus
		temasR9_3.add(t5);//ciudad

////////////////////R
		ArrayList<Tema> temasR9_4 = new ArrayList<Tema>();
		Rule regla9_4 = new Rule();
		regla9_4.setId(9_4);
		regla9_4.setListaTemas(temasR9_4);
		regla9_4.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_4);
		temasR9_4.add(t16);//numero
		temasR9_4.add(t12);//infectados
		temasR9_4.add(t8);//coronavirus
		temasR9_4.add(t5);//ciudad
		
////////////////////R
		ArrayList<Tema> temasR9_5 = new ArrayList<Tema>();
		Rule regla9_5 = new Rule();
		regla9_5.setId(9_5);
		regla9_5.setListaTemas(temasR9_5);
		regla9_5.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
				+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_5);
		temasR9_5.add(t16);//numero
		temasR9_5.add(t4);//casos
		temasR9_5.add(t5);//ciudad

////////////////////R
		ArrayList<Tema> temasR9_6 = new ArrayList<Tema>();
		Rule regla9_6 = new Rule();
		regla9_6.setId(9_6);
		regla9_6.setListaTemas(temasR9_6);
		regla9_6.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
				+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_6);
		temasR9_6.add(t16);//numero
		temasR9_6.add(t12);//infectados
		temasR9_6.add(t5);//ciudad

////////////////////R
		ArrayList<Tema> temasR9_7 = new ArrayList<Tema>();
		Rule regla9_7 = new Rule();
		regla9_7.setId(9_7);
		regla9_7.setListaTemas(temasR9_7);
		regla9_7.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
				+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_7);
		temasR9_7.add(t16);//numero
		temasR9_7.add(t4);//casos
		temasR9_7.add(t8);//coronavirus
		temasR9_7.add(t5);//ciudad

////////////////////R
		ArrayList<Tema> temasR9_8 = new ArrayList<Tema>();
		Rule regla9_8 = new Rule();
		regla9_8.setId(9_8);
		regla9_8.setListaTemas(temasR9_8);
		regla9_8.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
				+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_8);
		temasR9_8.add(t16);//numero
		temasR9_8.add(t12);//infectados
		temasR9_8.add(t8);//coronavirus
		temasR9_8.add(t5);//ciudad
		
////////////////////R
		ArrayList<Tema> temasR9_9 = new ArrayList<Tema>();
		Rule regla9_9 = new Rule();
		regla9_9.setId(9_9);
		regla9_9.setListaTemas(temasR9_9);
		regla9_9.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_9);
		temasR9_9.add(t16);//numero
		temasR9_9.add(t4);//casos
		temasR9_9.add(t5);//ciudad
		temasR9_9.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_10 = new ArrayList<Tema>();
		Rule regla9_10 = new Rule();
		regla9_10.setId(9_10);
		regla9_10.setListaTemas(temasR9_10);
		regla9_10.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_10);
		temasR9_10.add(t16);//numero
		temasR9_10.add(t12);//infectados
		temasR9_10.add(t5);//ciudad
		temasR9_10.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_11 = new ArrayList<Tema>();
		Rule regla9_11 = new Rule();
		regla9_11.setId(9_11);
		regla9_11.setListaTemas(temasR9_11);
		regla9_11.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_11);
		temasR9_11.add(t16);//numero
		temasR9_11.add(t4);//casos
		temasR9_11.add(t8);//coronavirus
		temasR9_11.add(t5);//ciudad
		temasR9_11.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_12 = new ArrayList<Tema>();
		Rule regla9_12 = new Rule();
		regla9_12.setId(9_12);
		regla9_12.setListaTemas(temasR9_12);
		regla9_12.Respuesta = "La cantidad de infectados en la ciudad es de ____________";
		reglasGenerales.add(regla9_12);
		temasR9_12.add(t16);//numero
		temasR9_12.add(t12);//infectados
		temasR9_12.add(t8);//coronavirus
		temasR9_12.add(t5);//ciudad
		temasR9_12.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_13 = new ArrayList<Tema>();
		Rule regla9_13 = new Rule();
		regla9_13.setId(9_13);
		regla9_13.setListaTemas(temasR9_13);
		regla9_13.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_13);
		temasR9_13.add(t16);//numero
		temasR9_13.add(t4);//casos
		temasR9_13.add(t5);//ciudad
		temasR9_13.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_14 = new ArrayList<Tema>();
		Rule regla9_14 = new Rule();
		regla9_14.setId(9_14);
		regla9_14.setListaTemas(temasR9_14);
		regla9_14.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_14);
		temasR9_14.add(t16);//numero
		temasR9_14.add(t12);//infectados
		temasR9_14.add(t5);//ciudad
		temasR9_14.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_15 = new ArrayList<Tema>();
		Rule regla9_15 = new Rule();
		regla9_15.setId(9_15);
		regla9_15.setListaTemas(temasR9_15);
		regla9_15.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_15);
		temasR9_15.add(t16);//numero
		temasR9_15.add(t4);//casos
		temasR9_15.add(t8);//coronavirus
		temasR9_15.add(t5);//ciudad
		temasR9_15.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR9_16 = new ArrayList<Tema>();
		Rule regla9_16 = new Rule();
		regla9_16.setId(9_16);
		regla9_16.setListaTemas(temasR9_16);
		regla9_16.Respuesta = "La cantidad de infectados en la ciudad es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla9_16);
		temasR9_16.add(t16);//numero
		temasR9_16.add(t12);//infectados
		temasR9_16.add(t8);//coronavirus
		temasR9_16.add(t5);//ciudad
		temasR9_16.add(t36);//santafe
		
////////////////////R
		ArrayList<Tema> temasR10_1 = new ArrayList<Tema>();
		Rule regla10_1 = new Rule();
		regla10_1.setId(10_1);
		regla10_1.setListaTemas(temasR10_1);
		regla10_1.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_1);
		temasR10_1.add(t16);//numero
		temasR10_1.add(t4);//casos
		temasR10_1.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_2 = new ArrayList<Tema>();
		Rule regla10_2 = new Rule();
		regla10_2.setId(10_2);
		regla10_2.setListaTemas(temasR10_2);
		regla10_2.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_2);
		temasR10_2.add(t16);//numero
		temasR10_2.add(t12);//infectados
		temasR10_2.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_3 = new ArrayList<Tema>();
		Rule regla10_3 = new Rule();
		regla10_3.setId(10_3);
		regla10_3.setListaTemas(temasR10_3);
		regla10_3.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_3);
		temasR10_3.add(t16);//numero
		temasR10_3.add(t4);//casos
		temasR10_3.add(t8);//coronavirus
		temasR10_3.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_4 = new ArrayList<Tema>();
		Rule regla10_4 = new Rule();
		regla10_4.setId(10_4);
		regla10_4.setListaTemas(temasR10_4);
		regla10_4.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_4);
		temasR10_4.add(t16);//numero
		temasR10_4.add(t12);//infectados
		temasR10_4.add(t8);//coronavirus
		temasR10_4.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_5 = new ArrayList<Tema>();
		Rule regla10_5 = new Rule();
		regla10_5.setId(10_5);
		regla10_5.setListaTemas(temasR10_5);
		regla10_5.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_5);
		temasR10_5.add(t16);//numero
		temasR10_5.add(t4);//casos
		temasR10_5.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_6 = new ArrayList<Tema>();
		Rule regla10_6 = new Rule();
		regla10_6.setId(10_6);
		regla10_6.setListaTemas(temasR10_6);
		regla10_6.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_6);
		temasR10_6.add(t16);//numero
		temasR10_6.add(t12);//infectados
		temasR10_6.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_7 = new ArrayList<Tema>();
		Rule regla10_7 = new Rule();
		regla10_7.setId(10_7);
		regla10_7.setListaTemas(temasR10_7);
		regla10_7.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_7);
		temasR10_7.add(t16);//numero
		temasR10_7.add(t4);//casos
		temasR10_7.add(t8);//coronavirus
		temasR10_7.add(t18);//provincia

////////////////////R
		ArrayList<Tema> temasR10_8 = new ArrayList<Tema>();
		Rule regla10_8 = new Rule();
		regla10_8.setId(10_8);
		regla10_8.setListaTemas(temasR10_8);
		regla10_8.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
			+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_8);
		temasR10_8.add(t16);//numero
		temasR10_8.add(t12);//infectados
		temasR10_8.add(t8);//coronavirus
		temasR10_8.add(t18);//provincia
		
////////////////////R
		ArrayList<Tema> temasR10_9 = new ArrayList<Tema>();
		Rule regla10_9 = new Rule();
		regla10_9.setId(10_9);
		regla10_9.setListaTemas(temasR10_9);
		regla10_9.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_9);
		temasR10_9.add(t16);//numero
		temasR10_9.add(t4);//casos
		temasR10_9.add(t18);//provincia
		temasR10_9.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_10 = new ArrayList<Tema>();
		Rule regla10_10 = new Rule();
		regla10_10.setId(10_10);
		regla10_10.setListaTemas(temasR10_10);
		regla10_10.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_10);
		temasR10_10.add(t16);//numero
		temasR10_10.add(t12);//infectados
		temasR10_10.add(t18);//provincia
		temasR10_10.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_11 = new ArrayList<Tema>();
		Rule regla10_11 = new Rule();
		regla10_11.setId(10_11);
		regla10_11.setListaTemas(temasR10_11);
		regla10_11.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_11);
		temasR10_11.add(t16);//numero
		temasR10_11.add(t4);//casos
		temasR10_11.add(t8);//coronavirus
		temasR10_11.add(t18);//provincia
		temasR10_11.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_12 = new ArrayList<Tema>();
		Rule regla10_12 = new Rule();
		regla10_12.setId(10_12);
		regla10_12.setListaTemas(temasR10_12);
		regla10_12.Respuesta = "La cantidad de infectados en la provincia es de ____________";
		reglasGenerales.add(regla10_12);
		temasR10_12.add(t16);//numero
		temasR10_12.add(t12);//infectados
		temasR10_12.add(t8);//coronavirus
		temasR10_12.add(t18);//provincia
		temasR10_12.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_13 = new ArrayList<Tema>();
		Rule regla10_13 = new Rule();
		regla10_13.setId(10_13);
		regla10_13.setListaTemas(temasR10_13);
		regla10_13.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_13);
		temasR10_13.add(t16);//numero
		temasR10_13.add(t4);//casos
		temasR10_13.add(t18);//provincia
		temasR10_13.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_14 = new ArrayList<Tema>();
		Rule regla10_14 = new Rule();
		regla10_14.setId(10_14);
		regla10_14.setListaTemas(temasR10_14);
		regla10_14.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_14);
		temasR10_14.add(t16);//numero
		temasR10_14.add(t12);//infectados
		temasR10_14.add(t18);//provincia
		temasR10_14.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_15 = new ArrayList<Tema>();
		Rule regla10_15 = new Rule();
		regla10_15.setId(10_15);
		regla10_15.setListaTemas(temasR10_15);
		regla10_15.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_15);
		temasR10_15.add(t16);//numero
		temasR10_15.add(t4);//casos
		temasR10_15.add(t8);//coronavirus
		temasR10_15.add(t18);//provincia
		temasR10_15.add(t36);//santafe

////////////////////R
		ArrayList<Tema> temasR10_16 = new ArrayList<Tema>();
		Rule regla10_16 = new Rule();
		regla10_16.setId(10_16);
		regla10_16.setListaTemas(temasR10_16);
		regla10_16.Respuesta = "La cantidad de infectados en la provincia es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla10_16);
		temasR10_16.add(t16);//numero
		temasR10_16.add(t12);//infectados
		temasR10_16.add(t8);//coronavirus
		temasR10_16.add(t18);//provincia
		temasR10_16.add(t36);//santafe
		
////////////////////R
		ArrayList<Tema> temasR11_1 = new ArrayList<Tema>();
		Rule regla11_1 = new Rule();
		regla11_1.setId(11_1);
		regla11_1.setListaTemas(temasR11_1);
		regla11_1.Respuesta = "La cantidad de infectados en el país es de ____________";
		reglasGenerales.add(regla11_1);
		temasR11_1.add(t16);//numero
		temasR11_1.add(t4);//casos
		temasR11_1.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_2 = new ArrayList<Tema>();
		Rule regla11_2 = new Rule();
		regla11_2.setId(11_2);
		regla11_2.setListaTemas(temasR11_2);
		regla11_2.Respuesta = "La cantidad de infectados en el país es de ____________";
		reglasGenerales.add(regla11_2);
		temasR11_2.add(t16);//numero
		temasR11_2.add(t12);//infectados
		temasR11_2.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_3 = new ArrayList<Tema>();
		Rule regla11_3 = new Rule();
		regla11_3.setId(11_3);
		regla11_3.setListaTemas(temasR11_3);
		regla11_3.Respuesta = "La cantidad de infectados en el país es de ____________";
		reglasGenerales.add(regla11_3);
		temasR11_3.add(t16);//numero
		temasR11_3.add(t4);//casos
		temasR11_3.add(t8);//coronavirus
		temasR11_3.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_4 = new ArrayList<Tema>();
		Rule regla11_4 = new Rule();
		regla11_4.setId(11_4);
		regla11_4.setListaTemas(temasR11_4);
		regla11_4.Respuesta = "La cantidad de infectados en el país es de ____________";
		reglasGenerales.add(regla11_4);
		temasR11_4.add(t16);//numero
		temasR11_4.add(t12);//infectados
		temasR11_4.add(t8);//coronavirus
		temasR11_4.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_5 = new ArrayList<Tema>();
		Rule regla11_5 = new Rule();
		regla11_5.setId(11_5);
		regla11_5.setListaTemas(temasR11_5);
		regla11_5.Respuesta = "La cantidad de infectados en el país es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla11_5);
		temasR11_5.add(t16);//numero
		temasR11_5.add(t4);//casos
		temasR11_5.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_6 = new ArrayList<Tema>();
		Rule regla11_6 = new Rule();
		regla11_6.setId(11_6);
		regla11_6.setListaTemas(temasR11_6);
		regla11_6.Respuesta = "La cantidad de infectados en el país es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla11_6);
		temasR11_6.add(t16);//numero
		temasR11_6.add(t12);//infectados
		temasR11_6.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_7 = new ArrayList<Tema>();
		Rule regla11_7 = new Rule();
		regla11_7.setId(11_7);
		regla11_7.setListaTemas(temasR11_7);
		regla11_7.Respuesta = "La cantidad de infectados en el país es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla11_7);
		temasR11_7.add(t16);//numero
		temasR11_7.add(t4);//casos
		temasR11_7.add(t8);//coronavirus
		temasR11_7.add(t17);//país

////////////////////R
		ArrayList<Tema> temasR11_8 = new ArrayList<Tema>();
		Rule regla11_8 = new Rule();
		regla11_8.setId(11_8);
		regla11_8.setListaTemas(temasR11_8);
		regla11_8.Respuesta = "La cantidad de infectados en el país es de ____________, de los cuales, "
		+ "____________ fueron en las últimas 24 horas.";
		reglasGenerales.add(regla11_8);
		temasR11_8.add(t16);//numero
		temasR11_8.add(t12);//infectados
		temasR11_8.add(t8);//coronavirus
		temasR11_8.add(t17);//país
		
////////////////////R
		ArrayList<Tema> temasR12_1 = new ArrayList<Tema>();
		Rule regla12_1 = new Rule();
		regla12_1.setId(12_1);
		regla12_1.setListaTemas(temasR12_1);
		regla12_1.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires, donde hay "
				+ "un 30% de los casos del país.";
		reglasGenerales.add(regla12_1);
		temasR12_1.add(t9);//cual
		temasR12_1.add(t25);//zona
		temasR12_1.add(t13);//mayor
		temasR12_1.add(t20);//riesgo
		
////////////////////R
		ArrayList<Tema> temasR12_2 = new ArrayList<Tema>();
		Rule regla12_2 = new Rule();
		regla12_2.setId(12_2);
		regla12_2.setListaTemas(temasR12_2);
		regla12_2.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires. El distrito "
				+ "con más contagios confirmados oficialmente es San Martín con 67 casos, seguido de Vicente López "
				+ "con 60, Pilar con 51 y San Isidro con 45.";
		reglasGenerales.add(regla12_2);
		temasR12_2.add(t9);//cual
		temasR12_2.add(t25);//zona
		temasR12_2.add(t13);//mayor
		temasR12_2.add(t20);//riesgo
		
////////////////////R
		ArrayList<Tema> temasR12_3 = new ArrayList<Tema>();
		Rule regla12_3 = new Rule();
		regla12_3.setId(12_3);
		regla12_3.setListaTemas(temasR12_3);
		regla12_3.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires, donde hay "
			+ "un 30% de los casos del país.";
		reglasGenerales.add(regla12_3);
		temasR12_3.add(t9);//cual
		temasR12_3.add(t25);//zona
		temasR12_3.add(t13);//mayor
		temasR12_3.add(t16);//numero
		temasR12_3.add(t4);//caso

////////////////////R
		ArrayList<Tema> temasR12_4 = new ArrayList<Tema>();
		Rule regla12_4 = new Rule();
		regla12_4.setId(12_4);
		regla12_4.setListaTemas(temasR12_4);
		regla12_4.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires. El distrito "
			+ "con más contagios confirmados oficialmente es San Martín con 67 casos, seguido de Vicente López "
			+ "con 60, Pilar con 51 y San Isidro con 45.";
		reglasGenerales.add(regla12_4);
		temasR12_4.add(t9);//cual
		temasR12_4.add(t25);//zona
		temasR12_4.add(t13);//mayor
		temasR12_4.add(t16);//numero
		temasR12_4.add(t4);//caso

////////////////////R
		ArrayList<Tema> temasR12_5 = new ArrayList<Tema>();
		Rule regla12_5 = new Rule();
		regla12_5.setId(12_5);
		regla12_5.setListaTemas(temasR12_5);
		regla12_5.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires, donde hay "
		+ "un 30% de los casos del país.";
		reglasGenerales.add(regla12_5);
		temasR12_5.add(t11);//donde
		temasR12_5.add(t13);//mayor
		temasR12_5.add(t20);//riesgo

////////////////////R
		ArrayList<Tema> temasR12_6 = new ArrayList<Tema>();
		Rule regla12_6 = new Rule();
		regla12_6.setId(12_6);
		regla12_6.setListaTemas(temasR12_6);
		regla12_6.Respuesta = "La mayor concentración de casos está en la provincia de Buenos Aires. El distrito "
		+ "con más contagios confirmados oficialmente es San Martín con 67 casos, seguido de Vicente López "
		+ "con 60, Pilar con 51 y San Isidro con 45.";
		reglasGenerales.add(regla12_6);
		temasR12_6.add(t11);//donde
		temasR12_6.add(t13);//mayor
		temasR12_6.add(t16);//numero
		temasR12_6.add(t4);//caso
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//COMERCIANTE
		ArrayList<Rule> reglasComerciantes = new ArrayList<Rule>();
////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_1 = new ArrayList<Tema>();
		Rule regla13_1 = new Rule();
		regla13_1.setId(13_1);
		regla13_1.setListaTemas(temasR13_1);
		regla13_1.Respuesta = "Restringir la cantidad de personas dentro del comercio.";
		reglasComerciantes.add(regla13_1);
		temasR13_1.add(t19);//recomendación
		temasR13_1.add(t29);//comercio
		
////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_2 = new ArrayList<Tema>();
		Rule regla13_2 = new Rule();
		regla13_2.setId(13_2);
		regla13_2.setListaTemas(temasR13_2);
		regla13_2.Respuesta = "Disponer de alcohol en gel u otra solución hidroalcohólica desinfectante al alcance de los clientes y de los trabajadores. Se aconseja que el personal limpie sus manos con alcohol en gel cada vez que intercambie algún objeto con los consumidores.";
		reglasComerciantes.add(regla13_2);
		temasR13_2.add(t19);//recomendación
		temasR13_2.add(t29);//comercio

////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_3 = new ArrayList<Tema>();
		Rule regla13_3 = new Rule();
		regla13_3.setId(13_3);
		regla13_3.setListaTemas(temasR13_3);
		regla13_3.Respuesta = "Se recomienda ubicar los mostradores con alcohol en gel en la puerta del comercio para evitar la circulación.";
		reglasComerciantes.add(regla13_3);
		temasR13_3.add(t19);//recomendación
		temasR13_3.add(t29);//comercio

////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_4 = new ArrayList<Tema>();
		Rule regla13_4 = new Rule();
		regla13_4.setId(13_4);
		regla13_4.setListaTemas(temasR13_4);
		regla13_4.Respuesta = "Se aconseja que los pedidos puedan realizarse por teléfono o por internet. Procurar la habilitación de medios de ventas a través de internet y las redes sociales, entre otros.";
		reglasComerciantes.add(regla13_4);
		temasR13_4.add(t19);//recomendación
		temasR13_4.add(t29);//comercio

////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_5 = new ArrayList<Tema>();
		Rule regla13_5 = new Rule();
		regla13_5.setId(13_5);
		regla13_5.setListaTemas(temasR13_5);
		regla13_5.Respuesta = "Los comercios que disponen de delivery fomentar esta modalidad.";
		reglasComerciantes.add(regla13_5);
		temasR13_5.add(t19);//recomendación
		temasR13_5.add(t29);//comercio

////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_6 = new ArrayList<Tema>();
		Rule regla13_6 = new Rule();
		regla13_6.setId(13_6);
		regla13_6.setListaTemas(temasR13_6);
		regla13_6.Respuesta = "Evitar el contacto cercano y mantener una distancia de entre uno y dos metros entre las personas dentro de los locales comerciales. Además, se insta a evitar abrazos, besos o estrechar las manos entre los empleados y los clientes.";
		reglasComerciantes.add(regla13_6);
		temasR13_6.add(t19);//recomendación
		temasR13_6.add(t29);//comercio

////////////////////R		(Reglas implicadas comerciante)
		ArrayList<Tema> temasR13_7 = new ArrayList<Tema>();
		Rule regla13_7 = new Rule();
		regla13_7.setId(13_7);
		regla13_7.setListaTemas(temasR13_7);
		regla13_7.Respuesta = "Desinfectar lugares y equipos de trabajo reutilizables.";
		reglasComerciantes.add(regla13_7);
		temasR13_7.add(t19);//recomendación
		temasR13_7.add(t29);//comercio

////////////////////R		(Reglas que implican comerciante)
		ArrayList<Tema> temasR14_1 = new ArrayList<Tema>();
		Rule regla14_1 = new Rule();
		regla14_1.setId(14_1);
		regla14_1.setListaTemas(temasR14_1);
		regla14_1.Respuesta = "Si su comercio se encuentra habilitado para la atención, se le recomienda:<br>"
				+ "1- Restringir la cantidad de personas dentro del comercio.<br>" + 
				"2- Disponer de alcohol en gel u otra solución hidroalcohólica desinfectante al alcance de los clientes y de los trabajadores. Se aconseja que el personal limpie sus manos con alcohol en gel cada vez que intercambie algún objeto con los consumidores.<br>" + 
				"3- Se recomienda ubicar los mostradores con alcohol en gel en la puerta del comercio para evitar la circulación.<br>" +  
				"4- Se aconseja que los pedidos puedan realizarse por teléfono o por internet. Procurar la habilitación de medios de ventas a través de internet y las redes sociales, entre otros.<br>" + 
				"5- Los comercios que disponen de delivery fomentar esta modalidad.<br>" +  
				"6- Evitar el contacto cercano y mantener una distancia de entre uno y dos metros entre las personas dentro de los locales comerciales. Además, se insta a evitar abrazos, besos o estrechar las manos entre los empleados y los clientes.<br>" + 
				"7- Desinfectar lugares y equipos de trabajo reutilizables.";
		regla14_1.setReglasImplicadas(reglasComerciantes); //habilita las preguntas de los comerciantes
		reglasGenerales.add(regla14_1);
		temasR14_1.add(t24);//tener
		temasR14_1.add(t29);//comercio
		
		ArrayList<Integer> reglasAEliminarComerciante = new ArrayList<Integer>();
		reglasAEliminarComerciante.add(14_1);
		reglasAEliminarComerciante.add(14_2);
		reglasAEliminarComerciante.add(14_3);
		reglasAEliminarComerciante.add(14_4);
		regla14_1.setIdsReglasAEliminar(reglasAEliminarComerciante);
		
////////////////////R
		ArrayList<Tema> temasR14_2 = new ArrayList<Tema>();
		Rule regla14_2 = new Rule();
		regla14_2.setId(14_2);
		regla14_2.setListaTemas(temasR14_2);
		regla14_2.Respuesta = "Si su comercio se encuentra habilitado para la atención, se le recomienda:<br>"
				+ "1- Restringir la cantidad de personas dentro del comercio.<br>" + 
				"2- Disponer de alcohol en gel u otra solución hidroalcohólica desinfectante al alcance de los clientes y de los trabajadores. Se aconseja que el personal limpie sus manos con alcohol en gel cada vez que intercambie algún objeto con los consumidores.<br>" + 
				"3- Se recomienda ubicar los mostradores con alcohol en gel en la puerta del comercio para evitar la circulación.<br>" +  
				"4- Se aconseja que los pedidos puedan realizarse por teléfono o por internet. Procurar la habilitación de medios de ventas a través de internet y las redes sociales, entre otros.<br>" + 
				"5- Los comercios que disponen de delivery fomentar esta modalidad.<br>" +  
				"6- Evitar el contacto cercano y mantener una distancia de entre uno y dos metros entre las personas dentro de los locales comerciales. Además, se insta a evitar abrazos, besos o estrechar las manos entre los empleados y los clientes.<br>" + 
				"7- Desinfectar lugares y equipos de trabajo reutilizables.";
		regla14_2.setReglasImplicadas(reglasComerciantes); //habilita las preguntas de los comerciantes
		reglasGenerales.add(regla14_2);
		temasR14_2.add(t21);//ser
		temasR14_2.add(t29);//comerciante
		
		regla14_2.setIdsReglasAEliminar(reglasAEliminarComerciante);
		
////////////////////R
		ArrayList<Tema> temasR14_3 = new ArrayList<Tema>();
		Rule regla14_3 = new Rule();
		regla14_3.setId(14_3);
		regla14_3.setListaTemas(temasR14_3);
		regla14_3.Respuesta = "Si su comercio se encuentra habilitado para la atención, se le recomienda:<br>"
			+ "1- Restringir la cantidad de personas dentro del comercio.<br>" + 
			"2- Disponer de alcohol en gel u otra solución hidroalcohólica desinfectante al alcance de los clientes y de los trabajadores. Se aconseja que el personal limpie sus manos con alcohol en gel cada vez que intercambie algún objeto con los consumidores.<br>" + 
			"3- Se recomienda ubicar los mostradores con alcohol en gel en la puerta del comercio para evitar la circulación.<br>" +  
			"4- Se aconseja que los pedidos puedan realizarse por teléfono o por internet. Procurar la habilitación de medios de ventas a través de internet y las redes sociales, entre otros.<br>" + 
			"5- Los comercios que disponen de delivery fomentar esta modalidad.<br>" +  
			"6- Evitar el contacto cercano y mantener una distancia de entre uno y dos metros entre las personas dentro de los locales comerciales. Además, se insta a evitar abrazos, besos o estrechar las manos entre los empleados y los clientes.<br>" + 
			"7- Desinfectar lugares y equipos de trabajo reutilizables.";
		regla14_3.setReglasImplicadas(reglasComerciantes); //habilita las preguntas de los comerciantes
		reglasGenerales.add(regla14_3);
		temasR14_3.add(t24);//tener
		temasR14_3.add(t29);//comercio
		temasR14_3.add(t19);//recomendaciones
		
		regla14_3.setIdsReglasAEliminar(reglasAEliminarComerciante);

////////////////////R
		ArrayList<Tema> temasR14_4 = new ArrayList<Tema>();
		Rule regla14_4 = new Rule();
		regla14_4.setId(14_4);
		regla14_4.setListaTemas(temasR14_4);
		regla14_4.Respuesta = "Si su comercio se encuentra habilitado para la atención, se le recomienda:<br>"
			+ "1- Restringir la cantidad de personas dentro del comercio.<br>" + 
			"2- Disponer de alcohol en gel u otra solución hidroalcohólica desinfectante al alcance de los clientes y de los trabajadores. Se aconseja que el personal limpie sus manos con alcohol en gel cada vez que intercambie algún objeto con los consumidores.<br>" + 
			"3- Se recomienda ubicar los mostradores con alcohol en gel en la puerta del comercio para evitar la circulación.<br>" +  
			"4- Se aconseja que los pedidos puedan realizarse por teléfono o por internet. Procurar la habilitación de medios de ventas a través de internet y las redes sociales, entre otros.<br>" + 
			"5- Los comercios que disponen de delivery fomentar esta modalidad.<br>" +  
			"6- Evitar el contacto cercano y mantener una distancia de entre uno y dos metros entre las personas dentro de los locales comerciales. Además, se insta a evitar abrazos, besos o estrechar las manos entre los empleados y los clientes.<br>" + 
			"7- Desinfectar lugares y equipos de trabajo reutilizables.";
		regla14_4.setReglasImplicadas(reglasComerciantes); //habilita las preguntas de los comerciantes
		reglasGenerales.add(regla14_4);
		temasR14_4.add(t21);//ser
		temasR14_4.add(t29);//comerciante
		temasR14_4.add(t19);//recomendaciones
		
		regla14_4.setIdsReglasAEliminar(reglasAEliminarComerciante);
		
		
		
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//PERSONAL DE LA SALUD
		ArrayList<Rule> reglasPersonalSalud = new ArrayList<Rule>();
////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_1 = new ArrayList<Tema>();
		Rule regla15_1 = new Rule();
		regla15_1.setId(15_1);
		regla15_1.setListaTemas(temasR15_1);
		regla15_1.Respuesta = "Realizar higiene de manos frecuente durante las tareas asistenciales, y en " + 
				"momentos de tareas no asistenciales.";
		reglasPersonalSalud.add(regla15_1);
		temasR15_1.add(t19);//recomendación
		temasR15_1.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_2 = new ArrayList<Tema>();
		Rule regla15_2 = new Rule();
		regla15_2.setId(15_2);
		regla15_2.setListaTemas(temasR15_2);
		regla15_2.Respuesta = "Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.";
		reglasPersonalSalud.add(regla15_2);
		temasR15_2.add(t19);//recomendación
		temasR15_2.add(t33);//trabajo
		
////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_3 = new ArrayList<Tema>();
		Rule regla15_3 = new Rule();
		regla15_3.setId(15_3);
		regla15_3.setListaTemas(temasR15_3);
		regla15_3.Respuesta = "No llevarse las manos a la cara.";
		reglasPersonalSalud.add(regla15_3);
		temasR15_3.add(t19);//recomendación
		temasR15_3.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_4 = new ArrayList<Tema>();
		Rule regla15_4 = new Rule();
		regla15_4.setId(15_4);
		regla15_4.setListaTemas(temasR15_4);
		regla15_4.Respuesta = "Ventilar bien los ambientes del lugar de trabajo.";
		reglasPersonalSalud.add(regla15_4);
		temasR15_4.add(t19);//recomendación
		temasR15_4.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_5 = new ArrayList<Tema>();
		Rule regla15_5 = new Rule();
		regla15_5.setId(15_5);
		regla15_5.setListaTemas(temasR15_5);
		regla15_5.Respuesta = "Desinfectar los objetos que se usan con frecuencia.";
		reglasPersonalSalud.add(regla15_5);
		temasR15_5.add(t19);//recomendación
		temasR15_5.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_6 = new ArrayList<Tema>();
		Rule regla15_6 = new Rule();
		regla15_6.setId(15_6);
		regla15_6.setListaTemas(temasR15_6);
		regla15_6.Respuesta = "No compartir mate, vajilla o utensilios en el trabajo.";
		reglasPersonalSalud.add(regla15_6);
		temasR15_6.add(t19);//recomendación
		temasR15_6.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_7 = new ArrayList<Tema>();
		Rule regla15_7 = new Rule();
		regla15_7.setId(15_7);
		regla15_7.setListaTemas(temasR15_7);
		regla15_7.Respuesta = "Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo, <br>" + 
				"guardapolvo), y ésta debe quedar en el ámbito laboral.";
		reglasPersonalSalud.add(regla15_7);
		temasR15_7.add(t19);//recomendación
		temasR15_7.add(t33);//trabajo

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_8 = new ArrayList<Tema>();
		Rule regla15_8 = new Rule();
		regla15_8.setId(15_8);
		regla15_8.setListaTemas(temasR15_8);
		regla15_8.Respuesta = "Realizar higiene de manos frecuente durante las tareas asistenciales, y en <br>" + 
				"		\"momentos de tareas no asistenciales.";
		reglasPersonalSalud.add(regla15_8);
		temasR15_8.add(t19);//recomendación
		temasR15_8.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_9 = new ArrayList<Tema>();
		Rule regla15_9 = new Rule();
		regla15_9.setId(15_9);
		regla15_9.setListaTemas(temasR15_9);
		regla15_9.Respuesta = "Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.";
		reglasPersonalSalud.add(regla15_9);
		temasR15_9.add(t19);//recomendación
		temasR15_9.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_10 = new ArrayList<Tema>();
		Rule regla15_10 = new Rule();
		regla15_10.setId(15_10);
		regla15_10.setListaTemas(temasR15_10);
		regla15_10.Respuesta = "No llevarse las manos a la cara.";
		reglasPersonalSalud.add(regla15_10);
		temasR15_10.add(t19);//recomendación
		temasR15_10.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_11 = new ArrayList<Tema>();
		Rule regla15_11 = new Rule();
		regla15_11.setId(15_11);
		regla15_11.setListaTemas(temasR15_11);
		regla15_11.Respuesta = "Ventilar bien los ambientes del lugar de trabajo.";
		reglasPersonalSalud.add(regla15_11);
		temasR15_11.add(t19);//recomendación
		temasR15_11.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_12 = new ArrayList<Tema>();
		Rule regla15_12 = new Rule();
		regla15_12.setId(15_12);
		regla15_12.setListaTemas(temasR15_12);
		regla15_12.Respuesta = "Desinfectar los objetos que se usan con frecuencia.";
		reglasPersonalSalud.add(regla15_12);
		temasR15_12.add(t19);//recomendación
		temasR15_12.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_13 = new ArrayList<Tema>();
		Rule regla15_13 = new Rule();
		regla15_13.setId(15_13);
		regla15_13.setListaTemas(temasR15_13);
		regla15_13.Respuesta = "No compartir mate, vajilla o utensilios en el trabajo.";
		reglasPersonalSalud.add(regla15_13);
		temasR15_13.add(t19);//recomendación
		temasR15_13.add(t35);//medico/enfermero

////////////////////R		(Reglas implicadas personal salud)
		ArrayList<Tema> temasR15_14 = new ArrayList<Tema>();
		Rule regla15_14 = new Rule();
		regla15_14.setId(15_14);
		regla15_14.setListaTemas(temasR15_14);
		regla15_14.Respuesta = "Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo, <br>" + 
				"guardapolvo), y ésta debe quedar en el ámbito laboral.";
		reglasPersonalSalud.add(regla15_14);
		temasR15_14.add(t19);//recomendación
		temasR15_14.add(t35);//medico/enfermero

////////////////////R		(Reglas que implican personal de la salud)
		ArrayList<Tema> temasR16_1 = new ArrayList<Tema>();
		Rule regla16_1 = new Rule();
		regla16_1.setId(16_1);
		regla16_1.setListaTemas(temasR16_1);
		regla16_1.Respuesta = "Siendo usted personal de la salud se le recomienda:<br>1- Realizar higiene de manos frecuente durante las tareas asistenciales, y en<br>" + 
				"momentos de tareas no asistenciales.<br>" + 
				"2- Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.<br>" + 
				"3- No llevarse las manos a la cara.<br>" + 
				"4- Ventilar bien los ambientes del lugar de trabajo.<br>" + 
				"5- Desinfectar los objetos que se usan con frecuencia.<br>" + 
				"6- No compartir mate, vajilla o utensilios en el trabajo.<br>" + 
				"7- Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo,<br>" + 
				"guardapolvo), y ésta debe quedar en el ámbito laboral. <br>";
		regla16_1.setReglasImplicadas(reglasPersonalSalud); //habilita las preguntas del personal de la salud
		reglasGenerales.add(regla16_1);
		temasR16_1.add(t21);//ser
		temasR16_1.add(t31);//personal
		temasR16_1.add(t32);//salud
		
		ArrayList<Integer> reglasAEliminarPersonalSalud = new ArrayList<Integer>();
		reglasAEliminarPersonalSalud.add(16_1);
		reglasAEliminarPersonalSalud.add(16_2);
		reglasAEliminarPersonalSalud.add(16_3);
		reglasAEliminarPersonalSalud.add(16_4);
		regla16_1.setIdsReglasAEliminar(reglasAEliminarPersonalSalud);

////////////////////R
		ArrayList<Tema> temasR16_2 = new ArrayList<Tema>();
		Rule regla16_2 = new Rule();
		regla16_2.setId(16_2);
		regla16_2.setListaTemas(temasR16_2);
		regla16_2.Respuesta = "Siendo usted personal de la salud se le recomienda:<br>1- Realizar higiene de manos frecuente durante las tareas asistenciales, y en<br>" + 
				"momentos de tareas no asistenciales.<br>" + 
				"2- Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.<br>" + 
				"3- No llevarse las manos a la cara.<br>" + 
				"4- Ventilar bien los ambientes del lugar de trabajo.<br>" + 
				"5- Desinfectar los objetos que se usan con frecuencia.<br>" + 
				"6- No compartir mate, vajilla o utensilios en el trabajo.<br>" + 
				"7- Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo,<br>" + 
				"guardapolvo), y ésta debe quedar en el ámbito laboral. <br>";
		regla16_2.setReglasImplicadas(reglasPersonalSalud); //habilita las preguntas del personal de la salud
		reglasGenerales.add(regla16_2);
		temasR16_2.add(t21);//ser
		temasR16_2.add(t33);//trabajador
		temasR16_2.add(t32);//salud
		
		regla16_2.setIdsReglasAEliminar(reglasAEliminarPersonalSalud);

////////////////////R
		ArrayList<Tema> temasR16_3 = new ArrayList<Tema>();
		Rule regla16_3 = new Rule();
		regla16_3.setId(16_3);
		regla16_3.setListaTemas(temasR16_3);
		regla16_3.Respuesta = "Siendo usted personal de la salud se le recomienda:<br>1- Realizar higiene de manos frecuente durante las tareas asistenciales, y en<br>" + 
			"momentos de tareas no asistenciales.<br>" + 
			"2- Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.<br>" + 
			"3- No llevarse las manos a la cara.<br>" + 
			"4- Ventilar bien los ambientes del lugar de trabajo.<br>" + 
			"5- Desinfectar los objetos que se usan con frecuencia.<br>" + 
			"6- No compartir mate, vajilla o utensilios en el trabajo.<br>" + 
			"7- Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo,<br>" + 
			"guardapolvo), y ésta debe quedar en el ámbito laboral. <br>";
		regla16_3.setReglasImplicadas(reglasPersonalSalud); //habilita las preguntas del personal de la salud
		reglasGenerales.add(regla16_3);
		temasR16_3.add(t33);//trabajador
		temasR16_3.add(t34);//hospital
		
		regla16_3.setIdsReglasAEliminar(reglasAEliminarPersonalSalud);

////////////////////R
		ArrayList<Tema> temasR16_4 = new ArrayList<Tema>();
		Rule regla16_4 = new Rule();
		regla16_4.setId(16_4);
		regla16_4.setListaTemas(temasR16_4);
		regla16_4.Respuesta = "Siendo usted personal de la salud se le recomienda:<br>1- Realizar higiene de manos frecuente durante las tareas asistenciales, y en <br>" + 
		"momentos de tareas no asistenciales.<br>" + 
		"2- Toser o estornudar sobre el pliegue del codo o utilizar pañuelos descartables.<br>" + 
		"3- No llevarse las manos a la cara.<br>" + 
		"4- Ventilar bien los ambientes del lugar de trabajo.<br>" + 
		"5- Desinfectar los objetos que se usan con frecuencia.<br>" + 
		"6- No compartir mate, vajilla o utensilios en el trabajo.<br>" + 
		"7- Durante la jornada laboral, se debe utilizar ropa específica de trabajo (ambo,<br>" + 
		"guardapolvo), y ésta debe quedar en el ámbito laboral. <br>";
		regla16_4.setReglasImplicadas(reglasPersonalSalud); //habilita las preguntas del personal de la salud
		reglasGenerales.add(regla16_4);
		temasR16_4.add(t21);//ser
		temasR16_4.add(t35);//medico/enfermero
		
		regla16_4.setIdsReglasAEliminar(reglasAEliminarPersonalSalud);



		
		
		
		
		



/////////////////////////////////////////////////////////////////////////////////////////////////
//CASOS DE ENCUESTA
////////////////////R
//No es paciente de riesgo...probablemente tenga covid:
		ArrayList<Tema> temasR103_1 = new ArrayList<Tema>();
		Rule regla103_1 = new Rule();
		regla103_1.setId(103_1);
		regla103_1.setListaTemas(temasR103_1);
		regla103_1.Respuesta = "Manténgase tranquilo, usted no es paciente de riesgo. Si la situación empeora "
		+ "no dude en buscar asistencia médica. ¿Tiene alguna pregunta para hacer?";
		//reglasGenerales.add(regla103_1);
		temasR103_1.add(tsi);//afirmación
		
		regla103_1.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		
		regla103_1.getReglasImplicadas().addAll(reglasGenerales);
		regla103_1.getReglasImplicadas().addAll(reglasNoRiesgoSiInfectado);		//Implica todas las reglas de persona sin riesgo con covid


////////////////////R				
//Sí es paciente de riesgo...probablemente tenga covid:
		ArrayList<Tema> temasR103_2 = new ArrayList<Tema>();
		Rule regla103_2 = new Rule();
		regla103_2.setId(103_2);
		regla103_2.setListaTemas(temasR103_2);
		regla103_2.Respuesta = "Le recomendamos que busque atención médica, no quisiéramos que su salud empeore.<br>"
		+ "¿Desea saber algo más?";
		//reglasGenerales.add(regla103_2);
		temasR103_2.add(tsi);//afirmación
		
		regla103_2.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		
		regla103_2.getReglasImplicadas().addAll(reglasGenerales);
		regla103_2.getReglasImplicadas().addAll(reglasSiRiesgoSiInfectado);		//Implica todas las reglas de persona con riesgo con covid




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////Rb
//No es paciente de riesgo...cree que puede tener covid? NO:
		ArrayList<Tema> temasR102_3 = new ArrayList<Tema>();
		Rule regla102_3 = new Rule();
		regla102_3.setId(102_3);
		regla102_3.setListaTemas(temasR102_3);
		regla102_3.Respuesta = "Excelente! Eso fue todo. ¿Tiene alguna pregunta para hacer?";
		//reglasGenerales.add(regla102_3);
		temasR102_3.add(tno);//negación
		
		regla102_3.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		
		regla102_3.getReglasImplicadas().addAll(reglasGenerales);
		regla102_3.getReglasImplicadas().addAll(reglasNoRiesgoNoInfectado);		//implicar todas las reglas de persona sin riesgo sin covid


////////////////////Rb
//Sí es paciente de riesgo...cree que puede tener covid? NO:
		ArrayList<Tema> temasR102_4 = new ArrayList<Tema>();
		Rule regla102_4 = new Rule();
		regla102_4.setId(102_4);
		regla102_4.setListaTemas(temasR102_4);
		regla102_4.Respuesta = "Excelente! Eso fue todo. ¿Tiene alguna pregunta para hacer?";
		//reglasGenerales.add(regla102_4);
		temasR102_4.add(tno);//negación
		
		regla102_4.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		
		regla102_4.getReglasImplicadas().addAll(reglasGenerales);
		regla102_4.getReglasImplicadas().addAll(reglasSiRiesgoNoInfectado);		//Implicar todas las reglas de paciente de riesgo sin covid


////////////////////Ra
//No es paciente de riesgo...cree que puede tener covid? SÍ:
		ArrayList<Tema> temasR102_1 = new ArrayList<Tema>();
		Rule regla102_1 = new Rule();
		regla102_1.setId(102_1);
		regla102_1.setListaTemas(temasR102_1);
		regla102_1.Respuesta = "Veamos...¿tiene usted fiebre, tos (seca), y principalmente, "
				+ "tiene dificultades respiratorias? (si la respuesta es no, no hay "
				+ "motivos para preocuparse).";
		//reglasGenerales.add(regla102_1);
		temasR102_1.add(tsi);//afirmación
		
		regla102_1.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla102_1.getReglasImplicadas().add(regla103_1);
		regla102_1.getReglasImplicadas().add(regla102_3);

////////////////////Ra				
//Sí es paciente de riesgo...cree que puede tener covid? SÍ:
		ArrayList<Tema> temasR102_2 = new ArrayList<Tema>();
		Rule regla102_2 = new Rule();
		regla102_2.setId(102_2);
		regla102_2.setListaTemas(temasR102_2);
		regla102_2.Respuesta = "Veamos...¿tiene usted fiebre, tos (seca), y principalmente, "
				+ "tiene dificultades respiratorias? (si la respuesta es no, no hay "
				+ "motivos para preocuparse).";
		//reglasGenerales.add(regla102_2);
		temasR102_2.add(tsi);//afirmación
		
		regla102_2.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  1:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla102_2.getReglasImplicadas().add(regla103_2);
		regla102_2.getReglasImplicadas().add(regla102_4);





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////R
//Tiene características que implican que es paciente de riesgo? SÍ:
		ArrayList<Tema> temasR101_1 = new ArrayList<Tema>();
		Rule regla101_1 = new Rule();
		regla101_1.setId(101_1);
		regla101_1.setListaTemas(temasR101_1);
		regla101_1.Respuesta = "Entendido. ¿Está usted en duda de ser portador de la enfermedad COVID-19?";
		//reglasGenerales.add(regla101_1);
		temasR101_1.add(tsi);//afirmación
		
		regla101_1.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla101_1.getReglasImplicadas().add(regla102_2);
		regla101_1.getReglasImplicadas().add(regla102_4);

////////////////////R
//Tiene características que implican que es paciente de riesgo? NO:
		ArrayList<Tema> temasR101_2 = new ArrayList<Tema>();
		Rule regla101_2 = new Rule();
		regla101_2.setId(101_2);
		regla101_2.setListaTemas(temasR101_2);
		regla101_2.Respuesta = "Perfecto. ¿Está usted en duda de ser portador de la enfermedad COVID-19?";
		//reglasGenerales.add(regla101_2);
		temasR101_2.add(tno);//negación
		
		regla101_2.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla101_2.getReglasImplicadas().add(regla102_1);
		regla101_2.getReglasImplicadas().add(regla102_3);




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Reglas respuestas encuesta rápida
////////////////////R
//Paciente de riesgo? SÍ:
		ArrayList<Tema> temasR100_1 = new ArrayList<Tema>();
		Rule regla100_1 = new Rule();
		regla100_1.setId(100_1);
		regla100_1.setListaTemas(temasR100_1);
		regla100_1.Respuesta = "Entendido. ¿Está usted en duda de ser portador de la enfermedad COVID-19?";
		//reglasGenerales.add(regla100_1);
		temasR100_1.add(tsi);//afirmación
		
		regla100_1.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla100_1.getReglasImplicadas().add(regla102_2);
		regla100_1.getReglasImplicadas().add(regla102_4);

////////////////////R
//Paciente de riesgo? NO:
		ArrayList<Tema> temasR100_2 = new ArrayList<Tema>();
		Rule regla100_2 = new Rule();
		regla100_2.setId(100_2);
		regla100_2.setListaTemas(temasR100_2);
		regla100_2.Respuesta = "Perfecto. ¿Está usted en duda de ser portador de la enfermedad COVID-19?";
		//reglasGenerales.add(regla100_2);
		temasR100_2.add(tno);//negación
		
		regla100_2.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla100_2.getReglasImplicadas().add(regla102_1);
		regla100_2.getReglasImplicadas().add(regla102_3);

////////////////////R
//Paciente de riesgo? NO SÉ:
		ArrayList<Tema> temasR100_3 = new ArrayList<Tema>();
		Rule regla100_3 = new Rule();
		regla100_3.setId(100_3);
		regla100_3.setListaTemas(temasR100_3);
		regla100_3.Respuesta = "No se preocupe, podemos averiguarlo.<br> ¿Es usted mayor de 60 años, "
		+ "tiene enfermedades respiratorias o cardiovasculares, o tiene usted diabetes? (al menos una opción).";
		//reglasGenerales.add(regla100_3);
		temasR100_3.add(tno);//negación
		temasR100_3.add(tsaber);//saber
		
		regla100_3.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		regla100_3.getReglasImplicadas().add(regla101_1);
		regla100_3.getReglasImplicadas().add(regla101_2);



/////////////////////////////////////////////////////////////////////////////////////////////////

//Regla inicial
//Hola:
////////////////////R
		ArrayList<Tema> temasR100_0 = new ArrayList<Tema>();
		Rule regla100_0 = new Rule();
		regla100_0.setId(100_0);
		regla100_0.setListaTemas(temasR100_0);
		regla100_0.Respuesta = "Hola! Antes de empezar debemos hacerle una serie de preguntas.<br>"
		+ "¿Es usted paciente de riesgo?";
		//reglasGenerales.add(regla100_0);
		temasR100_0.add(t1);//saludo
		
		regla100_0.getReglasImplicadas().add(regla100_1);
		regla100_0.getReglasImplicadas().add(regla100_2);
		regla100_0.getReglasImplicadas().add(regla100_3);
		
		regla100_0.setAcciones(Rule.IMPLICAREGLASYELIMINAANTERIORES);//  2:implicar reglas y borrar todas las reglas anteriores de la MP
		
		ChatbotAgent.reglaInicial = regla100_0;




/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		return reglasGenerales;
	}
	
	
	
	
	
	
	
	

	public void empezarConversacion() {
		ChatbotEnvironment.reglasMemoriaProduccion.add(ChatbotAgent.reglaInicial);
	}
	
	public String ejecutarRegla(String entradaUsuario) {
		
		InterfaceUpdater.addToLog("TEXTO ENTRADA DEL USUARIO: " + entradaUsuario);
		
		String respuesta = new String();
		ArrayList<String> palabrasUtiles = GestorDeFrases.palabrasUtiles(entradaUsuario);
		GestorDeFrases.matcheoRules(palabrasUtiles);
		
		ArrayList<Rule> reglasAEjecutar = Specificity.ejecutarCriterio();
		if(reglasAEjecutar.size() == 1) {
			Rule reglaAEjecutar = reglasAEjecutar.get(0);
			respuesta = reglaAEjecutar.Respuesta;
			
			ChatbotEnvironment.inferencia(reglaAEjecutar);
			ultimaRespuestaAgente = respuesta;
		}
		else {
			InterfaceUpdater.addToLog("SIN COINCIDENCIA.");
			respuesta = "Ups! No cuento con información para entender esa pregunta, intente ser más específico por favor :(<br>"
					+ "Lo último que le había dicho era:<br>"
					+ this.ultimaRespuestaAgente;
		}
		
		InterfaceUpdater.addToLog("RESPUESTA DEVUELTA POR EL AGENTE: "+ respuesta + "\r\n");
		System.out.println("Respuesta devuelta por el agente: "+ respuesta);
		
		return respuesta;
		
		
		

	}
	
	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String learn (String entradaUsuario) {
		
		InterfaceUpdater.addToLog("TEXTO ENTRADA DEL USUARIO: " + entradaUsuario);
		
		//1. Especificidad
		//2. No Duplicidad
		//3. Prioridad
		//4. Aleatorio
		
		System.out.println(entradaUsuario);
		
		String respuesta = new String();
		ArrayList<String> palabrasUtiles = GestorDeFrases.palabrasUtiles(entradaUsuario);
		GestorDeFrases.matcheoRules(palabrasUtiles);
		
		//Especificidad
		System.out.println("Especificidad");
		ArrayList<Rule> reglasAEjecutar = Specificity.ejecutarCriterio();
		if(reglasAEjecutar.size() == 1) {
			respuesta = reglasAEjecutar.get(0).Respuesta;
			reglasAEjecutar.get(0).setNoDuplication(reglasAEjecutar.get(0).getNoDuplication()+1);
			ChatbotEnvironment.inferencia(reglasAEjecutar.get(0));
		}
		else if(reglasAEjecutar.get(0).getSpecificity() != 0){
			
			//No duplicación
			System.out.println("No duplicación");
			reglasAEjecutar = NoDuplication.ejecutarCriterio(reglasAEjecutar);
			if(reglasAEjecutar.size() == 1) {
				respuesta = reglasAEjecutar.get(0).Respuesta;
				reglasAEjecutar.get(0).setNoDuplication(reglasAEjecutar.get(0).getNoDuplication()+1);
				ChatbotEnvironment.inferencia(reglasAEjecutar.get(0));
			}
			else {
				//Prioridad
				System.out.println("Prioridad");
				reglasAEjecutar = Priority.ejecutarCriterio(reglasAEjecutar);
				if(reglasAEjecutar.size() == 1) {
					respuesta = reglasAEjecutar.get(0).Respuesta;
					reglasAEjecutar.get(0).setNoDuplication(reglasAEjecutar.get(0).getNoDuplication()+1);
					ChatbotEnvironment.inferencia(reglasAEjecutar.get(0));
				}
				else {
					//Random
					System.out.println("Random");
					reglasAEjecutar = RandomCriterio.ejecutarCriterio(reglasAEjecutar);
					respuesta = reglasAEjecutar.get(0).Respuesta;
					reglasAEjecutar.get(0).setNoDuplication(reglasAEjecutar.get(0).getNoDuplication()+1);
					ChatbotEnvironment.inferencia(reglasAEjecutar.get(0));
				}
			}
		}
		else {
			InterfaceUpdater.addToLog("SIN COINCIDENCIA.");
			respuesta = "Ups! No cuento con información para entender esa pregunta, intente ser más específico por favor  :(<br>";
		}
		
		InterfaceUpdater.addToLog("RESPUESTA DEVUELTA POR EL AGENTE: "+ respuesta + "\r\n");
		System.out.println("Respuesta devuelta por el agente: "+ respuesta);
		return respuesta;
		
	}
	
	public String see() {
		String textoUsuario = ChatbotEnvironment.respuestaUsuario;
		ChatbotEnvironment.respuestaUsuario = null;
		return textoUsuario;
	}
	
}
