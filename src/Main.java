import java.time.LocalDate;

interface RegistroVenda {
    void registrar(String dataTexto, double preco);
}

class SistemaCaixaAntigo {
    public void salvarNoBanco(LocalDate data, int valorEmCentavos) {
        System.out.println("-> Venda registrada em " + data + " no valor de " + valorEmCentavos + " centavos.");
    }
}

class VendaAdapter implements RegistroVenda {
    private final SistemaCaixaAntigo sistemaAntigo;

    public VendaAdapter(SistemaCaixaAntigo sistemaAntigo) {
        this.sistemaAntigo = sistemaAntigo;
    }

    @Override
    public void registrar(String dataTexto, double preco) {
        LocalDate dataConvertida = LocalDate.parse(dataTexto);

        int centavosConvertidos = (int) Math.round(preco * 100);

        sistemaAntigo.salvarNoBanco(dataConvertida, centavosConvertidos);
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaCaixaAntigo caixaVelho = new SistemaCaixaAntigo();
        RegistroVenda venda = new VendaAdapter(caixaVelho);

        venda.registrar("2026-10-15", 19.90);
    }
}


