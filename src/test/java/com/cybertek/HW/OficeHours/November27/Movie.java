package com.cybertek.HW.OficeHours.November27;

public class Movie {
    /*
    Create a class named Movie that can be used with your video rental business.
The Movie class should track the Motion Picture Association of America
(MPAA) rating (e.g., Rated G, PG-13, R), ID Number, and movie title with appropriate accessor and mutator methods.
Also create an equals() method that overrides Object's equals() method,
where two movies are equal if their ID number is identical.
Next, create three additional classes named Action, Comedy, and Drama that are derived from Movie.
Finally, create an overridden method named calcLateFees that takes as input the number of days a movie is late and returns the late fee for that movie. The default late fee is $2/day.
Action movies have a late fee of $3/day, comedies are $2.50/day, and dramas are $2/day.
Create Cinema class with a main method to tests it.

Ask user to enter a movie ID and how many days it was late to display late fee.
Collapse
     */
    private String raiting;
    private int IdNumber;
    private String title;

    public void setRating(String raiting) {
        this.raiting =raiting;
    }

    public String getRaiting() {
        return raiting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdNumber() {
        return IdNumber;
    }
    public void setIdNumber(int idNumber) {
        this.IdNumber=IdNumber;
    }

    // based on our criteria, check if 2 object the same
    @Override
    public boolean equals(Object object) {
        Movie movie = (Movie) object;
        return this.IdNumber == movie.getIdNumber();
    }

    // to describe object
    @Override
    public String toString() {
        return "Movie{" +
                "rating='" + raiting + '\'' +
                ", IdNumber=" + IdNumber +
                ", title='" + title + '\'' +
                '}';
    }

    //create an overridden method named calcLateFees that takes
    //as input the number of days a movie is late and returns
    //the late fee for that movie. The default late fee is $2/day
    public double calcLateFees(int days) {
        return days * 2;
    }

    public Movie getMoviesById(Movie[] movies,int movieID) {
        for (Movie m: movies){
            if(m.IdNumber==movieID){
                return m;
            }
        }
        return null;
    }


}
