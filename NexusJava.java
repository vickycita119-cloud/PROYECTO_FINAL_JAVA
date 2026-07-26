import java.util.Scanner;

public class NexusJava {

    static Scanner scanner = new Scanner(System.in);

    //==========================================================
    // ARREGLOS DE PROFESORES
    //==========================================================

    static String[] nombreProfesor = new String[3];
    static String[] usuarioProfesor = new String[3];
    static String[] claveProfesor = new String[3];
    static String[] materiaProfesor = new String[3];

    //==========================================================
    // ARREGLOS DE ESTUDIANTES
    //==========================================================

    static String[] nombreEstudiante = new String[30];
    static String[] usuarioEstudiante = new String[30];
    static String[] claveEstudiante = new String[30];
    static String[] cursoEstudiante = new String[30];

    //==========================================================
    // NOTAS
    //==========================================================

    static double[] notaLM1 = new double[30];
    static double[] notaLM2 = new double[30];

    static double[] notaTP1 = new double[30];
    static double[] notaTP2 = new double[30];

    static double[] notaLC1 = new double[30];
    static double[] notaLC2 = new double[30];

    //==========================================================
    // CALCULOS ACADEMICOS
    //==========================================================

    static double[] promedioLM = new double[30];
    static double[] promedioTP = new double[30];
    static double[] promedioLC = new double[30];

    static double[] promedioFinal = new double[30];

    static int[] indiceRiesgo = new int[30];
    static double[] porcentajeAprobacion = new double[30];

    static String[] nivelRiesgo = new String[30];
    static String[] estadoAcademico = new String[30];

    //==========================================================
    // ANALISIS
    //==========================================================

    static String[] materiaMejor = new String[30];
    static String[] materiaPeor = new String[30];

    static String[] evolucionLM = new String[30];
    static String[] evolucionTP = new String[30];
    static String[] evolucionLC = new String[30];

    //==========================================================
    // CONJUNTOS
    //==========================================================

    static String[] conjuntoAltoRendimiento = new String[30];
    static String[] conjuntoRiesgo = new String[30];
    static String[] conjuntoTutorias = new String[30];
    static String[] conjuntoReconocimiento = new String[30];


    //==========================================================
    // FUNCIONES PRINCIPALES
    //==========================================================

    static double calcularPromedioPonderado(
            double notaLM,
            double notaTP,
            double notaLC) {

        return (notaLM * 0.40) + (notaTP * 0.40) + (notaLC * 0.20);
    }


    static int calcularIndiceRiesgo(
            double notaLM,
            double notaTP,
            double notaLC) {

        int riesgo = 0;

        if (notaLM < 7) {
            riesgo++;
        }

        if (notaTP < 7) {
            riesgo++;
        }

        if (notaLC < 7) {
            riesgo++;
        }

        return riesgo;
    }


    static double calcularPorcentajeAprobacion(int riesgo) {

        int materiasAprobadas = 3 - riesgo;

        return (materiasAprobadas / 3.0) * 100;
    }


    static String obtenerNivelRiesgo(int riesgo) {

        if (riesgo == 0) {
            return "BAJO";
        } else if (riesgo == 1) {
            return "MEDIO";
        } else {
            return "ALTO";
        }
    }


    static String obtenerEstadoAcademico(double promedio) {

        if (promedio >= 9) {
            return "EXCELENTE";
        } else if (promedio >= 7) {
            return "APROBADO";
        } else if (promedio >= 5) {
            return "RIESGO";
        } else {
            return "CRITICO";
        }
    }


    static String analizarEvolucion(
            double notaInicial,
            double notaFinal) {

        if (notaFinal > notaInicial) {
            return "MEJORA";
        } else if (notaFinal == notaInicial) {
            return "SE MANTIENE";
        } else {
            return "DISMINUYE";
        }
    }


    //==========================================================
    // SUBPROCESOS GENERALES
    //==========================================================

    static void limpiarConsola() {

        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }


    static void mostrarEncabezado() {

        System.out.println("==========================================");
        System.out.println("              N.E.X.U.S. v3.0");
        System.out.println(" Nucleo Estrategico para la eXperiencia");
        System.out.println("       Universitaria Smart");
        System.out.println("          CAMPUS INTELIGENTE");
        System.out.println("==========================================");
        System.out.println();
    }


