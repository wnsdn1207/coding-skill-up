package own.junn.practice;

import java.util.*;

public class HashTest {
    public static boolean hasNotPrefixString(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i=0; i<phone_book.length; i++) {
            for (int j=0; j<phone_book.length; j++) {
                if (i == j) continue;

                if (phone_book[j].length() >= phone_book[i].length()) {
                    if (phone_book[j].replaceAll("\"", "").startsWith(phone_book[i].replaceAll("\"", ""))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static int getAllCasesOfLook(String[][] clothes) {
        int totalCases = 0;

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String[] unitClothes : clothes) {
            String key = unitClothes[1].replaceAll("\"", "").replaceAll(" ", "");

            ArrayList<String> array = map.getOrDefault(key, new ArrayList<>());
            array.add(unitClothes[0].replaceAll("\"", "").replaceAll(" ", ""));

            map.put(key, array);
        }

        if (map.size() > 1) {
            int addCases = 1;

            for (String key : map.keySet()) {
                ArrayList<String> array = map.get(key);

                if (array.size() > 0) {
                    int temp = array.size()+1;
                    addCases *= temp;
                }
            }

            totalCases += addCases;
            totalCases -= 1;
        } else {
            totalCases += clothes.length;
        }

        return totalCases;
    }


    public static int[] getBestAlbum(String[] genres, int[] plays) {
        HashMap<String, Integer> totalCountMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            int playCount = totalCountMap.getOrDefault(genres[i].replaceAll(" ", ""), 0);
            playCount+= plays[i];

            totalCountMap.put(genres[i].replaceAll(" ", ""), playCount);
        }

        HashMap<Integer, String> reversedMap = new HashMap<>();
        for (String key : totalCountMap.keySet()) {
            reversedMap.put(totalCountMap.get(key), key);
        }

        System.out.println(String.format("key : %s, values : %s", totalCountMap.keySet(), totalCountMap.values()));

        ArrayList<Integer> playCountArray = new ArrayList<>(reversedMap.keySet());

        Collections.sort(playCountArray);       // sort를 먼저해주어야 내부 인스턴스가 정렬됨 (오름차순 정렬)
        Collections.reverse(playCountArray);    // sort 이후에 reverse를 해주어야 역순으로 정렬됨 (오름차순 정렬을 reverse 시킴 -> 내림차순 정렬)

        int index = 0;
        String[] orderedGenres = new String[totalCountMap.size()];
        for (int playCount : playCountArray) { orderedGenres[index++] = reversedMap.get(playCount); }

        ArrayList<Integer> tempBestAlbum = new ArrayList<>();

        System.out.println(String.format("ordererGenre : %s", Arrays.toString(orderedGenres)));

        for (String genre : orderedGenres) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i=0; i<plays.length; i++) {
                if (genres[i].replaceAll(" ", "").equalsIgnoreCase(genre)) {
                    if (map.containsKey(plays[i])) {
                        int tempValue = map.get(plays[i]);

                        if (tempValue <= i) {
                            map.put(plays[i], tempValue);
                        }
                    } else {
                        map.put(plays[i], i);
                    }
                }
            }

//            Iterator iterator = map.keySet().iterator();  // TreeMap key 기준 오름차순 정렬
            Iterator iterator = map.descendingKeySet().iterator();  // TreeMap key 기준 내림차순 정렬

            for (int i=0; i<2; i++)  {
                if (iterator.hasNext()) {
                    int key = (Integer) iterator.next();
                    System.out.println(String.format("key : %d, value : %d", key, map.get(key)));
                    tempBestAlbum.add(map.get(key));
                    index++;
                }
            }
        }

        int[] bestAlbum = new int[tempBestAlbum.size()];

        for (int i=0; i<bestAlbum.length; i++) {
            bestAlbum[i] = tempBestAlbum.get(i);
        }

        return bestAlbum;
    }

    public static int[] getBestAlbum2(String[] genres, int[] plays) {
        int i=0;
        for (String genre : genres) {

            Genre unitGenre = new Genre(genre, plays[++i]);
        }

        int[] bestAlbum = new int[4];

        return bestAlbum;
    }

    public static class Genre {
        public String genreName;
        public int playCount;

        public Genre(String genreName, int playCount) {
            this.genreName = genreName;
            this.playCount += playCount;
        }
    }
}
