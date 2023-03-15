INSERT INTO article(id, title, content)VALUES (1, '귀멸의 칼날', '이거 어떻게 생각함?');
INSERT INTO article(id, title, content)VALUES (2, '타이타닉', '이거 완전 슬프지 않나요? ㅠㅠ');
INSERT INTO article(id, title, content)VALUES (3, '트랜스포터', '좀 오래된 영환데.. 이거 나만재밌음?');

--article 더미 데이터
INSERT INTO article(id, title, content)VALUES (4, '트랜스포머', '포터보다 포머 아니냐? ㅋㅋ');
INSERT INTO article(id, title, content)VALUES (5, '어벤져스', '어벤져스가 짱임');
INSERT INTO article(id, title, content)VALUES (6, '토르', '토르형 너무 멋있음..');

--comment 더미 데이터

---1번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (10,1, '이영민', '귀칼. 진짜 작화가좋다.');
INSERT INTO comment(id, article_id,nickname, body)VALUES (11,1, '최무웅', '언능 극장판 나와야함');
INSERT INTO comment(id, article_id,nickname, body)VALUES (12,1, '유현재', '재밌긴해~');
---2번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (13,2, '김덕수', '처음으로 눈물흘린 영화');
INSERT INTO comment(id, article_id,nickname, body)VALUES (14,2, '박박재', '여주인공 지금봐도 이쁘네.');
INSERT INTO comment(id, article_id,nickname, body)VALUES (15,2, '유현재', '재밌긴해~');
---3번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (16,3, '김현수', 'ㅋㅋ자동차 액션 오짐');
INSERT INTO comment(id, article_id,nickname, body)VALUES (17,3, '석박지', '자동차 액션하면 생각나는건 포터뿐');
INSERT INTO comment(id, article_id,nickname, body)VALUES (18,3, '유현재', '포머같은 영화하고 비교 ㄴㄴ');
---4번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (1,4, '이영민', '맞아.. 포머가짱이지.');
INSERT INTO comment(id, article_id,nickname, body)VALUES (2,4, '최무웅', '야 그래도 포터가 재밌음ㅋㅋ');
INSERT INTO comment(id, article_id,nickname, body)VALUES (3,4, '유현재', '노잼.');
---5번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (4,5, '유병재', '마블껀 다좋음');
INSERT INTO comment(id, article_id,nickname, body)VALUES (5,5, '부정맨', '아이언맨 죽은 이후로는 거들떠도안봄');
INSERT INTO comment(id, article_id,nickname, body)VALUES (6,5, '주펄', '신과 함께가 더잼남');
---6번 게시글의 댓글들
INSERT INTO comment(id, article_id,nickname, body)VALUES (7,6, '주펄', '신과함께보셈');
INSERT INTO comment(id, article_id,nickname, body)VALUES (8,6, '침착맨', '서유기 보세요');
INSERT INTO comment(id, article_id,nickname, body)VALUES (9,6, '이영민', '토르 멋있지. ㅎㅎ');