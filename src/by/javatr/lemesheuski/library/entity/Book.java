package by.javatr.lemesheuski.library.entity;

import by.javatr.lemesheuski.library.entity.exception.BookException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    String title;
    String author;
    int year;
    String annotation;
    List<String> genres;

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        if (title != null) {
            this.title = title;
            return true;
        }
        return false;
    }

    public String getAuthor() {
        return author;
    }

    public boolean setAuthor(String author) {
        if(author != null) {
            this.author = author;
            return true;
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        if (year > 1800 && year < 2020) {
            this.year = year;
            return true;
        }
        return false;
    }

    public String getAnnotation() {
        return annotation;
    }

    public boolean setAnnotation(String annotation) {
        if(annotation!=null){
            if(annotation.length()>20 && annotation.length()<1000){
                this.annotation = annotation;
                return true;
            }
        }
        return false;
    }

    public List<String> getGenres() {
        List<String> tmp = new ArrayList<>();
        for (String genre:genres) {
            tmp.add(genre);
        }
        return tmp;
    }

    public boolean setGenres(List<String> genres) {
        if(!genres.isEmpty()){
            this.genres = genres;
            return true;
        }
        return false;
    }

    public Book(String title, String author, int year,
                String annotation, List<String> genres)
    throws BookException {
        if(title == null)
            throw new BookException("Title is empty");
        if(author == null)
            throw new BookException("Author is empty");
        if(annotation == null)
            throw new BookException("Annotation is empty");
        if(genres == null)
            throw new BookException("Genres is empty");
        if(!setTitle(title))
            throw new BookException("Incorrect title");
        if(!setAuthor(author))
            throw new BookException("Incorrect author");
        if(!setYear(year))
            throw new BookException("Incorrect year");
        if(!setAnnotation(annotation))
            throw new BookException("Incorrect annotation");
        if(!setGenres(genres))
            throw new BookException("Incorrect genres");
    }

    @Override
    public String toString() {
        StringBuilder genresStr = new StringBuilder();
        for(String str: genres){
            genresStr.append(str + " ");
        }
        genresStr.toString().trim();
        return  title + '\n' +
                author + '\n' +
                year +'\n'+
                genresStr.toString().trim()+'\n'+
                annotation + '\n';

    }
}
