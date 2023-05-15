package controller;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.*;
import dto.*;

/*
 * A unidade de tempo do SI é o segundo.
 * A partir daqui foram derivados o minuto (60 segundos) e a hora (3600 segundos).
 * Considera-se que um dia tem 86.400 segundos para a presente calculadora,
 * embora isso possa variar de acordo com a inserção de um "leap second".
 */

public class ConversorDeTempo {

    private Scanner scanner;
    private DecimalFormat decimalFormat;

    public ConversorDeTempo() {
        this.scanner = new Scanner(System.in);
        this.decimalFormat = new DecimalFormat("###,###.00");
    }

    public String conversorDeTempo() {
        int respostaDaConversaoDesejada = 0;
        double valorOriginal = 0.0, valorCalculado = 0.0;
        String retornoParaOUsuario = "", valorCalculadoFormatado = "";

        String[] opcoes = { "Horas pra minutos", "Horas para segundos", "Minutos para segundos", "Minutos para horas",
                "Segundos para minutos", "Segundos para horas", "Horas para dias", "Dias pra anos" };

        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                null,
                "Escolha qual conversão deseja fazer:",
                "Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        switch (opcaoSelecionada) {
            case "Horas pra minutos":
                respostaDaConversaoDesejada = 1;
                break;
            case "Horas para segundos":
                respostaDaConversaoDesejada = 2;
                break;
            case "Minutos para segundos":
                respostaDaConversaoDesejada = 3;
                break;
            case "Minutos para horas":
                respostaDaConversaoDesejada = 4;
                break;
            case "Segundos para minutos":
                respostaDaConversaoDesejada = 5;
                break;
            case "Segundos para horas":
                respostaDaConversaoDesejada = 6;
                break;
            case "Horas para dias":
                respostaDaConversaoDesejada = 7;
                break;
            case "Dias pra anos":
                respostaDaConversaoDesejada = 8;
                break;
        }

        switch (respostaDaConversaoDesejada) {
            case 1:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de horas:"));
                valorCalculado = valorOriginal * 60;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " minutos";
                break;
            case 2:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de horas:"));
                valorCalculado = valorOriginal * 3600;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " segundos";
                break;
            case 3:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em minutos:"));
                valorCalculado = valorOriginal * 60;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " segundos";
                break;
            case 4:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em minutos:"));
                valorCalculado = valorOriginal / 60;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " horas";
                break;
            case 5:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de segundos:"));
                valorCalculado = valorOriginal / 60;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " minutos";
                break;
            case 6:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de segundos:"));
                valorCalculado = valorOriginal / 3600;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " horas";
                break;
            case 7:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de horas:"));
                valorCalculado = valorOriginal / 24;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " dias";
                break;
            case 8:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade de dias:"));
                valorCalculado = valorOriginal / 365;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);
                retornoParaOUsuario = "O resultado é " + valorCalculadoFormatado + " anos";
                break;
        }

        return retornoParaOUsuario;

    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

}
