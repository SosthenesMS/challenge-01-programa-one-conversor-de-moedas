package controller;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.*;
import dto.*;

public class ConversorDeTemperatura {

    private Scanner scanner;
    private DecimalFormat decimalFormat;

    public ConversorDeTemperatura() {
        this.scanner = new Scanner(System.in);
        this.decimalFormat = new DecimalFormat("###,###.0");
    }

    public String conversorDeTemperatura() {

        int respostaTemperatura = 0;
        double valorOriginal = 0.0, valorConvertido = 0.0;
        String retornoParaOUsuario = "", valorConvertidoFormatado = "";

        String[] opcoes = { "1.Celsius em Fahrenheit", "2.Celsius em Kelvin", "3.Fahrenheit em Celsius",
                "4.Fahrenheit em Kelvin", "5.Kelvin em Celsius" };

        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                null,
                "Escolha qual conversão deseja fazer:",
                "Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        switch (opcaoSelecionada) {
            case "1.Celsius em Fahrenheit":
                respostaTemperatura = 1;
                break;
            case "2.Celsius em Kelvin":
                respostaTemperatura = 2;
                break;
            case "3.Fahrenheit em Celsius":
                respostaTemperatura = 3;
                break;
            case "4.Fahrenheit em Kelvin":
                respostaTemperatura = 4;
                break;
            case "5.Kelvin em Celsius":
                respostaTemperatura = 5;
                break;
        }

        switch (respostaTemperatura) {

            // F = 1.8*C + 32;
            case 1:
            valorOriginal = Integer.parseInt(JOptionPane
            .showInputDialog("Agora informe a quantidade em Celsius:"));
                valorConvertido = 1.8 * valorOriginal + 32;
                valorConvertidoFormatado = this.decimalFormat.format(valorConvertido);
                retornoParaOUsuario = "O valor convertido em Fahrenheit é " + valorConvertidoFormatado + "°F";
                break;

            // K = C +237.15
            case 2:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em Celsius:"));
                valorConvertido = valorOriginal + 273.15;
                valorConvertidoFormatado = this.decimalFormat.format(valorConvertido);
                retornoParaOUsuario = "O valor convertido em Kelvin é " + valorConvertidoFormatado + "K";
                break;

            // C = (F - 32)/1.8
            case 3:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em Fahrenheit:"));
                valorConvertido = (valorOriginal - 32) / 1.8;
                valorConvertidoFormatado = this.decimalFormat.format(valorConvertido);
                retornoParaOUsuario = "O valor convertido em Celsius é " + valorConvertidoFormatado + "°C";
                break;

            // Converter de Fahrenheit em Celsius (C = (F-32)/1.8) e depois de Celsius para
            // Kelvin (K = C + 273.15)
            case 4:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em Fahrenheit:"));
                valorConvertido = (((valorOriginal - 32) / 1.8) + 273.15);
                valorConvertidoFormatado = this.decimalFormat.format(valorConvertido);
                retornoParaOUsuario = "O valor convertido em Kelvin é " + valorConvertidoFormatado + "K";
                break;

            // C = K - 273.15
            case 5:
                valorOriginal = Integer.parseInt(JOptionPane
                        .showInputDialog("Agora informe a quantidade em Kelvin:"));
                valorConvertido = valorOriginal - 273.15;
                valorConvertidoFormatado = this.decimalFormat.format(valorConvertido);
                retornoParaOUsuario = "O valor convertido em Celsius é " + valorConvertidoFormatado + "°C";
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
