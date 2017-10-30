/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;
import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


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
                if (id.length()> 0 || id.length()< 30) {
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
        double importo=0;
        boolean done;

        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(inp);

        do {
            try {
                System.out.println("Inserisci l'importo");
                importo = Double.valueOf(tastiera.readLine());
                if (importo<=0) {
                    throw new IOException();
                } else {
                    done = true;
                }

            } catch (IOException e) {
                System.err.println("Errore nell'inserimento dell'importo!"); 
                done = false;

            }

        } while(!done); 
        return importo;
    }
    
    public static void stampaTutto(ContoCorrente c){
        DateFormat def= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Id Conto: " + c.getId());
        System.out.println("Saldo conto: " + c.getSaldo());
        System.out.println("Importo ultimo movimento: " + c.getImportoUM());
        System.out.println("Data ultimo movimento: " + def.format(c.getDataUM()));
        
    }
    
    public static Date reqData(){
        Date data=new Date();
        return data;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        

        ContoCorrente c1,c2;
        String id;
        double risultato;
        System.out.println("-----Conto 1----");
        c1=new ContoCorrente();
        System.out.println("-----Conto 2----");
        c2=new ContoCorrente(Banca.reqId());
        
        do {            
            risultato = c1.versamento();
        } while (risultato==-1);
        do {            
            risultato = c2.versamento();
        } while (risultato==-1);
        do {            
            risultato = c1.prelevamento();
        } while (risultato==-1);
        do {            
            risultato = c2.prelevamento();
        } while (risultato==-1);
        do {            
            risultato = c1.versamento();
        } while (risultato==-1);
        
        stampaTutto(c2);
        stampaTutto(c1);
    
    }
    
}