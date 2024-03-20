package randomteamgenerator2;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomTeamGenerator2 {
//    private static Map<String, ArrayList<Persona>> final_list = new HashMap<>();

    private final static String teamName = "Equipo ";

    public static void main(String[] args) {
        ArrayList<Persona> main_list = new ArrayList<>();
        /**
         * Rellemar la main_list con objetos del tipo Persona.
         */
        main_list.add(new Persona("Johan", false));
        main_list.add(new Persona("Misael", false));
        main_list.add(new Persona("Carlos", false));
        main_list.add(new Persona("Giovany", false));
        main_list.add(new Persona("Bryan", false));
        main_list.add(new Persona("Danna", false));
        main_list.add(new Persona("Fatima", false));
        main_list.add(new Persona("Ricardo", false));
        main_list.add(new Persona("Pina", false));
        main_list.add(new Persona("Paulo", false));
        main_list.add(new Persona("Oswaldo", false));
        main_list.add(new Persona("Gabriel", false));
        main_list.add(new Persona("Yahir", false));
        main_list.add(new Persona("Jair", false));
        main_list.add(new Persona("Max", false));
        main_list.add(new Persona("Frida", false));
        main_list.add(new Persona("Laura", false));
        main_list.add(new Persona("David", false));
        main_list.add(new Persona("Alan", false));
        main_list.add(new Persona("Nancy", false));
        main_list.add(new Persona("Fernanda", false));
        main_list.add(new Persona("Chris", false));
        main_list.add(new Persona("Toño", false));
        /**
         * Aleatorizando el orden de la lista original.
         */
        ArrayList<Persona> randomized_list = alphabeticalArrayList(main_list);

        //Método que ordena alfabeticamente los nombre de la lista.
        //ArrayList<Persona> alphabetical_list = alphabeticalArrayList(main_list);
        System.out.println("lista_principal tiene " + main_list.size() + " elementos, mientras que recombinaded_list tiene " + randomized_list.size() + " elementos reordenados de modo aleatorio.\n");
        /**
         * Generando una lista con los subconjuntos.
         */
        Map<String, ArrayList<Persona>> final_list = teamGenerator(randomized_list, 9);
        System.out.println("Con la lista proporcionada se han formado " + final_list.size() + " equipos:\n");

        forEachImpresor(final_list);
//        forImpresor(final_list);

    }

    public static Map<String, ArrayList<Persona>> teamGenerator(ArrayList<Persona> recombinaded_list, int ancho_equipos) {
        Map<String, ArrayList<Persona>> final_list = new HashMap<>();
        int contador = 0;
        int contador_sub = 0; // 0
        /**
         * Este while permite dejar trunco al último equipo, pues rompe el ciclo
         * cuando la totalidad de los elementos de la lista inicial han cambiado
         * de estado a añadido.
         */
        while (contador < recombinaded_list.size()) {
            /**
             * Repite hasta que el contador indique que todos los elementos
             * fueron empaquetados.
             */
            while (true) {
                /**
                 * Medida de seguridad If ante bucle infinito debido a
                 * subconjunto final incompleto.
                 */
                if (contador >= recombinaded_list.size()) {
//                    System.out.println("El contador finalmente es mas grande que el tamano de la recombinaded_list.");
                    break;
                }

                if (final_list.get((teamName + contador_sub)) != null) {

                    /**
                     * Actuará mientras .
                     */
                    for (int i = 0; i < ancho_equipos; i++) {
                        if (contador == recombinaded_list.size()) {
                            break;
                        }
                        final_list.get((teamName + contador_sub)).add(recombinaded_list.get(contador));
                        /**
                         * Cambiar estado del elemento a "añadido".
                         */
                        recombinaded_list.get(contador).setEstado(true);
//                        System.out.println("La persona numero " + contador + ", " + recombinaded_list.get(contador).getNombre() + "," + " ha sido anadida al subconjunto " + (teamName + contador_sub));
                        contador++;
//                        System.out.println("Contador es: " + contador);
                    }
                    contador_sub++;
                } else {
                    /**
                     * Debido a que el subconjunto no existe, se crea.
                     */
                    final_list.put((teamName + contador_sub), new ArrayList<Persona>()); // Añade subconjunto a lista grande
//                    System.out.println("El subconjunto " + contador_sub + " no existia, por lo que fue creado.");
                }
            }
        }
        return final_list;
    }

    private static ArrayList randomnizeArrayList(ArrayList<Persona> lista_principal) {
        int contador = 0;

        Random random = new Random();
        ArrayList randomnizedArrayList = new ArrayList<Persona>();

        while (contador < lista_principal.size()) {
            /**
             * Generación del número aleatorio entre 0 & el ancho de
             * lista_principal.
             */
            int numero_aleatorio = random.nextInt(lista_principal.size());
            if (lista_principal.get(numero_aleatorio).getEstado() == false) {
                randomnizedArrayList.add(lista_principal.get(numero_aleatorio));
                lista_principal.get(numero_aleatorio).setEstado(true);
                contador++;
            }
        }
        return randomnizedArrayList;
    }

    private static void forEachImpresor(Map<String, ArrayList<Persona>> final_list) {
        /**
         * Este for recorrerá el HashMap.
         */
        int i = 0;
        for (Map.Entry<String, ArrayList<Persona>> subconjunto : final_list.entrySet()) {

            if (final_list.containsKey((teamName + i))) {
                // Obtener el valor asociado a la clave
                ArrayList<Persona> personas = final_list.get((teamName + i));
                // Ahora puedes trabajar con la lista de personas del equipo
                System.out.println((teamName + (i + 1)) + " compuesto por " + personas.size() + " personas.");
                // Iterar sobre la lista de personas
                for (Persona persona : personas) {
                    // Aquí puedes hacer lo que necesites con cada persona
                    System.out.println(persona.getNombre());
                }
                System.out.println("");
            } else {
                // La clave "Equipo 1" no existe en el mapa
                System.out.println("La clave " + (teamName + i) + " no existe en el mapa.");
            }
            i++;
        }
    }

    private static void forImpresor(Map<String, ArrayList<Persona>> final_list) {
        for (int i = 0; i < final_list.size(); i++) {
            ArrayList<Persona> subconjunto = final_list.get((teamName + i)); // Obtener la lista de personas   

            System.out.println(subconjunto + " compuesto por " + subconjunto.size() + " personas:");
            /**
             * Este for recorrerá los elementos de cada subconjunto.
             */
            for (int a = 0; final_list.get(teamName + a) != null && a < final_list.get(teamName + a).size(); a++) {
                try {
                    if (subconjunto.get(a) != null) {
                        Persona persona = subconjunto.get(a);
                        System.out.println(persona.getNombre());
                    }
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
    }

    private static ArrayList<Persona> alphabeticalArrayList(ArrayList<Persona> main_list) {
        ArrayList<Character> abecedario_list = new ArrayList<>();
        //arraylist ordenado.
        ArrayList<Persona> A_Z_list = new ArrayList<>();

        /**
         * abecedario.
         */
        abecedario_list.add('a');
        abecedario_list.add('b');
        abecedario_list.add('c');
        abecedario_list.add('d');
        abecedario_list.add('e');
        abecedario_list.add('f');
        abecedario_list.add('g');
        abecedario_list.add('h');
        abecedario_list.add('i');
        abecedario_list.add('j');
        abecedario_list.add('k');
        abecedario_list.add('l');
        abecedario_list.add('m');
        abecedario_list.add('o');
        abecedario_list.add('p');
        abecedario_list.add('q');
        abecedario_list.add('r');
        abecedario_list.add('s');
        abecedario_list.add('t');
        abecedario_list.add('u');
        abecedario_list.add('v');
        abecedario_list.add('w');
        abecedario_list.add('x');
        abecedario_list.add('y');
        abecedario_list.add('z');

        //creando ciclo for.
        for (int i = 0; i < abecedario_list.size(); i++) {
            for (int a = 0; a < main_list.size(); a++) {
                String nombre = main_list.get(a).getNombre();
                char primera_letra = nombre.charAt(0);
                //System.out.println("Letra obtenida de la persona: " + primera_letra);
                if (main_list.get(a).getEstado() == false && Character.toLowerCase(primera_letra) == Character.toLowerCase(abecedario_list.get(i))) {
                        A_Z_list.add(main_list.get(a));
                        main_list.get(a).setEstado(true);
                }
            }

        }

        return A_Z_list;
    }
}

class Persona {

    private String nombre;
    private Boolean estado;

    // Constructor
    public Persona(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
