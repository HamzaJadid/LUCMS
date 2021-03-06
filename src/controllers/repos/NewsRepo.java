package controllers.repos;

import com.j256.ormlite.dao.Dao;
import models.News;
import services.IModel;
import services.Persistence;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public final class NewsRepo extends Persistence {
    private static NewsRepo _news;
    private final Dao<IModel, String> _accessObject;

    private NewsRepo() throws SQLException {
        _accessObject = getAccessObject(News.class);
    }

    public static NewsRepo getInstance() throws SQLException {
        if(_news == null) _news = new NewsRepo();
        return _news;
    }

    @Override
    public void create(IModel model) throws SQLException {
        final News news = (News) model;
        _accessObject.create(news);
    }

    @Override
    public List<IModel> retrieveAll() throws SQLException {
        final List<IModel> models = _accessObject.queryBuilder().query();
        Collections.reverse(models);
        return models;
    }

    @Override
    public void update(IModel model) throws SQLException {

    }

    @Override
    public void delete(IModel model) throws SQLException {

    }
}
