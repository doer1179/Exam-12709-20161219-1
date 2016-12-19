package com.wyc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wyc.entity.Film;

public interface FilmDao {

	public List<Film> QueryFilm(Connection conn)throws SQLException;
	public void AddFilm(Connection conn,String title,String description,int language_id)throws SQLException;

	public void DeleteOne(int film_id)throws SQLException;
	public Film UpdateOne1(int film_id)throws SQLException;
	public void UpdateOne2(Film film,int language_id)throws SQLException;
}
