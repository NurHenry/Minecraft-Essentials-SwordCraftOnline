package de.sco.essential.util;

import java.util.ArrayList;
import java.util.List;

public class InsultSystem{

    private List<String> words = new ArrayList<>();

    public InsultSystem() {

    }

    private boolean onList(String word){
        if (words.contains(word)){
            return true;
        }
        return false;
    }

    private void addWord(String word){
        words.add(word);
    }

    private void removeWord(String word){
        words.remove(word);
    }

}
