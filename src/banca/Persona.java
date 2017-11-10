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
/**
 *
 * @author Alex
 */
public class Persona {

    String nome, cognome, comuneNascita, indirizzo, numTel, codFisc;
    char sex;
    Data dataNascita;    
    
    public Persona(String nome, String cognome, char sex, String comuneNascita, String indirizzo, String numTel, String codFisc, Data dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.sex = sex;
        this.comuneNascita = comuneNascita;
        this.indirizzo = indirizzo;
        this.numTel = numTel;
        this.codFisc = codFisc;
        this.dataNascita = dataNascita;
    }
    
    public static boolean checkSex(char sex) {
        if (sex == 'M' || sex == 'm' || sex == 'F' || sex == 'f') {
            return true;
        }
        return false;
    // si potrebbe fare tutto in una linea: return sex == 'M' || sex == 'm' || sex == 'F' || sex == 'f';
    }
    public static boolean check18(int mm,int aa){ //Molto brutto da vedere ma controlla se è maggiorenne nel mese di Novembre 2017
        if (aa>1999) {
            return mm<11;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getComuneNascita() {
        return comuneNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getCodFisc() {
        return codFisc;
    }

    public char getSex() {
        return sex;
    }

    public Data getDataNascita() {
        return dataNascita;
    }
    
}
