/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * //   @author mark
 */
//   @Entity
//   @Table(name = "AGES_CARD")
//   @XmlRootElement
//   @NamedQueries({
    //   @NamedQuery(name = "AgesCard.findAll", query = "SELECT a FROM AgesCard a"),
    //   @NamedQuery(name = "AgesCard.findBySeq", query = "SELECT a FROM AgesCard a WHERE a.seq = :seq"),
    //   @NamedQuery(name = "AgesCard.findById", query = "SELECT a FROM AgesCard a WHERE a.id = :id"),
    //   @NamedQuery(name = "AgesCard.findByName", query = "SELECT a FROM AgesCard a WHERE a.name = :name"),
    //   @NamedQuery(name = "AgesCard.findByAge", query = "SELECT a FROM AgesCard a WHERE a.age = :age"),
    //   @NamedQuery(name = "AgesCard.findByCivilMilitary", query = "SELECT a FROM AgesCard a WHERE a.civilMilitary = :civilMilitary"),
    //   @NamedQuery(name = "AgesCard.findByTag", query = "SELECT a FROM AgesCard a WHERE a.tag = :tag"),
    //   @NamedQuery(name = "AgesCard.findByAction", query = "SELECT a FROM AgesCard a WHERE a.action = :action"),
    //   @NamedQuery(name = "AgesCard.findByIconPoints", query = "SELECT a FROM AgesCard a WHERE a.iconPoints = :iconPoints"),
    //   @NamedQuery(name = "AgesCard.findByEffect", query = "SELECT a FROM AgesCard a WHERE a.effect = :effect"),
    //   @NamedQuery(name = "AgesCard.findByCost", query = "SELECT a FROM AgesCard a WHERE a.cost = :cost"),
    //   @NamedQuery(name = "AgesCard.findByColor", query = "SELECT a FROM AgesCard a WHERE a.color = :color"),
    //   @NamedQuery(name = "AgesCard.findByCnt", query = "SELECT a FROM AgesCard a WHERE a.cnt = :cnt"),
    //   @NamedQuery(name = "AgesCard.findByTokenWhite", query = "SELECT a FROM AgesCard a WHERE a.tokenWhite = :tokenWhite"),
    //   @NamedQuery(name = "AgesCard.findByTokenRed", query = "SELECT a FROM AgesCard a WHERE a.tokenRed = :tokenRed"),
    //   @NamedQuery(name = "AgesCard.findByTokenYellow", query = "SELECT a FROM AgesCard a WHERE a.tokenYellow = :tokenYellow"),
    //   @NamedQuery(name = "AgesCard.findByTokenBlue", query = "SELECT a FROM AgesCard a WHERE a.tokenBlue = :tokenBlue"),
    //   @NamedQuery(name = "AgesCard.findByEffectWhite", query = "SELECT a FROM AgesCard a WHERE a.effectWhite = :effectWhite"),
    //   @NamedQuery(name = "AgesCard.findByEffectFood", query = "SELECT a FROM AgesCard a WHERE a.effectFood = :effectFood"),
    //   @NamedQuery(name = "AgesCard.findByEffectRed", query = "SELECT a FROM AgesCard a WHERE a.effectRed = :effectRed"),
    //   @NamedQuery(name = "AgesCard.findByEffectMusic", query = "SELECT a FROM AgesCard a WHERE a.effectMusic = :effectMusic"),
    //   @NamedQuery(name = "AgesCard.findByEffectStone", query = "SELECT a FROM AgesCard a WHERE a.effectStone = :effectStone"),
    //   @NamedQuery(name = "AgesCard.findByEffectIdea", query = "SELECT a FROM AgesCard a WHERE a.effectIdea = :effectIdea"),
    //   @NamedQuery(name = "AgesCard.findByEffectSmile", query = "SELECT a FROM AgesCard a WHERE a.effectSmile = :effectSmile"),
    //   @NamedQuery(name = "AgesCard.findByEffectHouse", query = "SELECT a FROM AgesCard a WHERE a.effectHouse = :effectHouse"),
    //   @NamedQuery(name = "AgesCard.findByEffectBlue", query = "SELECT a FROM AgesCard a WHERE a.effectBlue = :effectBlue"),
    //   @NamedQuery(name = "AgesCard.findByEffectWeapon", query = "SELECT a FROM AgesCard a WHERE a.effectWeapon = :effectWeapon"),
    //   @NamedQuery(name = "AgesCard.findByEffectWeaponOld", query = "SELECT a FROM AgesCard a WHERE a.effectWeaponOld = :effectWeaponOld"),
    //   @NamedQuery(name = "AgesCard.findByEffectYellow", query = "SELECT a FROM AgesCard a WHERE a.effectYellow = :effectYellow"),
    //   @NamedQuery(name = "AgesCard.findByCostPeople", query = "SELECT a FROM AgesCard a WHERE a.costPeople = :costPeople"),
    //   @NamedQuery(name = "AgesCard.findByCostFoot", query = "SELECT a FROM AgesCard a WHERE a.costFoot = :costFoot"),
    //   @NamedQuery(name = "AgesCard.findByCostWonder", query = "SELECT a FROM AgesCard a WHERE a.costWonder = :costWonder"),
    //   @NamedQuery(name = "AgesCard.findByCostMilitary", query = "SELECT a FROM AgesCard a WHERE a.costMilitary = :costMilitary"),
    //   @NamedQuery(name = "AgesCard.findByCostHorse", query = "SELECT a FROM AgesCard a WHERE a.costHorse = :costHorse"),
    //   @NamedQuery(name = "AgesCard.findByCostCannon", query = "SELECT a FROM AgesCard a WHERE a.costCannon = :costCannon"),
    //   @NamedQuery(name = "AgesCard.findByCostPeace", query = "SELECT a FROM AgesCard a WHERE a.costPeace = :costPeace"),
    //   @NamedQuery(name = "AgesCard.findByCostRevolution", query = "SELECT a FROM AgesCard a WHERE a.costRevolution = :costRevolution"),
    //   @NamedQuery(name = "AgesCard.findByCostRed", query = "SELECT a FROM AgesCard a WHERE a.costRed = :costRed"),
    //   @NamedQuery(name = "AgesCard.findByCostStone", query = "SELECT a FROM AgesCard a WHERE a.costStone = :costStone"),
    //   @NamedQuery(name = "AgesCard.findByCostIdea", query = "SELECT a FROM AgesCard a WHERE a.costIdea = :costIdea"),
    //   @NamedQuery(name = "AgesCard.findByCostFood", query = "SELECT a FROM AgesCard a WHERE a.costFood = :costFood"),
    //   @NamedQuery(name = "AgesCard.findByCostMusic", query = "SELECT a FROM AgesCard a WHERE a.costMusic = :costMusic")})
public class AgesCardSourceCode implements Serializable {
    private static final long serialVersionUID = 1L;
    //   @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    //   @Basic(optional = false)
    //   @Column(name = "SEQ")
    private Integer seq;
    private String sourceCode;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
  
    public AgesCardSourceCode() {
    }

    public AgesCardSourceCode(Integer seq) {
        this.seq = seq;
    }
    
}
