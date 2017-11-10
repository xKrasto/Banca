/*
*# DON'T BE A DICK PUBLIC LICENSE
*
*> Version 1.1, December 2016
*
*> Copyright (C) [2017] [Alexandro, xKrasto]
*
*Everyone is permitted to copy and distribute verbatim or modified
*copies of this license document.
*
*> DON'T BE A DICK PUBLIC LICENSE
*> TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
*
*1. Do whatever you like with the original work, just don't be a dick.
*
*   Being a dick includes - but is not limited to - the following instances:
*
* 1a. Outright copyright infringement - Don't just copy this and change the name.
* 1b. Selling the unmodified original with no work done what-so-ever, that's REALLY being a dick.
* 1c. Modifying the original work to contain hidden harmful content. That would make you a PROPER dick.
*
*2. If you become rich through modifications, related works/services, or supporting the original work,
*share the love. Only a dick would make loads off this work and not buy the original work's
*creator(s) a pint.
*
*3. Code is provided with no warranty. Using somebody else's code and bitching when it goes wrong makes
*you a DONKEY dick. Fix the problem yourself. A non-dick would submit the fix back.
 */
package banca;

import java.util.Date;

public class ContoCorrente {
    protected Persona intestatario;
    protected String id;
    protected double saldo;
    protected Data dataUM;
    protected double importoUM;

    public Persona getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(Persona intestatario) {
        this.intestatario = intestatario;
    }

    
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

    public Data getDataUM() {
        return dataUM;
    }

    public double getImportoUM() {
        return importoUM;
    }

    public double versamento(double importo, Data data) {
        if (controlloImporto(importo, true)) {
            this.importoUM = importo;
            this.saldo += importo;
            return saldo;
        } else {
            System.out.println("L'importo da te inserito è negativo!");
            return -1;
        }
    }

    public double prelevamento(double importo, Data data) {
        if (controlloImporto(importo, false)) {
            this.importoUM = importo;
            this.saldo -= importo;
            this.dataUM = data;
            return this.saldo;
        } else {
            System.out.println("L'importo da te inserito supera il saldo!");
            return -1;
        }
    }

    public boolean controlloImporto(double importo, boolean versa) {

        if (versa) {
            return importo > 0;
        } else {
            
            return importo < saldo && importo > 0;
        }
    }
    
}
