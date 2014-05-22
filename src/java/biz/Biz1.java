/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import entity.AgesCard;
import entity.AgesCardSourceCode;
import entity.Card;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mark
 */
@Named
//@Stateless
@SessionScoped
public class Biz1 implements Serializable {
//public class Biz1 implements Serialiab`le{

    private List<Card> list1;
    private List<AgesCard> list2;
    private List<AgesCardSourceCode> list3;

    public Biz1() {
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        
    }

    public void updateAgesCardList() throws Exception {
        refillCardList();
        refillAgesCardList();

    }

    public List<AgesCardSourceCode> getAgesCardsSourceCode() {
        System.out.println(" ### to provide AgesCard");
        list3 = new ArrayList<>();
        AgesCardSourceCode src;
        for (AgesCard card2 : list2) {
            src=new AgesCardSourceCode();
            src.setSeq(card2.getSeq());
            src.setSourceCode(getGeneratedSourceCode(card2));
            list3.add(src);
//            list3.add(this.getGeneratedSourceCode(card2));
        }

        return list3;
    }

    public static void main(String[] args) throws Exception {
        Biz1 biz1 = new Biz1();
        biz1.refillCardList();
        biz1.refillAgesCardList();
        biz1.showAgesCardGeneratedSourceCode();

    }

    public String getGeneratedSourceCode(AgesCard card) {
        StringBuilder sb = new StringBuilder();
        sb.append("ca.add(new AgesCard(").append(card.getSeq()).append(",");
        sb.append("").append(card.getId()).append(",");
        sb.append("\"").append(card.getName()).append("\",");
        sb.append("").append(card.getAge()).append(",");
        sb.append("\"").append(card.getCivilMilitary()).append("\",");
        sb.append("\"").append(card.getTag()).append("\",");
        sb.append("\"").append(card.getAction()).append("\",");
        sb.append("\"").append(card.getIconPoints()).append("\",");
        sb.append("\"").append(card.getEffect()).append("\",");
        sb.append("\"").append(card.getCost()).append("\",");
        sb.append("\"").append(card.getColor()).append("\",");
        sb.append("").append(card.getCnt()).append(",");
        sb.append("").append(card.getTokenWhite()).append(",");
        sb.append("").append(card.getTokenRed()).append(",");
        sb.append("").append(card.getTokenYellow()).append(",");
        sb.append("").append(card.getTokenBlue()).append(",");
        sb.append("").append(card.getEffectWhite()).append(",");
        sb.append("").append(card.getEffectFood()).append(",");
        sb.append("").append(card.getEffectRed()).append(",");
        sb.append("").append(card.getEffectMusic()).append(",");
        sb.append("").append(card.getEffectStone()).append(",");
        sb.append("").append(card.getEffectIdea()).append(",");
        sb.append("").append(card.getEffectSmile()).append(",");
        sb.append("").append(card.getEffectHouse()).append(",");
        sb.append("").append(card.getEffectBlue()).append(",");
        sb.append("").append(card.getEffectWeapon()).append(",");
        sb.append("").append(card.getEffectWeaponOld()).append(",");
        sb.append("").append(card.getEffectYellow()).append(",");
        sb.append("").append(card.getCostPeople()).append(",");
        sb.append("").append(card.getCostFoot()).append(",");
        sb.append("").append(card.getCostWonder()).append(",");
        sb.append("").append(card.getCostMilitary()).append(",");
        sb.append("").append(card.getCostHorse()).append(",");
        sb.append("").append(card.getCostCannon()).append(",");
        sb.append("").append(card.getCostPeace()).append(",");
        sb.append("").append(card.getCostRevolution()).append(",");
        sb.append("").append(card.getCostRed()).append(",");
        sb.append("").append(card.getCostStone()).append(",");
        sb.append("").append(card.getCostIdea()).append(",");
        sb.append("").append(card.getCostFood()).append(",");
        sb.append("").append(card.getCostMusic()).append("));");
        return sb.toString();
//        System.out.println(sb.toString());

    }

    public void showAgesCardGeneratedSourceCode() {
        for (AgesCard card2 : list2) {
            System.out.println(this.getGeneratedSourceCode(card2));
        }
    }

    public void refillCardList() {
        Client client1 = ClientBuilder.newClient();
        list1 = new ArrayList<>();
        list1 = client1.target("http://localhost:8080/ages-w026-ws/webresources/card")
                .request(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Card>>() {
                });

        for (Card card : list1) {
            System.out.println(card.getId() + " " + card.getName());
        }
        client1.close();
    }

