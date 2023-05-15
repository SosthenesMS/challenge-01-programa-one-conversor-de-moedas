package dto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import model.*;
import controller.*;

public class TaxaAtual {

    private String url;

    public double obterRetornoDaTaxaAtual(String url, int respostaMoedaEscolhida) {

        String bodyResponse = "";
        Double valorTaxa = 0.0;
        Gson gson = new Gson();
        Moeda moeda = new Moeda();

        URI endereco = URI.create(url);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        try {
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            bodyResponse = response.body();
            moeda = gson.fromJson(bodyResponse, Moeda.class);

            switch (respostaMoedaEscolhida) {
                case 1:
                    valorTaxa = Double.parseDouble(moeda.getBRLUSD().getHigh());
                    break;
                case 2:
                    valorTaxa = Double.parseDouble(moeda.getBRLEUR().getHigh());
                    break;
                case 3:
                    valorTaxa = Double.parseDouble(moeda.getBRLARS().getHigh());
                    break;
                case 4:
                    valorTaxa = Double.parseDouble(moeda.getBRLCLP().getHigh());
                    break;
                case 5:
                    valorTaxa = Double.parseDouble(moeda.getBRLCNY().getHigh());
                    break;
                case 6:
                    valorTaxa = Double.parseDouble(moeda.getBRLGBP().getHigh());
                    break;
                case 7:
                    valorTaxa = Double.parseDouble(moeda.getBRLUYU().getHigh());
                    break;
                case 8:
                    valorTaxa = Double.parseDouble(moeda.getBRLCOP().getHigh());
                    break;
                case 9:
                    valorTaxa = Double.parseDouble(moeda.getUSDBRL().getHigh());
                    break;
                case 10:
                    valorTaxa = Double.parseDouble(moeda.getEURBRL().getHigh());
                    break;
                case 11:
                    valorTaxa = Double.parseDouble(moeda.getARSBRL().getHigh());
                    break;
                case 12:
                    valorTaxa = Double.parseDouble(moeda.getCLPBRL().getHigh());
                    break;
                case 13:
                    valorTaxa = Double.parseDouble(moeda.getCNYBRL().getHigh());
                    break;
                case 14:
                    valorTaxa = Double.parseDouble(moeda.getGBPBRL().getHigh());
                    break;
                case 15:
                    valorTaxa = Double.parseDouble(moeda.getUYUBRL().getHigh());
                    break;
                case 16:
                    valorTaxa = Double.parseDouble(moeda.getCOPBRL().getHigh());
                    break;

            }

        } catch (IOException | InterruptedException ex) {
            System.out.println("Erro na classe HttpResponse, por favor verifique o código fonte. StackTrace: ");
            ex.printStackTrace();
        }

        return valorTaxa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TaxaAtual(String url) {
        this.url = url;
    }

    public TaxaAtual() {
    }

}