    static void mostrarTitulo(String titulo) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println(titulo);
        System.out.println("==========================================");
        System.out.println();
    }

    
    static void esperarContinuar() {

        System.out.println();
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine();
    }


    static void mostrarSalida() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Gracias por utilizar N.E.X.U.S. v3.0");
        System.out.println("Sistema Campus Inteligente");
        System.out.println("==========================================");
    }


    //==========================================================
    // CARGA DE DATOS
    //==========================================================

    static void cargarDatos() {

        //======================================================
        // PROFESORES
        //======================================================

        nombreProfesor[0] = "Richard Sucuy";
        usuarioProfesor[0] = "rsucuy";
        claveProfesor[0] = "RS2026";
        materiaProfesor[0] = "Logica Matematica";

        nombreProfesor[1] = "Carlos Vargas";
        usuarioProfesor[1] = "cvargas";
        claveProfesor[1] = "CV2026";
        materiaProfesor[1] = "Tecnicas de Programacion";

        nombreProfesor[2] = "Elmer Gallardo";
        usuarioProfesor[2] = "egallardo";
        claveProfesor[2] = "EG2026";
        materiaProfesor[2] = "Lenguaje y Comunicacion";


        //======================================================
        // ESTUDIANTES
        //======================================================

        String[] nombres = {

            "Juan Perez", "Maria Gomez", "Carlos Ruiz",
            "Ana Torres", "Luis Herrera", "Sofia Castro",
            "Diego Morales", "Valeria Rios", "Andres Vega",
            "Camila Ortiz",

            "Jorge Mena", "Paula Diaz", "Kevin Luna",
            "Daniela Cruz", "Miguel Leon", "Fernanda Silva",
            "Jose Paredes", "Andrea Reyes", "Bryan Flores",
            "Natalia Vera",

            "David Salazar", "Gabriela Mora", "Cristian Naranjo",
            "Isabella Cueva", "Steven Jimenez", "Melissa Romero",
            "Alex Mendoza", "Vanessa Rojas", "Fernando Arias",
            "Lucia Cabrera"
        };


        String[] usuarios = {

            "juan01", "maria02", "carlos03",
            "ana04", "luis05", "sofia06",
            "diego07", "vale08", "andres09",
            "camila10",

            "jorge11", "paula12", "kevin13",
            "dani14", "miguel15", "fer16",
            "jose17", "andrea18", "bryan19",
            "nata20",

            "david21", "gaby22", "cris23",
            "isa24", "steven25", "meli26",
            "alex27", "vane28", "fer29",
            "lucia30"
        };


        String[] claves = {

            "JP001", "MG002", "CR003",
            "AT004", "LH005", "SC006",
            "DM007", "VR008", "AV009",
            "CO010",

            "JM011", "PD012", "KL013",
            "DC014", "ML015", "FS016",
            "JP017", "AR018", "BF019",
            "NV020",

            "DS021", "GM022", "CN023",
            "IC024", "SJ025", "MR026",
            "AM027", "VR028", "FA029",
            "LC030"
        };


        for (int i = 0; i < 30; i++) {

            nombreEstudiante[i] = nombres[i];
            usuarioEstudiante[i] = usuarios[i];
            claveEstudiante[i] = claves[i];

            if (i < 10) {
                cursoEstudiante[i] = "A";
            } else if (i < 20) {
                cursoEstudiante[i] = "B";
            } else {
                cursoEstudiante[i] = "C";
            }
        }


        //======================================================
        // NOTAS
        //======================================================

        double[][] notas = {

            {10,10,9,10,10,9},
            {9,10,10,9,9,10},
            {8,8,7,8,8,7},
            {7,8,8,7,7,8},
            {8,7,8,8,7,7},
            {5,8,6,9,7,8},
            {6,9,5,8,6,9},
            {5,6,8,7,6,5},
            {6,5,6,5,8,6},
            {4,6,7,6,5,6},

            {9,9,10,9,9,10},
            {7,7,8,7,8,7},
            {5,5,6,5,6,5},
            {3,4,5,3,4,5},
            {8,9,7,8,8,9},
            {6,7,7,8,6,7},
            {4,5,5,4,6,5},
            {9,10,9,10,10,9},
            {7,6,7,7,8,7},
            {5,6,6,5,5,6},

            {10,9,10,10,9,10},
            {8,8,7,8,8,7},
            {6,5,6,5,7,6},
            {4,3,5,4,5,4},
            {9,9,8,9,10,9},
            {7,8,7,7,8,8},
            {5,7,6,7,5,6},
            {8,9,9,8,8,9},
            {6,6,5,6,7,6},
            {3,4,4,3,5,4}
        };


        for (int i = 0; i < 30; i++) {

            notaLM1[i] = notas[i][0];
            notaLM2[i] = notas[i][1];

            notaTP1[i] = notas[i][2];
            notaTP2[i] = notas[i][3];

            notaLC1[i] = notas[i][4];
            notaLC2[i] = notas[i][5];
        }
    }


    //==========================================================
    // PROCESAMIENTO AUTOMATICO
    //==========================================================

    static void procesarDatos() {

        for (int i = 0; i < 30; i++) {

            promedioLM[i] =
                    (notaLM1[i] + notaLM2[i]) / 2;

            promedioTP[i] =
                    (notaTP1[i] + notaTP2[i]) / 2;

            promedioLC[i] =
                    (notaLC1[i] + notaLC2[i]) / 2;


            promedioFinal[i] =
                    calcularPromedioPonderado(
                            promedioLM[i],
                            promedioTP[i],
                            promedioLC[i]);


            indiceRiesgo[i] =
                    calcularIndiceRiesgo(
                            promedioLM[i],
                            promedioTP[i],
                            promedioLC[i]);


            porcentajeAprobacion[i] =
                    calcularPorcentajeAprobacion(
                            indiceRiesgo[i]);


            estadoAcademico[i] =
                    obtenerEstadoAcademico(
                            promedioFinal[i]);


            nivelRiesgo[i] =
                    obtenerNivelRiesgo(
                            indiceRiesgo[i]);


            // MATERIA MEJOR

            materiaMejor[i] = "Logica Matematica";

            double mayorNota = promedioLM[i];

            if (promedioTP[i] > mayorNota) {

                materiaMejor[i] =
                        "Tecnicas de Programacion";

                mayorNota = promedioTP[i];
            }

            if (promedioLC[i] > mayorNota) {

                materiaMejor[i] =
                        "Lenguaje y Comunicacion";
            }


            // MATERIA PEOR

            materiaPeor[i] = "Logica Matematica";

            double menorNota = promedioLM[i];

            if (promedioTP[i] < menorNota) {

                materiaPeor[i] =
                        "Tecnicas de Programacion";

                menorNota = promedioTP[i];
            }

            if (promedioLC[i] < menorNota) {

                materiaPeor[i] =
                        "Lenguaje y Comunicacion";
            }


            // EVOLUCION

            evolucionLM[i] =
                    analizarEvolucion(
                            notaLM1[i],
                            notaLM2[i]);

            evolucionTP[i] =
                    analizarEvolucion(
                            notaTP1[i],
                            notaTP2[i]);

            evolucionLC[i] =
                    analizarEvolucion(
                            notaLC1[i],
                            notaLC2[i]);


            // CONJUNTOS

            conjuntoAltoRendimiento[i] =
                    promedioFinal[i] >= 9 ? "SI" : "NO";


            conjuntoRiesgo[i] =
                    indiceRiesgo[i] >= 1 ? "SI" : "NO";


            conjuntoTutorias[i] =
                    indiceRiesgo[i] >= 2 ? "SI" : "NO";


            conjuntoReconocimiento[i] =
                    promedioFinal[i] >= 9
                    && indiceRiesgo[i] == 0
                    ? "SI" : "NO";
        }
    }


    //==========================================================
    // PANEL DEL ESTUDIANTE
    //==========================================================

    static void panelEstudiante(int posicion) {

    int opcion;

    do {

        limpiarConsola();

        System.out.println("==========================================");
        System.out.println("          PANEL DEL ESTUDIANTE");
        System.out.println("==========================================");

        System.out.println();
        System.out.println("Estudiante: "
                + nombreEstudiante[posicion]);

        System.out.println("Curso: "
                + cursoEstudiante[posicion]);

        System.out.println();

        System.out.println("1. Ver rendimiento academico");
        System.out.println("2. Ver diagnostico inteligente");
        System.out.println("3. Ver recomendaciones");
        System.out.println("4. Cerrar sesion");

        opcion = scanner.nextInt();
        scanner.nextLine();


        switch (opcion) {

            case 1:

                limpiarConsola();

                System.out.println("========= RENDIMIENTO ACADEMICO =========");

                System.out.println();
                System.out.println("Logica Matematica: "
                        + promedioLM[posicion]);

                System.out.println("Tecnicas de Programacion: "
                        + promedioTP[posicion]);

                System.out.println("Lenguaje y Comunicacion: "
                        + promedioLC[posicion]);

                System.out.println();
                System.out.println("Promedio ponderado: "
                        + promedioFinal[posicion]);

                System.out.println("Porcentaje aprobado: "
                        + porcentajeAprobacion[posicion]
                        + "%");

                esperarContinuar();

                break;


            case 2:

                limpiarConsola();

                System.out.println("========= DIAGNOSTICO N.E.X.U.S. =========");

                System.out.println();
                System.out.println("Estado academico: "
                        + estadoAcademico[posicion]);

                System.out.println("Indice de riesgo: "
                        + indiceRiesgo[posicion]);

                System.out.println("Nivel de riesgo: "
                        + nivelRiesgo[posicion]);

                System.out.println();

                if (indiceRiesgo[posicion] == 0) {

                    System.out.println("Diagnostico:");
                    System.out.println(
                            "El estudiante mantiene un rendimiento estable.");

                } else if (indiceRiesgo[posicion] == 1) {

                    System.out.println("Diagnostico:");
                    System.out.println(
                            "Se detecta una materia que requiere seguimiento.");

                } else {

                    System.out.println("Diagnostico:");
                    System.out.println(
                            "El estudiante necesita intervencion academica.");
                }

                esperarContinuar();

                break;


            case 3:

                limpiarConsola();

                System.out.println(
                        "====== RECOMENDACIONES DEL SISTEMA ======");

                System.out.println();

                if (conjuntoTutorias[posicion].equals("SI")) {

                    System.out.println(
                            "Tutorias recomendadas: SI");

                    System.out.println(
                            "El estudiante posee dos o mas materias en riesgo.");

                } else {

                    System.out.println(
                            "Tutorias recomendadas: NO");

                    System.out.println(
                            "El estudiante mantiene un nivel aceptable.");
                }


                if (promedioLM[posicion] < 7
                        && promedioTP[posicion] < 7) {

                    System.out.println();
                    System.out.println(
                            "Curso de refuerzo recomendado:");

                    System.out.println(
                            "Logica Matematica y Programacion.");
                }


                if (porcentajeAprobacion[posicion] < 50) {

                    System.out.println();
                    System.out.println(
                            "Prioridad de seguimiento: ALTA");

                    System.out.println(
                            "Menos del 50% de materias aprobadas.");
                }


                System.out.println();
                System.out.println("Recomendacion final:");

                if (promedioFinal[posicion] >= 9) {

                    System.out.println(
                            "Mantener rendimiento y participar en programas de excelencia.");

                } else {

                    System.out.println(
                            "Continuar fortaleciendo las areas detectadas por el sistema.");
                }

                esperarContinuar();

                break;
        }

    } while (opcion != 4);


    limpiarConsola();

    System.out.println("==========================================");
    System.out.println("       CIERRE DE SESION DEL ESTUDIANTE");
    System.out.println("==========================================");

    System.out.println();
    System.out.println("Estudiante: "
            + nombreEstudiante[posicion]);

    System.out.println("Promedio final: "
            + promedioFinal[posicion]);

    System.out.println();


    if (promedioFinal[posicion] >= 9) {

        System.out.println(
                "Excelente trabajo. Tu esfuerzo y dedicacion se reflejan en tus resultados.");

        System.out.println(
                "Continua manteniendo este gran nivel academico.");

    } else if (promedioFinal[posicion] >= 7) {

        System.out.println(
                "Buen trabajo. Has logrado aprobar tu rendimiento academico.");

        System.out.println(
                "Sigue esforzandote para alcanzar un nivel aun mas alto.");

    } else if (promedioFinal[posicion] >= 5) {

        System.out.println(
                "No te rindas. Todavia tienes la oportunidad de mejorar.");

        System.out.println(
                "Con esfuerzo, constancia y apoyo puedes superar tus dificultades.");

    } else {

        System.out.println(
                "No permitas que una calificacion defina tu capacidad.");

        System.out.println(
                "Este resultado es una oportunidad para comenzar a mejorar.");

        System.out.println(
                "N.E.X.U.S. te recomienda buscar apoyo academico y continuar esforzandote.");
    }


    System.out.println();
    System.out.println(
            "Sesion de estudiante cerrada correctamente.");

    esperarContinuar();
}


    //==========================================================
    // PANEL DEL PROFESOR
    //==========================================================

    static void panelProfesor(int posicionProfesor) {

        int opcion;

        do {

            limpiarConsola();

            System.out.println("==========================================");
            System.out.println("          PANEL DEL PROFESOR");
            System.out.println("==========================================");

            System.out.println();
            System.out.println("Profesor: "
                    + nombreProfesor[posicionProfesor]);

            System.out.println("Materia: "
                    + materiaProfesor[posicionProfesor]);

            System.out.println();

            System.out.println("1. Ver estudiantes por paralelo");
            System.out.println("2. Indicadores del curso");
            System.out.println("3. Ver estudiantes en riesgo");
            System.out.println("4. Cerrar sesion");

            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {

                case 1:

                    mostrarEstudiantesPorMateria(posicionProfesor);

                    break;


                case 2:

                    mostrarIndicadores(posicionProfesor);

                    break;


                case 3:

                    mostrarEstudiantesEnRiesgo(posicionProfesor);

                    break;
            }

        } while (opcion != 4);


        limpiarConsola();

        System.out.println("========= RECOMENDACION DEL SISTEMA =========");

        System.out.println();
        System.out.println("Profesor: "
                + nombreProfesor[posicionProfesor]);

        System.out.println("Materia: "
                + materiaProfesor[posicionProfesor]);

        System.out.println();

        System.out.println(
                "Aumentar tutorias para estudiantes con promedio menor a 7.");

        System.out.println();
        System.out.println(
                "Frecuencia sugerida:");

        System.out.println(
                "2 sesiones semanales de refuerzo.");

        System.out.println();
        System.out.println(
                "Sesion cerrada correctamente.");

        esperarContinuar();
    }


    static double obtenerPromedioMateria(
            int profesor,
            int estudiante) {

        if (materiaProfesor[profesor]
                .equals("Logica Matematica")) {

            return promedioLM[estudiante];

        } else if (materiaProfesor[profesor]
                .equals("Tecnicas de Programacion")) {

            return promedioTP[estudiante];

        } else {

            return promedioLC[estudiante];
        }
    }


