package com.wyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wyc.dao.LanguageDao;
import com.wyc.entity.Language;

public class LanguageDaoImpl implements LanguageDao {

	@Override
	public List<Language> GetLanguageList(Connection conn) throws SQLException {
		List<Language>list=new ArrayList<>();
		
		PreparedStatement ps=conn.prepareStatement("SELECT language_id,name AS 'language'  FROM language ;");
		ResultSet rs=ps.executeQuery();
		Language language=null;
		while(rs.next()){
		language=new Language(); 
		language.setLanguage_id(rs.getInt("language_id"));
		language.setName(rs.getString("language"));
		list.add(language);
		}
		
		return list;
	}

}
