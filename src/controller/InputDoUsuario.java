package controller;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.*;
import model.*;
import dto.*;

public class InputDoUsuario {

	private ConversorDeMoeda conversorDeMoeda;
	private ConversorDeTemperatura conversorDeTemperatura;
	private ConversorDeTempo conversorDeTempo;
	private Scanner scanner;

	public InputDoUsuario() {

		this.conversorDeMoeda = new ConversorDeMoeda();
		this.conversorDeTemperatura = new ConversorDeTemperatura();
		this.conversorDeTempo = new ConversorDeTempo();
		this.scanner = new Scanner(System.in);

	}

	public void obterDadosDeEntrada() {

		int respostaTipoDeConversao = 0;
		String retornoParaOUsuario = "";
		boolean verificaçãoFinal = true;

		String[] opcoes = { "Conversor de moeda", "Conversor de temperatura", "Conversor de Tempo" };

		do {
			do {

				String opcaoSelecionada = (String) JOptionPane.showInputDialog(
						null,
						"Selecione uma opção:",
						"Menu",
						JOptionPane.PLAIN_MESSAGE,
						null,
						opcoes,
						opcoes[0]);

				switch (opcaoSelecionada) {
					case "Conversor de moeda":
						respostaTipoDeConversao = 1;
						break;
					case "Conversor de temperatura":
						respostaTipoDeConversao = 2;
						break;
					case "Conversor de Tempo":
						respostaTipoDeConversao = 3;
						break;
				}

			} while (respostaTipoDeConversao != 1 && respostaTipoDeConversao != 2 && respostaTipoDeConversao != 3);

			switch (respostaTipoDeConversao) {
				case 1:
					retornoParaOUsuario = conversorDeMoeda.obterValorConvertido();
					JOptionPane.showMessageDialog(null, retornoParaOUsuario);
					// System.out.println(showMessageDialog);
					break;
				case 2:
					retornoParaOUsuario = conversorDeTemperatura.conversorDeTemperatura();
					JOptionPane.showMessageDialog(null, retornoParaOUsuario);
					// System.out.println(retornoParaOUsuario);
					break;
				case 3:
					retornoParaOUsuario = conversorDeTempo.conversorDeTempo();
					JOptionPane.showMessageDialog(null, retornoParaOUsuario);
					// System.out.println(retornoParaOUsuario);
					break;
			}

			verificaçãoFinal = verificacaoFinal();

		} while (verificaçãoFinal == true);

	}

	public boolean verificacaoFinal() {

		boolean verificador = true;
		String respostaPerguntaFinal;

		do {
			respostaPerguntaFinal = JOptionPane.showInputDialog("Deseja continuar? (S/N)").toLowerCase();
		} while (!respostaPerguntaFinal.equals("s") && !respostaPerguntaFinal.equals("n"));

		if (respostaPerguntaFinal.equals("s")) {
			verificador = true;
		} else if (respostaPerguntaFinal.equals("n")) {
			verificador = false;
		}

		return verificador;
	}

	public ConversorDeMoeda getConversorDeMoeda() {
		return conversorDeMoeda;
	}

	public void setConversorDeMoeda(ConversorDeMoeda conversorDeMoeda) {
		this.conversorDeMoeda = conversorDeMoeda;
	}

	public ConversorDeTemperatura getConversorDeTemperatura() {
		return conversorDeTemperatura;
	}

	public void setConversorDeTemperatura(ConversorDeTemperatura conversorDeTemperatura) {
		this.conversorDeTemperatura = conversorDeTemperatura;
	}

	public ConversorDeTempo getConversorDeTempo() {
		return conversorDeTempo;
	}

	public void setConversorDeTempo(ConversorDeTempo conversorDeTempo) {
		this.conversorDeTempo = conversorDeTempo;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

}
