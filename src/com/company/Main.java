package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        Map<String,String[]>newWords=new HashMap<>();
        dictionary.put("дом", new String[]{"жилище", "логово", "хата", "квартира"});
        dictionary.put("большой", new String[]{"крупный", "огромный", "массивный", "громадный"});
        dictionary.put("красивый", new String[]{"безупречный", "симпотичный", "прекрасный", "привлекательный"});
        dictionary.put("человек", new String[]{"персона", "личность", "индивидум"});
        dictionary.put("Книга ",new String[]{"Словарь"," Литература ","Справочник"});
        dictionary.put("Цвета",new String[]{"Красный "," Чорный ","Белый"});
        dictionary.put("Одежда",new String[]{"Шапка "," Куртка","Перчатки"});
        dictionary.put("Планета ",new String[]{"Земля"," Марс ","Луна"});
        dictionary.put("Озера ",new String[]{"Ысак Кол"," Кол тор  ","Кегети "});
        dictionary.put("Цветы  ",new String[]{" Роза "," Аргхидея  "," Ромашка "});


          Set<String>Keys=dictionary.keySet();
        Iterator iterator=Keys.iterator();
        while (iterator.hasNext()){
            String Key=iterator.next().toString();
            String[]values=dictionary.get(Key);
            newWords.put(Key,values);
            for (int i = 0; i < values.length ; i++) {
                String StillKeys=values[i];
                ArrayList<String>list=new ArrayList<>(values.length);
                list.addAll(Arrays.asList(values));
                list.remove(StillKeys);
                list.add(Key);
                String[]StillValues=new String[list.size()];
                StillValues=list.toArray(StillValues);
                System.out.println(StillKeys+" -  "+ Arrays.toString(StillValues));

                newWords.put(StillKeys,StillValues);

            }
        }

        for (Map.Entry<String, String[]> item : dictionary.entrySet()) {
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));
        }

        while (true) {
            System.out.println("Введите слова из словаря:");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for (String word: words) {
                String[] values = dictionary.get(word);
                if (values != null) {
                    Random r = new Random();
                    int k = r.nextInt(values.length);
                    System.out.print(values[k]+" ");
                } else
                    System.out.print("Такого слова нет");
            }
            System.out.println();

        }

    }
}
