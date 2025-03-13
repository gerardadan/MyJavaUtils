package org.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T> void readGenericList(List<T> list){
        for(T item :list){
            Print.printConsole(item.toString());
        }
    }

    public static void readIntList(List<Integer> integers){
        for(Integer intItem :integers){
            Print.printConsole(intItem.toString());
        }
    }

    public static List<Integer> invertIntList(List<Integer> integers){
        checkListIsEmpty(integers);
        List<Integer> invertedIntList = new ArrayList<>();
        for(int i=integers.size()-1;i>=0;i--){
            invertedIntList.add(integers.get(i));
        }

        return invertedIntList;
    }

    public static <T> List<T> invertTList(List<T> list){
        checkListIsEmpty(list);
        List<T> invertedList = new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            invertedList.add(list.get(i));
        }

        return invertedList;
    }

    public static List<Integer> setNumbersIntList(int size){
        List<Integer> listInt = new ArrayList<>();
        for(int i=0;i<=size;i++){
            listInt.add(i);
        }

        return listInt;
    }

    public static <T> boolean checkListIsEmpty(List<T> list){
        if(list.isEmpty())
            throw new IllegalStateException ("List is empty");
        return false;
    }

}