static void mostrarEstudiantesPorMateria(
        int posicionProfesor) {

    limpiarConsola();

    System.out.println(
            "========= RANKING DE LA MATERIA =========");

    System.out.println();

    System.out.println(
            "Profesor: "
            + nombreProfesor[posicionProfesor]);

    System.out.println(
            "Materia: "
            + materiaProfesor[posicionProfesor]);

    System.out.println();

    int[] posiciones = new int[30];

    for (int i = 0; i < 30; i++) {

        posiciones[i] = i;
    }


    for (int i = 0; i < 29; i++) {

        for (int j = i + 1; j < 30; j++) {

            double notaActual =
                    obtenerPromedioMateria(
                            posicionProfesor,
                            posiciones[i]);

            double notaSiguiente =
                    obtenerPromedioMateria(
                            posicionProfesor,
                            posiciones[j]);


            if (notaSiguiente > notaActual) {

                int aux = posiciones[i];

                posiciones[i] = posiciones[j];

                posiciones[j] = aux;
            }
        }
    }


    for (int i = 0; i < 30; i++) {

        int posicion = posiciones[i];

        double nota =
                obtenerPromedioMateria(
                        posicionProfesor,
                        posicion);


        System.out.println(
                (i + 1)
                + ". "
                + nombreEstudiante[posicion]
                + " | Curso: "
                + cursoEstudiante[posicion]
                + " | Nota: "
                + nota);
    }


    System.out.println();
    System.out.println(
            "========= CUADRO DE HONOR DE LA MATERIA =========");

    System.out.println();

    boolean existeCuadroHonor = false;

    for (int i = 0; i < 30; i++) {

        double nota =
                obtenerPromedioMateria(
                        posicionProfesor,
                        i);


        if (nota >= 9) {

            existeCuadroHonor = true;

            System.out.println(
                    nombreEstudiante[i]
                    + " | Curso: "
                    + cursoEstudiante[i]
                    + " | Nota: "
                    + nota);
        }
    }


    if (!existeCuadroHonor) {

        System.out.println(
                "No existen estudiantes con nota de 9 o superior.");
    }


    esperarContinuar();
}


    static void mostrarIndicadores(
            int posicionProfesor) {

        limpiarConsola();

        System.out.println(
                "========= INDICADORES DEL CURSO =========");

        for (String curso : new String[]{"A", "B", "C"}) {

            int aprobados = 0;
            int riesgos = 0;
            int criticos = 0;

            System.out.println();
            System.out.println(
                    "============= PARALELO " + curso + " =============");

            for (int i = 0; i < 30; i++) {

                if (cursoEstudiante[i].equals(curso)) {

                    double promedio =
                            obtenerPromedioMateria(
                                    posicionProfesor, i);

                    if (promedio >= 7) {

                        System.out.println(
                                "APROBADO: "
                                + nombreEstudiante[i]
                                + " - Nota: "
                                + promedio);

                        aprobados++;

                    } else if (promedio >= 5) {

                        System.out.println(
                                "RIESGO: "
                                + nombreEstudiante[i]
                                + " - Nota: "
                                + promedio);

                        riesgos++;

                    } else {

                        System.out.println(
                                "CRITICO: "
                                + nombreEstudiante[i]
                                + " - Nota: "
                                + promedio);

                        criticos++;
                    }
                }
            }

            System.out.println();
            System.out.println("Total aprobados: " + aprobados);

            System.out.println("Total riesgo: " + riesgos);

            System.out.println("Total criticos: " + criticos);
        }

        esperarContinuar();
    }


    static void mostrarEstudiantesEnRiesgo(
            int posicionProfesor) {

        limpiarConsola();

        System.out.println(
                "========= ESTUDIANTES EN RIESGO =========");

        System.out.println();
        System.out.println("NOTA MENOR A 7");

        for (int i = 0; i < 30; i++) {

            double promedio =
                    obtenerPromedioMateria(
                            posicionProfesor, i);

            if (promedio < 7) {

                System.out.println();

                System.out.println(
                        nombreEstudiante[i]);

                System.out.println(
                        "Paralelo: "
                        + cursoEstudiante[i]);

                System.out.println(
                        "Nota: "
                        + promedio);
            }
        }

        esperarContinuar();
    }


    //==========================================================
    // ANALISIS AVANZADO
    //==========================================================

    static void analisisAvanzado() {

        int opcion;

        do {

            limpiarConsola();

            System.out.println("==========================================");

            System.out.println("        ANALISIS ACADEMICO AVANZADO");

            System.out.println("==========================================");

            System.out.println();

            System.out.println("1. Ranking de estudiantes");

            System.out.println("2. Cuadro de honor");

            System.out.println("3. Estudiantes de alto rendimiento");

            System.out.println("4. Estudiantes en riesgo");

            System.out.println("5. Estudiantes con tutorias");

            System.out.println("6. Estudiantes con reconocimiento");

            System.out.println("7. Operaciones de conjuntos");

            System.out.println("8. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {

                case 1 -> ranking();

                case 2 -> mostrarConjunto("CUADRO DE HONOR", conjuntoReconocimiento);

                case 3 -> mostrarConjunto("ESTUDIANTES ALTO RENDIMIENTO", conjuntoAltoRendimiento);

                case 4 -> mostrarConjunto("ESTUDIANTES EN RIESGO", conjuntoRiesgo);

                case 5 -> mostrarConjunto("ESTUDIANTES CON TUTORIAS", conjuntoTutorias);

                case 6 -> mostrarConjunto("CANDIDATOS A RECONOCIMIENTO", conjuntoReconocimiento);

                case 7 -> operacionesConjuntos();
            }

        } while (opcion != 8);
    }


