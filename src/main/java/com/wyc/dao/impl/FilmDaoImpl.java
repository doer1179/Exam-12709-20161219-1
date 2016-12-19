package com.wyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.wyc.dao.FilmDao;
import com.wyc.entity.Film;
import com.wyc.util.ConnectionFactory;

public class FilmDaoImpl implements FilmDao {

	@Override
	public List<Film> QueryFilm(Connection conn) throws SQLException {
		List<Film> list = new ArrayList<>();
		
		PreparedStatement ps=conn.prepareStatement("SELECT f.film_id,f.title,f.description,l.name AS 'language'  FROM film f ,language l WHERE  f.language_id=l.language_id");
		
		ResultSet rs=ps.executeQuery();
		
		Film film = null;
		
		
		while(rs.next()){
			
			int film_id=rs.getInt("film_id");
			String title=rs.getString("title");
			String description=rs.getString("description");
			String language=rs.getString("language");
			film=new Film(film_id, title, description, language);
			
			list.add(film);
		}
		return list;
	}

	@Override
	public void DeleteOne(int film_id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps=conn.prepareStatement("DELETE FROM film WHERE film_id=?");
		ps.setInt(1, film_id);
		ps.execute();
	}

	@Override
	public void UpdateOne2(Film film,int language_id) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE film SET title=?,description=?,language_id=? WHERE film_id=?");
		ps.setString(1,film.getTitle());
		ps.setString(2,film.getDescription());
		ps.setInt(3,language_id);
		ps.setInt(4,film.getFilm_id());
		ps.execute();
	}

	@Override
	public void AddFilm(Connection conn,String title,String description,int language_id) throws SQLException {
		
		PreparedStatement ps=conn.prepareStatement("INSERT INTO film(title,description,language_id) VALUES(?,?,?)");
		
		ps.setString(1, title);
		ps.setString(2, description);
		ps.setInt(3, language_id);
		
		ps.execute();
	}

	@Override
	public Film UpdateOne1(int filmid) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT film_id,title,description,l.name AS 'language' FROM film f ,language l WHERE f.film_id=? AND f.language_id=l.language_id");
		ps.setInt(1, filmid);
		ResultSet rs=ps.executeQuery();
		Film film=null;
		if(rs.next()){
			int film_id=rs.getInt("film_id");
			String title=rs.getString("title");
			String description=rs.getString("description");
			String language = rs.getString("language");
			
			film=new Film(film_id, title, description, language);
		}
		return film;
	}

	


}
