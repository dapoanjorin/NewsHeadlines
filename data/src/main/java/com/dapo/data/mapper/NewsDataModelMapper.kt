package com.dapo.data.mapper

import com.dapo.database.model.ArticleEntity
import com.dapo.remote.model.Article
import javax.inject.Inject

class NewsDataModelMapper @Inject constructor() :
    DataModelMapper<ArticleEntity, Article>() {
    override fun mapFromEntity(entity: ArticleEntity): Article {
        return with(entity) {
            Article(author, content, description, publishedAt, source, title, url, urlToImage)
        }
    }

    override fun mapToEntity(article: Article): ArticleEntity {
        return with(article) {
            ArticleEntity(null, author, content, description, publishedAt, source, title, url, urlToImage)
        }
    }
}