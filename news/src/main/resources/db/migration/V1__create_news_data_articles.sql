CREATE TABLE news_data_articles (
                               id SERIAL PRIMARY KEY,
                               article_id VARCHAR(255) UNIQUE NOT NULL, -- JSON의 article_id
                               title VARCHAR(255) NOT NULL,
                               link TEXT NOT NULL,
                               video_url TEXT, -- JSON의 video_url
                               description TEXT,
                               content TEXT,
                               image_url TEXT, -- JSON의 image_url
                               source_id VARCHAR(255), -- JSON의 source_id
                               source_priority INT, -- JSON의 source_priority
                               source_url TEXT, -- JSON의 source_url
                               country TEXT[], -- JSON의 country (PostgreSQL 배열 사용)
                               category TEXT[], -- JSON의 category (PostgreSQL 배열 사용)
                               keywords TEXT[], -- JSON의 keywords (PostgreSQL 배열 사용)
                               pub_date TIMESTAMP, -- JSON의 pubDate
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_created_at ON news_data_articles(created_at);
CREATE INDEX idx_title ON news_data_articles(title);
CREATE INDEX idx_article_id ON news_data_articles(article_id);