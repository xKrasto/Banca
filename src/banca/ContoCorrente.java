package banca;

import java.util.Date;

public class ContoCorrente {

    private final String id;
    private double saldo;
    private Date dataUM;
    private double importoUM;
//COSTRUTTORE 1

    public ContoCorrente() {
        this.id = Banca.reqId();
        this.saldo = 0;
    }

    ;
//COSTRUTTORE 2

    public ContoCorrente(String id) {
        this.id = id;
        this.saldo = 0;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getDataUM() {
        return dataUM;
    }

    public double getImportoUM() {
        return importoUM;
    }

    public double versamento() {
        double importo = Banca.reqImporto();
        this.dataUM = Banca.reqData();
        if (controlloImporto(importo, true)) {
            this.importoUM = importo;
            this.saldo += importo;
            return saldo;
        } else {
            System.out.println("L'importo da te inserito è negativo!");
        }
        return -1;
    }

    public double versamento(double importo, Date data) {
        this.importoUM = importo;
        this.dataUM = data;
        this.saldo += importo;
        return saldo;

    }

    public double prelevamento() {
        double importo = Banca.reqImporto();
        this.dataUM = Banca.reqData();
        if (controlloImporto(Banca.reqImporto(), false)) {
            this.importoUM = importo;
            this.saldo -= importo;
            return this.saldo;
        } else {
            System.out.println("L'importo da te inserito supera il saldo!");
        }
        return -1;
    }

    public double prelevamento(double importo, Date data) {
        this.importoUM = importo;
        this.dataUM = data;
        this.saldo -= importo;
        return this.saldo;
    }

    public boolean controlloImporto(double importo, boolean versa) {
        boolean ok;
        if (versa) {
            ok = importo > 0;
        } else {
            ok = importo < saldo;
        }
        return ok;
    }

}
