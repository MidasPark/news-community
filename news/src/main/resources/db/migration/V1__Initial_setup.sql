CREATE TABLE news_articles (
                               id SERIAL PRIMARY KEY,
                               article_id VARCHAR(255) UNIQUE NOT NULL, -- JSON의 article_id
                               title VARCHAR(255) NOT NULL,
                               link TEXT NOT NULL,
                               keywords TEXT[], -- JSON의 keywords (PostgreSQL 배열 사용)
                               creator TEXT[], -- JSON의 creator (PostgreSQL 배열 사용)
                               video_url TEXT, -- JSON의 video_url
                               description TEXT,
                               content TEXT NOT NULL,
                               pub_date TIMESTAMP, -- JSON의 pubDate
                               image_url TEXT, -- JSON의 image_url
                               source_id VARCHAR(255), -- JSON의 source_id
                               source_priority INT, -- JSON의 source_priority
                               source_name VARCHAR(255), -- JSON의 source_name
                               source_url TEXT, -- JSON의 source_url
                               source_icon TEXT, -- JSON의 source_icon
                               country TEXT[], -- JSON의 country (PostgreSQL 배열 사용)
                               category TEXT[], -- JSON의 category (PostgreSQL 배열 사용)
                               date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          article_id INT NOT NULL REFERENCES news_articles(id) ON DELETE CASCADE,
                          user_id INT NOT NULL,
                          content TEXT NOT NULL,
                          date_posted TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          status BOOLEAN DEFAULT TRUE -- True: Approved, False: Pending
);

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) UNIQUE NOT NULL,
                            description TEXT
);

CREATE TABLE article_categories (
                                    article_id INT NOT NULL REFERENCES news_articles(id) ON DELETE CASCADE,
                                    category_id INT NOT NULL REFERENCES categories(id) ON DELETE CASCADE,
                                    PRIMARY KEY (article_id, category_id)
);

CREATE TABLE likes (
                       id SERIAL PRIMARY KEY,
                       article_id INT NOT NULL REFERENCES news_articles(id) ON DELETE CASCADE,
                       user_id INT NOT NULL,
                       date_liked TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE article_tags (
                              article_id INT NOT NULL REFERENCES news_articles(id) ON DELETE CASCADE,
                              tag_id INT NOT NULL REFERENCES tags(id) ON DELETE CASCADE,
                              PRIMARY KEY (article_id, tag_id)
);

CREATE TABLE notifications (
                               id SERIAL PRIMARY KEY,
                               user_id INT NOT NULL,
                               message TEXT NOT NULL,
                               is_read BOOLEAN DEFAULT FALSE, -- 읽음 여부
                               date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
