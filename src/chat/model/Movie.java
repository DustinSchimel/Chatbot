package chat.model;

import java.time.LocalDate;
/**
 * 
 * Model that relates to every aspect of the movies
 * @author Dustin Schimel
 *
 */
public class Movie
{
	private String title = "Default title";
	private String genre = "Default genre";
	private String ratingMPAA = "PG";
	private String review = "It's probably good, maybe.";
	private int length = 25;
	private LocalDate releaseDate = LocalDate.now();
	private double starScore;
	
	/**
	 * Initializes all the data members
	 * @param title, genre, ratingMPA, review, length, releaseDate, starScore
	 */
	public Movie(String title, String genre, String ratingMPA, String review, int length, LocalDate releaseDate, double starScore)
	{
		this.title = title;
		this.genre = genre;
		this.ratingMPAA = ratingMPA;
		this.review = review;
		this.length = length;
		this.releaseDate = releaseDate;
		this.starScore = starScore;
	}
	
	/**
	 * Initializes the movie title only
	 * @param title
	 */
	public Movie(String title)
	{
		this.title = title;
		
		if (this.title.length() < 3 || this.title.isEmpty())
		{
			this.title = "Default title";
		}
	}

	public String getTitle()
	{
		if (this.title.equals(""))
		{
			this.title = "dAKSd";
		}
		
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate) //may need to fix this
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		String description = "This is a movie description";
		
		return description;
	}
}