static void ranking() {

    limpiarConsola();

    System.out.println("========= RANKING ACADEMICO GENERAL =========");

    System.out.println();

    int[] posiciones = new int[30];

    for (int i = 0; i < 30; i++) {

        posiciones[i] = i;
    }


    for (int i = 0; i < 29; i++) {

        for (int j = i + 1; j < 30; j++) {

            if (promedioFinal[posiciones[j]]
                    > promedioFinal[posiciones[i]]) {

                int aux = posiciones[i];

                posiciones[i] = posiciones[j];

                posiciones[j] = aux;
            }
        }
    }


    for (int i = 0; i < 30; i++) {

        int posicion = posiciones[i];

        System.out.println(
                (i + 1)
                + ". "
                + nombreEstudiante[posicion]
                + " | Promedio: "
                + promedioFinal[posicion]
                + " | Curso: "
                + cursoEstudiante[posicion]);
    }

    esperarContinuar();
}


    static void mostrarConjunto(
        String titulo,
        String[] conjunto) {

    limpiarConsola();

    System.out.println("========= " + titulo + " =========");

    int[] posiciones = new int[30];

    int cantidad = 0;


    //======================================================
    // GUARDAR SOLAMENTE LOS ESTUDIANTES DEL CONJUNTO
    //======================================================

    for (int i = 0; i < 30; i++) {

        if (conjunto[i].equals("SI")) {

            posiciones[cantidad] = i;

            cantidad++;
        }
    }


    //======================================================
    // ORDENAR DE MAYOR A MENOR PROMEDIO
    //======================================================

    for (int i = 0; i < cantidad - 1; i++) {

        for (int j = i + 1; j < cantidad; j++) {

            if (promedioFinal[posiciones[j]]
                    > promedioFinal[posiciones[i]]) {

                int aux = posiciones[i];

                posiciones[i] = posiciones[j];

                posiciones[j] = aux;
            }
        }
    }


    //======================================================
    // MOSTRAR RESULTADOS
    //======================================================

    if (cantidad == 0) {

        System.out.println(
                "No existen estudiantes en este grupo.");

    } else {

        for (int i = 0; i < cantidad; i++) {

            int posicion = posiciones[i];

            System.out.println();

            System.out.println((i + 1) + ". " + nombreEstudiante[posicion]);

            System.out.println("Curso: " + cursoEstudiante[posicion]);

            System.out.println("Nota: " + promedioFinal[posicion]);
        }
    }

    esperarContinuar();
}


    static void operacionesConjuntos() {

        limpiarConsola();

        System.out.println("========= OPERACIONES DE CONJUNTOS =========");

        System.out.println();
        System.out.println("UNION:");
        System.out.println(
                "Alto rendimiento U Reconocimiento");

        for (int i = 0; i < 30; i++) {

            if (conjuntoAltoRendimiento[i].equals("SI")
                    || conjuntoReconocimiento[i].equals("SI")) {

                System.out.println(
                        nombreEstudiante[i]);
            }
        }


        System.out.println();
        System.out.println("INTERSECCION:");
        System.out.println("Riesgo y Tutorias");

        for (int i = 0; i < 30; i++) {

            if (conjuntoRiesgo[i].equals("SI")
                    && conjuntoTutorias[i].equals("SI")) {

                System.out.println(
                        nombreEstudiante[i]);
            }
        }


        System.out.println();
        System.out.println("DIFERENCIA:");
        System.out.println("Riesgo sin Tutorias");

        for (int i = 0; i < 30; i++) {

            if (conjuntoRiesgo[i].equals("SI")
                    && conjuntoTutorias[i].equals("NO")) {

                System.out.println(
                        nombreEstudiante[i]);
            }
        }

        esperarContinuar();
    }


    //==========================================================
    // REPORTE INSTITUCIONAL
    //==========================================================

    static void reporteInstitucional() {

        int aprobados = 0;

        int riesgoBajo = 0;
        int riesgoMedio = 0;
        int riesgoAlto = 0;

        int cantidadTutorias = 0;
        int cantidadReconocimiento = 0;

        double sumaPromedios = 0;

        int reprobadosLM = 0;
        int reprobadosTP = 0;
        int reprobadosLC = 0;


        for (int i = 0; i < 30; i++) {

            sumaPromedios += promedioFinal[i];


            if (promedioFinal[i] >= 7) {
                aprobados++;
            }


            if (nivelRiesgo[i].equals("BAJO")) {
                riesgoBajo++;
            }

            if (nivelRiesgo[i].equals("MEDIO")) {
                riesgoMedio++;
            }

            if (nivelRiesgo[i].equals("ALTO")) {
                riesgoAlto++;
            }


            if (conjuntoTutorias[i].equals("SI")) {
                cantidadTutorias++;
            }


            if (conjuntoReconocimiento[i].equals("SI")) {
                cantidadReconocimiento++;
            }


            if (promedioLM[i] < 7) {
                reprobadosLM++;
            }

            if (promedioTP[i] < 7) {
                reprobadosTP++;
            }

            if (promedioLC[i] < 7) {
                reprobadosLC++;
            }
        }


        double promedioInstitucional = sumaPromedios / 30;


        String materiaMayorReprobacion;


        if (reprobadosLM >= reprobadosTP
                && reprobadosLM >= reprobadosLC) {

            materiaMayorReprobacion =
                    "Logica Matematica";

        } else if (reprobadosTP >= reprobadosLC) {

            materiaMayorReprobacion =
                    "Tecnicas de Programacion";

        } else {

            materiaMayorReprobacion =
                    "Lenguaje y Comunicacion";
        }


        limpiarConsola();

        System.out.println("==========================================");

        System.out.println("       REPORTE INSTITUCIONAL N.E.X.U.S.");

        System.out.println("          CAMPUS INTELIGENTE");

        System.out.println("==========================================");


        System.out.println();

        System.out.println("Total estudiantes analizados: 30");

        System.out.println();

        System.out.println("Promedio institucional: " + promedioInstitucional);


        System.out.println();

        System.out.println("Porcentaje de aprobacion: "+ ((aprobados * 100.0) / 30)+ "%");


        System.out.println();

        System.out.println("RIESGO ACADEMICO");

        System.out.println(
                "Riesgo bajo: "
                + riesgoBajo);

        System.out.println(
                "Riesgo medio: "
                + riesgoMedio);

        System.out.println(
                "Riesgo alto: "
                + riesgoAlto);


        System.out.println();

        System.out.println(
                "Materia con mayor indice de reprobacion:");

        System.out.println(materiaMayorReprobacion);


        System.out.println();

        System.out.println("Tutorias recomendadas: " + cantidadTutorias);

        System.out.println("Candidatos a reconocimiento academico: " + cantidadReconocimiento);


        System.out.println();

        System.out.println("========== DIAGNOSTICO DEL SISTEMA ==========");


        if (riesgoAlto > 0) {

            System.out.println("El sistema recomienda una intervencion academica.");

            System.out.println("Existen estudiantes con nivel alto de riesgo.");

        } else if (riesgoMedio > 0) {

            System.out.println("El sistema recomienda seguimiento preventivo.");

            System.out.println("Existen estudiantes que requieren apoyo.");

        } else {

            System.out.println("El sistema determina rendimiento institucional estable.");

            System.out.println("La mayoria mantiene un desempeno adecuado.");
        }


        esperarContinuar();
    }


    //==========================================================
    // MENU PRINCIPAL
    //==========================================================

    static void menuPrincipal() {

        int opcion;

        do {

            limpiarConsola();

            mostrarEncabezado();

            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Cuadro de Honor");
            System.out.println("3. Estudiantes por Curso");
            System.out.println("4. Analisis Institucional");
            System.out.println("5. Analisis Avanzado");
            System.out.println("6. Salir");

            System.out.println();

            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {

                case 1:

                    iniciarSesion();

                    break;


                case 2:

                    mostrarConjunto("CUADRO DE HONOR", conjuntoReconocimiento);

                    break;


                case 3:

                    estudiantesPorCurso();

                    break;


                case 4:

                    reporteInstitucional();

                    break;


                case 5:

                    analisisAvanzado();

                    break;


                case 6:

                    mostrarSalida();

                    break;


                default:

                    System.out.println(
                            "Opcion no valida.");

                    esperarContinuar();
            }

        } while (opcion != 6);


        limpiarConsola();

        mostrarSalida();
    }


    //==========================================================
    // INICIO DE SESION
    //==========================================================

    static void iniciarSesion() {

        limpiarConsola();

        System.out.println(
                "========= INICIO DE SESION =========");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Clave: ");
        String clave = scanner.nextLine();


        boolean encontrado = false;


        for (int i = 0; i < 30; i++) {

            if (usuarioEstudiante[i].equals(usuario)
                    && claveEstudiante[i].equals(clave)) {

                encontrado = true;

                panelEstudiante(i);
            }
        }


        for (int i = 0; i < 3; i++) {

            if (usuarioProfesor[i].equals(usuario)
                    && claveProfesor[i].equals(clave)) {

                encontrado = true;

                panelProfesor(i);
            }
        }


        if (!encontrado) {

            System.out.println();

            System.out.println(
                    "Usuario o clave incorrectos.");

            esperarContinuar();
        }
    }


    //==========================================================
    // ESTUDIANTES POR CURSO
    //==========================================================

    static void estudiantesPorCurso() {

        limpiarConsola();

        System.out.println(
                "========= ESTUDIANTES POR CURSO =========");


        for (String curso : new String[]{"A", "B", "C"}) {

            System.out.println();

            System.out.println("PARALELO " + curso);

            for (int i = 0; i < 30; i++) {

                if (cursoEstudiante[i].equals(curso)) {

                    System.out.println(nombreEstudiante[i]);
                }
            }
        }

        esperarContinuar();
    }


    //==========================================================
    // MAIN
    //==========================================================

    public static void main(String[] args) {

        cargarDatos();

        procesarDatos();

        menuPrincipal();
    }
}
