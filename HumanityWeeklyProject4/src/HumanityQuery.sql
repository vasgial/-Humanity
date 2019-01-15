CREATE DATABASE humanity_weekly_project4;

SELECT * FROM humanity_weekly_project4.student;

SELECT * FROM humanity_weekly_project4.worker;

TRUNCATE humanity_weekly_project4.student ;

INSERT INTO humanity_weekly_project4.worker
value(8, 'Akis', 'Petretzikis', 16.2, 8);

INSERT INTO humanity_weekly_project4.worker
value(null, 'Tzeni', 'Mpotsi', 11.2, 6),
(null, 'Demi', 'Markora', 12.6, 3),
(null, 'Lampros', 'Konstadaras', 15.2, 9),
(null, 'Ntanou', 'Kouloumpi', 11.2, 7),
(null, 'Giannis', 'Mpatsinilas', 11.2, 6),
(null, 'Lilika', 'Kalitsi', 16.5, 3),
(null, 'Dimitra', 'Triovolou', 19.2, 6),
(null, 'Akis', 'Petretzikis', 16.2, 8),
(null, 'Sakis', 'Rouvas', 31.2, 6),
(null, 'Katia', 'Papathanasiou', 11.2, 6),
(null, 'Maria', 'Tzirita', 21.5, 3),
(null, 'Elli', 'Stay', 19.2, 6),
(null, 'Tati', 'Stefanidou', 19.2, 8),
(null, 'Stefanos', 'Xios', 41.2, 3),
(null, 'Tzesi', 'Papoutsi', 11.2, 6);


INSERT INTO humanity_weekly_project4.student 
value (null, 'Anna' , 'Papantoniou', 'AB78' ), 
(null, 'Stavroula' , 'Gialeleli', 'AB78' ),
(null, 'Antonios' , 'Gialelis', 'AB78' ),
(null, 'Fotini' , 'Anagnostopoulou', 'AB78' ),
(null, 'Maria' , 'Papantoniou', 'AB78' ),
(null, 'Konstantina' , 'Gialeli', 'AB78' ),
(null, 'Stelios' , 'Nikolis', 'BS99' ),
(null, 'Vasiliki' , 'Gialeli', 'BS99' ),
(null, 'Giorgos' , 'Xalastaras', 'AB78' ),
(null, 'Konstantinos' , 'Papantoniou', 'AG66' ),
(null, 'Nikolaos' , 'Gialelis', 'AG66' ),
(null, 'Styliani' , 'Mpilanteri', 'AG66'),
(null, 'Stefanos' , 'Kosyvas', 'AG66'),
(null, 'Thodoris' , 'Papantoniou', 'AG66'),
(null, 'Koula' , 'Papadopoulou', 'AG66'),
(null, 'Aggeliki' , 'Eleftheriou', 'AG66');

UPDATE humanity_weekly_project4.student 
SET firstName = 'VASILIKI', lastName = 'GIALELI' , faculty = 'AB080128'
WHERE id = 2;


SELECT id FROM humanity_weekly_project4.worker WHERE firstName = 'Tzeni' and lastName = 'Mpotsi';
SELECT id FROM humanity_weekly_project4.worker WHERE firstName = ? and lastName = ?;

DELETE FROM humanity_weekly_project4.worker WHERE id = 1;




