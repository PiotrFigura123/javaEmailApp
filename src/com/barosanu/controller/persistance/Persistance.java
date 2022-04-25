package com.barosanu.controller.persistance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistance {

    private String VALID_ACCOUNT_LOCAION = "C:\\Users\\Admin\\IdeaProjects\\EmailApp\\validAccounts.ser";
    public List<ValidAccount> loadFromPersistance(){
        List<ValidAccount> resultList = new ArrayList<ValidAccount>();
        try{
            FileInputStream fileInputStream = new FileInputStream(VALID_ACCOUNT_LOCAION);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<ValidAccount> persistedList = (List<ValidAccount>) objectInputStream.readObject();
            resultList.addAll(persistedList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
    public void saveToPersistance(List<ValidAccount> validAccounts){
        try{
            File file = new File(VALID_ACCOUNT_LOCAION);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(validAccounts);
            objectOutputStream.close();
            fileOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

