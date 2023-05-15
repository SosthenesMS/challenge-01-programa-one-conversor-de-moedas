package controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.*;
import dto.*;

public class ConversorDeMoeda {

        private TaxaAtual taxaAtual;
        private DecimalFormat decimalFormat;
        private Scanner scanner;

        public ConversorDeMoeda() {

                this.taxaAtual = new TaxaAtual();
                this.decimalFormat = new DecimalFormat("####,####.00");
                this.scanner = new Scanner(System.in);

        }

        public String obterValorConvertido() {

                String chaveApi = "", retornoParaOUsuario = "", valorCalculadoFormatado = "",
                                simboloMonetarioFinal = "";
                double valorOriginal = 0, valorTaxa = 0, valorCalculado = 0;
                int respostaMoedaEscolhida = 0;

                List<String> chave = List.of("BRL-USD", "BRL-EUR", "BRL-ARS", "BRL-CLP", "BRL-CNY", "BRL-GBP",
                                "BRL-UYU", "BRL-COP", "USD-BRL", "EUR-BRL", "ARS-BRL", "CLP-BRL", "CNY-BRL", "GBP-BRL",
                                "UYU-BRL", "COP-BRL");
                List<String> simboloMonetario = List.of("R$", "US$", "€", "$", "$", "¥", "£", "$", "$");

                do {

                        String[] opcoes = { "1.Real Brasileiro -> Dólar Americano", "2.Real Brasileiro -> Euro",
                                        "3.Real Brasileiro -> Peso Argentino", "4.Real Brasileiro -> Peso Chileno",
                                        "5.Real Brasileiro -> Yuan Chinês", "6.Real Brasileiro -> Libra Esterlina",
                                        "7.Real Brasileiro -> Peso Uruguaio", "8.Real Brasileiro -> Peso Colombiano",
                                        "9.Dólar Americano -> Real Brasileiro", "10.Euro -> Real Brasileiro",
                                        "11.Peso Argentino -> Real Brasileiro", "12.Peso Chileno -> Real Brasileiro",
                                        "13.Yuan Chinês -> Real Brasileiro", "14.Libra Esterlina -> Real Brasileiro",
                                        "15.Peso Uruguaio -> Real Brasileiro",
                                        "16.Peso Colombiano -> Real Brasileiro" };
                        String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                                        null,
                                        "Escolha a moeda para qual você deseja converter:",
                                        "Menu",
                                        JOptionPane.PLAIN_MESSAGE,
                                        null,
                                        opcoes,
                                        opcoes[0]);

                        switch (opcaoSelecionada) {
                                case "1.Real Brasileiro -> Dólar Americano":
                                        respostaMoedaEscolhida = 1;
                                        break;
                                case "2.Real Brasileiro -> Euro":
                                        respostaMoedaEscolhida = 2;
                                        break;
                                case "3.Real Brasileiro -> Peso Argentino":
                                        respostaMoedaEscolhida = 3;
                                        break;
                                case "4.Real Brasileiro -> Peso Chileno":
                                        respostaMoedaEscolhida = 4;
                                        break;
                                case "5.Real Brasileiro -> Yuan Chinês":
                                        respostaMoedaEscolhida = 5;
                                        break;
                                case "6.Real Brasileiro -> Libra Esterlina":
                                        respostaMoedaEscolhida = 6;
                                        break;
                                case "7.Real Brasileiro -> Peso Uruguaio":
                                        respostaMoedaEscolhida = 7;
                                        break;
                                case "8.Real Brasileiro -> Peso Colombiano":
                                        respostaMoedaEscolhida = 8;
                                        break;
                                case "9.Dólar Americano -> Real Brasileiro":
                                        respostaMoedaEscolhida = 9;
                                        break;
                                case "10.Euro -> Real Brasileiro":
                                        respostaMoedaEscolhida = 10;
                                        break;
                                case "11.Peso Argentino -> Real Brasileiro":
                                        respostaMoedaEscolhida = 11;
                                        break;
                                case "12.Peso Chileno -> Real Brasileiro":
                                        respostaMoedaEscolhida = 12;
                                        break;
                                case "13.Yuan Chinês -> Real Brasileiro":
                                        respostaMoedaEscolhida = 13;
                                        break;
                                case "14.Libra Esterlina -> Real Brasileiro":
                                        respostaMoedaEscolhida = 14;
                                        break;
                                case "15.Peso Uruguaio -> Real Brasileiro":
                                        respostaMoedaEscolhida = 15;
                                        break;
                                case "16.Peso Colombiano -> Real Brasileiro":
                                        respostaMoedaEscolhida = 16;
                                        break;
                        }

                } while (respostaMoedaEscolhida != 1 && respostaMoedaEscolhida != 2 && respostaMoedaEscolhida != 3
                                && respostaMoedaEscolhida != 4 && respostaMoedaEscolhida != 5
                                && respostaMoedaEscolhida != 6 && respostaMoedaEscolhida != 7
                                && respostaMoedaEscolhida != 8 && respostaMoedaEscolhida != 9
                                && respostaMoedaEscolhida != 10 && respostaMoedaEscolhida != 11
                                && respostaMoedaEscolhida != 12 && respostaMoedaEscolhida != 13
                                && respostaMoedaEscolhida != 14 && respostaMoedaEscolhida != 15
                                && respostaMoedaEscolhida != 16 && Character.isLetter(respostaMoedaEscolhida));

                valorOriginal = Integer.parseInt(JOptionPane
                                .showInputDialog("Agora informe o valor: "));

                chaveApi = chave.get(respostaMoedaEscolhida - 1);
                valorTaxa = taxaAtual.obterRetornoDaTaxaAtual(
                                "https://economia.awesomeapi.com.br/json/last/" + chaveApi, respostaMoedaEscolhida);

                valorCalculado = valorOriginal * valorTaxa;
                valorCalculadoFormatado = decimalFormat.format(valorCalculado);

                if (respostaMoedaEscolhida >= 9) {
                        simboloMonetarioFinal = simboloMonetario.get(0);
                } else {
                        simboloMonetarioFinal = simboloMonetario.get(respostaMoedaEscolhida);
                }

                retornoParaOUsuario = "O valor da conversão é de " + simboloMonetarioFinal + " "
                                + valorCalculadoFormatado;

                return retornoParaOUsuario;
        }

        public TaxaAtual getTaxaAtual() {
                return taxaAtual;
        }

        public void setTaxaAtual(TaxaAtual taxaAtual) {
                this.taxaAtual = taxaAtual;
        }

        public DecimalFormat getDecimalFormat() {
                return decimalFormat;
        }

        public void setDecimalFormat(DecimalFormat decimalFormat) {
                this.decimalFormat = decimalFormat;
        }

        public Scanner getScanner() {
                return scanner;
        }

        public void setScanner(Scanner scanner) {
                this.scanner = scanner;
        }

}
