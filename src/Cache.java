import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by suyeon on 2017-09-16.
 */
public class Cache {
    public static void main(String[] args){
        int cacheSize = 5;
        String[] cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        LinkedList<String> cityList = new LinkedList<>();
        int miss = 0, hit = 0;


        //hit인지 miss인지 counting
        for(int i= 0; i<cities.length; i++){
            // 소문자로 변환
            cities[i] = cities[i].toLowerCase();

            if( cityList.contains(cities[i]) ){
                hit += 1;   //적중수 증가
                int index = cityList.indexOf(cities[i]);
                cityList.remove(index);
                cityList.add(cities[i]);    // 다시 최근에 썼다는 의미로 큐듸 가장 뒤에 배치
            }
            else{   // 캐시에 없는 도시라면?
                miss += 5;

                if(cityList.size() < cacheSize){    //리스트에 공간이 남아있을때
                    cityList.add(cities[i]);

                }
                else{
                    if(cacheSize == 0){
                        continue;
                    }
                    cityList.removeFirst();
                    cityList.add(cities[i]);
                    /*
                    int index = cityList.indexOf(cities[i]);
                    cityList.remove(index);
                    cityList.add(cities[i]);
                    */
                }
            }
        } //for()

        int sum = miss + hit;
        System.out.println("실행시간 " + sum);

    }
}
