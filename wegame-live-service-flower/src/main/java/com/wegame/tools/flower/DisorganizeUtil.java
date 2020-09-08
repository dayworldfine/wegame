package com.wegame.tools.flower;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName：DisorganizeUtil
 * @Description: 打乱工具类
 * @Author：13738700108
 * @Data 2020/9/8 22:31
 * @Version: v1.0
 **/
public class DisorganizeUtil {


    public static List<Player> disorganizePlayers(List<Player> players) {
        System.out.println("打乱前："+players);
        /*两种方法都行*/
//        Collections.shuffle(players);
//        Iterator<Player> iterator = players.iterator();
//        while (iterator.hasNext()){
//            Player next = iterator.next();
//            Card[] cards = next.getCards();
//            List<Card> cards1 = Arrays.asList(cards);
//            Collections.shuffle(cards1);
//        }
        Collections.shuffle(players);
        players.stream().forEach(p-> Collections.shuffle(Arrays.asList(p.getCards())));
        System.out.println("打乱后："+players);
        return players;
    }
}
