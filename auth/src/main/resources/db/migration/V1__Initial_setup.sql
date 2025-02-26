CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    firebase_uid VARCHAR(128) UNIQUE NOT NULL, -- Firebase UID
    username VARCHAR(50) UNIQUE NOT NULL, -- 사용자 이름
    email VARCHAR(100) UNIQUE NOT NULL, -- 이메일
    profile_image VARCHAR(255), -- 프로필 이미지 URL
    bio TEXT, -- 사용자 소개
    date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 가입일
);
