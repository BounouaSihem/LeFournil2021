package fr.fournil.bakery.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FrequencyCommandeProduct {

	public static final String OptionPonctuel = "achat ponctuel";
	public static final String OptionOne = "Une fois par semaine pendant 1 mois";
	public static final String OptionTwo = "Une fois par semaine pendant 2 mois";
	public static final String OptionThree = "Une fois par semaine pendant 3 mois";
	public static final String OptionFour = "Une fois par semaine pendant 4 mois";
	public static final String OptionFive = "Une fois par semaine pendant 5 mois";
	public static final String OptionSix = "Une fois par semaine pendant 6 mois";
	public static final String OptionSeven = "Une fois par semaine pendant 7 mois";
	public static final String OptionEight = "Une fois par semaine pendant 8 mois";
	public static final String OptionNine = "Une fois par semaine pendant 9 mois";
	public static final String OptionTen = "Une fois par semaine pendant 10 mois";
	public static final String OptionEleven = "Une fois par semaine pendant 11 mois";
	public static final String OptionTwelve = "Une fois par semaine pendant 12 mois";
	public static final String OptionOneAlter = "Une fois tous les deux semaines pendant 1 mois";
	public static final String OptionTwoAlter = "Une fois tous les deux semaines pendant 2 mois";
	public static final String OptionThreeAlter = "Une fois tous les deux semaines pendant 3 mois";
	public static final String OptionFourAlter = "Une fois tous les deux semaines pendant 4 mois";
	public static final String OptionFiveAlter = "Une fois tous les deux semaines pendant 5 mois";
	public static final String OptionSixAlter = "Une fois tous les deux semaines pendant 6 mois";
	public static final String OptionSevenAlter = "Une fois tous les deux semaines pendant 7 mois";
	public static final String OptionEightAlter = "Une fois tous les deux semaines pendant 8 mois";
	public static final String OptionNineAlter = "Une fois tous les deux semaines pendant 9 mois";
	public static final String OptionTenAlter = "Une fois tous les deux semaines pendant 10 mois";
	public static final String OptionElevenAlter = "Une fois tous les deux semaines pendant 11 mois";
	public static final String OptionTwelveAlter = "Une fois tous les deux semaines pendant 12 mois";

	

	

}
