package com.example.cami.universitylabster.base_classes;

/**
 * Created by Cami on 09.12.2017.
 */

public class Student {
    String id;


    String parola;



    String codFac,FacN,SpecN;
    String codSpec;
    String an;
    String grupa;
    String codSapt;
    String nume,prenume,tel,mail;

    public Student(String id,String parola, String codFac, String codSpec, String an, String grupa, String nume, String prenume, String tel, String mail) {
        this.id = id;
        this.codFac = codFac;
        this.codSpec = codSpec;
        this.an = an;
        this.parola=parola;
        this.grupa = grupa;
        this.nume = nume;
        this.prenume = prenume;
        this.tel = tel;
        this.mail = mail;
    }
    public String getFacN() {
        return FacN;
    }

    public void setFacN(String facN) {
        FacN = facN;
    }

    public String getSpecN() {
        return SpecN;
    }

    public void setSpecN(String specN) {
        SpecN = specN;
    }
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    public String getCodSapt() {

        return codSapt;
    }

    public void setCodSapt(String codSapt) {
        this.codSapt = codSapt;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodFac() {
        return codFac;
    }

    public void setCodFac(String codFac) {
        this.codFac = codFac;
    }

    public String getCodSpec() {
        return codSpec;
    }

    public void setCodSpec(String codSpec) {
        this.codSpec = codSpec;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
