package com.wyc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.wyc.entity.Language;

public interface LanguageDao {

	public List<Language> GetLanguageList(Connection conn)throws SQLException;
}
