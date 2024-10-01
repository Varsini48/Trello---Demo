create database virtualartgallery;
use virtualartgallery;

-- creation of table 'artists'

CREATE TABLE Artists (
 ArtistID INT PRIMARY KEY,
 Name VARCHAR(255) NOT NULL,
 Biography TEXT,
 Nationality VARCHAR(100));
 
 -- creation of table 'categories'
 
 CREATE TABLE Categories (
 CategoryID INT PRIMARY KEY,
 Name VARCHAR(100) NOT NULL);
 
 -- creation of table 'artworks'
 
 CREATE TABLE Artworks (
 ArtworkID INT PRIMARY KEY,
 Title VARCHAR(255) NOT NULL,
 ArtistID INT,
 CategoryID INT,
 Year INT,
 Description TEXT,
 ImageURL VARCHAR(255),
 FOREIGN KEY (ArtistID) REFERENCES Artists (ArtistID),
 FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID));
 
 -- creation of table 'exhibitions'
 
 CREATE TABLE Exhibitions (
 ExhibitionID INT PRIMARY KEY,
 Title VARCHAR(255) NOT NULL,
 StartDate DATE,
 EndDate DATE,
 Description TEXT);
 
 -- creation of table 'ExhibitionArtworks'
 
 CREATE TABLE ExhibitionArtworks (
 ExhibitionID INT,
 ArtworkID INT,
 PRIMARY KEY (ExhibitionID, ArtworkID),
 FOREIGN KEY (ExhibitionID) REFERENCES Exhibitions (ExhibitionID),
 FOREIGN KEY (ArtworkID) REFERENCES Artworks (ArtworkID));
 
 -- insertion of records into 'Artists'
 
 INSERT INTO Artists (ArtistID, Name, Biography, Nationality) VALUES
 (1, 'Pablo Picasso', 'Renowned Spanish painter and sculptor.', 'Spanish'),
 (2, 'Vincent van Gogh', 'Dutch post-impressionist painter.', 'Dutch'),
 (3, 'Leonardo da Vinci', 'Italian polymath of the Renaissance.', 'Italian');
 
 -- insertion of records into 'Categories'
 
 INSERT INTO Categories (CategoryID, Name) VALUES
 (1, 'Painting'),
 (2, 'Sculpture'),
 (3, 'Photography');
 
 -- insertion of records into 'Artworks'
 
 INSERT INTO Artworks (ArtworkID, Title, ArtistID, CategoryID, Year, Description, ImageURL) VALUES
 (1, 'Starry Night', 2, 1, 1889, 'A famous painting by Vincent van Gogh.', 'starry_night.jpg'),
 (2, 'Mona Lisa', 3, 1, 1503, 'The iconic portrait by Leonardo da Vinci.', 'mona_lisa.jpg'),
 (3, 'Guernica', 1, 1, 1937, 'Pablo Picasso\'s powerful anti-war mural.', 'guernica.jpg');
 
 update artworks set categoryid = 1 where artworkid=3;
 select * from artworks;
 
 -- insertion of records into 'exhibitions'
 
 INSERT INTO Exhibitions (ExhibitionID, Title, StartDate, EndDate, Description) VALUES
 (1, 'Modern Art Masterpieces', '2023-01-01', '2023-03-01', 'A collection of modern art masterpieces.'),
 (2, 'Renaissance Art', '2023-04-01', '2023-06-01', 'A showcase of Renaissance art treasures.');
 
 -- insertion of records into 'ExhibitionArtworks'
 
 INSERT INTO ExhibitionArtworks (ExhibitionID, ArtworkID) VALUES
 (1, 1),
 (1, 2),
 (1, 3),
 (2, 2);
 delete from ExhibitionArtworks  where artworkid=3;
 
 select * from exhibitionartworks;
 desc artworks;
 
-- 1 Retrieve the names of all artists along with the number of artworks they have in the gallery, and list them in descending order of the number of artworks.

select artists.name, count(artworks.artworkid) as no_artworks
from artists
join artworks
on artists.artistid=artworks.artistid
group by artists.artistid
order by no_artworks desc;

-- 2 (incomplete) List the titles of artworks created by artists from 'Spanish' and 'Dutch' nationalities, and order
-- them by the year in ascending order.

select artworks.title, artists.artistid
from artists 
join artworks
on artists.artistid=artworks.artistid
where artists.artistid in (select artistid from artists where nationality = 'spanish' or 'dutch' )
order by artworks.year ;

-- 3 Find the names of all artists who have  artworks in the 'Painting' category, and the number of
-- artworks they have in this category.

select artists.name, count(artworks.categoryid) as no_of_artworks
from artists
join artworks on artists.artistid=artworks.artistid
join categories on categories.categoryid=artworks.categoryid
where categories.name in ( select categories.name = 'Painting' from categories) 
group by artists.name;

-- 4 List the names of artworks from the 'Modern Art Masterpieces' exhibition, along with their
 -- artists and categories.

