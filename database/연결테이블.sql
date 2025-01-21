drop table pokemon_image;
create table pokemon_image (
	pokemon_no references pokemon(pokemon_no) on delete cascade,
	attachment_no references attachment(attachment_no) on delete cascade
primary key(pokemon_no, attachment_no)
unique(pokemon_no)
);

create table country_flag (
	country_no references country(country_no) on delete cascade,
	attachment_no references attachment(attachment_no) on delete cascade
);

create table game_user_profile (
	game_user_no references game_user(game_user_no) on delete cascade,
	attachment_no references attachment(attachment_no) on delete cascade
);


select * from pokemon_image;
select * from country_flag;
select * from game_user_profile;
