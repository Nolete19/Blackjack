package com.nolete19.BlackJack.Configuracion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuracion {
    //Atributos
    public int numeroJugadoresIA = 3;
    public int numeroJugadoresHumanos = 1;
    public int apuestaMinima = 10;
    public int apuestaMaxima = 100;
    public int saldoInicialJugadoresIA = 1000;
    public int saldoInicialJugadoresHumanos = 10;
    public int milisegundosEspera = 1000;
    public double multiplicadorBlackjack = 1.5;
    public double multiplicadorGanadorBasico = 1;

    /**constuctor**/
    public Configuracion(String archivoConfiguracion) throws IOException {
        cargarConfiguracion(archivoConfiguracion);
    }

    /**
     * método  para leer el archivo de configuración y
     * asignar los valores correspondientes a las variables de la clase.
     * @param archivoConfiguracion
     * @throws IOException
     */
    private void cargarConfiguracion(String archivoConfiguracion) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(archivoConfiguracion));
        String contenido = new String(bytes);
        String[] lineas = contenido.split("\n");

        for (String linea : lineas) {
            String[] partes = linea.split("=");
            String nombre = partes[0].trim();
            String valor = partes[1].trim();

            switch (nombre) {
                case "numeroJugadoresIA":
                    numeroJugadoresIA = Integer.parseInt(valor);
                    break;
                case "numeroJugadoresHumanos":
                    numeroJugadoresHumanos = Integer.parseInt(valor);
                    break;
                case "apuestaMinima":
                    apuestaMinima = Integer.parseInt(valor);
                    break;
                case "apuestaMaxima":
                    apuestaMaxima = Integer.parseInt(valor);
                    break;
                case "saldoInicialJugadoresIA":
                    saldoInicialJugadoresIA = Integer.parseInt(valor);
                    break;
                case "saldoInicialJugadoresHumanos":
                    saldoInicialJugadoresHumanos = Integer.parseInt(valor);
                    break;
                case "milisegundosEspera":
                    milisegundosEspera = Integer.parseInt(valor);
                    break;
                case "multiplicadorBlackjack":
                    multiplicadorBlackjack = Double.parseDouble(valor);
                    break;
                case "multiplicadorGanadorBasico":
                    multiplicadorGanadorBasico = Double.parseDouble(valor);
                    break;
                default:
                    // Opcional: Manejar casos de configuración no reconocida
                    break;
            }
        }
    }



    //Setters
    public void setNumeroJugadoresIA(int numeroJugadoresIA) {
        this.numeroJugadoresIA = numeroJugadoresIA;
    }

    public void setNumeroJugadoresHumanos(int numeroJugadoresHumanos) {
        this.numeroJugadoresHumanos = numeroJugadoresHumanos;
    }

    public void setApuestaMinima(int apuestaMinima) {
        this.apuestaMinima = apuestaMinima;
    }

    public void setApuestaMaxima(int apuestaMaxima) {
        this.apuestaMaxima = apuestaMaxima;
    }

    public void setSaldoInicialJugadoresIA(int saldoInicialJugadoresIA) {
        this.saldoInicialJugadoresIA = saldoInicialJugadoresIA;
    }

    public void setSaldoInicialJugadoresHumanos(int saldoInicialJugadoresHumanos) {
        this.saldoInicialJugadoresHumanos = saldoInicialJugadoresHumanos;
    }

    public void setMilisegundosEspera(int milisegundosEspera) {
        this.milisegundosEspera = milisegundosEspera;
    }

    public void setMultiplicadorBlackjack(double multiplicadorBlackjack) {
        this.multiplicadorBlackjack = multiplicadorBlackjack;
    }

    public void setMultiplicadorGanadorBasico(double multiplicadorGanadorBasico) {
        this.multiplicadorGanadorBasico = multiplicadorGanadorBasico;
    }
    /**
     * Método para guardar la configuración en un archivo.
     *
     * @param archivoConfiguracion El nombre del archivo de configuración.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarConfiguracion(String archivoConfiguracion) throws IOException {
        StringBuilder contenido = new StringBuilder();

        contenido.append("numeroJugadoresIA=").append(numeroJugadoresIA).append("\n");
        contenido.append("numeroJugadoresHumanos=").append(numeroJugadoresHumanos).append("\n");
        contenido.append("apuestaMinima=").append(apuestaMinima).append("\n");
        contenido.append("apuestaMaxima=").append(apuestaMaxima).append("\n");
        contenido.append("saldoInicialJugadoresIA=").append(saldoInicialJugadoresIA).append("\n");
        contenido.append("saldoInicialJugadoresHumanos=").append(saldoInicialJugadoresHumanos).append("\n");
        contenido.append("milisegundosEspera=").append(milisegundosEspera).append("\n");
        contenido.append("multiplicadorBlackjack=").append(multiplicadorBlackjack).append("\n");
        contenido.append("multiplicadorGanadorBasico=").append(multiplicadorGanadorBasico).append("\n");

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(archivoConfiguracion));
            writer.write(contenido.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}

