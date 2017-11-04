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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

/**
 *
 * @author Alex
 */
public class Banca {

    public static String reqId() {
        String id;
        id = "0";
        boolean done;
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(inp);
        do {
            try {
                System.out.println("Inserisci il numero di conto corrente");
                id = tastiera.readLine();
                if (id.length() > 0 || id.length() < 30) {
                    done = true;
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.err.println("Errore nell'inserimento! ");
                done = false;
            }

        } while (!done);
        return id;
    }

    public static double reqImporto() {
        double importo = 0;
        boolean done;
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(inp);
        do {
            try {
                System.out.println("Inserisci l'importo");
                importo = Double.valueOf(tastiera.readLine());
                if (importo <= 0) {
                    throw new IOException();
                } else {
                    done = true;
                }
            } catch (IOException e) {
                System.err.println("Errore nell'inserimento dell'importo!");
                done = false;
            }
        } while (!done);
        return importo;
    }

    public static void stampaTutto(ContoCorrente c) {
        DecimalFormat money = new DecimalFormat("#,00");
        DateFormat def = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("------------------------------------------"); // un po di formattazione dai
        System.out.println("Id Conto: " + c.getId());
        System.out.println("Saldo conto: " + c.getSaldo());
        System.out.println("Importo ultimo movimento: " +c.getImportoUM());
        System.out.println("Data ultimo movimento: " + def.format(c.getDataUM()));
        System.out.println("------------------------------------------"); // un po di formattazione dai
    }

    public static Date reqData() {
        Date data = new Date();
        return data;
    }

    public static void stampaTutto(ContoConFido c) {
        DecimalFormat money = new DecimalFormat("#,00");
        DateFormat def = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("------------------------------------------"); // un po di formattazione dai
        System.out.println("Id Conto: " + c.getId());
        System.out.println("Fido: " + c.getFido());
        System.out.println("Saldo conto: " + c.getSaldo());
        if (c.getSaldo() < 0) {
            System.out.println("Attenzione, sei in debito con la banca!");
        }
        System.out.println("Importo ultimo movimento: " + c.getImportoUM());
        System.out.println("Data ultimo movimento: " + def.format(c.getDataUM()));
        System.out.println("------------------------------------------"); // un po di formattazione dai
    }

    public static void main(String[] args) {
        // 
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        //    
        ContoCorrente c1;
        ContoConFido c2;
        int operazione;
        boolean done = false;
        System.out.println("Conto 1:");
        c1 = new ContoCorrente(Banca.reqId());
        do {
            try {
                System.out.println("Inserisci il tipo di operazione che vuoi fare con il conto 1!");
                System.out.println("Inserisci 1 per effettuare un versamento;");
                System.out.println("Inserisci 2 per effettuare un prelevamento;");
                System.out.println("Inserisci 3 per uscire e visualizzare un riepilogo;");
                operazione = Integer.valueOf(tastiera.readLine());
                if (operazione <= 0 || operazione >= 4) {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.err.println("Errore nell'inserimento dell'operazione!");
                done = false;
                continue;
            }
            switch (operazione) {
                case 1:         //VERSAMENTO
                    System.out.println("Hai scelto il versamento!");
                    c1.versamento(Banca.reqImporto(), Banca.reqData());
                    done = false;
                    break;
                case 2:         //PRELEVAMENTO
                    System.out.println("Hai scelto il prelevamento!");
                    c1.prelevamento(Banca.reqImporto(), Banca.reqData());
                    done = false;
                    break;
                case 3:
                    System.out.println("Riepilogo:");
                    Banca.stampaTutto(c1);
                    done = true;
                    break;
                default:
                    System.out.println("Errore, io non dovrei spuntare! (default cc)");
                    done = false;
                    break;
            }
        } while (!done);
        System.out.println("Conto 2:");
        c2 = new ContoConFido(Banca.reqId());
        //Stessa cosa ma leggermente riadattata al fido
        do {
            try {
                System.out.println("Inserisci il tipo di operazione che vuoi fare con il conto 1!");
                System.out.println("Inserisci 1 per impostare il fido;");
                System.out.println("Inserisci 2 per effettuare un versamento;");
                System.out.println("Inserisci 3 per effettuare un prelevamento;");
                System.out.println("Inserisci 4 per uscire e visualizzare un riepilogo;");
                operazione = Integer.valueOf(tastiera.readLine());
                if (operazione <= 0 || operazione >= 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Errore nell'inserimento dell'operazione!");
                done = false;
                continue;
            }
            switch (operazione) {
                case 1:         //SET FIDO
                    System.out.println("Hai scelto di impostare il fido!");
                    c2.setFido(Banca.reqImporto());
                    done = false;
                    break;
                case 2:         //VERSAMENTO
                    System.out.println("Hai scelto il versamento!");
                    c2.versamento(Banca.reqImporto(), Banca.reqData());
                    done = false;
                    break;
                case 3:         //PRELEVAMENTO
                    System.out.println("Hai scelto il prelevamento!");
                    c2.prelevamento(Banca.reqImporto(), Banca.reqData());
                    break;
                case 4:
                    System.out.println("Riepilogo:");
                    Banca.stampaTutto(c2);
                    done = true;
                    break;
                default:
                    System.out.println("Errore, io non dovrei spuntare! (default cc)");
                    done = false;
                    break;
            }
        } while (!done);

        //Termino senza errori
        System.exit(0);
    }
}