    public void refillAgesCardList() throws Exception {
        list2 = new ArrayList<>();
        AgesCard agesCard;
        int seq = 0;

        for (Card card : list1) {
            for (int num = 0; num < card.getCnt(); num++) {
                seq++;
                agesCard = new AgesCard();
                //
                agesCard.setSeq(seq);
                agesCard.setId(card.getId());
                agesCard.setName(card.getName());
                agesCard.setAction(card.getAction());
                agesCard.setEffect(card.getEffect());
                agesCard.setIconPoints(card.getIconPoints());
                agesCard.setAge(card.getAge());
                agesCard.setCivilMilitary(card.getCivilMilitary());
                agesCard.setTag(card.getTag());
                agesCard.setColor(card.getColor());
                //
                agesCard = updateEffectAndIconPoints(agesCard);
                //
                list2.add(agesCard);
            }
        }
//        list2 = control2.findAgesCardEntities();
        System.out.println("AgesCard in ArrayList size = " + list2.size());

    }

    private AgesCard parseCardEffect(AgesCard card) {
        String[] tokens = card.getEffect().split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = Integer.parseInt(pair[1]);
//            System.out.println(key + " " + val);

//            Effect keyword: [+黃點, +白點, +紅點, 石頭, 燈泡, 笑臉, 食物, 過期武器, +房屋, 音樂, +藍點, 武器]
            switch (key) {
                case "+黃點":
                    card.setEffectYellow(val);
                    break;
                case "+白點":
                    card.setEffectWhite(val);
                    break;
                case "+紅點":
                    card.setEffectRed(val);
                    break;
                case "+藍點":
                    card.setEffectBlue(val);
                    break;
                case "+房屋":
                    card.setEffectHouse(val);
                    break;
                case "食物":
                    card.setEffectFood(val);
                    break;
                case "音樂":
                    card.setEffectMusic(val);
                    break;
                case "石頭":
                    card.setEffectStone(val);
                    break;
                case "燈泡":
                    card.setEffectIdea(val);
                    break;
                case "笑臉":
                    card.setEffectSmile(val);
                    break;
                case "藍點":
                    card.setEffectBlue(val);
                    break;
                case "武器":
                    card.setEffectWeapon(val);
                    break;
                case "過期武器":
                    card.setEffectWeaponOld(val);
                    break;
                default:
                    System.out.println("***************NEED TO HANDLE => " + key);

            }

        }
        return card;
    }

    private AgesCard parseIconPoints(AgesCard card) {
//        int counter=0;
        String[] tokens = card.getIconPoints().split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = -999;
            try {
                if (key.equals("奇蹟石頭")) {
                    val = 98765;
                } else {

                    val = Integer.parseInt(pair[1]);
                }
            } catch (Exception ex) {
                System.out.println(card.getId() + " IconPoints is " + card.getIconPoints());

                System.out.println("token is ###" + token + "###");
                ex.printStackTrace();
                System.exit(-1);
            }
//            System.out.println(key + " " + val);

//            Effect keyword: [+黃點, +白點, +紅點, 石頭, 燈泡, 笑臉, 食物, 過期武器, +房屋, 音樂, +藍點, 武器]
            switch (key) {
                case "擴充人口":
                    card.setCostPeople(val);
                    break;
                case "步":
                    card.setCostFoot(val);
                    break;
                case "奇蹟石頭":
                    card.setCostWonder(val);
                    break;
                case "軍事牌":
                    card.setCostMilitary(val);
                    break;
                case "馬":
                    card.setCostHorse(val);
                    break;
                case "炮":
                    card.setCostCannon(val);
                    break;
                case "和平燈炮":
                    card.setCostPeace(val);
                    break;
                case "革命燈泡":
                    card.setCostRevolution(val);
                    break;
                case "消耗紅點":
                    card.setCostRed(val);
                    break;
                case "石頭":
                    card.setCostStone(val);
                    break;
                case "燈泡":
                    card.setCostIdea(val);
                    break;
                case "食物":
                    card.setCostFood(val);
                    break;
                case "音樂":
                    card.setCostMusic(val);
                    break;

                default:
                    System.out.println("***************NEED TO HANDLE => " + key);
                    System.exit(-1);
            }
        }
        return card;
    }

    private AgesCard updateEffectAndIconPoints(AgesCard card) throws Exception {
        if (card.getEffect().length() > 0) {
            parseCardEffect(card);
        }
        if (card.getIconPoints().length() > 0) {
            parseIconPoints(card);
        }

        return card;
    }
}
