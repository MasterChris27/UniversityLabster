package com.example.cami.universitylabster.base_classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Cami on 09.12.2017.
 */

public class CourseId {
    String facName,specName;
    String courseId;
    String nameCourse;
    String numeProf,mailProf;
    String courseType;
    List<String> participanti = new ArrayList<String>();
    int validare = 1;
    String oraStart,oraFinish;
    String notite;
    String idUser;
    Boolean cursImportant=false;
    Date dataId= new Date(2017-1901,12,11);
    public Boolean getCursImportant() {
        return cursImportant;
    }

    public void setCursImportant(Boolean cursImportant) {
        this.cursImportant = cursImportant;
    }


    public Date getDataId() {
        return dataId;
    }
    public boolean valid() {
        if(validare>0){
            return true;
        }
        else{
            return false;
        }
    }
    public void setValidare(int n){
        validare=n;
    }

    public void setDataId(Date data) {
        this.dataId = data;
    }

    public CourseId(String facName, String specName, String courseId, String nameCourse, String numeProf, String mailProf, String courseType, String participant, String oraStart, String oraFinish, String notite) {
        this.facName = facName;
        this.specName = specName;
        this.courseId = courseId;
        this.nameCourse = nameCourse;
        this.numeProf = numeProf;
        this.mailProf = mailProf;
        this.courseType = courseType;
        this.participanti.add(participant);
        this.oraStart = oraStart;
        this.oraFinish = oraFinish;
        this.notite = notite;
    }

    public String getFacName() {

        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNumeProf() {
        return numeProf;
    }

    public void setNumeProf(String numeProf) {
        this.numeProf = numeProf;
    }

    public String getMailProf() {
        return mailProf;
    }

    public void setMailProf(String mailProf) {
        this.mailProf = mailProf;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getOraStart() {
        return oraStart;
    }

    public void setOraStart(String oraStart) {
        this.oraStart = oraStart;
    }

    public String getOraFinish() {
        return oraFinish;
    }

    public void setOraFinish(String oraFinish) {
        this.oraFinish = oraFinish;
    }

    public String getNotite() {
        return notite;
    }

    public void setNotite(String notite) {
        this.notite = notite;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }





    public boolean checkPresent(String id) {
        participanti.contains(id);
        return true;
    }

    public void addParticipant(String s) {
      participanti.add(s);
      validare+=1;
    }
public CourseId(){

}

}