select artists.name, categories.name
from artists
join artworks on artists.artistid=artworks.artistid
join categories on categories.categoryid=artworks.categoryid
join exhibitionartworks on exhibitionartworks.artworkid=artworks.artworkid
where ExhibitionArtworks.ExhibitionID in (select Exhibitions.ExhibitionID from exhibitions where title = 'Modern Art Masterpieces');

-- 5 Find the artists who have more than two artworks in the gallery

select artists.name, count(artworks.artworkid) as no_of_artworks
from artists
join artworks on artists.artistid=artworks.artistid
group by artists.name
having no_of_artworks>2;

-- 6 Find the titles of artworks that were exhibited in both 'Modern Art Masterpieces' and 'Renaissance Art' exhibitions

select artworks.title, exhibitions.title
from artworks 
join ExhibitionArtworks on artworks.artworkid=ExhibitionArtworks.artworkid
join exhibitions on exhibitions.exhibitionid=ExhibitionArtworks.exhibitionid
where exhibitions.title =all (select exhibitions.title from exhibitions );

-- 7 Find the total number of artworks in each category

select count(artworks.artworkid), categories.categoryid
from artworks
join categories on artworks.categoryid=categories.categoryid
group by categories.categoryid;

-- 8 List artists who have more than 3 artworks in the gallery.

select artists.name, count(artworks.artworkid) as no_of_artworks
from artists
join artworks on artists.artistid=artworks.artistid
group by artists.name
having no_of_artworks>3;

-- 9 Find the artworks created by artists from a specific nationality (e.g., Spanish).
select artworks.title, artists.name, artists.nationality
from artists 
join artworks
on artists.artistid=artworks.artistid
where artists.artistid in (select artists.artistid from artists where nationality = 'Italian');

-- 10 (incomplete) List exhibitions that feature artwork by both Vincent van Gogh and Leonardo da Vinci.
select exhibitions.title
from artists
join artworks on artists.artistid=artworks.artistid
join exhibitionartworks on artworks.artworkid=exhibitionartworks.artworkid
join exhibitions on exhibitions.exhibitionid=exhibitionartworks.exhibitionid
where artists.name = any (select artists.name from artists where artists.artistid = 2 or 3);

-- 11 Find all the artworks that have not been included in any exhibition.
-- (deleted a record from the 'exhibitionartworks' table to obtain the output)

select artworks.title 
from artworks
left join exhibitionartworks on artworks.artworkid=exhibitionartworks.artworkid
where exhibitionartworks.exhibitionid is null;

-- 12 List artists who have created artworks in all available categories.
select artists.name
from  artists
join artworks on artists.artistid=artworks.artistid
join categories on categories.categoryid=artworks.categoryid
where artworks.artistid =all (select categories.categoryid from categories);

-- 13 List the total number of artworks in each category.
select categories.name, count(artworkid)
from artworks
join categories on artworks.categoryid=categories.categoryid
group by categories.categoryid;

-- 14 Find the artists who have more than 2 artworks in the gallery.

select artists.name, count(artworks.artworkid) as no_of_artworks
from artists
join artworks on artists.artistid=artworks.artistid
group by artists.name
having no_of_artworks>2;

-- 15 List the categories with the average year of artworks they contain, only for categories with more than 1 artwork.

select categories.categoryid, avg(artworks.year)as avg_year
from categories 
join artworks on categories.categoryid=artworks.categoryid 
group by categories.categoryid
having count(categories.categoryid) >=1;


-- 16 Find the artworks that were exhibited in the 'Modern Art Masterpieces' exhibition.
select artworks.title
from artworks 
join exhibitionartworks on artworks.artworkid=exhibitionartworks.artworkid
join exhibitions on exhibitions.exhibitionid=exhibitionartworks.exhibitionid
where exhibitionartworks.exhibitionid in (select exhibitionid from exhibitions where title= 'Modern Art Masterpieces');

-- 17 Find the categories where the average year of artworks is greater than the average year of all artworks.
select categories.categoryid, avg(artworks.year)as avg_year
from categories 
join artworks on categories.categoryid=artworks.categoryid 
group by categories.categoryid
having avg_year> (select avg(year)as avg_all_years from artworks);

-- 18 List the artworks that were not exhibited in any exhibition
-- (deleted a record from the 'exhibitionartworks' table to obtain the output)

select artworks.title 
from artworks
left join exhibitionartworks on artworks.artworkid=exhibitionartworks.artworkid
where exhibitionartworks.exhibitionid is null;

-- 19 Show artists who have artworks in the same category as "Mona Lisa."
select artists.name 
from artists
join artworks on artists.artistid=artworks.artistid
join categories on categories.categoryid = artworks.categoryid
where artworks.categoryid in  (select categoryid from artworks where title='Mona Lisa');

-- 20 List the names of artists and the number of artworks they have in the gallery

select artists.name, count(artworks.artistid) as no_of_works
from artists
join artworks on artists.artistid = artworks. ArtistID
group by artists.name;



