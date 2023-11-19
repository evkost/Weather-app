package com.evkost.weatherapp.data.local.database.dao.core.query;

import java.util.Arrays;

public class QueryBuilder {
    private final Query query = new Query();

    public QueryBuilder selection(String selection, Object... args) {
        this.query.setSelection(selection);
        this.query.setSelectionArgs(Arrays.stream(args).map(Object::toString).toArray(String[]::new));
        return this;
    }

    public QueryBuilder groupBy(String groupBy) {
        this.query.setGroupBy(groupBy);
        return this;
    }

    public QueryBuilder having(String having) {
        this.query.setHaving(having);
        return this;
    }

    public QueryBuilder orderBy(String orderBy) {
        this.query.setOrderBy(orderBy);
        return this;
    }

    public Query build() {
        return query;
    }
}
