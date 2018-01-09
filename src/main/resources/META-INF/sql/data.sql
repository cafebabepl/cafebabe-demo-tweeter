delete from tweeter_tweet;
delete from tweeter_user;

insert into tweeter_user(firstName, lastName, email) values ('Adam', 'Mickiewicz', 'adam.mickiewicz@cafebabe.pl');
insert into tweeter_tweet(title, text, created, user_id) values ('Dziady. Część IV', 'Kto miłości nie zna, ten żyje szczęśliwy, i noc ma spokojną, i dzień nietęskliwy.', now(), (select max(id) from tweeter_user));
insert into tweeter_tweet(title, text, created, user_id) values ('Pan Tadeusz', 'Bo serce nie jest sługa, nie zna, co to pany, I nie da się przemocą okuwać w kajdany.', now(), (select max(id) from tweeter_user));
insert into tweeter_tweet(title, text, created, user_id) values ('Dziady. Część II', 'Cicho wszędzie, głucho wszędzie, co to będzie co to będzie?', now(), (select max(id) from tweeter_user));

insert into tweeter_user(firstName, lastName, email) values ('Juliusz', 'Słowacki', 'juliusz.slowacki@cafebabe.pl');
insert into tweeter_tweet(title, text, created, user_id) values ('Kordian', 'A potem, jako czynią modne bohatery, w łeb sobie strzelę', now(), (select max(id) from tweeter_user));
insert into tweeter_tweet(title, text, created, user_id) values ('Lilla Weneda', 'Nie czas żałować róż, gdy płoną lasy.', now(), (select max(id) from tweeter_user));

insert into tweeter_user(firstName, lastName, email) values ('Bolesław', 'Prus', 'boleslaw.prus@cafebabe.pl');
insert into tweeter_tweet(title, text, created, user_id) values ('Lalka', '...Najgorszą samotnością nie jest tak, która otacza człowieka, ale ta pustka w nim samym', now(), (select max(id) from tweeter_user));

commit;