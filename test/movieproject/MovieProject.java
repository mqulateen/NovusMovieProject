/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieproject;

import DataLayer.MovieData;
import ClassLayer.*;
import ApplicationVariables.AppVariables;
import BusinessLayer.MovieBusinessLayer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author mqul
 */
public class MovieProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MovieBusinessLayer mbl = new MovieBusinessLayer();
        Films films = mbl.getFilmsFromCSV(AppVariables.FILE_PATH);
        
        Films f = mbl.getFilmSubsetByMovieID(films, "2975590");
        f.forEach(x -> System.out.println(x.filmName));
        
        mbl.getDistinctActorsFromFilms(films, null).forEach(x -> System.out.println(x.getName()));
        
        
        /*List<Film> tmpFilms= new ArrayList();
        
        tmpFilms.addAll(films.stream().filter(x -> x.actors.stream().anyMatch(li -> li.getID().equals(" 0000255"))).collect(Collectors.toList()));
        
        /*films.forEach(film -> film.actors.stream().anyMatch(li -> li.getID().equals(" 0000255")));
        for(Film film : films){
            List<Actor> aList = film.actors;
            
            if(aList.stream().anyMatch(li -> li.getID().equals(" 0000255"))){
                tmpFilms.add(film);
            }
        }*/
        
        //tmpFilms.forEach(x -> System.out.println(x.filmName));
        
        
       /* MovieData md = new MovieData();
        
        try{
            List<Film> films = md.getCsvData(AppVariables.FILE_PATH);
            
            //films.stream().filter(f -> f.actors.stream().forEach(System.out::println));
            
            for(Film f:films){
                System.out.println("-----------");
                System.out.println(f.filmName);
                for(Director d : f.directors){
                    System.out.println("----Dir----");
                    System.out.println(d.personName);
                }
                
                for(Actor a : f.actors){
                    System.out.println("----Act----");
                    System.out.println(a.personName);
                    System.out.println("-----------");
                }
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
    
}
